/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.*;
import top.buukle.provider.security.entity.*;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.provider.security.service.UserService;
import top.buukle.provider.security.vo.query.ModuleQuery;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.response.FuzzySearchListVo;
import top.buukle.provider.security.vo.response.ModuleButtonListVo;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.vo.result.ModuleNavigationVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 
 * @author elvin
 *
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	@Resource
    private ModuleMapper moduleMapper;
	@Resource
    private UserService userService;
	@Resource
    private UserMapper userMapper;
	@Resource
    private ButtonMapper buttonMapper;
	@Resource
    private ButtonTypeMapper buttonTypeMapper;
	@Resource
    private ModuleButtonMapper moduleButtonMapper;
	@Override
	public Module getModuleById(Integer id) throws Exception{
		return moduleMapper.selectByPrimaryKey(id);
	}

    @Override
    public List<Module> getModuleByParas(Module module) throws Exception {
        return null;
    }

    public void save(Module module) throws Exception {
		moduleMapper.insert(module);
	}
	@Override
	public void update(Module module) throws Exception {
		moduleMapper.updateByPrimaryKeySelective(module);
	}
	@Override
	public void delete(Module module) throws Exception {
	}
	@Override
	public List<Module> getModulesByParasNoPage(Module module) throws Exception {
		return null;
	}

    /**
     * 获取用户菜单树
     * @param httpServletRequest
     * @param applicationName
     * @return
     */
	@Override
	public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest, String applicationName) throws Exception {
        String userCookie = this.validateParameter(httpServletRequest,applicationName);
        //获取用户菜单列表
        List<Module> userModuleListAll = userService.getUserCacheInfoByType(Module.class,userCookie);
        List<Module> userModuleListApplication = new ArrayList<>();
        //根据应用名过滤
        for (Module module:  userModuleListAll) {
            if(StringUtil.isNotEmpty(module.getBak01()) && module.getBak01().equals(applicationName)){
                userModuleListApplication.add(module);
            }
        }
        //转换用户菜单列表为菜单树
        ArrayList<ModuleNavigationVo> moduleNavigationVoList = new ArrayList<>();
        for (Module module : userModuleListApplication) {
            if(module.getPid().equals(NumberUtil.INTEGER_ZERO)){
                ModuleNavigationVo moduleNavigationVo = new ModuleNavigationVo();
                ModuleNavigationVo.copyProperties(module,moduleNavigationVo);
                moduleNavigationVoList.add(moduleNavigationVo);
                this.getSonModule(userModuleListApplication,moduleNavigationVo);
            }
        }
        return moduleNavigationVoList;
	}

    /**
     * 分页获取菜单列表
     * @param query
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<Module> getModuleList(ModuleQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<Module> list = moduleMapper.getModuleList(query);
        return new PageResponse.Builder().build(new PageInfo<>(list));
    }

    /**
     * 起停用菜单
     * @param query
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(ModuleQuery query) {
        if(null != query.getStatus() && query.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            query.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            query.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        moduleMapper.doBanOrRelease(query);
        // 更新全局菜单缓存
        UserInvoker.clearGlobalCacheInfoByType(Module.class);
        // 更新用户菜单缓存 ==>> TODO 此处可优化为异步线程处理
        List<User> users = userMapper.getUserByModuleId(query.getId());
        if(CollectionUtils.isNotEmpty(users)){
            for (User user : users) {
                UserInvoker.clearUserCacheInfoByType(Module.class,user.getUserId());
            }
        }
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 获取菜单按钮列表
     * @param request
     * @param id
     * @return
     */
    @Override
    public List<ModuleButtonListVo> getModuleButtonForPage(HttpServletRequest request, Integer id) throws Exception {
        //获取全局按钮列表
        List<Button> globalButtonList = userService.getGlobalCacheByType(Button.class);
        if(CollectionUtils.isEmpty(globalButtonList)){
            return new ArrayList<>();
        }
        //获取指定菜单按钮列表
        List<Button> moduleButtonList = buttonMapper.getModuleButtons(id);
        List<Integer> moduleButtonIdList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(moduleButtonList)){
            for (Button mButton: moduleButtonList) {
                moduleButtonIdList.add(mButton.getId());
            }
        }
        //初始化返回包装对象
        List<ModuleButtonListVo> moduleButtonListVoList = new ArrayList<>();
        List<ButtonType> buttonTypes = buttonTypeMapper.getButtonTypes();
        if(CollectionUtils.isEmpty(buttonTypes)){
            return null;
        }
        //初始化按钮类型-虚拟按钮 映射map
        Map<Integer,ModuleButtonListVo> buttonTypeValueMap = new HashMap<>();
        //初始化按钮类别 虚拟按钮id
        int vid = -1;
        for (ButtonType buttonType: buttonTypes) {
            //初始化按钮类别 虚拟按钮 实体
            ModuleButtonListVo ModuleButtonListVo = new ModuleButtonListVo();
            ModuleButtonListVo.setpId(NumberUtil.INTEGER_ZERO);
            ModuleButtonListVo.setChecked(true);
            ModuleButtonListVo.setId(vid--);
            ModuleButtonListVo.setName(buttonType.getTypeOperation());
            moduleButtonListVoList.add(ModuleButtonListVo);
            buttonTypeValueMap.put(Integer.parseInt(buttonType.getTypeValue()),ModuleButtonListVo);
        }
        //设置指定菜单拥有按钮选中标识,并设置按钮类型与按钮的父子关系
        for (Button gButton: globalButtonList) {
            ModuleButtonListVo moduleButtonListVo = new ModuleButtonListVo();
            BeanUtils.copyProperties(moduleButtonListVo,gButton);
            moduleButtonListVo.setName(gButton.getButtonName() + "  (" +gButton.getBak01() + ")");
            //设置选中标识
            if(moduleButtonIdList.contains(gButton.getId())){
                moduleButtonListVo.setChecked(true);
            }
            //设置按钮类型(虚拟按钮)与按钮的父子关系
            if(buttonTypeValueMap.keySet().contains(gButton.getOperationType())){
                moduleButtonListVo.setpId(buttonTypeValueMap.get(gButton.getOperationType()).getId());
            }
            moduleButtonListVoList.add(moduleButtonListVo);
        }
        return moduleButtonListVoList;
    }

    /**
     * 设置菜单按钮
     * @param ids
     * @param query
     * @return
     */
    @Override
    public BaseResponse setModuleButton(String ids, ModuleQuery query) {
        moduleButtonMapper.deleteModuleButton(query.getId());
        if(StringUtil.isEmpty(ids)){
            return new BaseResponse.Builder().buildSuccess();
        }
        String[] idsArr = ids.split(",");
        if(null== idsArr || idsArr.length < 1){
            return new BaseResponse.Builder().buildSuccess();
        }
        for (String idStr : idsArr) {
            if(StringUtil.isNotEmpty(idStr) && Integer.parseInt(idStr) > NumberUtil.INTEGER_ZERO){
                ModuleButton moduleButton = new ModuleButton(Integer.parseInt(idStr),query.getId());
                moduleButton.setGmtCreated(new Date());
                moduleButtonMapper.insert(moduleButton);
            }
        }
        //更新菜单下按钮缓存
        UserInvoker.deleteModuleButton(query.getId());
        return new BaseResponse.Builder().buildSuccess();
    }


    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) {
        List<Module> buttonList = moduleMapper.fuzzySearchByName("%" + fuzzyText + "%");
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(buttonList)){
            for (Module module: buttonList) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(module.getModuleName());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
    }

    /**
     * 递归获取子菜单
     * @param userModuleList
     * @param moduleNavigationVo
     */
    private void getSonModule(List<Module> userModuleList, ModuleNavigationVo moduleNavigationVo) {
        for (Module module: userModuleList) {
            if(module.getPid().equals(moduleNavigationVo.getId())){
                ModuleNavigationVo moduleNavigationVoSon = new ModuleNavigationVo();
                ModuleNavigationVo.copyProperties(module,moduleNavigationVoSon);
                List<ModuleNavigationVo> childrenList = moduleNavigationVo.getChildren();
                this.getSonModule(userModuleList,moduleNavigationVoSon);
                if(CollectionUtils.isEmpty(childrenList)){
                    childrenList = new ArrayList<>();
                    moduleNavigationVo.setChildren(childrenList);
                }
                childrenList.add(moduleNavigationVoSon);
            }
        }
    }

    /**
     * 校验参数
     * @param httpServletRequest
     * @param applicationName
     * @return
     */
    private String validateParameter(HttpServletRequest httpServletRequest, String applicationName) {
        if(StringUtil.isEmpty(applicationName)){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_APPLICATION_NAME_NULL);
        }
        String userCookie = CookieUtil.getUserCookie(httpServletRequest);
        if(StringUtil.isEmpty(userCookie)){
            throw new BaseException(BaseResponseCode.USER_COOKIE_NULL);
        }
        return userCookie;
    }
}

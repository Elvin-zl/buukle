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
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.ModuleMapper;
import top.buukle.provider.security.dao.RoleModuleMapper;
import top.buukle.provider.security.dao.UserMapper;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.entity.RoleModule;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.RoleService;
import top.buukle.provider.security.dao.RoleMapper;
import top.buukle.provider.security.entity.Role;
import top.buukle.provider.security.service.UserService;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.query.RoleQuery;
import top.buukle.provider.security.vo.response.FuzzySearchListVo;
import top.buukle.provider.security.vo.response.PageResponse;
import top.buukle.provider.security.vo.response.RoleModuleListVo;
import top.buukle.provider.security.vo.response.UserRoleListVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;
	@Resource
	private UserService userService;
	@Resource
	private UserMapper userMapper;
	@Resource
	private ModuleMapper moduleMapper;
	@Resource
	private RoleModuleMapper roleModuleMapper;
	@Override
	public Role getRoleById(Integer id) throws Exception{
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> getRoleByParas(Role role) throws Exception {
		return null;
	}

	@Override
	public void save(Role role) throws Exception {
		roleMapper.insert(role);
	}
	@Override
	public void update(Role role) throws Exception {
		roleMapper.updateByPrimaryKeySelective(role);
	}
	@Override
	public void delete(Role role) throws Exception {
	}
	@Override
	public List<Role> getRolesByParasNoPage(Role role) throws Exception {
		return null;
	}

    /**
     * 分页查询角色列表
     * @param roleQuery
     * @param pageBounds
     * @return
     */
	@Override
	public PageResponse<Role> getRoleList(RoleQuery roleQuery, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<Role> list = roleMapper.getRoleList(roleQuery);
        return new PageResponse.Builder().build(new PageInfo<>(list));
	}

    /**
     * 启用/停用 角色
     * @param query
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(RoleQuery query) {
        if(null != query.getStatus() && query.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            query.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            query.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        roleMapper.doBanOrRelease(query);
        //更新全局角色缓存
        UserInvoker.clearGlobalCacheInfoByType(Role.class);
        // 根据用户角色更新用户菜单缓存 ==>> TODO 此处可优化为异步线程处理
        List<User> users = userMapper.getUserByRoleId(query.getId());
        if(CollectionUtils.isNotEmpty(users)){
            for (User user : users) {
                UserInvoker.clearUserCacheInfoByType(Module.class,user.getUserId());
            }
        }
        return new BaseResponse.Builder().buildSuccess();
    }


	/**
	 * 获取角色菜单列表
	 * @param request
	 * @param id
	 * @return
	 */
	@Override
	public List<RoleModuleListVo> getRoleModuleForPage(HttpServletRequest request, Integer id) throws Exception {
        //获取全局菜单列表
        List<Module> globalModuleList = userService.getGlobalCacheByType(Module.class);
        if(CollectionUtils.isEmpty(globalModuleList)){
            return new ArrayList<>();
        }
        //获取指定角色菜单列表
        List<Role> list = new ArrayList<>();
        list.add(new Role(id));
        List<Module> roleModuleList = moduleMapper.getUserModuleListByUserRoleList(list);
        List<Integer> roleModuleIdList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(roleModuleList)){
            for (Module rModule: roleModuleList) {
                roleModuleIdList.add(rModule.getId());
            }
        }
        List<RoleModuleListVo> roleModuleListVoList = new ArrayList<>();
        //设置指定角色拥有菜单选中标识
        for (Module gModule: globalModuleList) {
            RoleModuleListVo roleModuleListVo = new RoleModuleListVo();
            BeanUtils.copyProperties(roleModuleListVo,gModule);
            roleModuleListVo.setName(gModule.getModuleName());
            roleModuleListVo.setpId(gModule.getPid());
            roleModuleListVo.setId(gModule.getId());
            if(roleModuleIdList.contains(gModule.getId())){
                roleModuleListVo.setChecked(true);
            }
            roleModuleListVoList.add(roleModuleListVo);
        }
        return roleModuleListVoList;
	}

    /**
     * 设置角色菜单
     * @param ids
     * @param query
     * @return
     */
    @Override
    public BaseResponse setRoleModule(String ids, RoleQuery query) {
        roleModuleMapper.deleteRoleModule(query.getId());
        if(StringUtil.isEmpty(ids)){
            return new BaseResponse.Builder().buildSuccess();
        }
        String[] idsArr = ids.split(",");
        if(null== idsArr || idsArr.length < 1){
            return new BaseResponse.Builder().buildSuccess();
        }
        for (String idStr : idsArr) {
            if(StringUtil.isNotEmpty(idStr)){
                RoleModule userRole = new RoleModule(Integer.parseInt(idStr),query.getId());
                userRole.setGmtCreated(new Date());
                roleModuleMapper.insert(userRole);
            }
        }
        // 根据用户角色更新用户菜单缓存 ==>> TODO 此处可优化为异步线程处理
        List<User> users = userMapper.getUserByRoleId(query.getId());
        if(CollectionUtils.isNotEmpty(users)){
            for (User user : users) {
                UserInvoker.clearUserCacheInfoByType(Module.class,user.getUserId());
            }
        }
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) {
        List<Role> roleList = roleMapper.fuzzySearchByName("%" + fuzzyText + "%");
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(roleList)){
            for (Role role: roleList) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(role.getRoleName());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
    }
}

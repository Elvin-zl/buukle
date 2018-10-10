/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.RequestHead;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.provider.security.dao.ModuleMapper;
import top.buukle.provider.security.entity.Module;
import top.buukle.provider.security.vo.result.ModuleNavigationVo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("moduleService")
public class ModuleServiceImpl implements ModuleService {
	@Resource
	ModuleMapper moduleMapper;
	@Override
	public List<Module> getModuleByParas(Module module, PageBounds pageBounds) throws Exception {
		return moduleMapper.getModuleByParas(module, pageBounds);
	}
	@Override
	public Module getModuleById(Integer id) throws Exception{
		return moduleMapper.getModuleById(id);
	}
	
	@Override
	public List<Module> getModuleByParas(Module module) throws Exception {
		return moduleMapper.getModuleByParas(module);
	}
	@Override
	public void save(Module module) throws Exception {
		moduleMapper.save(module);
	}
	@Override
	public void update(Module module) throws Exception {
		moduleMapper.update(module);
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
	public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest, String applicationName) {
        String userCookie = this.validateParameter(httpServletRequest,applicationName);
        List<Module> userModuleListAll = this.getUserModule(userCookie,applicationName);
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

    private List<Module> getUserModule(String userCookie, String applicationName) {
        List<Module> userModuleListAll = UserInvoker.getUserModule(userCookie);
        if(CollectionUtils.isEmpty(userModuleListAll)){
            User user = UserInvoker.getUser(userCookie);
            userModuleListAll = moduleMapper.getUserModuleListByUserId(user);
            UserInvoker.saveUserModule(userModuleListAll,userCookie,new RequestHead.Builder().build(applicationName));
            if(CollectionUtils.isEmpty(userModuleListAll)){
                throw new BaseException(BaseResponseCode.USER_PERMISSION_USER_MODULE_LIST_NULL);
            }
        }
        return userModuleListAll;
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

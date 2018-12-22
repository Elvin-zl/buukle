package top.buukle.plugin.security.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.buukle.plugin.security.business.SecurityBusiness;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/16.
 * @Description : Security client
 */
@Component
public class SecurityClient {

    @Autowired
    private SecurityBusiness securityBusiness;

    /**
     * 获取用户菜单信息
     * @param httpServletRequest
     * @return
     */
    public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest){
        return securityBusiness.getUserModuleTree(httpServletRequest);
    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    public User getUserInfo(HttpServletRequest request){
        return securityBusiness.getUserInfo(request);
    }

    /**
     * 获取全局按钮类型
     * @return
     */
    public List<ButtonType> getButtonTypes(){
        return securityBusiness.getButtonTypes();
    }

    /**
     * 获取菜单下的按钮
     * @param request
     * @param moduleId
     * @return
     */
    public List<Button> getModuleButtons(HttpServletRequest request, Integer moduleId) {
        return securityBusiness.getModuleButtons(request, moduleId);
    }

    /**
     * 获取用户下辖信息列表
     * @param userId
     * @return
     */
    public List<String> getUserSubordinate(String userId) {
        return securityBusiness.getUserSubordinate(userId);
    }
}

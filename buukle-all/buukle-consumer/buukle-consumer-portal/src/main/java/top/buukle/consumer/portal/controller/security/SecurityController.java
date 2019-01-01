package top.buukle.consumer.portal.controller.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/18.
 * @Description :
 */
@Controller
@RequestMapping("/security")
public class SecurityController {

    @Autowired
    private SecurityClient securityClient;

    /**
     * 获取用户菜单信息
     * @param httpServletRequest
     * @return
     */
    @RequestMapping("/getUserModuleTree")
    @ResponseBody
    public List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest){
        return securityClient.getUserModuleTree(httpServletRequest);
    }

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    @RequestMapping("/getUserInfo")
    @ResponseBody
    public User getUserInfo(HttpServletRequest request){
        return securityClient.getUserInfo(request);
    }

    /**
     * 获取全局按钮类型
     * @return
     */
    @RequestMapping("/getButtonTypes")
    @ResponseBody
    public List<ButtonType> getButtonTypes(){
        return securityClient.getButtonTypes();
    }

    /**
     * 获取菜单下的按钮
     * @param request
     * @param moduleId
     * @return
     */
    @RequestMapping("/getModuleButtons/{moduleId}")
    @ResponseBody
    public List<Button> getModuleButtons(HttpServletRequest request, @PathVariable("moduleId") Integer moduleId) {
        return securityClient.getModuleButtons(request, moduleId);
    }

}


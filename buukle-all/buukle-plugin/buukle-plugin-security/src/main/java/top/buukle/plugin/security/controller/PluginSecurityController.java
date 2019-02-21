package top.buukle.plugin.security.controller;

import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.constants.SecurityConstants;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/2.
 * @Description :
 */
@Controller
public class PluginSecurityController {

    /**
     * 去往登陆页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.LOGIN_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName(SecurityConstants.VIEW_NAME_PARAMETERS.getLoginViewName());
        return modelAndView;
    }
    /**
     * 生成验证码路径
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.LOGIN_VERIFY_ENVIRONMENT_KEY+"}")
    public  ModelAndView getVerificationImg(ModelAndView modelAndView) {
        return null;
    }
    /**
     * 去往首页页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.INDEX_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName(SecurityConstants.VIEW_NAME_PARAMETERS.getIndexViewName());
        return modelAndView;
    }
    /**
     * 去往超时页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.OUT_OF_TIME_PATH_LOGIN_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView outOfTime(ModelAndView modelAndView) {
        modelAndView.setViewName(SecurityConstants.VIEW_NAME_PARAMETERS.getOutOfTimeViewName());
        return modelAndView;
    }
    /**
     * 去往越权页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.NO_PERMISSION_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView noPermission(ModelAndView modelAndView) {
        modelAndView.setViewName(SecurityConstants.VIEW_NAME_PARAMETERS.getNoPermissionViewName());
        return modelAndView;
    }
    /**
     * 执行登出
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.LOGOUT_PATH_ENVIRONMENT_KEY+"}")
    @ResponseBody
    public BaseResponse logout() {
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 执行登录
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.DOLOGIN_PATH_ENVIRONMENT_KEY+"}")
    @ResponseBody
    public BaseResponse doLogin() {
        return new BaseResponse.Builder().buildSuccess();
    }
    /**
     * 去往错误页面
     * @param modelAndView
     * @return
     */
    @RequestMapping("${"+ SecurityConstants.ERROR_PAGE_PATH_ENVIRONMENT_KEY+"}")
    public  ModelAndView error(ModelAndView modelAndView) {
        modelAndView.setViewName(SecurityConstants.VIEW_NAME_PARAMETERS.getErrorViewName());
        return modelAndView;
    }
    /**
     * 去往无来源页面
     * @param modelAndView
     * @return
     */
    @RequestMapping(SecurityConstants.NO_REEFER_PATH)
    public  ModelAndView noReefer(ModelAndView modelAndView) {
        modelAndView.setViewName(SecurityConstants.NO_REEFER_VIEW_NAME);
        return modelAndView;
    }
}
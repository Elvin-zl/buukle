package top.buukle.plugin.security.business;


import top.buukle.common.response.BaseResponse;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/10.
 * @Description :
 */
public interface SecurityBusiness {


    /**
     * 登出
     * @param request
     * @param response
     */
    BaseResponse logout(HttpServletRequest request, HttpServletResponse response);

    /**
     * 登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    BaseResponse doLogin(HttpServletRequest request, HttpServletResponse response) throws Exception;

    /**
     * 鉴权
     * @param request
     * @param response
     * @param uri
     * @param ssoDefaultAge
     * @param applicationName
     * @return
     * @throws Exception
     */
    BaseResponse authAndSetPermission(HttpServletRequest request, HttpServletResponse response, String uri, String ssoDefaultAge, String applicationName) throws Exception;

    /**
     * 获取用户菜单信息
     * @param httpServletRequest
     * @return
     */
    List<ModuleNavigationVo> getUserModuleTree(HttpServletRequest httpServletRequest);

    /**
     * 获取用户信息
     * @param request
     * @return
     */
    User getUserInfo(HttpServletRequest request);

    /**
     * 获取全局按钮类型
     * @return
     */
    List<ButtonType> getButtonTypes();


    /**
     * 获取菜单下的按钮
     * @param request
     * @param moduleId
     * @return
     */
    List<Button> getModuleButtons(HttpServletRequest request, Integer moduleId);

    /**
     * 获取用户下辖信息列表
     * @param userId
     * @return
     */
    List<String> getUserSubordinate(String userId);

    /**
     * 获取文章作者信息
     * @param userId
     * @return
     */
    User getArticleAuthor(String userId);

    /**
     * 更新用户基本信息
     * @param user
     * @param httpServletRequest
     * @return
     */
    BaseResponse updateUserBasicResource(User user, HttpServletRequest httpServletRequest);

    /**
     * 注册新用户
     * @param request
     * @param response
     * @return
     */
    BaseResponse doRegister(HttpServletRequest request, HttpServletResponse response);

}

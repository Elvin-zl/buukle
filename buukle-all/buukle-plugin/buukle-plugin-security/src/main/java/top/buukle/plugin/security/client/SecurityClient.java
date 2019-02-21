package top.buukle.plugin.security.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.business.SecurityBusiness;
import top.buukle.plugin.security.constants.SecurityConstants;
import top.buukle.plugin.security.entity.Button;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.plugin.security.entity.User;
import top.buukle.plugin.security.util.CookieUtil;
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

    private static final BaseLogger LOGGER = BaseLogger.getLogger(SecurityClient.class);
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
        User userInfo;
        try {
             userInfo = securityBusiness.getUserInfo(request);
        } catch (Exception e) {
            User user = new User();
            user.setUserId(SecurityConstants.USER_ID_OFFLINE);
            return user;
        }
        return userInfo;
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

    /**
     * 获取文章作者信息
     * @param userId
     * @return
     */
    public User getArticleAuthor(String userId) {
        return securityBusiness.getArticleAuthor(userId);
    }

    /**
     * 更新用户基本信息
     * @param user
     * @param httpServletRequest
     * @return
     */
    public BaseResponse updateUserBasicResource(User user, HttpServletRequest httpServletRequest) {
        User userInfo = this.getUserInfo(httpServletRequest);
        if(null == userInfo){
            throw new BaseException(BaseResponseCode.USER_UPDATE_WRONG_NO_LOGIN);
        }
        user.setId(userInfo.getId());
        user.setUsername(userInfo.getUsername());
        user.setUserId(userInfo.getUserId());
        return securityBusiness.updateUserBasicResource(user,httpServletRequest);
    }
}

package top.buukle.provider.security.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.common.dataIsolation.IsolationConstants;
import top.buukle.plugin.security.vo.response.ModuleNavigationVo;
import top.buukle.provider.security.dao.GroupsMapper;
import top.buukle.provider.security.dao.UserExpMapper;
import top.buukle.plugin.security.entity.*;
import top.buukle.provider.security.business.UserBusiness;
import top.buukle.provider.security.constants.SecurityConstants;
import org.springframework.stereotype.Component;
import top.buukle.provider.security.dao.UserMapper;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ButtonService;
import top.buukle.provider.security.service.ModuleService;
import top.buukle.provider.security.service.UserService;
import top.buukle.plugin.security.vo.query.UserQuery;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/21.
 * @Description :
 */
@Component
public class UserBusinessImpl implements UserBusiness {

    @Autowired
    private ButtonService buttonService;

    /**
     * 获取已完成认证的用户获取用户信息
     * @param request
     * @return
     */
    @Override
    public User getUserInfo(HttpServletRequest request) {
        return UserInvoker.getUser(CookieUtil.getUserCookie(request));
    }

    /**
     * 获取全局按钮类型
     * @return
     */
    @Override
    public List<ButtonType> getButtonTypes() {
        return buttonService.getButtonTypes();
    }

    /**
     * 获取菜单下的按钮信息
     * @param baseRequest
     * @return
     */
    @Override
    public List<Button> getModuleButtons(BaseRequest baseRequest) {
        Integer moduleId = (Integer) baseRequest.getInfo(Integer.class);
        return buttonService.getModuleButtons(moduleId);
    }
}

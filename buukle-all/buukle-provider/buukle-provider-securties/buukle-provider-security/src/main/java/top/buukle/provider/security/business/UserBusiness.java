package top.buukle.provider.security.business;

import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.provider.security.entity.User;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/5.
 * @Description :
 */
public interface UserBusiness {

    BaseResponse doLogin(BaseRequest baseRequest) throws Exception;

    User getUserInfo(HttpServletRequest request);
}

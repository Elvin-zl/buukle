package top.buukle.security.api;


import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.User;
import top.buukle.security.entity.vo.UserQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description UserService 接口类
*/
public interface ApiUserService {


    CommonResponse innerLogin(User user, HttpServletRequest request, HttpServletResponse response);

    void sessionUserResource(HttpServletRequest request, User userInfo, boolean isUpdate);
}
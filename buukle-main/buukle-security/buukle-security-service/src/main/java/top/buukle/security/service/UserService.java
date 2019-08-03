package top.buukle.security .service;


import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security .entity.User;
import top.buukle.security .entity.vo.UserQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description UserService 接口类
*/
public interface UserService {


    PageResponse getPageList(UserQuery query) ;

    FuzzyResponse fuzzySearch(String text, String fieldName);

    CommonResponse delete(UserQuery query, HttpServletRequest request);

    User getById(UserQuery query);

    CommonResponse save(UserQuery query, HttpServletRequest request);

    CommonResponse update(UserQuery query, HttpServletRequest request);
}
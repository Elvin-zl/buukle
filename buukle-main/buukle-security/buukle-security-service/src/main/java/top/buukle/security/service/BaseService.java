package top.buukle.security.service;


import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.vo.BaseQuery;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/4.
 * @Description :
 */
public interface BaseService {

    Object selectByPrimaryKey(Integer id) ;

    PageResponse userPage(BaseQuery query) ;

    FuzzyResponse fuzzySearch(String text, String fieldName);

    CommonResponse delete(Integer id, HttpServletRequest request);

    CommonResponse save(BaseQuery query, HttpServletRequest request);

    CommonResponse update(BaseQuery query, HttpServletRequest request);

    CommonResponse deleteBatch(String ids, HttpServletRequest request);
}

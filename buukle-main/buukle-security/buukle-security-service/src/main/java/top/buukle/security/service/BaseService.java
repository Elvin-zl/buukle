package top.buukle.security.service;


import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.vo.BaseQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/8/4.
 * @Description :
 */
public interface BaseService {

    Object selectByPrimaryKeyForCrud(HttpServletRequest request, Integer id) ;

    PageResponse getPage(BaseQuery query) ;

    FuzzyResponse fuzzySearch(String text, String fieldName);

    CommonResponse delete(Integer id, HttpServletRequest request, HttpServletResponse response);

    CommonResponse save(BaseQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse update(BaseQuery query, HttpServletRequest request, HttpServletResponse response);

    CommonResponse deleteBatch(String ids, HttpServletRequest request, HttpServletResponse response);
}

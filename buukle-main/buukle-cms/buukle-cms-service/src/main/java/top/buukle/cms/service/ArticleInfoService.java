package top.buukle.cms.service;


import top.buukle.cms.entity.ArticleInfo;
import top.buukle.cms.entity.vo.ArticleInfoQuery;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description ArticleInfoService实现类
*/
public interface ArticleInfoService  {

    /**
    * 分页获取列表
    * @param query
    * @return
    */
    PageResponse getPageList(ArticleInfoQuery query) ;

    FuzzyResponse fuzzySearch(String fuzzyText, String fieldName);

    CommonResponse delete(ArticleInfoQuery query, HttpServletRequest request);

    ArticleInfo getById(ArticleInfoQuery query);

    CommonResponse save(ArticleInfoQuery query, HttpServletRequest request);

    CommonResponse update(ArticleInfoQuery query, HttpServletRequest request);
}
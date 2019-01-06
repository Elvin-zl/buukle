package top.buukle.consumer.cms .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.ArticleDesc;
import top.buukle.consumer.cms .entity.vo.ArticleDescQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description ArticleDescService 接口类
*/
public interface ArticleDescService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<ArticleDesc> getArticleDescList(ArticleDescQuery query, PageBounds pageBounds);

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    */
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText);

    /**
    * 逻辑删除单条数据
    * @param query
    * @param request
    * @return
    */
    BaseResponse deleteArticleDesc(ArticleDescQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    ArticleDesc getArticleDescDetail(ArticleDescQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveArticleDesc(ArticleDescQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateArticleDesc(ArticleDescQuery query, HttpServletRequest request);
}
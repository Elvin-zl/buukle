package top.buukle.consumer.cms .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms.vo.ArticleCatTreeNodeVo;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.ArticleCat;
import top.buukle.consumer.cms .entity.vo.ArticleCatQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description ArticleCatService 接口类
*/
public interface ArticleCatService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<ArticleCat> getArticleCatList(ArticleCatQuery query, PageBounds pageBounds);

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
    BaseResponse deleteArticleCat(ArticleCatQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    ArticleCat getArticleCatDetail(ArticleCatQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveArticleCat(ArticleCatQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateArticleCat(ArticleCatQuery query, HttpServletRequest request);

    /**
     * 获取文章分类树
     * @return
     */
    List<ArticleCatTreeNodeVo> getArticleCatTree();

    /**
     * 获取文章父分类树
     * @return
     */
    List<ArticleCatTreeNodeVo> getArticleCatFatherTree();
}
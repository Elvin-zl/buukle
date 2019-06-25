package top.buukle.consumer.www.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.entity.ArticleInfo;
import top.buukle.consumer.www.entity.vo.ArticleInfoQuery;
import top.buukle.consumer.www.vo.ArticleInformationVo;
import top.buukle.consumer.www.vo.ArticlePublishVo;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

/**
* @author elvin
* @description ArticleInfoService 接口类
*/
public interface ArticleInfoService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<ArticleInformationVo> getArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds) throws InvocationTargetException, IllegalAccessException;

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
    BaseResponse deleteArticleInfo(ArticleInfoQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    ArticleInfo getArticleInfoDetail(ArticleInfoQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveArticleInfo(ArticleInfoQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateArticleInfo(ArticleInfoQuery query, HttpServletRequest request);

    /**
     * 获取我的文章列表
     * @param query
     * @param pageBounds
     * @return
     */
    PageResponse<ArticleInfo> getUserArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds);

    /**
     * 获取文章审核列表
     * @param query
     * @param pageBounds
     * @return
     */
    PageResponse<ArticleInfo> getAuditArticleInfoList(ArticleInfoQuery query, PageBounds pageBounds);

    /**
     * 发布文章
     * @param publishVo
     * @param request
     * @return
     */
    BaseResponse doPublish(ArticlePublishVo publishVo, HttpServletRequest request) throws Exception;

    /**
     * 草稿文章
     * @param publishVo
     * @param request
     * @return
     */
    BaseResponse doDraft(ArticlePublishVo publishVo, HttpServletRequest request) throws Exception;

    /**
     * 查看文章详情
     *
     *
     * @param idStr
     * @param request
     * @param query
     * @param isPortal
     * @return
     */
    ArticleInformationVo getArticleAllInformation(String idStr, HttpServletRequest request, ArticleInfoQuery query, Boolean isPortal);

    /**
     * 增减赞数 1
     * @param articleInfoQuery
     * @param request
     */
    void updateLikeNumber(ArticleInfoQuery articleInfoQuery, HttpServletRequest request);

    /**
     * @description 更新文章
     * @param articleInfo
     * @return void
     * @Author elvin
     * @Date 2019/6/25
     */
    void updateArticleInfo(ArticleInfo articleInfo);
}
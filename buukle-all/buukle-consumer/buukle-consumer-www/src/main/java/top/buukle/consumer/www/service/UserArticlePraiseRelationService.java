package top.buukle.consumer.www.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.www.entity.UserArticlePraiseRelation;
import top.buukle.consumer.www.entity.vo.UserArticlePraiseRelationQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description UserArticlePraiseRelationService 接口类
*/
public interface UserArticlePraiseRelationService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<UserArticlePraiseRelation> getUserArticlePraiseRelationList(UserArticlePraiseRelationQuery query, PageBounds pageBounds);

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
    BaseResponse deleteUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    UserArticlePraiseRelation getUserArticlePraiseRelationDetail(UserArticlePraiseRelationQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateUserArticlePraiseRelation(UserArticlePraiseRelationQuery query, HttpServletRequest request);

    /**
     * 根据用户和文章id查询点赞记录
     * @param relationQuery
     * @return
     */
    UserArticlePraiseRelation getUserArticlePraiseRelation(UserArticlePraiseRelationQuery relationQuery);

    /**
     * 点赞/取消赞
     * @param query
     * @param request
     * @return
     */
    BaseResponse doSwitchPraise(UserArticlePraiseRelationQuery query, HttpServletRequest request);

    /**
     * 点赞/取消赞 任务执行
     * @param query
     * @param request
     */
    void updateArticlePraise(UserArticlePraiseRelationQuery query, HttpServletRequest request) throws InterruptedException;
}
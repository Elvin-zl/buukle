package top.buukle.consumer.www .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.www .entity.TimelineComment;
import top.buukle.consumer.www.entity.TimelineInfo;
import top.buukle.consumer.www .entity.vo.TimelineCommentQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description TimelineCommentService 接口类
*/
public interface TimelineCommentService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<TimelineComment> getTimelineCommentList(TimelineCommentQuery query, PageBounds pageBounds);

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
    BaseResponse deleteTimelineComment(TimelineCommentQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    TimelineComment getTimelineCommentDetail(TimelineCommentQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveTimelineComment(TimelineCommentQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateTimelineComment(TimelineCommentQuery query, HttpServletRequest request);


    BaseResponse<TimelineInfo> getTimelineComments(TimelineCommentQuery query, PageBounds pageBounds, HttpServletRequest request);

    BaseResponse saveComment(TimelineCommentQuery query, HttpServletRequest request);
}
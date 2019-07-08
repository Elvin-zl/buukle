package top.buukle.consumer.www.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.www.entity.TimelineInfo;
import top.buukle.consumer.www.entity.vo.TimelineInfoQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description TimelineInfoService 接口类
*/
public interface TimelineInfoService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<TimelineInfo> getTimelineInfoList(TimelineInfoQuery query, PageBounds pageBounds);

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
    BaseResponse deleteTimelineInfo(TimelineInfoQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    TimelineInfo getTimelineInfoDetail(TimelineInfoQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveTimelineInfo(TimelineInfoQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateTimelineInfo(TimelineInfoQuery query, HttpServletRequest request);
}
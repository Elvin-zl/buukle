package top.buukle.consumer.www .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www .service.TimelineCommentService;
import top.buukle.consumer.www .entity.TimelineComment;
import top.buukle.consumer.www .entity.vo.TimelineCommentQuery;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description TimelineComment controller
*/
@Controller
@RequestMapping("/timelineComment")
public class TimelineCommentController{

    @Autowired
    TimelineCommentService timelineCommentService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getTimelineCommentList")
    @ResponseBody
    public PageResponse<TimelineComment> getTimelineCommentList(TimelineCommentQuery query,PageBounds pageBounds) throws Exception {
        return timelineCommentService.getTimelineCommentList(query,pageBounds);
    }

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    * @throws Exception
    */
    @RequestMapping("/fuzzySearchByText")
    @ResponseBody
    public List<FuzzySearchListVo>  fuzzySearchByText(String fuzzyText) throws Exception {
        return timelineCommentService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteTimelineComment")
    @ResponseBody
    public BaseResponse deleteTimelineComment(TimelineCommentQuery query, HttpServletRequest request) throws Exception {
        return timelineCommentService.deleteTimelineComment(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getTimelineCommentDetail")
    @ResponseBody
    public TimelineComment getTimelineCommentDetail(TimelineCommentQuery query) throws Exception {
        return timelineCommentService.getTimelineCommentDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveTimelineComment")
    @ResponseBody
    public BaseResponse saveTimelineComment(TimelineCommentQuery query, HttpServletRequest request) throws Exception {
        return timelineCommentService.saveTimelineComment(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateTimelineComment")
    @ResponseBody
    public BaseResponse updateTimelineComment(TimelineCommentQuery query, HttpServletRequest request) throws Exception {
        return timelineCommentService.updateTimelineComment(query,request);
    }


    @RequestMapping("/toTimelineComments")
    public ModelAndView toTimelineComments(TimelineCommentQuery query, PageBounds pageBounds, HttpServletRequest request) throws Exception {
        return new ModelAndView("timeline/timelineComments","timelineCommentList",timelineCommentService.getTimelineComments(query, pageBounds,request).getBusiness().getDataList());
    }


    /**
     * 新增回复
     * @param query
     * @return
     * @throws Exception
     */
    @RequestMapping("/saveComment")
    @ResponseBody
    public BaseResponse saveComment (TimelineCommentQuery query,HttpServletRequest request) throws Exception {
        return timelineCommentService.saveComment(query ,request);
    }
}
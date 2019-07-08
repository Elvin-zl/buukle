package top.buukle.consumer.www.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.service.TimelineInfoService;
import top.buukle.consumer.www.entity.TimelineInfo;
import top.buukle.consumer.www.entity.vo.TimelineInfoQuery;


import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @author elvin
* @description TimelineInfo controller
*/
@Controller
@RequestMapping("/timelineInfo")
public class TimelineInfoController{

    @Autowired
    TimelineInfoService timelineInfoService;


    /**
     * @description 跳转广场首页
     * @param
     * @return org.springframework.web.servlet.ModelAndView
     * @Author zhanglei1102
     * @Date 2019/7/4
     */
    @RequestMapping("/square")
    public ModelAndView square(HttpServletRequest request){
        String operation = request.getParameter("operation");
        Map<String,String> operationCodeMap = new HashMap<>();
        if(StringUtil.isNotEmpty(operation)){
            operationCodeMap.put("operation",operation);
        }
        return new ModelAndView("timeline/square",operationCodeMap);
    }
    /**
     * 跳转想法详情页
     * @param idStr
     * @return
     * @throws Exception
     */
    @RequestMapping("/detail/{idStr}")
    public ModelAndView detail(@PathVariable("idStr") String idStr,HttpServletRequest request) throws Exception {
        TimelineInfoQuery timelineInfoQuery = new TimelineInfoQuery();
        timelineInfoQuery.setId(Integer.parseInt(new String(Base64.getDecoder().decode(idStr))));
        return new ModelAndView("timeline/timelineDetail","timelineInfo",timelineInfoService.getTimelineInfoDetail(timelineInfoQuery));
    }
    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getTimelineInfoList")
    @ResponseBody
    public PageResponse<TimelineInfo> getTimelineInfoList(TimelineInfoQuery query,PageBounds pageBounds) throws Exception {
        return timelineInfoService.getTimelineInfoList(query,pageBounds);
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
        return timelineInfoService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteTimelineInfo")
    @ResponseBody
    public BaseResponse deleteTimelineInfo(TimelineInfoQuery query, HttpServletRequest request) throws Exception {
        return timelineInfoService.deleteTimelineInfo(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getTimelineInfoDetail")
    @ResponseBody
    public TimelineInfo getTimelineInfoDetail(TimelineInfoQuery query) throws Exception {
        return timelineInfoService.getTimelineInfoDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveTimelineInfo")
    @ResponseBody
    public BaseResponse saveTimelineInfo(TimelineInfoQuery query, HttpServletRequest request) throws Exception {
        return timelineInfoService.saveTimelineInfo(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateTimelineInfo")
    @ResponseBody
    public BaseResponse updateTimelineInfo(TimelineInfoQuery query, HttpServletRequest request) throws Exception {
        return timelineInfoService.updateTimelineInfo(query,request);
    }

}
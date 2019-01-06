package top.buukle.provider.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.provider.security .service.VisitorLogsService;
import top.buukle.plugin.security.entity.VisitorLogs;
import top.buukle.plugin.security.entity.vo.VisitorLogsQuery;


import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description VisitorLogs controller
*/
@Controller
@RequestMapping("/visitorLogs")
public class VisitorLogsController{

    @Autowired
    VisitorLogsService visitorLogsService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getVisitorLogsList")
    @ResponseBody
    public PageResponse<VisitorLogs> getVisitorLogsList(VisitorLogsQuery query,PageBounds pageBounds) throws Exception {
        return visitorLogsService.getVisitorLogsList(query,pageBounds);
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
        return visitorLogsService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteVisitorLogs")
    @ResponseBody
    public BaseResponse deleteVisitorLogs(VisitorLogsQuery query, HttpServletRequest request) throws Exception {
        return visitorLogsService.deleteVisitorLogs(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getVisitorLogsDetail")
    @ResponseBody
    public VisitorLogs getVisitorLogsDetail(VisitorLogsQuery query) throws Exception {
        return visitorLogsService.getVisitorLogsDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveVisitorLogs")
    @ResponseBody
    public BaseResponse saveVisitorLogs(VisitorLogsQuery query, HttpServletRequest request) throws Exception {
        return visitorLogsService.saveVisitorLogs(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateVisitorLogs")
    @ResponseBody
    public BaseResponse updateVisitorLogs(VisitorLogsQuery query, HttpServletRequest request) throws Exception {
        return visitorLogsService.updateVisitorLogs(query,request);
    }

}
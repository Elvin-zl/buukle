package top.buukle.security .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.buukle.common.call.CommonResponse;
import top.buukle.security .entity.vo.WorkerJobLogsQuery;
import top.buukle.security .service.WorkerJobLogsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description  WorkerJobLogs controller
*/
@Controller
@RequestMapping("/workerJobLogs")
public class WorkerJobLogsController {

    @Autowired
    private WorkerJobLogsService workerJobLogsService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/{pageName}")
    public ModelAndView getPage(@PathVariable("pageName") String pageName, WorkerJobLogsQuery query, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("response", workerJobLogsService.getPage(query));
        modelAndView.setViewName("workerJobLogs/" + pageName);
        return modelAndView;
    }

    /**
    * @description 新增或者修改
    * @param query
    * @param request
    * @return top.buukle.common.call.CommonResponse
    * @Author elvin
    * @Date 2019/8/5
    */
    @RequestMapping("/saveOrEdit")
    @ResponseBody
    public CommonResponse saveOrEdit(WorkerJobLogsQuery query, HttpServletRequest request, HttpServletResponse response) throws Exception {
        return workerJobLogsService.saveOrEdit(query,request,response);
    }
}
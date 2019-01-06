package top.buukle.consumer.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.entity.AsyncTask;
import top.buukle.consumer.portal.entity.vo.AsyncTaskQuery;
import top.buukle.consumer.portal.service.AsyncTaskService;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description AsyncTask controller
*/
@Controller
@RequestMapping("/asyncTask")
public class AsyncTaskController{

    @Autowired
    AsyncTaskService asyncTaskService;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getAsyncTaskList")
    @ResponseBody
    public PageResponse<AsyncTask> getUserList(AsyncTaskQuery query, PageBounds pageBounds) throws Exception {
        return asyncTaskService.getAsyncTaskList(query,pageBounds);
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
        return asyncTaskService.fuzzySearchByText(fuzzyText);
    }

    /**
    * 删除记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/deleteAsyncTask")
    @ResponseBody
    public BaseResponse deleteAsyncTask(AsyncTaskQuery query, HttpServletRequest request) throws Exception {
        return asyncTaskService.deleteAsyncTask(query,request);
    }

    /**
    * 查看记录详情
    * @param query
    * @return
    * @throws Exception
    */
    @RequestMapping("/getAsyncTaskDetail")
    @ResponseBody
    public AsyncTask getAsyncTaskDetail(AsyncTaskQuery query) throws Exception {
        return asyncTaskService.getAsyncTaskDetail(query);
    }

    /**
    * 新增记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/saveAsyncTask")
    @ResponseBody
    public BaseResponse saveAsyncTask(AsyncTaskQuery query, HttpServletRequest request) throws Exception {
        return asyncTaskService.saveAsyncTask(query,request);
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    * @throws Exception
    */
    @RequestMapping("/updateAsyncTask")
    @ResponseBody
    public BaseResponse updateAsyncTask(AsyncTaskQuery query, HttpServletRequest request) throws Exception {
        return asyncTaskService.updateAsyncTask(query,request);
    }

}
package top.buukle.consumer.cms .controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.plugin.security.vo.query.PageBounds;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .service.AsyncTaskService;
import top.buukle.consumer.cms .entity.AsyncTask;
import top.buukle.consumer.cms .entity.vo.AsyncTaskQuery;
import top.buukle.plugin.security.vo.response.FuzzySearchListVo;

import java.util.List;

@Controller
@RequestMapping("/asyncTask")
public class AsyncTaskController{

    @Autowired
    AsyncTaskService service;

    /**
    * 获取列表
    * @return
    * @throws Exception
    */
    @RequestMapping("/getAsyncTaskList")
    @ResponseBody
    public PageResponse<AsyncTask> getUserList(AsyncTaskQuery query,PageBounds pageBounds) throws Exception {
        return service.getAsyncTaskList(query,pageBounds);
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
        return service.fuzzySearchByText(fuzzyText);
    }

}
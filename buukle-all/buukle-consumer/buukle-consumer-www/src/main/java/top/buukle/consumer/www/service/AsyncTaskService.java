package top.buukle.consumer.www.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.entity.AsyncTask;
import top.buukle.consumer.www.entity.vo.AsyncTaskQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description AsyncTaskService 接口类
*/
public interface AsyncTaskService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<AsyncTask> getAsyncTaskList(AsyncTaskQuery query, PageBounds pageBounds);

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
    BaseResponse deleteAsyncTask(AsyncTaskQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    AsyncTask getAsyncTaskDetail(AsyncTaskQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveAsyncTask(AsyncTaskQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateAsyncTask(AsyncTaskQuery query, HttpServletRequest request);

    /**
     * 更新记录
     * @param query
     * @return
     */
    BaseResponse updateAsyncTaskForTask(AsyncTaskQuery query);
}
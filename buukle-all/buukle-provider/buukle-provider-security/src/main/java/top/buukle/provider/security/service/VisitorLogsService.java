package top.buukle.provider.security .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.plugin.security.entity.VisitorLogs;
import top.buukle.plugin.security.entity.vo.VisitorLogsQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description VisitorLogsService 接口类
*/
public interface VisitorLogsService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<VisitorLogs> getVisitorLogsList(VisitorLogsQuery query, PageBounds pageBounds);

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
    BaseResponse deleteVisitorLogs(VisitorLogsQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    VisitorLogs getVisitorLogsDetail(VisitorLogsQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveVisitorLogs(VisitorLogsQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateVisitorLogs(VisitorLogsQuery query, HttpServletRequest request);
}
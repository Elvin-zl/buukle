package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.WorkerJobLogsQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description WorkerJobLogsService 接口类
*/
public interface WorkerJobLogsService extends BaseService{

    CommonResponse saveOrEdit(WorkerJobLogsQuery query, HttpServletRequest request, HttpServletResponse response);

}
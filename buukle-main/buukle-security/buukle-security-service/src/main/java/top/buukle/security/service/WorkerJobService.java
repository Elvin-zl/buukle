package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.WorkerJobQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description WorkerJobService 接口类
*/
public interface WorkerJobService extends BaseService{

    CommonResponse saveOrEdit(WorkerJobQuery query, HttpServletRequest request, HttpServletResponse response);

}
package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.WorkerTaskQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description WorkerTaskService 接口类
*/
public interface WorkerTaskService extends BaseService{

    CommonResponse saveOrEdit(WorkerTaskQuery query, HttpServletRequest request, HttpServletResponse response);

}
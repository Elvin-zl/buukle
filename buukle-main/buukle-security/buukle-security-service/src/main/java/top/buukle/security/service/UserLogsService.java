package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.UserLogsQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description UserLogsService 接口类
*/
public interface UserLogsService extends BaseService{

    CommonResponse saveOrEdit(UserLogsQuery query, HttpServletRequest request, HttpServletResponse response);

}
package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.InterfaceRegisterLogsQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description InterfaceRegisterLogsService 接口类
*/
public interface InterfaceRegisterLogsService extends BaseService{

    CommonResponse saveOrEdit(InterfaceRegisterLogsQuery query, HttpServletRequest request, HttpServletResponse response);

}
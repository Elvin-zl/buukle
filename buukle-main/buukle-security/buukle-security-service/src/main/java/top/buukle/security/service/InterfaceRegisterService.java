package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.InterfaceRegisterQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description InterfaceRegisterService 接口类
*/
public interface InterfaceRegisterService extends BaseService{

    CommonResponse saveOrEdit(InterfaceRegisterQuery query, HttpServletRequest request, HttpServletResponse response);

}
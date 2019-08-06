package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.ButtonQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description ButtonService 接口类
*/
public interface ButtonService extends BaseService{

    CommonResponse saveOrEdit(ButtonQuery query, HttpServletRequest request, HttpServletResponse response);

}
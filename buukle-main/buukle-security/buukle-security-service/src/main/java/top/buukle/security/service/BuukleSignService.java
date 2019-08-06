package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.BuukleSignQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description BuukleSignService 接口类
*/
public interface BuukleSignService extends BaseService{

    CommonResponse saveOrEdit(BuukleSignQuery query, HttpServletRequest request, HttpServletResponse response);

}
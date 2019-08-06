package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.security.entity.vo.AreaQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
* @author elvin
* @description AreaService 接口类
*/
public interface AreaService extends BaseService{

    CommonResponse saveOrEdit(AreaQuery query, HttpServletRequest request, HttpServletResponse response);

}
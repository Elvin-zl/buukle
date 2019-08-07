package top.buukle.security .service;

import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.entity.vo.ItemQuery;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
* @author elvin
* @description ItemService 接口类
*/
public interface ItemService extends BaseService{

    CommonResponse saveOrEdit(ItemQuery query, HttpServletRequest request, HttpServletResponse response);

    PageResponse itemList(Map<String, String> query);
}
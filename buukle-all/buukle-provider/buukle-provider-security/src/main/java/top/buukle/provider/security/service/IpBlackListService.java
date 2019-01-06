package top.buukle.provider.security .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.plugin.security.entity.IpBlackList;
import top.buukle.plugin.security.entity.vo.IpBlackListQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description IpBlackListService 接口类
*/
public interface IpBlackListService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<IpBlackList> getIpBlackListList(IpBlackListQuery query, PageBounds pageBounds);

    /**
    * 模糊搜索
    * @param fuzzyText
    * @return
    */
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText);

    /**
    * 逻辑删除单条数据
    * @param query
    * @param request
    * @return
    */
    BaseResponse deleteIpBlackList(IpBlackListQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    IpBlackList getIpBlackListDetail(IpBlackListQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveIpBlackList(IpBlackListQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateIpBlackList(IpBlackListQuery query, HttpServletRequest request);
}
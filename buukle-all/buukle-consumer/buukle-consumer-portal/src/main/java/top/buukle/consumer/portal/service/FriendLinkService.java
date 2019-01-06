package top.buukle.consumer.portal.service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.entity.FriendLink;
import top.buukle.consumer.portal.entity.vo.FriendLinkQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
* @author elvin
* @description FriendLinkService 接口类
*/
public interface FriendLinkService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<FriendLink> getFriendLinkList(FriendLinkQuery query, PageBounds pageBounds);

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
    BaseResponse deleteFriendLink(FriendLinkQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    FriendLink getFriendLinkDetail(FriendLinkQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveFriendLink(FriendLinkQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateFriendLink(FriendLinkQuery query, HttpServletRequest request);
}
package top.buukle.consumer.cms .service;

import top.buukle.common.response.BaseResponse;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import java.util.List;
import top.buukle.consumer.cms .entity.UserMessage;
import top.buukle.consumer.cms .entity.vo.UserMessageQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description UserMessageService 接口类
*/
public interface UserMessageService{

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    public PageResponse<UserMessage> getUserMessageList(UserMessageQuery query, PageBounds pageBounds);

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
    BaseResponse deleteUserMessage(UserMessageQuery query, HttpServletRequest request);

    /**
    * 获取记录详情
    * @param query
    * @return
    */
    UserMessage getUserMessageDetail(UserMessageQuery query);


    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse saveUserMessage(UserMessageQuery query, HttpServletRequest request);

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    BaseResponse updateUserMessage(UserMessageQuery query, HttpServletRequest request);
}
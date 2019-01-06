package top.buukle.consumer.portal.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.portal.constants.StatusConstants;
import top.buukle.consumer.portal.dao.FriendLinkMapper;
import top.buukle.consumer.portal.entity.FriendLink;
import top.buukle.consumer.portal.entity.FriendLinkExample;
import top.buukle.consumer.portal.entity.vo.FriendLinkQuery;
import top.buukle.consumer.portal.service.FriendLinkService;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description FriendLinkService实现类
*/
@Service
public class FriendLinkServiceImpl implements FriendLinkService {

    @Autowired
    private FriendLinkMapper friendLinkMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<FriendLink> getFriendLinkList(FriendLinkQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(friendLinkMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<FriendLink> list = friendLinkMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (FriendLink item: list) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                //fuzzySearchListVo.setText(item.getTitle());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
        }

    /**
    * 根据id更新记录状态数据
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse deleteFriendLink(FriendLinkQuery query, HttpServletRequest request) {
        if(friendLinkMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query, StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
            throw new BaseException(BaseResponseCode.STATUS_UPDATE_FAIL);
        }
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 查询记录详情
    * @param query
    * @return
    */
    @Override
    public FriendLink getFriendLinkDetail(FriendLinkQuery query) {
        return friendLinkMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveFriendLink(FriendLinkQuery query, HttpServletRequest request) {
        friendLinkMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateFriendLink(FriendLinkQuery query, HttpServletRequest request) {
        FriendLinkExample friendLinkExample = new FriendLinkExample();
        FriendLinkExample.Criteria criteria = friendLinkExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        friendLinkMapper.updateByExampleSelective(query,friendLinkExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private FriendLink assQueryForInsert(FriendLinkQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        //TODO
        //query.setPlatformId(operator.getPlatformId());
        //query.setAgentId(operator.getAgentId());
        //query.setGroupId(operator.getGroupId());
        //query.setSalesmanId(operator.getSalesmanId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private FriendLink assQueryForUpdateStatus(FriendLinkQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        FriendLinkQuery infoQuery = new FriendLinkQuery();
        infoQuery.setId(query.getId());
        infoQuery.setStatus(status);
        infoQuery.setGmtModified(new Date());
        infoQuery.setModifier(operator.getUsername());
        infoQuery.setModifierCode(operator.getUserId());
        return infoQuery;
    }

    /**
    * 组装分页参数
    * @param query
    * @return
    */
    private FriendLinkExample assExampleForList(FriendLinkQuery query) {
        FriendLinkExample example = new FriendLinkExample();
        FriendLinkExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        //TODO
        //if(StringUtil.isNotEmpty(query.getTitle())){
        //    criteria.andTitleEqualTo(query.getTitle());
        //}
        if(null != query.getStatus()){
            criteria.andStatusEqualTo(query.getStatus());
        }
        return example;
    }

    /**
    * 组装模糊搜索Example
    * @param fuzzyText
    * @return
    */
    private FriendLinkExample assFuzzyExample(String fuzzyText) {
        FriendLinkExample example = new FriendLinkExample();
        FriendLinkExample.Criteria criteria = example.createCriteria();
        //TODO
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}
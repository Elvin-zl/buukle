package top.buukle.consumer.www.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www.constants.StatusConstants;
import top.buukle.consumer.www.entity.TimelineInfoExample;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.consumer.www.service.TimelineInfoService;
import top.buukle.consumer.www.dao.TimelineInfoMapper;
import top.buukle.consumer.www.entity.TimelineInfo;
import top.buukle.consumer.www.entity.vo.TimelineInfoQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description TimelineInfoService实现类
*/
@Service
public class TimelineInfoServiceImpl implements TimelineInfoService{

    @Autowired
    private TimelineInfoMapper timelineInfoMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<TimelineInfo> getTimelineInfoList(TimelineInfoQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(timelineInfoMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<TimelineInfo> list = timelineInfoMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (TimelineInfo item: list) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(item.getTopic());
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
    public BaseResponse deleteTimelineInfo(TimelineInfoQuery query, HttpServletRequest request) {
        if(timelineInfoMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query, StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public TimelineInfo getTimelineInfoDetail(TimelineInfoQuery query) {
        return timelineInfoMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveTimelineInfo(TimelineInfoQuery query, HttpServletRequest request) {
        timelineInfoMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateTimelineInfo(TimelineInfoQuery query, HttpServletRequest request) {
        TimelineInfoExample timelineInfoExample = new TimelineInfoExample();
        TimelineInfoExample.Criteria criteria = timelineInfoExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        timelineInfoMapper.updateByExampleSelective(query,timelineInfoExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private TimelineInfo assQueryForInsert(TimelineInfoQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        query.setPlatformId(operator.getPlatformId());
        query.setAgentId(operator.getAgentId());
        query.setGroupId(operator.getGroupId());
        query.setSalesmanId(operator.getSalesmanId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private TimelineInfo assQueryForUpdateStatus(TimelineInfoQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        TimelineInfoQuery infoQuery = new TimelineInfoQuery();
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
    private TimelineInfoExample assExampleForList(TimelineInfoQuery query) {
        TimelineInfoExample example = new TimelineInfoExample();
        TimelineInfoExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
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
    private TimelineInfoExample assFuzzyExample(String fuzzyText) {
        TimelineInfoExample example = new TimelineInfoExample();
        TimelineInfoExample.Criteria criteria = example.createCriteria();
        criteria.andTopicLike("%" + fuzzyText + "%");
        return example;
    }
}
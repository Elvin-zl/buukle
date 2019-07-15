package top.buukle.consumer.www .service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.www .constants.StatusConstants;
import top.buukle.consumer.www.constants.TimelineInfoConstants;
import top.buukle.consumer.www.dao.TimelineInfoMapper;
import top.buukle.consumer.www.entity.*;
import top.buukle.consumer.www.entity.vo.CommentResponseVo;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.consumer.www .service.TimelineCommentService;
import top.buukle.consumer.www .dao.TimelineCommentMapper;
import top.buukle.consumer.www .entity.vo.TimelineCommentQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description TimelineCommentService实现类
*/
@Service
public class TimelineCommentServiceImpl implements TimelineCommentService{

    @Autowired
    private TimelineCommentMapper timelineCommentMapper;
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
    public PageResponse<TimelineComment> getTimelineCommentList(TimelineCommentQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(timelineCommentMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<TimelineComment> list = timelineCommentMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (TimelineComment item: list) {
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
    public BaseResponse deleteTimelineComment(TimelineCommentQuery query, HttpServletRequest request) {
        if(timelineCommentMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public TimelineComment getTimelineCommentDetail(TimelineCommentQuery query) {
        return timelineCommentMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveTimelineComment(TimelineCommentQuery query, HttpServletRequest request) {
        query.setStatus(StatusConstants.STATUS_OPEN);
        timelineCommentMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateTimelineComment(TimelineCommentQuery query, HttpServletRequest request) {
        TimelineCommentExample timelineCommentExample = new TimelineCommentExample();
        TimelineCommentExample.Criteria criteria = timelineCommentExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        timelineCommentMapper.updateByExampleSelective(query,timelineCommentExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * @description 加载信息流评论
     * @param query
     * @param pageBounds
     * @param request
     * @return top.buukle.common.response.BaseResponse<top.buukle.consumer.www.entity.TimelineInfo>
     * @Author zhanglei1102
     * @Date 2019/7/4
     */
    @Override
    public BaseResponse<TimelineInfo> getTimelineComments(TimelineCommentQuery query, PageBounds pageBounds, HttpServletRequest request) {
        TimelineCommentExample timelineCommentExample = new TimelineCommentExample();
        TimelineCommentExample.Criteria criteria = timelineCommentExample.createCriteria();
        criteria.andTimelineInfoIdEqualTo(query.getTimelineInfoId());
        criteria.andPidTypeEqualTo(TimelineInfoConstants.PID_TYPE_COMMENT);
        TimelineInfo timelineInfo = timelineInfoMapper.selectByPrimaryKey(query.getTimelineInfoId());
//        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        // 查询文章评论
        List<TimelineComment> timelineCommentList = timelineCommentMapper.selectByExample(timelineCommentExample);
        List<CommentResponseVo> responseVoList = new ArrayList<>();
        if(org.springframework.util.CollectionUtils.isEmpty(timelineCommentList)){
            return new BaseResponse.Builder().buildSuccess();
        }
        // 组装返回实体
        this.assSonComments(responseVoList,timelineCommentList,pageBounds,timelineInfo != null && securityClient.getUserInfo(request).getUserId().equals(timelineInfo.getUserId()));
        return new BaseResponse.Builder().buildSuccess(responseVoList);
    }

    @Override
    public BaseResponse saveComment(TimelineCommentQuery query, HttpServletRequest request) {
        return this.saveTimelineComment(query, request);
    }

    /**
     * 组装子列表,并递归调用查询回复列表
     * @param responseVoList
     * @param timelineComments
     * @param pageBounds
     * @param isAuthor
     */
    private void assSonComments(List<CommentResponseVo> responseVoList, List<TimelineComment> timelineComments, PageBounds pageBounds, Boolean isAuthor) {
        for (TimelineComment timelineComment: timelineComments) {
            CommentResponseVo responseVo = new CommentResponseVo();
            BeanUtils.copyProperties(timelineComment,responseVo);
            responseVo.setAuthorFlag(isAuthor);
            responseVoList.add(responseVo);
            this.getSonComments(responseVo,pageBounds,isAuthor);
        }
    }

    /**
     * 查询回复
     * @param responseVo
     * @param pageBounds
     * @param isAuthor
     */
    private void getSonComments(CommentResponseVo responseVo, PageBounds pageBounds, Boolean isAuthor) {
        TimelineCommentExample timelineCommentExample = new TimelineCommentExample();
        TimelineCommentExample.Criteria criteria = timelineCommentExample.createCriteria();
        criteria.andPidEqualTo(responseVo.getId());
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<TimelineComment> sonCommentList = timelineCommentMapper.selectByExample(timelineCommentExample);
        if(org.springframework.util.CollectionUtils.isEmpty(sonCommentList)){
            return;
        }
        List<CommentResponseVo> responseVoList = new ArrayList<>();
        this.assSonComments(responseVoList,sonCommentList,pageBounds, isAuthor);
        responseVo.setSons(responseVoList);
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private TimelineComment assQueryForInsert(TimelineCommentQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private TimelineComment assQueryForUpdateStatus(TimelineCommentQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        TimelineCommentQuery infoQuery = new TimelineCommentQuery();
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
    private TimelineCommentExample assExampleForList(TimelineCommentQuery query) {
        TimelineCommentExample example = new TimelineCommentExample();
        TimelineCommentExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(StringUtil.isNotEmpty(query.getComment())){
            criteria.andCommentEqualTo(query.getComment());
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
    private TimelineCommentExample assFuzzyExample(String fuzzyText) {
        TimelineCommentExample example = new TimelineCommentExample();
        TimelineCommentExample.Criteria criteria = example.createCriteria();
        criteria.andCommentLike("%" + fuzzyText + "%");
        return example;
    }
}
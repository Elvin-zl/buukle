package top.buukle.consumer.cms .service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.consumer.cms .constants.StatusConstants;
import top.buukle.consumer.cms .entity.UserImageExample;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.consumer.cms .service.UserImageService;
import top.buukle.consumer.cms .dao.UserImageMapper;
import top.buukle.consumer.cms .entity.UserImage;
import top.buukle.consumer.cms .entity.vo.UserImageQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description UserImageService实现类
*/
@Service
public class UserImageServiceImpl implements UserImageService{

    @Autowired
    private UserImageMapper userImageMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<UserImage> getUserImageList(UserImageQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(userImageMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<UserImage> list = userImageMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (UserImage item: list) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                // fuzzySearchListVo.setText(item.getTitle());
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
    public BaseResponse deleteUserImage(UserImageQuery query, HttpServletRequest request) {
        if(userImageMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public UserImage getUserImageDetail(UserImageQuery query) {
        return userImageMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveUserImage(UserImageQuery query, HttpServletRequest request) {
        userImageMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateUserImage(UserImageQuery query, HttpServletRequest request) {
        UserImageExample userImageExample = new UserImageExample();
        UserImageExample.Criteria criteria = userImageExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        userImageMapper.updateByExampleSelective(query,userImageExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private UserImage assQueryForInsert(UserImageQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        // TODO
        // query.setPlatformId(operator.getPlatformId());
        // query.setAgentId(operator.getAgentId());
        // query.setGroupId(operator.getGroupId());
        // query.setSalesmanId(operator.getSalesmanId());
        return query;
    }

    /**
    * 组装更新状态实体
    * @param query
    * @param status
    * @param request
    * @return
    */
    private UserImage assQueryForUpdateStatus(UserImageQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        UserImageQuery infoQuery = new UserImageQuery();
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
    private UserImageExample assExampleForList(UserImageQuery query) {
        UserImageExample example = new UserImageExample();
        UserImageExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        // TODO
        // if(StringUtil.isNotEmpty(query.getTitle())){
        //     criteria.andTitleEqualTo(query.getTitle());
        // }
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
    private UserImageExample assFuzzyExample(String fuzzyText) {
        UserImageExample example = new UserImageExample();
        UserImageExample.Criteria criteria = example.createCriteria();
        // TODO
        // criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}
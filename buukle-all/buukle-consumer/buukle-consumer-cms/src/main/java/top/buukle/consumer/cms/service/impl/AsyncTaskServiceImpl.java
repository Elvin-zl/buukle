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
import top.buukle.consumer.cms .entity.AsyncTaskExample;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.consumer.cms .service.AsyncTaskService;
import top.buukle.consumer.cms .dao.AsyncTaskMapper;
import top.buukle.consumer.cms .entity.AsyncTask;
import top.buukle.consumer.cms .entity.vo.AsyncTaskQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description AsyncTaskService实现类
*/
@Service
public class AsyncTaskServiceImpl implements AsyncTaskService{

    @Autowired
    private AsyncTaskMapper asyncTaskMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<AsyncTask> getAsyncTaskList(AsyncTaskQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(asyncTaskMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<AsyncTask> list = asyncTaskMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (AsyncTask item: list) {
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
    public BaseResponse deleteAsyncTask(AsyncTaskQuery query, HttpServletRequest request) {
        if(asyncTaskMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public AsyncTask getAsyncTaskDetail(AsyncTaskQuery query) {
        return asyncTaskMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveAsyncTask(AsyncTaskQuery query, HttpServletRequest request) {
        asyncTaskMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateAsyncTask(AsyncTaskQuery query, HttpServletRequest request) {
        AsyncTaskExample asyncTaskExample = new AsyncTaskExample();
        AsyncTaskExample.Criteria criteria = asyncTaskExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        asyncTaskMapper.updateByExampleSelective(query,asyncTaskExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private AsyncTask assQueryForInsert(AsyncTaskQuery query, HttpServletRequest request) {
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
    private AsyncTask assQueryForUpdateStatus(AsyncTaskQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        AsyncTaskQuery infoQuery = new AsyncTaskQuery();
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
    private AsyncTaskExample assExampleForList(AsyncTaskQuery query) {
        AsyncTaskExample example = new AsyncTaskExample();
        AsyncTaskExample.Criteria criteria = example.createCriteria();
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
    private AsyncTaskExample assFuzzyExample(String fuzzyText) {
        AsyncTaskExample example = new AsyncTaskExample();
        AsyncTaskExample.Criteria criteria = example.createCriteria();
        // TODO
        // criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}
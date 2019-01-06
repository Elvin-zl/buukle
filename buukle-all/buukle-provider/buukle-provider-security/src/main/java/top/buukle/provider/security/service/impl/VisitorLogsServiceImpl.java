package top.buukle.provider.security .service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.DateUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.vo.response.PageResponse;
import top.buukle.provider.security .constants.StatusConstants;
import top.buukle.plugin.security.entity.VisitorLogsExample;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.provider.security .service.VisitorLogsService;
import top.buukle.provider.security .dao.VisitorLogsMapper;
import top.buukle.plugin.security.entity.VisitorLogs;
import top.buukle.plugin.security.entity.vo.VisitorLogsQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description VisitorLogsService实现类
*/
@Service
public class VisitorLogsServiceImpl implements VisitorLogsService{

    @Autowired
    private VisitorLogsMapper visitorLogsMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<VisitorLogs> getVisitorLogsList(VisitorLogsQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(visitorLogsMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<VisitorLogs> list = visitorLogsMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (VisitorLogs item: list) {
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
    public BaseResponse deleteVisitorLogs(VisitorLogsQuery query, HttpServletRequest request) {
        if(visitorLogsMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public VisitorLogs getVisitorLogsDetail(VisitorLogsQuery query) {
        return visitorLogsMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveVisitorLogs(VisitorLogsQuery query, HttpServletRequest request) {
        visitorLogsMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateVisitorLogs(VisitorLogsQuery query, HttpServletRequest request) {
        VisitorLogsExample visitorLogsExample = new VisitorLogsExample();
        VisitorLogsExample.Criteria criteria = visitorLogsExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        visitorLogsMapper.updateByExampleSelective(query,visitorLogsExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private VisitorLogs assQueryForInsert(VisitorLogsQuery query, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        query.setGmtCreated(new Date());
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
    private VisitorLogs assQueryForUpdateStatus(VisitorLogsQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        VisitorLogsQuery infoQuery = new VisitorLogsQuery();
        infoQuery.setId(query.getId());
        infoQuery.setStatus(status);
        return infoQuery;
    }

    /**
    * 组装分页参数
    * @param query
    * @return
    */
    private VisitorLogsExample assExampleForList(VisitorLogsQuery query) {
        VisitorLogsExample example = new VisitorLogsExample();
        VisitorLogsExample.Criteria criteria = example.createCriteria();
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
    private VisitorLogsExample assFuzzyExample(String fuzzyText) {
        VisitorLogsExample example = new VisitorLogsExample();
        VisitorLogsExample.Criteria criteria = example.createCriteria();
        //TODO
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}
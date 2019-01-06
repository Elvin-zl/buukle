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
import top.buukle.plugin.security.entity.IpBlackListExample;
import top.buukle.plugin.security.client.SecurityClient;
import top.buukle.plugin.security.entity.User;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import top.buukle.provider.security .service.IpBlackListService;
import top.buukle.provider.security .dao.IpBlackListMapper;
import top.buukle.plugin.security.entity.IpBlackList;
import top.buukle.plugin.security.entity.vo.IpBlackListQuery;

import javax.servlet.http.HttpServletRequest;

/**
* @author elvin
* @description IpBlackListService实现类
*/
@Service
public class IpBlackListServiceImpl implements IpBlackListService{

    @Autowired
    private IpBlackListMapper ipBlackListMapper;

    @Autowired
    private SecurityClient securityClient;

    /**
    * 分页获取列表
    * @param query
    * @param pageBounds
    * @return
    */
    @Override
    public PageResponse<IpBlackList> getIpBlackListList(IpBlackListQuery query, PageBounds pageBounds) {
    PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        return new PageResponse.Builder().build(new PageInfo<>(ipBlackListMapper.selectByExample(this.assExampleForList(query))));
    }

    /**
    * 模糊搜素
    * @param fuzzyText
    * @return
    */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByText(String fuzzyText) {
        List<IpBlackList> list = ipBlackListMapper.selectByExample(this.assFuzzyExample(fuzzyText));
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(list)){
            for (IpBlackList item: list) {
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
    public BaseResponse deleteIpBlackList(IpBlackListQuery query, HttpServletRequest request) {
        if(ipBlackListMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(query,StatusConstants.STATUS_DELETED_CONCEALABLE,request)) != 1){
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
    public IpBlackList getIpBlackListDetail(IpBlackListQuery query) {
        return ipBlackListMapper.selectByPrimaryKey(query.getId());
    }

    /**
    * 保存记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse saveIpBlackList(IpBlackListQuery query, HttpServletRequest request) {
        ipBlackListMapper.insert(this.assQueryForInsert(query,request));
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 更新记录
    * @param query
    * @param request
    * @return
    */
    @Override
    public BaseResponse updateIpBlackList(IpBlackListQuery query, HttpServletRequest request) {
        IpBlackListExample ipBlackListExample = new IpBlackListExample();
        IpBlackListExample.Criteria criteria = ipBlackListExample.createCriteria();
        criteria.andIdEqualTo(query.getId());
        User operator = securityClient.getUserInfo(request);
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());
        ipBlackListMapper.updateByExampleSelective(query,ipBlackListExample);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
    * 组装新增实体
    * @param query
    * @param request
    * @return
    */
    private IpBlackList assQueryForInsert(IpBlackListQuery query, HttpServletRequest request) {
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
    private IpBlackList assQueryForUpdateStatus(IpBlackListQuery query, Integer status, HttpServletRequest request) {
        User operator = securityClient.getUserInfo(request);
        IpBlackListQuery infoQuery = new IpBlackListQuery();
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
    private IpBlackListExample assExampleForList(IpBlackListQuery query) {
        IpBlackListExample example = new IpBlackListExample();
        IpBlackListExample.Criteria criteria = example.createCriteria();
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
    private IpBlackListExample assFuzzyExample(String fuzzyText) {
        IpBlackListExample example = new IpBlackListExample();
        IpBlackListExample.Criteria criteria = example.createCriteria();
        //TODO
        //criteria.andTitleLike("%" + fuzzyText + "%");
        return example;
    }
}
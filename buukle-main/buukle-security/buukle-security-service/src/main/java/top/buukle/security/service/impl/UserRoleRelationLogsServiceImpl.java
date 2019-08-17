package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security .dao.UserRoleRelationLogsMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security .entity.User;
import top.buukle.security .entity.UserRoleRelationLogs;
import top.buukle.security .entity.UserRoleRelationLogsExample;
import top.buukle.security .entity.vo.BaseQuery;
import top.buukle.security .entity.vo.UserRoleRelationLogsQuery;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.UserRoleRelationLogsService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.UserRoleRelationLogsEnums;
import top.buukle.security .service.exception.SystemException;
import top.buukle.security .service.util.ConvertHumpUtil;
import top.buukle.util.DateUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description UserRoleRelationLogsService实现类
*/
@Service("userRoleRelationLogsService")
public class UserRoleRelationLogsServiceImpl implements UserRoleRelationLogsService{

    @Autowired
    private UserRoleRelationLogsMapper userRoleRelationLogsMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((UserRoleRelationLogsQuery)query).getPage(),((UserRoleRelationLogsQuery)query).getPageSize());
        List<UserRoleRelationLogs> list = userRoleRelationLogsMapper.selectByExample(this.assExampleForList(((UserRoleRelationLogsQuery)query)));
        PageInfo<UserRoleRelationLogs> pageInfo = new PageInfo<>(list);
        return new PageResponse.Builder().build(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
    }

    /**
     * 根据id删除记录状态数据
     * @param id 删除数据实例
     * @param request httpServletRequest
     * @param response
     * @return
     */
    @Override
    public CommonResponse delete(Integer id, HttpServletRequest request, HttpServletResponse response) {
        if(userRoleRelationLogsMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, UserRoleRelationLogsEnums.status.DELETED.value(),request,response)) != 1){
            throw new SystemException(SystemReturnEnum.DELETE_INFO_EXCEPTION);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 批量删除
     * @param ids
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public CommonResponse deleteBatch(String ids, HttpServletRequest request, HttpServletResponse response) {
        String trimIds = ids.trim();
        String[] split = trimIds.split(",");
        if(StringUtil.isEmpty(trimIds) || split.length<1){
            throw new SystemException(SystemReturnEnum.USER_BATCH_DELETE_IDS_NULL);
        }
        List<Integer> idList = JsonUtil.parseArray(JsonUtil.toJSONString(Arrays.asList(split)), Integer.class);
        UserRoleRelationLogsExample userRoleRelationLogsExample = new UserRoleRelationLogsExample();
        UserRoleRelationLogsExample.Criteria criteria = userRoleRelationLogsExample.createCriteria();
        criteria.andIdIn(idList);
        UserRoleRelationLogs userRoleRelationLogs = new UserRoleRelationLogs();

        User operator = SessionUtil. getOperator(request, response);
        userRoleRelationLogs.setGmtModified(new Date());
        userRoleRelationLogs.setModifier(operator.getUsername());
        userRoleRelationLogs.setModifierCode(operator.getUserId());

        userRoleRelationLogs.setStatus(UserRoleRelationLogsEnums.status.DELETED.value());
        userRoleRelationLogsMapper.updateByExampleSelective(userRoleRelationLogs,userRoleRelationLogsExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.UserRoleRelationLogs
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public UserRoleRelationLogs selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new UserRoleRelationLogs();
        }
        UserRoleRelationLogs userRoleRelationLogs = userRoleRelationLogsMapper.selectByPrimaryKey(id);
        return userRoleRelationLogs == null ? new UserRoleRelationLogs() : userRoleRelationLogs;
    }

    /**
     * @description 新增或者修改
     * @param query
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/5
     */
    @Override
    public CommonResponse saveOrEdit(UserRoleRelationLogsQuery query, HttpServletRequest request, HttpServletResponse response) {
        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            this.save(query,request,response);
        }
        // 更新
        else{
            this.update(query,request,response);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 模糊搜素
     * @param text 模糊的字符
     * @param fieldName 模糊字段名
     * @return FuzzyResponse
     */
    @Override
    public FuzzyResponse fuzzySearch(String text, String fieldName) {
        FuzzyVo fuzzyVo = new FuzzyVo();
        fuzzyVo.setText(text);
        fuzzyVo.setFieldName(fieldName);
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("UserRoleRelationLogs"));
        return new FuzzyResponse.Builder().build(commonMapper.fuzzySearch(fuzzyVo));
    }

    /**
     * 保存记录
     * @param query  查询实体
     * @param request httpServletRequest
     * @param response
     * @return
     */
    @Override
    public CommonResponse save(BaseQuery query, HttpServletRequest request, HttpServletResponse response) {

        userRoleRelationLogsMapper.insert(this.assQueryForInsert((UserRoleRelationLogsQuery)query,request,response));
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 更新记录
     * @param query
     * @param request
     * @param response
     * @return
     */
    @Override
    public CommonResponse update(BaseQuery query, HttpServletRequest request, HttpServletResponse response) {
        UserRoleRelationLogsQuery userRoleRelationLogsQuery = ((UserRoleRelationLogsQuery)query);

        UserRoleRelationLogsExample example = new UserRoleRelationLogsExample();
        UserRoleRelationLogsExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userRoleRelationLogsQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        userRoleRelationLogsQuery.setGmtModified(new Date());
        userRoleRelationLogsQuery.setModifier(operator.getUsername());
        userRoleRelationLogsQuery.setModifierCode(operator.getUserId());
        userRoleRelationLogsMapper.updateByExampleSelective(userRoleRelationLogsQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(UserRoleRelationLogsQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private UserRoleRelationLogs assQueryForInsert(UserRoleRelationLogsQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(UserRoleRelationLogsEnums.status.INIT.value());
        query.setGmtCreated(new Date());
        User operator = SessionUtil.getOperator(request, response);
        query.setCreator(operator.getUsername());
        query.setCreatorCode(operator.getUserId());
        query.setGmtModified(new Date());
        query.setModifier(operator.getUsername());
        query.setModifierCode(operator.getUserId());

        return query;
    }

    /**
     * 组装更新状态实体
     * @param id
     * @param status
     * @param request
     * @param response
     * @return
     */
    private UserRoleRelationLogs assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        UserRoleRelationLogsQuery infoQuery = new UserRoleRelationLogsQuery();
        User operator = SessionUtil. getOperator(request, response);
        infoQuery.setId(id);
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
    private UserRoleRelationLogsExample assExampleForList(UserRoleRelationLogsQuery query) {
        UserRoleRelationLogsExample example = new UserRoleRelationLogsExample();
        UserRoleRelationLogsExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        // TODO
        if(StringUtil.isNotEmpty(query.getStates())){
            List list = new ArrayList();
            for (String state : query.getStates().split(",")) {
                list.add(Integer.parseInt(state));
            }
            criteria.andStatusIn(list);
        }
        criteria.andStatusNotEqualTo(StatusConstants.DELETED);
        example.setOrderByClause("gmt_modified desc");
        return example;
    }
}
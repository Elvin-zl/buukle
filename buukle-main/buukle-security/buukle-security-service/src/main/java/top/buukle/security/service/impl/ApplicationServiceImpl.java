package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security .dao.ApplicationMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security.dao.UserMapper;
import top.buukle.security.entity.*;
import top.buukle.security .entity.vo.BaseQuery;
import top.buukle.security .entity.vo.ApplicationQuery;
import top.buukle.security.entity.vo.SelectTreeNodeResult;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.ApplicationService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.ApplicationEnums;
import top.buukle.security.service.constants.UserEnums;
import top.buukle.security .service.exception.SystemException;
import top.buukle.security .service.util.ConvertHumpUtil;
import top.buukle.util.DateUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**
* @author elvin
* @description ApplicationService实现类
*/
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService{

    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((ApplicationQuery)query).getPage(),((ApplicationQuery)query).getPageSize());
        List<Application> list = applicationMapper.selectByExample(this.assExampleForList(((ApplicationQuery)query)));
        PageInfo<Application> pageInfo = new PageInfo<>(list);
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
        // 校验操作权限
        this.validatePerm(request,applicationMapper.selectByPrimaryKey(id));
        if(applicationMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, ApplicationEnums.status.DELETED.value(),request,response)) != 1){
            throw new SystemException(SystemReturnEnum.DELETE_INFO_EXCEPTION);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验操作权限
     * @param request
     * @param application
     * @return void
     * @Author elvin
     * @Date 2019/8/18
     */
    private void validatePerm(HttpServletRequest request, Application application) {
        // 查询当前用户角色
        Map<String,Role> roleMap = (Map<String,Role>)SessionUtil.get(request, SessionUtil.USER_ROLE_MAP_KEY);
        if(application != null){
            UserExample userExample = new UserExample();
            userExample.createCriteria().andUserIdEqualTo(application.getCreatorCode());
            List<User> users = userMapper.selectByExample(userExample);
            if(CollectionUtils.isEmpty(users) || users.size()!=1){
                throw new SystemException(SystemReturnEnum.APPLICATION_SAVE_OR_EDIT_NO_CREATOR);
            }
            if(UserEnums.superManager.SYSTEM_MANAGER.value().equals(users.get(0).getSuperManager())){
                throw new SystemException(SystemReturnEnum.OPERATE_INFO_SYSTEM_PROTECT_EXCEPTION);
            }
            Role role = roleMap.get(application.getCode());
            if(role == null || !role.getPid().equals(0)){
                throw new SystemException(SystemReturnEnum.APPLICATION_SAVE_OR_EDIT_NO_PERM);
            }
        }
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
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andIdIn(idList);
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        for (Application application: applications) {
            // 校验操作权限
            this.validatePerm(request,application);
        }
        Application application = new Application();
        User operator = SessionUtil. getOperator(request, response);
        application.setGmtModified(new Date());
        application.setModifier(operator.getUsername());
        application.setModifierCode(operator.getUserId());

        application.setStatus(ApplicationEnums.status.DELETED.value());
        applicationMapper.updateByExampleSelective(application,applicationExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.Application
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public Application selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new Application();
        }
        Application application = applicationMapper.selectByPrimaryKey(id);
        // 校验操作权限
        this.validatePerm(httpServletRequest,application);
        return application == null ? new Application() : application;
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
    public CommonResponse saveOrEdit(ApplicationQuery query, HttpServletRequest request, HttpServletResponse response) {
        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            this.save(query,request,response);
        }
        // 更新
        else{
            // 校验操作权限
            this.validatePerm(request,applicationMapper.selectByPrimaryKey(query.getId()));
            this.update(query,request,response);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 获取应用树
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author zhanglei1102
     * @Date 2019/8/9
     */
    @Override
    public PageResponse getApplicationTree(HttpServletRequest request, HttpServletResponse response) {
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andStatusEqualTo(ApplicationEnums.status.PUBLISED.value());
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        List<SelectTreeNodeResult> nodes = new ArrayList<>();
        for (Application application: applications) {
            SelectTreeNodeResult node = new SelectTreeNodeResult();
            node.setId(application.getId());
            node.setTitle(application.getCode());
            node.setSpread(false);
            nodes.add(node);
        }
        return new PageResponse.Builder().build(nodes,0,0,0);
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Application"));
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

        applicationMapper.insert(this.assQueryForInsert((ApplicationQuery)query,request,response));
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
        ApplicationQuery applicationQuery = ((ApplicationQuery)query);

        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(applicationQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        applicationQuery.setGmtModified(new Date());
        applicationQuery.setModifier(operator.getUsername());
        applicationQuery.setModifierCode(operator.getUserId());
        applicationMapper.updateByExampleSelective(applicationQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(ApplicationQuery query) {
        // TODO
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Application assQueryForInsert(ApplicationQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(ApplicationEnums.status.INIT.value());
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
    private Application assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        ApplicationQuery infoQuery = new ApplicationQuery();
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
    private ApplicationExample assExampleForList(ApplicationQuery query) {
        ApplicationExample example = new ApplicationExample();
        ApplicationExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(StringUtil.isNotEmpty(query.getName())){
            criteria.andNameEqualTo(query.getName());
        }
        if(StringUtil.isNotEmpty(query.getCode())){
            criteria.andCodeEqualTo(query.getCode());
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }

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
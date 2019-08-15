package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.util.CollectionUtils;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;
import top.buukle.security.dao.*;
import top.buukle.security.entity.*;
import top.buukle.security.entity.vo.BaseQuery;
import top.buukle.security .entity.vo.UserQuery;
import top.buukle.security.plugin.util.SessionUtil;
import top.buukle.security .service.UserService;
import top.buukle.security.service.constants.SystemConstants;
import top.buukle.security .service.constants.UserEnums;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.exception.SystemException;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.security.service.util.ConvertHumpUtil;
import top.buukle.util.DateUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.MD5Util;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
* @author elvin
* @description UserService实现类
*/
@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private UserRoleRelationMapper userRoleRelationMapper;
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
        PageHelper.startPage(((UserQuery)query).getPage(),((UserQuery)query).getPageSize());
        List<User> list = userMapper.selectByExample(this.assExampleForList(((UserQuery)query)));
        PageInfo<User> pageInfo = new PageInfo<>(list);
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
        if(userMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, UserEnums.status.DELETED.value(),request,response)) != 1){
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
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIn(idList);
        User user = new User();

        User operator = SessionUtil. getOperator(request, response);
        user.setGmtModified(new Date());
        user.setModifier(operator.getUsername());
        user.setModifierCode(operator.getUserId());

        user.setStatus(UserEnums.status.DELETED.value());
        userMapper.updateByExampleSelective(user,userExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.User
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public User selectByPrimaryKey(Integer id) {
        if(id == null){
            return new User();
        }
        User user = userMapper.selectByPrimaryKey(id);
        return user == null ? new User() : user;
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
    public CommonResponse saveOrEdit(UserQuery query, HttpServletRequest request, HttpServletResponse response) {
        validateParamForSaveOrEdit(query);
        // 新增
        if(StringUtil.isEmpty(query.getUserId())){
            this.save(query,request,response);
        }
        // 更新
        else{
            // 去除禁止更新的项
            query.setUsername(null);
            query.setPassword(null);
            query.setSex(null);
            this.update(query,request,response);
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 设置用户角色
     * @param applicationId
     * @param ids
     * @param query
     * @param request
     * @param response
     * @return top.buukle.common.call.CommonResponse
     * @Author zhanglei1102
     * @Date 2019/8/13
     */
    @Override
    public CommonResponse userRoleSet(Integer applicationId, String ids, UserQuery query, HttpServletRequest request, HttpServletResponse response) {
        // 查询应用
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria applicationCriteria = applicationExample.createCriteria();
        applicationCriteria.andIdEqualTo(applicationId);
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        if(CollectionUtils.isEmpty(applications) || applications.size() > 1 ){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_PRE_APP_CODE_WRONG);
        }
        User operator = SessionUtil.getOperator(request, response);
        // 查询现有角色
        List<Role> userRoles = roleMapper.getUserRoleWithAppId(query.getUserId(), applications.get(0).getId());
        String roleIdCollection = StringUtil.EMPTY;
        if(!CollectionUtils.isEmpty(userRoles)){
            for (Role role: userRoles) {
                // 缓存用户历史角色id
                roleIdCollection += role.getId() + StringUtil.COMMA;
                // 清空该用户的角色
                UserRoleRelationExample userRoleRelationExample = new UserRoleRelationExample();
                UserRoleRelationExample.Criteria criteria = userRoleRelationExample.createCriteria();
                criteria.andUserIdEqualTo(query.getUserId());
                criteria.andRoleIdEqualTo(role.getId());
                userRoleRelationMapper.deleteByExample(userRoleRelationExample);
            }
        }
        // 重新设置角色
        if(StringUtil.isNotEmpty(ids)){
            for (String idStr : ids.split(",")) {
                UserRoleRelation userRoleRelation = new UserRoleRelation();
                userRoleRelation.setCreator(operator.getUsername());
                userRoleRelation.setGmtCreated(new Date());
                userRoleRelation.setCreatorCode(operator.getUserId());
                userRoleRelation.setUserId(query.getUserId());
                userRoleRelation.setRoleId(Integer.parseInt(idStr));
                userRoleRelationMapper.insert(userRoleRelation);
            }
        }
        // 组装日志实体
        UserRoleRelationLogs userRoleRelationLogs = new UserRoleRelationLogs();
        userRoleRelationLogs.setGmtCreated(new Date());
        userRoleRelationLogs.setCreator(operator.getUsername());
        userRoleRelationLogs.setCreatorCode(operator.getUserId());
        userRoleRelationLogs.setRoleIdCollection(roleIdCollection);
        userRoleRelationLogs.setUserId(query.getUserId());
        // 记录日志
        userRoleRelationLogsMapper.insert(userRoleRelationLogs);
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("User"));
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
        userMapper.insert(this.assQueryForInsert((UserQuery)query,request,response));
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
        UserQuery userQuery = ((UserQuery)query);

        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(userQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        userQuery.setGmtModified(new Date());
        userQuery.setModifier(operator.getUsername());
        userQuery.setModifierCode(operator.getUserId());
        userMapper.updateByExampleSelective(userQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(UserQuery query) {
        // id和userId 不一致
        if((StringUtil.isEmpty(query.getUserId()) && query.getId() != null) || (!StringUtil.isEmpty(query.getUserId()) && query.getId() == null)){
            throw new SystemException(SystemReturnEnum.USER_SAVE_OR_EDIT_PARAM_WRONG);
        }
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private User assQueryForInsert(UserQuery query, HttpServletRequest request, HttpServletResponse response) {
        if(StringUtil.isEmpty(query.getUsername())){
            throw new SystemException(SystemReturnEnum.USER_SAVE_OR_EDIT_USERNAME_NULL);
        }
        if(StringUtil.isEmpty(query.getPassword())){
            throw new SystemException(SystemReturnEnum.USER_SAVE_OR_EDIT_PASSWORD_NULL);
        }
        if(StringUtil.isEmpty(query.getrPassword())){
            throw new SystemException(SystemReturnEnum.USER_SAVE_OR_EDIT_RPASSWORD_NULL);
        }
        if(!query.getPassword().equals(query.getrPassword())){
            throw new SystemException(SystemReturnEnum.USER_SAVE_OR_EDIT_TWO_PED_NOT_SAME);
        }
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameEqualTo(query.getUsername());
        List<User> users = userMapper.selectByExample(userExample);
        if(!CollectionUtils.isEmpty(users)){
            throw new SystemException(SystemReturnEnum.USER_SAVE_OR_EDIT_USERNAME_EXIST);
        }
        query.setPassword(MD5Util.MD5WithUTF8(query.getPassword()));
        query.setrPassword(MD5Util.MD5WithUTF8(query.getrPassword()));
        this.validateParamForSaveOrEdit(query);
        query.setStatus(UserEnums.status.INIT.value());
        query.setUserId(SystemConstants.genUserId());
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
    private User assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        User operator = SessionUtil. getOperator(request, response);
        UserQuery infoQuery = new UserQuery();
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
    private UserExample assExampleForList(UserQuery query) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        if(StringUtil.isNotEmpty(query.getUsername())){
            criteria.andUsernameEqualTo(query.getUsername());
        }
        if(StringUtil.isNotEmpty(query.getUserId())){
            criteria.andUserIdEqualTo(query.getUserId());
        }
        if(StringUtil.isNotEmpty(query.getNameCn())){
            criteria.andNameCnEqualTo(query.getNameCn());
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
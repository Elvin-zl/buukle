package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.buukle.common.call.code.BaseReturnEnum;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.exception.CommonException;
import top.buukle.common.status.StatusConstants;
import top.buukle.security .dao.UserMapper;
import top.buukle.security .entity.User;
import top.buukle.security .entity.UserExample;
import top.buukle.security.entity.vo.BaseQuery;
import top.buukle.security .entity.vo.UserQuery;
import top.buukle.security .service.UserService;
import top.buukle.security .service.constants.UserEnums;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.exception.SystemException;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.util.DateUtil;
import top.buukle.util.JsonUtil;
import top.buukle.util.StringUtil;

import javax.servlet.http.HttpServletRequest;
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
    private UserMapper userMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse userPage(BaseQuery query) {
        PageHelper.startPage(((UserQuery)query).getPage(),((UserQuery)query).getPageSize());
        List<User> list = userMapper.selectByExample(this.assExampleForList(((UserQuery)query)));
        PageInfo<User> pageInfo = new PageInfo<>(list);
        return new PageResponse.Builder().build(list,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
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
        return new FuzzyResponse.Builder().build(userMapper.fuzzySearch(fuzzyVo));
    }

    /**
     * 保存记录
     * @param query  查询实体
     * @param request httpServletRequest
     * @return
     */
    @Override
    public CommonResponse save(BaseQuery query, HttpServletRequest request) {
        userMapper.insert(this.assQueryForInsert((UserQuery)query,request));
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * 根据id删除记录状态数据
     * @param id 删除数据实例
     * @param request httpServletRequest
     * @return
     */
    @Override
    public CommonResponse delete(Integer id, HttpServletRequest request) {
        if(userMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, UserEnums.status.DELETED.value(),request)) != 1){
            throw new SystemException(SystemReturnEnum.DELETE_INFO_EXCEPTION);
        }
        return new CommonResponse.Builder().buildSuccess();
    }


    /**
     * 更新记录
     * @param query
     * @param request
     * @return
     */
    @Override
    public CommonResponse update(BaseQuery query, HttpServletRequest request) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(((UserQuery)query).getId());
//        User operator = securityClient.getUserInfo(request);
        ((UserQuery)query).setGmtModified(new Date());
//        query.setModifier(operator.getUsername());
//        query.setModifierCode(operator.getUserId());
        userMapper.updateByExampleSelective((UserQuery)query,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 批量删除
     * @param ids
     * @param request
     * @return top.buukle.common.call.CommonResponse
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public CommonResponse deleteBatch(String ids, HttpServletRequest request) {
        String trimIds = ids.trim();
        String[] split = trimIds.split(",");
        if(StringUtil.isEmpty(trimIds) || split.length<1){
            throw new SystemException(SystemReturnEnum.USER_BATCH_IDS_NULL);
        }
        List<Integer> idList = JsonUtil.parseArray(JsonUtil.toJSONString(Arrays.asList(split)), Integer.class);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdIn(idList);
        User user = new User();
        user.setStatus(UserEnums.status.DELETED.value());
        userMapper.updateByExampleSelective(user,userExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 验证参数
     * @param user
     * @return void
     * @Author elvin
     * @Date 2019/8/3
     */
    private void validationParam(User user) {
        if(null == user){
            throw new CommonException(BaseReturnEnum.LOGIN_FAILED);
        }
        if(StringUtil.isEmpty(user.getUsername()) || StringUtil.isEmpty(user.getPassword())){
            throw new CommonException(BaseReturnEnum.LOGIN_FAILED_PARAM_NULL);
        }
    }

    /**
     * 组装文章查询Example实体
     * @param query
     * @param statusList
     * @return
     */
    private UserExample assExampleForList(UserQuery query, List<Integer> statusList) {
        UserExample example = new UserExample();
        UserExample.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(null == query.getStatus()){
            criteria.andStatusIn(statusList);
        }else{
            criteria.andStatusEqualTo(query.getStatus());
        }
        example.orderBy("gmt_created desc");
        return example;
    }


    /**
     * 组装新增实体
     * @param query
     * @param request
     * @return
     */
    private User assQueryForInsert(UserQuery query, HttpServletRequest request) {
        return query;
    }

    /**
     * 组装更新状态实体
     * @param id
     * @param status
     * @param request
     * @return
     */
    private User assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request) {
//      User operator = securityClient.getUserInfo(request);
        UserQuery infoQuery = new UserQuery();
        infoQuery.setId(id);
        infoQuery.setStatus(status);
        infoQuery.setGmtModified(new Date());
//        infoQuery.setModifier(operator.getUsername());
//        infoQuery.setModifierCode(operator.getUserId());
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
}
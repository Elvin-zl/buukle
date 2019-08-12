package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security.dao.ApplicationMapper;
import top.buukle.security .dao.RoleMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security.entity.Application;
import top.buukle.security .entity.User;
import top.buukle.security .entity.Role;
import top.buukle.security .entity.RoleExample;
import top.buukle.security.entity.vo.*;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.RoleService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.RoleEnums;
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
* @description RoleService实现类
*/
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ApplicationMapper applicationMapper;

    @Autowired
    private CommonMapper commonMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((RoleQuery)query).getPage(),((RoleQuery)query).getPageSize());
        List<Role> list = roleMapper.selectByExample(this.assExampleForList(((RoleQuery)query)));
        PageInfo<Role> pageInfo = new PageInfo<>(list);
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
        if(roleMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, RoleEnums.status.DELETED.value(),request,response)) != 1){
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
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andIdIn(idList);
        Role role = new Role();

        User operator = SessionUtil. getOperator(request, response);
        role.setGmtModified(new Date());
        role.setModifier(operator.getUsername());
        role.setModifierCode(operator.getUserId());

        role.setStatus(RoleEnums.status.DELETED.value());
        roleMapper.updateByExampleSelective(role,roleExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.Role
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public RoleCrudModelVo selectByPrimaryKey(Integer id) {
        if(id == null){
            return new RoleCrudModelVo();
        }
        Role role = roleMapper.selectByPrimaryKey(id);
        RoleCrudModelVo vo = null;
        if(role != null){
            vo = new RoleCrudModelVo();
            BeanUtils.copyProperties(role,vo);
            Application application = applicationMapper.selectByPrimaryKey(vo.getApplicationId());
            vo.setApplicationCode(application.getCode());
            if(vo.getPid()!=0){
                Role superRole = roleMapper.selectByPrimaryKey(vo.getPid());
                vo.setSuperName(superRole.getRoleName());
            }else{
                vo.setSuperName("root");
            }
        }
        return role == null ? new RoleCrudModelVo() : vo;
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
    public CommonResponse saveOrEdit(RoleQuery query, HttpServletRequest request, HttpServletResponse response) {
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
     * @description 获取上级角色树
     * @param applicationId
     *@param request
     * @param response   @return top.buukle.common.call.PageResponse
     * @Author elvin
     * @Date 2019/8/9
     */
    @Override
    public PageResponse getRoleTree(Integer applicationId, HttpServletRequest request, HttpServletResponse response) {
        RoleExample applicationExample = new RoleExample();
        RoleExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andStatusEqualTo(RoleEnums.status.PUBLISED.value());
        criteria.andApplicationIdEqualTo(applicationId);
        List<Role> roles = roleMapper.selectByExample(applicationExample);
        LayUiSelectTreeNode rootNode = new LayUiSelectTreeNode();
        rootNode.setId(0);
        rootNode.setTitle("root");
        rootNode.setSpread(true);
        List<LayUiSelectTreeNode> nodes = new ArrayList<>();
        nodes.add(rootNode);
        this.findChildren(rootNode,roles);
        return new PageResponse.Builder().build(nodes,0,0,0);
    }

    /**
     * @description 获取用户在该app下的角色
     * @param applicationCode
     * @param userId
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/12
     */
    @Override
    public PageResponse getAppUserRole(String applicationCode, String userId) {

        List<LayUiSelectTreeNode> layUiSelectTreeNodes = new ArrayList<>();

        LayUiSelectTreeNode layUiSelectTreeNode1 = new LayUiSelectTreeNode();
        layUiSelectTreeNode1.setTitle("管理员");
        layUiSelectTreeNode1.setId(2);
        layUiSelectTreeNode1.setSpread(true);
        layUiSelectTreeNode1.setChecked(true);
        layUiSelectTreeNodes.add(layUiSelectTreeNode1);

        List<LayUiSelectTreeNode> layUiSelectTreeNodes1 = new ArrayList<>();
        LayUiSelectTreeNode layUiSelectTreeNode2 = new LayUiSelectTreeNode();
        layUiSelectTreeNode2.setTitle("管理员");
        layUiSelectTreeNode2.setId(1);
        layUiSelectTreeNode1.setSpread(true);
        layUiSelectTreeNode2.setChecked(true);
        layUiSelectTreeNodes1.add(layUiSelectTreeNode2);
        layUiSelectTreeNode1.setChildren(layUiSelectTreeNodes1);
        PageResponse res = new PageResponse.Builder().build(layUiSelectTreeNodes, 0, 0, 0);
        res.getHead().setMsg("1");
        return res;
    }

    /**
     * @description 寻找子节点
     * @param node
     * @param roles
     * @return void
     * @Author elvin
     * @Date 2019/8/9
     */
    private void findChildren(LayUiSelectTreeNode node, List<Role> roles) {
        List<LayUiSelectTreeNode> nodes = new ArrayList<>();
        for (Role role: roles) {
            if(role.getPid().equals(node.getId())){
                LayUiSelectTreeNode nodeNew = new LayUiSelectTreeNode();
                nodeNew.setId(role.getId());
                nodeNew.setTitle(role.getRoleName());
                nodeNew.setSpread(true);
                nodes.add(nodeNew);
                this.findChildren(nodeNew,roles);
            }
        }
        node.setChildren(nodes);
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Role"));
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

        roleMapper.insert(this.assQueryForInsert((RoleQuery)query,request,response));
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
        RoleQuery roleQuery = ((RoleQuery)query);

        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(roleQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        roleQuery.setGmtModified(new Date());
        roleQuery.setModifier(operator.getUsername());
        roleQuery.setModifierCode(operator.getUserId());
        roleMapper.updateByExampleSelective(roleQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(RoleQuery query) {
        if(query.getApplicationId() == null){
            throw new SystemException(SystemReturnEnum.ROLE_SAVE_OR_EDIT_APPID_NULL);
        }
        if(query.getPid() == null){
            throw new SystemException(SystemReturnEnum.ROLE_SAVE_OR_EDIT_PID_NULL);
        }
        if(StringUtil.isEmpty(query.getRoleName())){
            throw new SystemException(SystemReturnEnum.ROLE_SAVE_OR_EDIT_NAME_NULL);
        }
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Role assQueryForInsert(RoleQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(RoleEnums.status.INIT.value());
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
    private Role assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        RoleQuery infoQuery = new RoleQuery();
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
    private RoleExample assExampleForList(RoleQuery query) {
        RoleExample example = new RoleExample();
        RoleExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        if(StringUtil.isNotEmpty(query.getRoleName())){
            criteria.andRoleNameEqualTo(query.getRoleName());
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
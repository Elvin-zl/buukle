package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security.dao.*;
import top.buukle.security.entity.*;
import top.buukle.security.entity.vo.*;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.RoleService;
import top.buukle.security.entity.constants.MenuEnums;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.RoleEnums;
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
* @description RoleService实现类
*/
@Service("roleService")
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private Environment env;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private ButtonMapper buttonMapper;
    @Autowired
    private RoleMenuButtonRelationMapper roleMenuButtonRelationMapper;
    @Autowired
    private RoleMenuButtonRelationLogsMapper relationLogsMapper;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((RoleQuery)query).getPage(),((RoleQuery)query).getPageSize());
        List<Role> list = roleMapper.selectByExample(this.assExampleForList(((RoleQuery)query)));
        Application application;
        List<RoleQuery> roleQueryList = new ArrayList<>();
        for (Role role: list) {
            application = applicationMapper.selectByPrimaryKey(role.getApplicationId());
            role.setApplicationName(application == null ? "" : application.getName());
            RoleQuery roleQuery = new RoleQuery();
            BeanUtils.copyProperties(role,roleQuery);
            roleQuery.setApplicationCode(application == null ? "" : application.getCode());
            roleQueryList.add(roleQuery);
        }
        PageInfo<Role> pageInfo = new PageInfo<>(list);
        return new PageResponse.Builder().build(roleQueryList,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
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
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role!=null){
            Application application = applicationMapper.selectByPrimaryKey(role.getApplicationId());
            // 校验操作权限
            this.validatePerm(request,application,id);
        }
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
        List<Role> roles = roleMapper.selectByExample(roleExample);
        for (Role roleToDel: roles) {
            Application application = applicationMapper.selectByPrimaryKey(roleToDel.getApplicationId());
            // 校验操作权限
            this.validatePerm(request,application,roleToDel.getId());
        }
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
    public RoleCrudModelVo selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new RoleCrudModelVo();
        }
        // 查询角色
        Role role = roleMapper.selectByPrimaryKey(id);
        RoleCrudModelVo vo = null;
        if(role != null){
            vo = new RoleCrudModelVo();
            BeanUtils.copyProperties(role,vo);
            Application application = applicationMapper.selectByPrimaryKey(vo.getApplicationId());
            // 校验权限
            this.validatePerm(httpServletRequest,application,id);
            vo.setApplicationCode(application.getCode());
            if(vo.getPid()!=0){
                Role superRole = roleMapper.selectByPrimaryKey(vo.getPid());
                vo.setSuperName(superRole.getRoleName());
            }else{
                vo.setSuperName(application.getCode());
            }
        }
        return role == null ? new RoleCrudModelVo() : vo;
    }

    /**
     * @description 校验是否有操作权限
     * @param httpServletRequest
     * @param application
     * @param id
     * @return void
     * @Author elvin
     * @Date 2019/8/18
     */
    private void validatePerm(HttpServletRequest httpServletRequest, Application application, Integer id) {
        Role role = roleMapper.selectByPrimaryKey(id);
        if(role != null && RoleEnums.systemFlag.SYSTEM_PROTECTED.value().equals(role.getSystemFlag())){
            throw new SystemException(SystemReturnEnum.OPERATE_INFO_SYSTEM_PROTECT_EXCEPTION);
        }
        // 获取操作者在app的角色映射
        Map<String, Role> operatorRoleMap = (Map<String, Role>) SessionUtil.get(httpServletRequest, SessionUtil.USER_ROLE_MAP_KEY);
        Role operatorRoleInCurrentApp = operatorRoleMap.get(application.getCode());
        if(operatorRoleInCurrentApp == null){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_NO_ROLE);
        }
        // 查询app角色列表
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria appCriteria = roleExample.createCriteria();
        appCriteria.andStatusEqualTo(RoleEnums.status.PUBLISED.value());
        appCriteria.andApplicationIdEqualTo(application.getId());
        List<Role> appRoles = roleMapper.selectByExample(roleExample);
        // 获取操作者下辖角色列表
        List<Integer> operatorSubRoleIds = new ArrayList<>();
        this.getUserSubRoles(operatorSubRoleIds,operatorRoleInCurrentApp,appRoles);
        if(!operatorSubRoleIds.contains(id)){
            throw new SystemException(SystemReturnEnum.ROLE_SET_MENU_WRONG_ROLE_NO_LEVEL);
        }
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
            Role roleToDel = roleMapper.selectByPrimaryKey(query.getId());
            if(roleToDel!=null){
                Application application = applicationMapper.selectByPrimaryKey(roleToDel.getApplicationId());
                // 校验操作权限
                this.validatePerm(request,application,roleToDel.getId());
            }
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
        Application application = applicationMapper.selectByPrimaryKey(applicationId);
        if(null == application){
            return new PageResponse.Builder().build(new ArrayList<SelectTreeNodeResult>(),0,0,0);
        }
        // 获取操作者在app的角色映射
        Map<String, Role> operatorRoleMap = (Map<String, Role>) SessionUtil.get(request, SessionUtil.USER_ROLE_MAP_KEY);
        Role operatorRoleInCurrentApp = operatorRoleMap.get(application.getCode());
        if(operatorRoleInCurrentApp == null){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_NO_ROLE);
        }
        // 查询app角色列表
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria appCriteria = roleExample.createCriteria();
        appCriteria.andStatusEqualTo(RoleEnums.status.PUBLISED.value());
        appCriteria.andApplicationIdEqualTo(application.getId());
        List<Role> appRoles = roleMapper.selectByExample(roleExample);
        // 获取操作者下辖角色列表
        List<Integer> operatorSubRoleIds = new ArrayList<>();
        this.getUserSubRoles(operatorSubRoleIds,operatorRoleInCurrentApp,appRoles);
        RoleExample applicationExample = new RoleExample();
        RoleExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andStatusEqualTo(RoleEnums.status.PUBLISED.value());
        criteria.andApplicationIdEqualTo(applicationId);
        List<Role> roles = roleMapper.selectByExample(applicationExample);
        SelectTreeNodeResult rootNode = new SelectTreeNodeResult();
        rootNode.setId(0);
        rootNode.setTitle(application.getCode());
        rootNode.setSpread(true);
        List<SelectTreeNodeResult> nodes = new ArrayList<>();
        nodes.add(rootNode);
        this.findChildren(rootNode,roles,operatorSubRoleIds);
        return new PageResponse.Builder().build(nodes,0,0,0);
    }

    /**
     * @description 获取用户在该app下的角色
     * @param applicationId
     * @param userId
     * @param request
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/12
     */
    @Override
    public PageResponse getAppUserRole(Integer applicationId, String userId, HttpServletRequest request) {
        // 查询应用
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria applicationCriteria = applicationExample.createCriteria();
        applicationCriteria.andIdEqualTo(applicationId);
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        if(CollectionUtils.isEmpty(applications) || applications.size() > 1 ){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_PRE_APP_CODE_WRONG);
        }
        // 查询被操作用户在app拥有的角色列表
        List<Role> userRoles = roleMapper.getUserRoleWithAppId(userId,applications.get(0).getId());
        // 获取操作者在app的角色映射
        Map<String, Role> operatorRoleMap = (Map<String, Role>) SessionUtil.get(request, SessionUtil.USER_ROLE_MAP_KEY);
        Role operatorRoleInCurrentApp = operatorRoleMap.get(applications.get(0).getCode());
        if(operatorRoleInCurrentApp == null){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_NO_ROLE);
        }
        // 查询app角色列表
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria criteria = roleExample.createCriteria();
        criteria.andStatusEqualTo(RoleEnums.status.PUBLISED.value());
        criteria.andApplicationIdEqualTo(applications.get(0).getId());
        List<Role> appRoles = roleMapper.selectByExample(roleExample);
        // 获取操作者下辖角色列表
        List<Integer> operatorSubRoleIds = new ArrayList<>();
        this.getUserSubRoles(operatorSubRoleIds,operatorRoleInCurrentApp,appRoles);
        // 判定操作者有无操作权限
        if(!CollectionUtils.isEmpty(userRoles) && !operatorSubRoleIds.contains(userRoles.get(0).getId())){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_NO_LEVEL);
        }
        List<RoleTreeResult> roleTree = new ArrayList<>();
        for (Role role: appRoles) {
            RoleTreeResult roleTreeResult = new RoleTreeResult();
            BeanUtils.copyProperties(role,roleTreeResult);
            // 屏蔽操作者不具有的高级角色
            roleTreeResult.setNocheck(!operatorSubRoleIds.contains(role.getId()));
            // 设置被操作用户当前选中角色
            roleTreeResult.setChecked((!CollectionUtils.isEmpty(userRoles)) && userRoles.contains(role));
            roleTree.add(roleTreeResult);
        }
        return new PageResponse.Builder().build(roleTree, 0, 0, 0);
    }

    /**
     * @description 获取用户下辖角色列表
     * @param userSubRoleIds
     * @param operatorRole
     * @param appRoles
     * @return void
     * @Author elvin
     * @Date 2019/8/17
     */
    @Override
    public void getUserSubRoles(List<Integer> userSubRoleIds, Role operatorRole, List<Role> appRoles) {
        userSubRoleIds.add(operatorRole.getId());
        // 获取用户下辖角色列表
        for (Role appRole: appRoles) {
            if(appRole.getPid().equals(operatorRole.getId())){
                this.getUserSubRoles(userSubRoleIds,appRole,appRoles);
            }
        }
    }

    /**
     * @description 获取角色在其应用下的资源列表
     * @param id
     * @param request
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/13
     */
    @Override
    public PageResponse getRoleMenuTree(Integer id, HttpServletRequest request) {
        // 查询被操作角色
        Role role = roleMapper.selectByPrimaryKey(id);
        // 查询应用
        ApplicationExample applicationExample = new ApplicationExample();
        ApplicationExample.Criteria applicationCriteria = applicationExample.createCriteria();
        applicationCriteria.andIdEqualTo(role.getApplicationId());
        List<Application> applications = applicationMapper.selectByExample(applicationExample);
        if(CollectionUtils.isEmpty(applications) || applications.size() > 1 ){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_PRE_APP_CODE_WRONG);
        }
        // 查询app角色列表
        RoleExample roleExample = new RoleExample();
        RoleExample.Criteria roleExampleCriteria = roleExample.createCriteria();
        roleExampleCriteria.andStatusEqualTo(RoleEnums.status.PUBLISED.value());
        roleExampleCriteria.andApplicationIdEqualTo(applications.get(0).getId());
        List<Role> appRoles = roleMapper.selectByExample(roleExample);
        // 获取操作者在app的角色映射
        Map<String, Role> operatorRoleMap = (Map<String, Role>) SessionUtil.get(request, SessionUtil.USER_ROLE_MAP_KEY);
        Role operatorRoleInCurrentApp = operatorRoleMap.get(applications.get(0).getCode());
        if(operatorRoleInCurrentApp == null){
            throw new SystemException(SystemReturnEnum.USER_SET_USER_ROLE_NO_ROLE);
        }
        // 获取操作者下辖角色列表
        List<Integer> operatorSubRoleIds = new ArrayList<>();
        this.getUserSubRoles(operatorSubRoleIds,operatorRoleInCurrentApp,appRoles);
        if(!operatorSubRoleIds.contains(id)){
            throw new SystemException(SystemReturnEnum.ROLE_SET_MENU_WRONG_ROLE_NO_LEVEL);
        }
        // 获取操作者下辖资源列表
        List<String> operatorSubResource = (List<String> )SessionUtil.get(request, SessionUtil.USER_URL_LIST_KEY);
        // 查询应用所有菜单
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andApplicationIdEqualTo(role.getApplicationId());
        List<Menu> appMenus = menuMapper.selectByExample(menuExample);
        // 查询应用所有按钮
        ButtonExample buttonExample = new ButtonExample();
        ButtonExample.Criteria buttonExampleCriteria = buttonExample.createCriteria();
        buttonExampleCriteria.andApplicationIdEqualTo(role.getApplicationId());
        List<Button> appButtons = buttonMapper.selectByExample(buttonExample);
        // 查询应用下角色拥有的菜单
        List<Menu> roleMenus = menuMapper.getRoleMenuListByRoleId(id,role.getApplicationId());
        List<Integer> roleMenuIds = new ArrayList<>();
        if(!CollectionUtils.isEmpty(roleMenus)){
            for (Menu roleMenu: roleMenus) {
                roleMenuIds.add(roleMenu.getId());
            }
        }
        // 查询应用下角色拥有的按钮
        List<Button> roleButtons = buttonMapper.getRoleButtonListByRoleId(id,role.getApplicationId());
        List<Integer> roleButtonIds = new ArrayList<>();
        if(!CollectionUtils.isEmpty(roleButtons)){
            for (Button roleButton: roleButtons) {
                roleButtonIds.add(roleButton.getId());
            }
        }
        // 组装该角色应用下的菜单树
        List<ZtreeNode> roleResources = new ArrayList<>();
        if(!CollectionUtils.isEmpty(appMenus)){
            for (Menu appMenu: appMenus) {
                ZtreeNode roleResource = new ZtreeNode();
                roleResource.setId(appMenu.getId());
                roleResource.setNocheck(!operatorSubResource.contains(appMenu.getUrl()));
                roleResource.setPid(appMenu.getPid());
                roleResource.setName(appMenu.getName() +
                        (MenuEnums.type.MENU.value().equals(appMenu.getType()) ?
                                (MenuEnums.display.DISPLAY_BLOCK.value().equals(appMenu.getDisplay()) ?  " (菜单[展示]) " : " (菜单[不展示]) "  )
                                : " (组件) "));
                roleResource.setChecked(roleMenuIds.contains(appMenu.getId()));
                roleResources.add(roleResource);
            }
        }
        // 组装该角色应用下的按钮树
        if(!CollectionUtils.isEmpty(appButtons)){
            for (Button appButton: appButtons) {
                ZtreeNode roleResource = new ZtreeNode();
                roleResource.setId(appButton.getId()* -1);
                roleResource.setNocheck(!operatorSubResource.contains(appButton.getUrl()));
                roleResource.setPid(appButton.getMenuId());
                roleResource.setName(appButton.getName() + " (按钮) ");
                roleResource.setChecked(roleButtonIds.contains(appButton.getId()));
                roleResources.add(roleResource);
            }
        }
        return new PageResponse.Builder().build(roleResources,0,0,0);
    }
    /**
     * @description 设置角色菜单按钮关系
     * @param ids   菜单按钮id集合 , 其中负值是按钮id
     * @param id    角色id
     * @param request
     * @param response
     * @return top.buukle.common.call.PageResponse
     * @Author zhanglei1102
     * @Date 2019/8/14
     */
    @Override
    public CommonResponse roleMenuSet(String ids, Integer id, HttpServletRequest request, HttpServletResponse response) {
        User operator = SessionUtil.getOperator(request, response);
        // 查询操作角色
        Role role = roleMapper.selectByPrimaryKey(id);
        // 查询应用下角色拥有的菜单
        List<Menu> roleMenus = menuMapper.getRoleMenuListByRoleId(id,role.getApplicationId());
        // 查询应用下角色拥有的按钮
        List<Button> roleButtons = buttonMapper.getRoleButtonListByRoleId(id,role.getApplicationId());
        List<Integer> roleMenuIds = new ArrayList<>();
        if(!CollectionUtils.isEmpty(roleMenus)){
            for (Menu roleMenu: roleMenus) {
                roleMenuIds.add(roleMenu.getId());
                // 删除现有的菜单关系(包括了按钮)
                RoleMenuButtonRelationExample relationExample = new RoleMenuButtonRelationExample();
                RoleMenuButtonRelationExample.Criteria criteria = relationExample.createCriteria();
                criteria.andMenuIdEqualTo(roleMenu.getId());
                criteria.andRoleIdEqualTo(id);
                roleMenuButtonRelationMapper.deleteByExample(relationExample);
            }
        }
        List<Integer> roleButtonIds = new ArrayList<>();
        if(!CollectionUtils.isEmpty(roleButtons)){
            for (Button roleButton: roleButtons) {
                roleButtonIds.add(roleButton.getId());
            }
        }
        // 记录日志
        RoleMenuButtonRelationLogs roleMenuButtonRelationLogs = new RoleMenuButtonRelationLogs();
        roleMenuButtonRelationLogs.setRoleId(id);
        roleMenuButtonRelationLogs.setMenuIdCollections(JsonUtil.toJSONString(roleMenuIds));
        roleMenuButtonRelationLogs.setButtonIdCollections(JsonUtil.toJSONString(roleButtonIds));
        roleMenuButtonRelationLogs.setCreator(operator.getUsername());
        roleMenuButtonRelationLogs.setCreatorCode(operator.getUserId());
        roleMenuButtonRelationLogs.setGmtCreated(new Date());
        relationLogsMapper.insert(roleMenuButtonRelationLogs);
        // 记录新的关系记录
        if(StringUtil.isNotEmpty(ids)){
            String[] menuAndButtonIds = ids.split(",");
            if(menuAndButtonIds.length < 1){
                return new CommonResponse.Builder().buildSuccess();
            }
            // 要设置的菜单&组件id集合
            List<Integer> menuIds = new ArrayList<>();
            // 要设置的按钮id集合
            List<Integer> buttonIds = new ArrayList<>();
            for (String idStr : menuAndButtonIds) {
                int idTemp = Integer.parseInt(idStr);
                if(idTemp > 0){
                    menuIds.add(idTemp);
                }else{
                    buttonIds.add(idTemp * -1);
                }
            }
            if(!CollectionUtils.isEmpty(menuIds)){
                // 记录角色,菜单关系
                for (Integer menuId : menuIds) {
                    RoleMenuButtonRelation roleMenuButtonRelation = new RoleMenuButtonRelation();
                    roleMenuButtonRelation.setCreator(operator.getUsername());
                    roleMenuButtonRelation.setGmtCreated(new Date());
                    roleMenuButtonRelation.setCreatorCode(operator.getUserId());
                    roleMenuButtonRelation.setMenuId(menuId);
                    roleMenuButtonRelation.setRoleId(id);
                    roleMenuButtonRelationMapper.insert(roleMenuButtonRelation);
                }
                // 记录角色,按钮关系
                if(!CollectionUtils.isEmpty(buttonIds)){
                    // 查询应用所有按钮
                    ButtonExample buttonExample = new ButtonExample();
                    ButtonExample.Criteria buttonExampleCriteria = buttonExample.createCriteria();
                    buttonExampleCriteria.andApplicationIdEqualTo(role.getApplicationId());
                    List<Button> appButtons = buttonMapper.selectByExample(buttonExample);
                    if(CollectionUtils.isEmpty(appButtons)){
                        throw new SystemException(SystemReturnEnum.ROLE_SET_MENU_WRONG_BTN_LIST_NOT_EXIST);
                    }
                    for (Button button: appButtons) {
                        if(buttonIds.contains(button.getId())){
                            if(menuIds.contains(button.getMenuId())){
                                RoleMenuButtonRelation roleMenuButtonRelation = new RoleMenuButtonRelation();
                                roleMenuButtonRelation.setCreator(operator.getUsername());
                                roleMenuButtonRelation.setGmtCreated(new Date());
                                roleMenuButtonRelation.setCreatorCode(operator.getUserId());
                                roleMenuButtonRelation.setMenuId(button.getMenuId());
                                roleMenuButtonRelation.setButtonId(button.getId());
                                roleMenuButtonRelation.setRoleId(id);
                                roleMenuButtonRelationMapper.insert(roleMenuButtonRelation);
                            }else{
                                throw new SystemException(SystemReturnEnum.ROLE_SET_MENU_WRONG_MENU_BTN_NOT_MATCH,button.getName() +"(按钮) 所属菜单应被勾选!");
                            }
                        }
                    }
                }
            }
        }
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 获取应用下的用户角色
     * @param userId
     * @param applicationId
     * @return top.buukle.security.entity.Role
     * @Author elvin
     * @Date 2019/8/17
     */
    @Override
    public Role getUserRole(String userId, Integer applicationId) {
        List<Role> roles = roleMapper.getUserRoleWithAppId(userId, applicationId);
        return CollectionUtils.isEmpty(roles) ? new Role() : roles.get(0);
    }

    /**
     * @description 寻找子节点
     * @param node
     * @param roles
     * @param operatorSubRoleIds
     * @return void
     * @Author elvin
     * @Date 2019/8/9
     */
    private void findChildren(SelectTreeNodeResult node, List<Role> roles, List<Integer> operatorSubRoleIds) {
        List<SelectTreeNodeResult> nodes = new ArrayList<>();
        for (Role role: roles) {
            if(role.getPid().equals(node.getId())){
                SelectTreeNodeResult nodeNew = new SelectTreeNodeResult();
                nodeNew.setDisabled(!operatorSubRoleIds.contains(role.getId()));
                nodeNew.setId(role.getId());
                nodeNew.setTitle(role.getRoleName());
                nodeNew.setSpread(true);
                nodes.add(nodeNew);
                this.findChildren(nodeNew,roles, operatorSubRoleIds);
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
        query.setCreatorRoleId(SessionUtil.getUserRoleId(request,env.getProperty("spring.application.name")).getId());
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
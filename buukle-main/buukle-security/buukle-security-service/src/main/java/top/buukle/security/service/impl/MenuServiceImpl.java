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
import top.buukle.security .dao.MenuMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security.entity.Application;
import top.buukle.security .entity.User;
import top.buukle.security .entity.Menu;
import top.buukle.security .entity.MenuExample;
import top.buukle.security.entity.vo.*;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.MenuService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.MenuEnums;
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
* @description MenuService实现类
*/
@Service("menuService")
public class MenuServiceImpl implements MenuService{

    @Autowired
    private MenuMapper menuMapper;

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
        PageHelper.startPage(((MenuQuery)query).getPage(),((MenuQuery)query).getPageSize());
        List<Menu> list = menuMapper.selectByExample(this.assExampleForList(((MenuQuery)query)));
        PageInfo<Menu> pageInfo = new PageInfo<>(list);
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
        if(menuMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, MenuEnums.status.DELETED.value(),request,response)) != 1){
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
        MenuExample menuExample = new MenuExample();
        MenuExample.Criteria criteria = menuExample.createCriteria();
        criteria.andIdIn(idList);
        Menu menu = new Menu();

        User operator = SessionUtil. getOperator(request, response);
        menu.setGmtModified(new Date());
        menu.setModifier(operator.getUsername());
        menu.setModifierCode(operator.getUserId());

        menu.setStatus(MenuEnums.status.DELETED.value());
        menuMapper.updateByExampleSelective(menu,menuExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.Menu
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public MenuCrudModelVo selectByPrimaryKey(Integer id) {
        if(id == null){
            return new MenuCrudModelVo();
        }
        Menu menu = menuMapper.selectByPrimaryKey(id);
        MenuCrudModelVo vo = new MenuCrudModelVo();
        if(menu != null){
            vo = new MenuCrudModelVo();
            BeanUtils.copyProperties(menu,vo);
            Application application = applicationMapper.selectByPrimaryKey(vo.getApplicationId());
            vo.setApplicationCode(application.getCode());
            if(vo.getPid()!=0){
                Menu superMenu = menuMapper.selectByPrimaryKey(vo.getPid());
                vo.setSuperName(superMenu.getName());
            }else{
                vo.setSuperName("root");
            }
        }
        return menu == null ? new MenuCrudModelVo() : vo;
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
    public CommonResponse saveOrEdit(MenuQuery query, HttpServletRequest request, HttpServletResponse response) {
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
     * @description 获取上级菜单
     * @param applicationId
     * @param request
     * @param response
     * @return top.buukle.common.call.PageResponse
     * @Author elvin
     * @Date 2019/8/10
     */
    @Override
    public PageResponse getMenuTree(Integer applicationId, HttpServletRequest request, HttpServletResponse response) {
        MenuExample applicationExample = new MenuExample();
        MenuExample.Criteria criteria = applicationExample.createCriteria();
        criteria.andStatusEqualTo(MenuEnums.status.PUBLISED.value());
        criteria.andApplicationIdEqualTo(applicationId);
        List<Menu> menus = menuMapper.selectByExample(applicationExample);
        LayUiSelectTreeNode rootNode = new LayUiSelectTreeNode();
        rootNode.setId(0);
        rootNode.setTitle("root");
        rootNode.setSpread(true);
        List<LayUiSelectTreeNode> nodes = new ArrayList<>();
        nodes.add(rootNode);
        this.findChildren(rootNode,menus);
        return new PageResponse.Builder().build(nodes,0,0,0);
    }

    /**
     * @description 寻找子节点
     * @param node
     * @param menus
     * @return void
     * @Author elvin
     * @Date 2019/8/9
     */
    private void findChildren(LayUiSelectTreeNode node, List<Menu> menus) {
        List<LayUiSelectTreeNode> nodes = new ArrayList<>();
        for (Menu menu: menus) {
            if(menu.getPid().equals(node.getId())){
                LayUiSelectTreeNode nodeNew = new LayUiSelectTreeNode();
                nodeNew.setId(menu.getId());
                nodeNew.setTitle(menu.getName());
                nodeNew.setSpread(true);
                nodes.add(nodeNew);
                this.findChildren(nodeNew,menus);
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Menu"));
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

        menuMapper.insert(this.assQueryForInsert((MenuQuery)query,request,response));
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
        MenuQuery menuQuery = ((MenuQuery)query);

        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(menuQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        menuQuery.setGmtModified(new Date());
        menuQuery.setModifier(operator.getUsername());
        menuQuery.setModifierCode(operator.getUserId());
        menuMapper.updateByExampleSelective(menuQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(MenuQuery query) {
        if(query.getApplicationId() ==null ){
            throw new SystemException(SystemReturnEnum.MENU_SAVE_OR_EDIT_APPID_NULL);
        }
        if(query.getPid() ==null ){
            throw new SystemException(SystemReturnEnum.MENU_SAVE_OR_EDIT_PID_NULL);
        }
        if(StringUtil.isEmpty(query.getName())){
            throw new SystemException(SystemReturnEnum.MENU_SAVE_OR_EDIT_NAME_NULL);
        }
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Menu assQueryForInsert(MenuQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(MenuEnums.status.INIT.value());
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
    private Menu assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        MenuQuery infoQuery = new MenuQuery();
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
    private MenuExample assExampleForList(MenuQuery query) {
        MenuExample example = new MenuExample();
        MenuExample.Criteria criteria = example.createCriteria();
        if(StringUtil.isNotEmpty(query.getStartTime())){
            criteria.andGmtCreatedGreaterThanOrEqualTo(DateUtil.parse(query.getStartTime()));
        }
        if(StringUtil.isNotEmpty(query.getEndTime())){
            criteria.andGmtCreatedLessThanOrEqualTo(DateUtil.parse(query.getEndTime()));
        }
        if(query.getId() != null){
            criteria.andIdEqualTo(query.getId());
        }
        if(StringUtil.isNotEmpty(query.getName())){
            criteria.andNameEqualTo(query.getName());
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
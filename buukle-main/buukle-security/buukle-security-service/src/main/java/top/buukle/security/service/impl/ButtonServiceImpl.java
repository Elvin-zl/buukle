package top.buukle.security .service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import top.buukle.common.call.CommonResponse;
import top.buukle.common.call.FuzzyResponse;
import top.buukle.common.call.PageResponse;
import top.buukle.common.call.vo.FuzzyVo;
import top.buukle.common.status.StatusConstants;

import top.buukle.security.dao.ApplicationMapper;
import top.buukle.security .dao.ButtonMapper;
import top.buukle.security .dao.CommonMapper;
import top.buukle.security.dao.MenuMapper;
import top.buukle.security.entity.*;
import top.buukle.security .entity.vo.BaseQuery;
import top.buukle.security.entity.vo.ButtonCrudModelVo;
import top.buukle.security .entity.vo.ButtonQuery;
import top.buukle.security .plugin.util.SessionUtil;
import top.buukle.security .service.ButtonService;
import top.buukle.security .service.constants.SystemReturnEnum;
import top.buukle.security .service.constants.ButtonEnums;
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
* @description ButtonService实现类
*/
@Service("buttonService")
public class ButtonServiceImpl implements ButtonService{

    @Autowired
    private ButtonMapper buttonMapper;
    @Autowired
    private ApplicationMapper applicationMapper;
    @Autowired
    private CommonMapper commonMapper;
    @Autowired
    private MenuMapper menuMapper;
    @Autowired
    private Environment env;

    /**
     * 分页获取列表
     * @param query 查询对象
     * @return PageResponse
     */
    @Override
    public PageResponse getPage(BaseQuery query) {
        PageHelper.startPage(((ButtonQuery)query).getPage(),((ButtonQuery)query).getPageSize());
        List<Button> list = buttonMapper.selectByExample(this.assExampleForList(((ButtonQuery)query)));
        PageInfo<Button> pageInfo = new PageInfo<>(list);
        Application application;
        List<ButtonQuery> buttonQueryList = new ArrayList<>();
        for (Button button: list) {
            ButtonQuery buttonQuery = new ButtonQuery();
            BeanUtils.copyProperties(button,buttonQuery);
            application = applicationMapper.selectByPrimaryKey(button.getApplicationId());
            buttonQuery.setApplicationName(application == null ? "" : application.getName());
            buttonQuery.setApplicationCode(application == null ? "" : application.getCode());
            buttonQueryList.add(buttonQuery);
        }
        return new PageResponse.Builder().build(buttonQueryList,pageInfo.getPageNum(),pageInfo.getPageSize(),pageInfo.getTotal());
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
        Button button = buttonMapper.selectByPrimaryKey(id);
        if(button!=null){
            // 校验操作权限
            this.validatePerm(request,button);
        }
        if(buttonMapper.updateByPrimaryKeySelective(this.assQueryForUpdateStatus(id, ButtonEnums.status.DELETED.value(),request,response)) != 1){
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
        ButtonExample buttonExample = new ButtonExample();
        ButtonExample.Criteria criteria = buttonExample.createCriteria();
        criteria.andIdIn(idList);
        List<Button> buttons = buttonMapper.selectByExample(buttonExample);
        for (Button buttonToDel: buttons) {
            // 校验操作权限
            this.validatePerm(request,buttonToDel);
        }
        Button button = new Button();
        User operator = SessionUtil. getOperator(request, response);
        button.setGmtModified(new Date());
        button.setModifier(operator.getUsername());
        button.setModifierCode(operator.getUserId());
        button.setStatus(ButtonEnums.status.DELETED.value());
        buttonMapper.updateByExampleSelective(button,buttonExample);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 根据id查询
     * @param id
     * @return top.buukle.security.entity.Button
     * @Author elvin
     * @Date 2019/8/4
     */
    @Override
    public ButtonCrudModelVo selectByPrimaryKeyForCrud(HttpServletRequest httpServletRequest, Integer id) {
        if(id == null){
            return new ButtonCrudModelVo();
        }
        Button button = buttonMapper.selectByPrimaryKey(id);
        ButtonCrudModelVo vo = null;
        if(button != null){
            // 校验操作权限
            this.validatePerm(httpServletRequest,button);
            vo = new ButtonCrudModelVo();
            BeanUtils.copyProperties(button,vo);
            Application application = applicationMapper.selectByPrimaryKey(vo.getApplicationId());
            vo.setApplicationCode(application.getCode());
            if(vo.getMenuId()!=0){
                Menu menu = menuMapper.selectByPrimaryKey(vo.getMenuId());
                vo.setSuperName(menu.getName());
            }else{
                vo.setSuperName("root");
            }
        }
        return button == null ? new ButtonCrudModelVo() : vo;
    }

    /**
     * @description 校验操作权限
     * @param httpServletRequest
     * @param button
     * @return void
     * @Author elvin
     * @Date 2019/8/18
     */
    private void validatePerm(HttpServletRequest httpServletRequest, Button button) {
        if(ButtonEnums.systemFlag.SYSTEM_PROTECTED.value().equals(button.getSystemFlag())){
            throw new SystemException(SystemReturnEnum.OPERATE_INFO_SYSTEM_PROTECT_EXCEPTION);
        }
        // 获取操作者下辖资源列表
        List<String> operatorSubResource = (List<String> )SessionUtil.get(httpServletRequest, SessionUtil.USER_URL_LIST_KEY);
        if(!operatorSubResource.contains(button.getUrl())){
            throw new SystemException(SystemReturnEnum.BUTTON_SAVE_OR_EDIT_NO_PERM);
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
    public CommonResponse saveOrEdit(ButtonQuery query, HttpServletRequest request, HttpServletResponse response) {
        validateParamForSaveOrEdit(query);
        // 新增
        if(query.getId() == null){
            query.setCreatorRoleId(SessionUtil.getUserRoleId(request,env.getProperty("spring.application.name")).getId());
            this.save(query,request,response);
        }
        // 更新
        else{
            Button button = buttonMapper.selectByPrimaryKey(query.getId());
            if(button!=null){
                // 校验操作权限
                this.validatePerm(request,button);
            }
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
        fuzzyVo.setTableName(ConvertHumpUtil.humpToLine("Button"));
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

        buttonMapper.insert(this.assQueryForInsert((ButtonQuery)query,request,response));
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
        ButtonQuery buttonQuery = ((ButtonQuery)query);

        ButtonExample example = new ButtonExample();
        ButtonExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(buttonQuery.getId());
        User operator = SessionUtil. getOperator(request, response);
        buttonQuery.setGmtModified(new Date());
        buttonQuery.setModifier(operator.getUsername());
        buttonQuery.setModifierCode(operator.getUserId());
        buttonMapper.updateByExampleSelective(buttonQuery,example);
        return new CommonResponse.Builder().buildSuccess();
    }

    /**
     * @description 校验参数 saveOrEdit
     * @param query
     * @return void
     * @Author elvin
     * @Date 2019/8/5
     */
    private void validateParamForSaveOrEdit(ButtonQuery query) {
        if(query.getApplicationId() == null){
            throw new SystemException(SystemReturnEnum.BUTTON_SAVE_OR_EDIT_APPID_NULL);
        }
        if(query.getMenuId() == null){
            throw new SystemException(SystemReturnEnum.BUTTON_SAVE_OR_EDIT_MENUID_NULL);
        }
        if(StringUtil.isEmpty(query.getName())){
            throw new SystemException(SystemReturnEnum.BUTTON_SAVE_OR_EDIT_NAME_NULL);
        }
    }

    /**
     * 组装新增实体
     * @param query
     * @param request
     * @param response
     * @return
     */
    private Button assQueryForInsert(ButtonQuery query, HttpServletRequest request, HttpServletResponse response) {
        this.validateParamForSaveOrEdit(query);
        query.setStatus(ButtonEnums.status.INIT.value());
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
    private Button assQueryForUpdateStatus(Integer id, Integer status, HttpServletRequest request, HttpServletResponse response) {
        ButtonQuery infoQuery = new ButtonQuery();
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
    private ButtonExample assExampleForList(ButtonQuery query) {
        ButtonExample example = new ButtonExample();
        ButtonExample.Criteria criteria = example.createCriteria();
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
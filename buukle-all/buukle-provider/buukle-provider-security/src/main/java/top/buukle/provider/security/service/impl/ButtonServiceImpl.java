/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.business.ButtonBusiness;
import top.buukle.provider.security.constants.SecurityConstants;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.ButtonTypeMapper;
import top.buukle.provider.security.dao.ModuleButtonMapper;
import top.buukle.provider.security.dao.UserMapper;
import top.buukle.plugin.security.entity.*;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ButtonService;
import top.buukle.provider.security.dao.ButtonMapper;
import top.buukle.plugin.security.vo.query.ButtonQuery;
import top.buukle.common.vo.page.PageBounds;
import top.buukle.common.vo.fuuzy.FuzzySearchListVo;
import top.buukle.common.vo.response.PageResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("buttonService")
public class ButtonServiceImpl implements ButtonService {
	@Resource
	private ButtonMapper buttonMapper;
    @Resource
    private ButtonTypeMapper buttonTypeMapper;
    @Autowired
	private ButtonBusiness buttonBusiness;
    @Autowired
	private ModuleButtonMapper moduleButtonMapper;
    @Autowired
    private UserMapper userMapper;

	@Override
	public Button getButtonById(Integer id) throws Exception{
		return buttonMapper.selectByPrimaryKey(id);
	}

    @Override
    public List<Button> getButtonByParas(Button button) throws Exception {
        return null;
    }

    @Override
	public void save(Button button) throws Exception {
		buttonMapper.insert(button);
	}
	@Override
	public void update(Button button) throws Exception {
		buttonMapper.updateByPrimaryKeySelective(button);
	}
	@Override
	public void delete(Button button) throws Exception {
	}
	@Override
	public List<Button> getButtonsByParasNoPage(Button button) throws Exception {
		return null;
	}

	/**
	 * 获取按钮类型
	 * @return
	 */
	@Override
	public List<ButtonType> getButtonTypes() {
        List<ButtonType> buttonTypes =  buttonBusiness.getButtonTypes();
        if(CollectionUtils.isNotEmpty(buttonTypes)){
            return buttonTypes;
        }
        buttonTypes = buttonTypeMapper.getButtonTypes();
        if(CollectionUtils.isNotEmpty(buttonTypes)){
            // 缓存全局按钮类型列表
            buttonBusiness.saveButtonTypes(buttonTypes);
        }
        return buttonTypes;
	}

    /**
     * 获取用户在指定菜单下的按钮
     * @param httpServletRequest
     * @param moduleId
     * @return
     */
    @Override
    public List<Button> getModuleButtons(HttpServletRequest httpServletRequest, Integer moduleId) throws Exception {
        return this.getModuleButtons(moduleId);
    }

    /**
     * 分页获取按钮列表
     * @param query
     * @param pageBounds
     * @return
     */
    @Override
    public PageResponse<Button> getButtonList(ButtonQuery query, PageBounds pageBounds) {
        PageHelper.startPage(pageBounds.getPage(), pageBounds.getLimit());
        List<Button> list =buttonMapper.getButtonList(query);
        return new PageResponse.Builder().build(new PageInfo<>(list));
    }

    /**
     * 起停用按钮
     *
     * @param request
     * @param query
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(HttpServletRequest request, ButtonQuery query) throws InvocationTargetException, IllegalAccessException {
        if(query == null){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
        Button button = buttonMapper.selectByPrimaryKey(query.getId());
        if(button.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM) && query.getStatus() != null && query.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
        }
        if(query.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            query.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            query.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        buttonMapper.updateByPrimaryKeySelective(this.assButton(request, query, false));
        // 更新缓存
        this.refreshButtonCaChe(query.getId());
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 组装按钮对象
     * @param request
     * @param query
     * @param isAdd
     */
    private Button assButton(HttpServletRequest request, ButtonQuery query, boolean isAdd) throws InvocationTargetException, IllegalAccessException {
        User operator = UserInvoker.getUser(CookieUtil.getUserCookie(request));
        Button button = new Button();
        BeanUtils.copyProperties(button,query);
        if(isAdd){
            button.setCreator(operator.getUsername());
            button.setCreatorCode(operator.getUserId());
            button.setGmtCreated(new Date());
            button.setBak02(SecurityConstants.DELETE_LEVEL_TRUE);
        }else{
            button.setModifier(operator.getUsername());
            button.setModifierCode(operator.getUserId());
            button.setGmtModified(new Date());
        }
        return button;
    }

    /**
     * 添加按钮
     *
     * @param request
     * @param query
     * @return
     */
    @Override
    public BaseResponse addButton(HttpServletRequest request, ButtonQuery query) throws InvocationTargetException, IllegalAccessException {
        // 校验参数
        validateAddParam(query);
        // insert
        buttonMapper.insert(this.assButton(request, query, true));
        // 更新全局按钮缓存
        UserInvoker.clearGlobalCacheInfoByType(Button.class);
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 获取详情
     * @param request
     * @param query
     * @return
     */
    @Override
    public Button getButtonDetail(HttpServletRequest request, ButtonQuery query) {
        return buttonMapper.selectByPrimaryKey(query.getId());
    }

    /**
     * 修改按钮
     * @param request
     * @param query
     * @param id
     * @return
     */
    @Override
    public BaseResponse editButton(HttpServletRequest request, ButtonQuery query, Integer id) throws InvocationTargetException, IllegalAccessException {
        // 检验参数
        this.validateUpdateParam(id,query);
        // 组装并更新
        if(buttonMapper.updateByPrimaryKeySelective(this.assButton(request,query,false)) > 0){
            // 更新缓存
            this.refreshButtonCaChe(id);
            return new BaseResponse.Builder().buildSuccess();
        }
        throw new BaseException(BaseResponseCode.BUTTON_EDIT_EXCEPTION);
    }

    /**
     * 刷新按钮缓存
     * @param id
     */
    private void refreshButtonCaChe(Integer id) {
        List<ModuleButton> moduleButtonList = moduleButtonMapper.getByButtonId(id);
        // 更新全局按钮缓存
        UserInvoker.clearGlobalCacheInfoByType(Button.class);
        // 更新菜单下按钮缓存
        if(CollectionUtils.isNotEmpty(moduleButtonList)){
            for (ModuleButton moduleButton: moduleButtonList) {
                UserInvoker.deleteModuleButton(moduleButton.getModuleId());
                // 更新拥有该菜单的用户的按钮缓存 ==>> TODO 此处可优化为异步线程处理
                List<User> users = userMapper.getUserByModuleId(moduleButton.getModuleId());
                if(CollectionUtils.isNotEmpty(users)){
                    for (User user : users) {
                        UserInvoker.clearUserCacheInfoByType(Button.class,user.getUserId());
                    }
                }
            }
        }
    }

    /**
     * 校验更新参数
     * @param id
     * @param query
     */
    private void validateUpdateParam(Integer id, ButtonQuery query) {
        Button button = buttonMapper.selectByPrimaryKey(id);
        if(null == button){
            throw new BaseException(BaseResponseCode.FAILED);
        }
        if(button.getBak02().equals(SecurityConstants.DELETE_LEVEL_SYSTEM) && query.getStatus() != null && query.getStatus().equals(SecurityStatusConstants.STATUS_CLOSE)){
            throw new BaseException(BaseResponseCode.EDIT_FORBIDDEN);
        }
    }

    /**
     * 模糊搜索
     * @param fuzzyText
     * @return
     */
    @Override
    public List<FuzzySearchListVo> fuzzySearchByName(String fuzzyText) {
        List<Button> buttonList = buttonMapper.fuzzySearchByName("%" + fuzzyText + "%");
        List<FuzzySearchListVo> fuzzySearchListVos = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(buttonList)){
            for (Button button: buttonList) {
                FuzzySearchListVo fuzzySearchListVo = new FuzzySearchListVo();
                fuzzySearchListVo.setText(button.getButtonName());
                fuzzySearchListVos.add(fuzzySearchListVo);
            }
        }
        return fuzzySearchListVos;
    }

    /**
     * 获取菜单下的按钮
     * @param moduleId
     * @return
     */
    @Override
    public List<Button> getModuleButtons(Integer moduleId) {
        List<Button>  buttonList = UserInvoker.getModuleButton(moduleId);
        if(CollectionUtils.isEmpty(buttonList)){
            List<Button> moduleButtons = buttonMapper.getModuleButtons(moduleId);
            UserInvoker.saveModuleButton(moduleButtons,moduleId);
            return moduleButtons;
        }
        return buttonList;
    }

    private void validateAddParam(ButtonQuery query) {
        // 名称
        if(StringUtil.isEmpty(query.getButtonName())){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_NAME_NULL);
        }
        // 分布级别
        if(null== query.getLayoutLevel()){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_LAYOUTLEVEL_NULL);
        }
        // 相应类型
        if(null== query.getOperationType()){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_OPERATION_TYPE_NULL);
        }
        // 备注
        if(null== query.getBak01()){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_REMARK_NULL);
        }
    }
}

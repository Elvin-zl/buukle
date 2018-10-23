/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.common.StringUtil;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.business.ButtonBusiness;
import top.buukle.provider.security.constants.SecurityStatusConstants;
import top.buukle.provider.security.dao.ButtonTypeMapper;
import top.buukle.provider.security.dao.ModuleButtonMapper;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.ButtonType;
import top.buukle.provider.security.entity.ModuleButton;
import top.buukle.provider.security.entity.User;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ButtonService;
import top.buukle.provider.security.dao.ButtonMapper;
import top.buukle.provider.security.vo.query.ButtonQuery;
import top.buukle.provider.security.vo.query.PageBounds;
import top.buukle.provider.security.vo.response.PageResponse;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
            //缓存全局按钮类型列表
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
        List<Button>  buttonList = UserInvoker.getModuleButton(moduleId);
        if(CollectionUtils.isEmpty(buttonList)){
            List<Button> moduleButtons = buttonMapper.getModuleButtons(moduleId);
            UserInvoker.saveModuleButton(moduleButtons,moduleId);
            return moduleButtons;
        }
        return buttonList;
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
     * @param query
     * @return
     */
    @Override
    public BaseResponse doBanOrRelease(ButtonQuery query) {
        if(query == null){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_NULL);
        }
        if(query.getStatus().equals(SecurityStatusConstants.STATUS_OPEN)){
            query.setStatus(SecurityStatusConstants.STATUS_CLOSE);
        }else{
            query.setStatus(SecurityStatusConstants.STATUS_OPEN);
        }
        buttonMapper.doBanOrRelease(query);
        ModuleButton moduleButton = moduleButtonMapper.getByButtonId(query.getId());
        // 更新全局按钮缓存
        UserInvoker.clearGlobalCacheInfoByType(Button.class);
        // 更新菜单下按钮缓存
        UserInvoker.deleteModuleButton(moduleButton.getModuleId());
        return new BaseResponse.Builder().buildSuccess();
    }

    /**
     * 添加按钮
     *
     * @param request
     * @param query
     * @return
     */
    @Override
    public BaseResponse addButton(HttpServletRequest request, ButtonQuery query) {
        //校验参数
        validateAddParam(query);
        User user = UserInvoker.getUser(CookieUtil.getUserCookie(request));
        query.setGmtCreated(new Date());
        query.setCreator(user.getCreatorMessage());
        query.setCreatorCode(user.getUserId());
        buttonMapper.insert(query);
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

    private void validateAddParam(ButtonQuery query) {
        //名称
        if(StringUtil.isEmpty(query.getButtonName())){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_NAME_NULL);
        }
        //分布级别
        if(null== query.getLayoutLevel()){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_LAYOUTLEVEL_NULL);
        }
        //相应类型
        if(null== query.getOperationType()){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_OPERATION_TYPE_NULL);
        }
        //备注
        if(null== query.getBak01()){
            throw new BaseException(BaseResponseCode.BUTTON_ADD_REMARK_NULL);
        }
    }
}

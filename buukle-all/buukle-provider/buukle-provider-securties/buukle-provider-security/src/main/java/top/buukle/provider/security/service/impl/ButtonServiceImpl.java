/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.buukle.plugin.security.util.CookieUtil;
import top.buukle.provider.security.business.ButtonBusiness;
import top.buukle.provider.security.dao.ButtonTypeMapper;
import top.buukle.provider.security.entity.Button;
import top.buukle.provider.security.entity.ButtonType;
import top.buukle.provider.security.invoker.UserInvoker;
import top.buukle.provider.security.service.ButtonService;
import top.buukle.provider.security.dao.ButtonMapper;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Button> getModuleButtons(HttpServletRequest httpServletRequest, Integer moduleId) {
        List<Button> userButton = UserInvoker.getUserButton(CookieUtil.getUserCookie(httpServletRequest));
        List<Button> collect = userButton.stream().filter(s -> s.getModuleId().equals(moduleId)).collect(Collectors.toList());
        return collect;
    }
}

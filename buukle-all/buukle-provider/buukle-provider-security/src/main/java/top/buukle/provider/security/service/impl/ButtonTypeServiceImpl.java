/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import top.buukle.provider.security.dao.ButtonTypeMapper;
import top.buukle.plugin.security.entity.ButtonType;
import top.buukle.provider.security.service.ButtonTypeService;

/**
 * 
 * @author tengbx
 *
 */
@Service("buttonTypeService")
public class ButtonTypeServiceImpl implements ButtonTypeService {
	@Resource
	private ButtonTypeMapper buttonTypeMapper;
	@Override
	public ButtonType getButtonTypeById(Integer id) throws Exception{
		return buttonTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<ButtonType> getButtonTypeByParas(ButtonType buttonType) throws Exception {
		return null;
	}

	@Override
	public void save(ButtonType buttonType) throws Exception {
		buttonTypeMapper.insert(buttonType);
	}
	@Override
	public void update(ButtonType buttonType) throws Exception {
		buttonTypeMapper.updateByPrimaryKeySelective(buttonType);
	}
	@Override
	public void delete(ButtonType buttonType) throws Exception {
	}
	@Override
	public List<ButtonType> getButtonTypesByParasNoPage(ButtonType buttonType) throws Exception {
		return null;
	}
}

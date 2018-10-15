/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.ModuleButtonService;
import top.buukle.provider.security.dao.ModuleButtonMapper;
import top.buukle.provider.security.entity.ModuleButton;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("moduleButtonService")
public class ModuleButtonServiceImpl implements ModuleButtonService {
	@Resource
	ModuleButtonMapper moduleButtonMapper;
	@Override
	public ModuleButton getModuleButtonById(Integer id) throws Exception{
		return moduleButtonMapper.getModuleButtonById(id);
	}

	@Override
	public List<ModuleButton> getModuleButtonByParas(ModuleButton moduleButton) throws Exception {
		return null;
	}

	@Override
	public void save(ModuleButton moduleButton) throws Exception {
		moduleButtonMapper.save(moduleButton);
	}
	@Override
	public void update(ModuleButton moduleButton) throws Exception {
		moduleButtonMapper.update(moduleButton);
	}
	@Override
	public void delete(ModuleButton moduleButton) throws Exception {
	}
	@Override
	public List<ModuleButton> getModuleButtonsByParasNoPage(ModuleButton moduleButton) throws Exception {
		return null;
	}
}

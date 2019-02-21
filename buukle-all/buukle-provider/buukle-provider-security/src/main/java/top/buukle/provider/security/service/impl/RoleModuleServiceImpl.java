/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.RoleModuleService;
import top.buukle.provider.security.dao.RoleModuleMapper;
import top.buukle.plugin.security.entity.RoleModule;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("roleModuleService")
public class RoleModuleServiceImpl implements RoleModuleService {
	@Resource
	private RoleModuleMapper roleModuleMapper;
	@Override
	public RoleModule getRoleModuleById(Integer id) throws Exception{
		return roleModuleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<RoleModule> getRoleModuleByParas(RoleModule roleModule) throws Exception {
		return null;
	}

	@Override
	public void save(RoleModule roleModule) throws Exception {
		roleModuleMapper.insert(roleModule);
	}
	@Override
	public void update(RoleModule roleModule) throws Exception {
		roleModuleMapper.updateByPrimaryKeySelective(roleModule);
	}
	@Override
	public void delete(RoleModule roleModule) throws Exception {
	}
	@Override
	public List<RoleModule> getRoleModulesByParasNoPage(RoleModule roleModule) throws Exception {
		return null;
	}
}

/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.RoleService;
import top.buukle.provider.security.dao.RoleMapper;
import top.buukle.provider.security.entity.Role;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {
	@Resource
	private RoleMapper roleMapper;
	@Override
	public Role getRoleById(Integer id) throws Exception{
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Role> getRoleByParas(Role role) throws Exception {
		return null;
	}

	@Override
	public void save(Role role) throws Exception {
		roleMapper.insert(role);
	}
	@Override
	public void update(Role role) throws Exception {
		roleMapper.updateByPrimaryKeySelective(role);
	}
	@Override
	public void delete(Role role) throws Exception {
	}
	@Override
	public List<Role> getRolesByParasNoPage(Role role) throws Exception {
		return null;
	}
}

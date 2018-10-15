/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.UserGroupService;
import top.buukle.provider.security.dao.UserGroupMapper;
import top.buukle.provider.security.entity.UserGroup;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userGroupService")
public class UserGroupServiceImpl implements UserGroupService {
	@Resource
	UserGroupMapper userGroupMapper;
	@Override
	public UserGroup getUserGroupById(Integer id) throws Exception{
		return userGroupMapper.getUserGroupById(id);
	}

	@Override
	public List<UserGroup> getUserGroupByParas(UserGroup userGroup) throws Exception {
		return null;
	}

	@Override
	public void save(UserGroup userGroup) throws Exception {
		userGroupMapper.save(userGroup);
	}
	@Override
	public void update(UserGroup userGroup) throws Exception {
		userGroupMapper.update(userGroup);
	}
	@Override
	public void delete(UserGroup userGroup) throws Exception {
	}
	@Override
	public List<UserGroup> getUserGroupsByParasNoPage(UserGroup userGroup) throws Exception {
		return null;
	}
}

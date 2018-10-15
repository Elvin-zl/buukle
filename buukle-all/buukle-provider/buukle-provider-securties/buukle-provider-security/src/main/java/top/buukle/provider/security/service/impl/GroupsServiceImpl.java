/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.GroupsService;
import top.buukle.provider.security.dao.GroupsMapper;
import top.buukle.provider.security.entity.Groups;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("groupsService")
public class GroupsServiceImpl implements GroupsService {
	@Resource
	GroupsMapper groupsMapper;
	@Override
	public Groups getGroupsById(Integer id) throws Exception{
		return groupsMapper.getGroupsById(id);
	}

	@Override
	public List<Groups> getGroupsByParas(Groups groups) throws Exception {
		return null;
	}

	@Override
	public void save(Groups groups) throws Exception {
		groupsMapper.save(groups);
	}
	@Override
	public void update(Groups groups) throws Exception {
		groupsMapper.update(groups);
	}
	@Override
	public void delete(Groups groups) throws Exception {
	}
	@Override
	public List<Groups> getGroupssByParasNoPage(Groups groups) throws Exception {
		return null;
	}
}

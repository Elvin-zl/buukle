/*
 * Powered By [rapid-framework]
 * Web Site: http://www.rapid-framework.org.cn
 * Google Code: http://code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import org.springframework.stereotype.Service;
import top.buukle.provider.security.service.UserExpService;
import top.buukle.provider.security.dao.UserExpMapper;
import top.buukle.plugin.security.entity.UserExp;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author elvin
 *
 */
@Service("userExpService")
public class UserExpServiceImpl implements UserExpService {
	@Resource
	private UserExpMapper userExpMapper;
	@Override
	public UserExp getUserExpById(Integer id) throws Exception{
		return userExpMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserExp> getUserExpByParas(UserExp userExp) throws Exception {
		return null;
	}

	@Override
	public void save(UserExp userExp) throws Exception {
		userExpMapper.insert(userExp);
	}
	@Override
	public void update(UserExp userExp) throws Exception {
		userExpMapper.updateByPrimaryKeySelective(userExp);
	}
	@Override
	public void delete(UserExp userExp) throws Exception {
	}
	@Override
	public List<UserExp> getUserExpsByParasNoPage(UserExp userExp) throws Exception {
		return null;
	}
}

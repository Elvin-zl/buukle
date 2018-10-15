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
import top.buukle.provider.security.dao.BuukleSignMapper;
import top.buukle.provider.security.entity.BuukleSign;
import top.buukle.provider.security.service.BuukleSignService;

/**
 * 
 * @author tengbx
 *
 */
@Service("buukleSignService")
public class BuukleSignServiceImpl implements BuukleSignService {
	@Resource
	BuukleSignMapper buukleSignMapper;
	@Override
	public BuukleSign getBuukleSignById(Integer id) throws Exception{
		return buukleSignMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BuukleSign> getBuukleSignByParas(BuukleSign buukleSign) throws Exception {
		return null;
	}

	@Override
	public void save(BuukleSign buukleSign) throws Exception {
		buukleSignMapper.insert(buukleSign);
	}
	@Override
	public void update(BuukleSign buukleSign) throws Exception {
		buukleSignMapper.updateByPrimaryKeySelective(buukleSign);
	}
	@Override
	public void delete(BuukleSign buukleSign) throws Exception {
	}
	@Override
	public List<BuukleSign> getBuukleSignsByParasNoPage(BuukleSign buukleSign) throws Exception {
		return null;
	}
}

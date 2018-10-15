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
import top.buukle.provider.security.dao.BuukleSignLogsMapper;
import top.buukle.provider.security.entity.BuukleSignLogs;
import top.buukle.provider.security.service.BuukleSignLogsService;

/**
 * 
 * @author tengbx
 *
 */
@Service("buukleSignLogsService")
public class BuukleSignLogsServiceImpl implements BuukleSignLogsService {
	@Resource
	BuukleSignLogsMapper buukleSignLogsMapper;
	@Override
	public BuukleSignLogs getBuukleSignLogsById(Integer id) throws Exception{
		return buukleSignLogsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<BuukleSignLogs> getBuukleSignLogsByParas(BuukleSignLogs buukleSignLogs) throws Exception {
		return null;
	}

	@Override
	public void save(BuukleSignLogs buukleSignLogs) throws Exception {
		buukleSignLogsMapper.insert(buukleSignLogs);
	}
	@Override
	public void update(BuukleSignLogs buukleSignLogs) throws Exception {
		buukleSignLogsMapper.updateByPrimaryKeySelective(buukleSignLogs);
	}
	@Override
	public void delete(BuukleSignLogs buukleSignLogs) throws Exception {
	}
	@Override
	public List<BuukleSignLogs> getBuukleSignLogssByParasNoPage(BuukleSignLogs buukleSignLogs) throws Exception {
		return null;
	}
}

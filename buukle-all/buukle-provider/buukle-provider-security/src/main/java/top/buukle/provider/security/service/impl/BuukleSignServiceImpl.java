/*
 * Powered By [rapid-framework]
 * Web Site: http:// www.rapid-framework.org.cn
 * Google Code: http:// code.google.com/p/rapid-framework/
 * Since 2008 - 2018
 */

package top.buukle.provider.security.service.impl;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.provider.security.constants.SecurityPublicKeyConstant;
import top.buukle.provider.security.dao.BuukleSignMapper;
import top.buukle.plugin.security.entity.BuukleSign;
import top.buukle.provider.security.invoker.BuukleSignInvoker;
import top.buukle.provider.security.service.BuukleSignService;

/**
 * 
 * @author tengbx
 *
 */
@Service("buukleSignService")
public class BuukleSignServiceImpl implements BuukleSignService {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(BuukleSignService.class);
    @Resource
    private BuukleSignMapper buukleSignMapper;
	@Override
	public BuukleSign getBuukleSignById(Integer id) throws Exception{
		return buukleSignMapper.selectByPrimaryKey(id);
	}

	/**
	 * 获取当前请求用户公钥
	 * @param buukleSign
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<BuukleSign> getUserBuukleSign(BuukleSign buukleSign) throws Exception {
		BuukleSign buukleSignCache = BuukleSignInvoker.getUserBuukleSign(SecurityPublicKeyConstant.USER_PUBLIC_KEY_PREFIX + buukleSign.getApplicationName() + buukleSign.getPartnerId());
		if(null != buukleSignCache){
		    LOGGER.info("应用:{}下,用户:{} 的请求命中验签缓存!",buukleSign.getApplicationName(),buukleSign.getPartnerId());
            List<BuukleSign> list = new ArrayList<>();
			list.add(buukleSignCache);
			return list;
		}
        List<BuukleSign> buukleSignByParas = buukleSignMapper.getBuukleSignByParas(buukleSign);
		if(CollectionUtils.isNotEmpty(buukleSignByParas) && buukleSignByParas.size() == NumberUtil.INTEGER_ONE){
            BuukleSignInvoker.saveUserBuukleSign(buukleSignByParas.get(0));
        }
        return buukleSignByParas;
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

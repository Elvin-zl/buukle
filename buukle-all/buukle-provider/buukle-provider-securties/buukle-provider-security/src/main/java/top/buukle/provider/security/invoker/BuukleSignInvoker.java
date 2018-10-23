package top.buukle.provider.security.invoker;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.NumberUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.provider.security.constants.SecurityPublicKeyConstant;
import top.buukle.provider.security.entity.BuukleSign;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/16.
 * @Description : 接口牙签缓存执行类
 */
public class BuukleSignInvoker {

    /**
     * 查询当前请求用户的公钥缓存
     * @param buukleSignCacheKey
     * @return
     */
    public static BuukleSign getUserBuukleSign(String buukleSignCacheKey) {
        String buukleSignStr = RedisString.get(buukleSignCacheKey);
        return StringUtil.isEmpty(buukleSignStr) ? null: JsonUtil.parseObject(buukleSignStr,BuukleSign.class);
    }

    /**
     * 缓存当前请求用户的公钥数据(默认超时时间是一天)
     * @param buukleSign
     */
    public static void saveUserBuukleSign(BuukleSign buukleSign) {
        RedisString.setWithExpire(SecurityPublicKeyConstant.USER_PUBLIC_KEY_PREFIX + buukleSign.getApplicationName() + buukleSign.getPartnerId(),JsonUtil.toJSONString(buukleSign), NumberUtil.LONG_ONE_DAY_SECOND);
    }
}

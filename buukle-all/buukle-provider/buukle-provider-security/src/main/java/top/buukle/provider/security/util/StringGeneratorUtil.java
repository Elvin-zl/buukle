package top.buukle.provider.security.util;

import top.buukle.common.util.common.StringUtil;

import java.util.UUID;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/30.
 * @Description : String生成工具类
 */
public class StringGeneratorUtil {

    /**
     * 生成用户缓存信息key
     * @return
     */
    public static String generateUserCookie() {
        return UUID.randomUUID().toString().replace(StringUtil.MIDDLE,StringUtil.EMPTY);
    }

    /**
     * 生成用户ID
     * @return
     */
    public static String generateUserID() {
        return "BK_" + (UUID.randomUUID().toString().replace(StringUtil.MIDDLE,StringUtil.EMPTY)).toUpperCase();
    }
}

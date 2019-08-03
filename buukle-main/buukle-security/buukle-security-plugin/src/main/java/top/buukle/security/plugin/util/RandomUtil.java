package top.buukle.security.plugin.util;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/11.
 * @Description :
 */
public class RandomUtil {

    /**
     * 获取当前系统时间+随机数 字符串
     * @return
     */
    public static String getRandomTimePlusNumber() {
        return (System.currentTimeMillis() + Math.random() + "");
    }
}

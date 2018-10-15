package top.buukle.common.util.RSA;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/6/6.
 * @Description :
 */
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 *    BASE64加密解密
 *  @author YUANWEi
 */
public class Coder {
    /**
     * BASE64解密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception {
        return (new BASE64Decoder()).decodeBuffer(key);
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] key) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(key);
    }
}

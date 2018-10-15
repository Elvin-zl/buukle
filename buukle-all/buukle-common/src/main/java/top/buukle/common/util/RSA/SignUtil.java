package top.buukle.common.util.RSA;


import org.junit.Test;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.request.RequestHead;
import top.buukle.common.util.common.JsonUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/13.
 * @Description : buukle签名工具类
 */
public class SignUtil {

    /** 加密后数据key*/
    public static final String ENCODE_DATA_KEY = "ENCODE_DATA_KEY";
    /** security签名key*/
    public static final String SECURITY_SIGN_KEY = "SECURITY_SIGN_KEY";
    /** 测试私钥*/
    private static final String PRIVATE_KEY = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJpbIJa0CxL8mud4/FDjLOfRj14b" +
            "60FyoBu91YVO8RJY3HMixT0h6OsqX5mQ72/5NfYOynwJuV3tgeZcCxlTi2NdStLoSyxPy7HhbPw4" +
            "8nmpZY5Mc6pBMBm+O8CHhxME0YgOW7AS8Cec+iGT5/J5vhEKC9yfJVBJbqDjJtmx2tANAgMBAAEC" +
            "gYEAgkfV+r0d97mTuTmJpXAJT+S1oFXqO8RW1PNmS+00VisAboFzfsSnRg3uwLvvDFCIthUH3KeM" +
            "eHXlxRv9FjRImZFHUYu9h5NgGc6FVCr62l789NoLh/s5b7Wcipi7HKLsTGdxyD/c0Vje9pPytogi" +
            "JJwkCUgjfWLmElnE+MNCX7UCQQDuwV+J47hW0TjpYrd0d2Oliy1t7EkWILtQUIsHvybS+KAHPPAW" +
            "FluG1cZotAaDqYn5S8MDAhNBxPy1K5+wB+o3AkEApYEx7sHG6X/F6pvhzzCjQkillO1mYpg2Br/W" +
            "snbF3En9sV719idX+sxRycNCVvXfZkYIllEO5VWZf7On9+Cl2wJAWDd87H8GgpWFuL4v2MmwON+G" +
            "5qGyk4l+jHtmE3Ouja8tud7rOs4B/X0JdXBnI8jF4SX8JSVkJh353ZsDws/52wJABhyDL4HQSocB" +
            "U+x1piTxolz0YE9z3Ggqdo1W7DgejkfdKlOLWY+SXBx3WK/xHyztFuW3I3XSyv0iMej8ZtbQyQJB" +
            "AJPhpsDxjhqys/l6zt4UFJ9w/CsYMH6D0o1mdDFkFCeHgQENDZ8ochAtdm7FBHNH1J81YMqPkG4A" +
            "pAtCDejPaG4=";

    /** 测试公钥*/
    private static final String PUBLIC_KEY = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCaWyCWtAsS/JrnePxQ4yzn0Y9eG+tBcqAbvdWFTvESWNxzIsU9IejrKl+ZkO9v+TX2Dsp8Cbld7YHmXAsZU4tjXUrS6EssT8ux4Wz8OPJ5qWWOTHOqQTAZvjvAh4cTBNGIDluwEvAnnPohk+fyeb4RCgvcnyVQSW6g4ybZsdrQDQIDAQAB";

    /**
     * 加密数据,生成签名
     * @param data          数据
     * @param privateKey    私钥
     * @return
     */
    public static Map<String,String> signWithEncrypt(String data, String privateKey) throws Exception {
        byte[] encodedData = RSACoder.encryptByPrivateKey(data.getBytes(), privateKey);
        String sign = RSACoder.sign(encodedData, privateKey);
        Map<String,String> encryptMap = new HashMap<>();
        encryptMap.put(ENCODE_DATA_KEY,encodedData.toString());
        encryptMap.put(SECURITY_SIGN_KEY,sign);
        return encryptMap;
    }

    /**
     * 不加密数据,生成签名
     * @param data          数据
     * @param privateKey    私钥
     * @return
     */
    public static String sign(String data, String privateKey) throws Exception {
        return RSACoder.sign(data.getBytes(), privateKey).replace("\r\n","");
    }

    /**
     * 验签(数据无加密)
     * @param data      数据
     * @param publicKey 公钥
     * @param sign      签名
     */
    public static boolean verify(String data, String publicKey, String sign) throws Exception {
        return RSACoder.verify(data.getBytes(), publicKey, sign);
    }

    @Test
    public void signTest() {
        try {
            //签名
            BaseRequest baseRequest = new BaseRequest();
            RequestHead requestHead = new RequestHead();
            requestHead.setApplicationName("test");
            requestHead.setOperationDatetime(new Date());
            baseRequest.setRequestHead(requestHead);
            baseRequest.setInfo("13257677876");
            String data = JsonUtil.toJSONString(baseRequest);
            String sign = sign(data, PRIVATE_KEY);

            //验签
            boolean verify = verify(data, PUBLIC_KEY, sign);
            System.out.println(verify);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

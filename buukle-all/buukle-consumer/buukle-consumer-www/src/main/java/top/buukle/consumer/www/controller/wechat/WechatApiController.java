package top.buukle.consumer.www.controller.wechat;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/3/7.
 * @Description :
 */
@Controller
@RequestMapping("/wechatApi")
public class WechatApiController {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(WechatApiController.class);

    @Value("${wechat.appid}")
    private String appid;

    @RequestMapping("/initWXJSInterface")
    @ResponseBody
    public Map<String, String> init(String url){
        return sign(RedisString.get("jsapiTicket"), url);
    }

    public Map<String, String> sign(String jsapiTicket, String url) {
        Map<String, String> ret = new HashMap<>();
        String nonceStr = createNonceStr();
        String timestamp = createTimestamp();
        String string1;
        String signature = null;
        // 注意这里参数名必须全部小写，且必须有序
        string1 = "jsapi_ticket=" + jsapiTicket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;
        LOGGER.info("加密串 :{}",string1);
        try {
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(string1.getBytes("UTF-8"));
            signature = byteToHex(crypt.digest());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ret.put("url", url);
        ret.put("appIds", appid);
        ret.put("jsapiTicket", jsapiTicket);
        ret.put("nonceStrs", nonceStr);
        ret.put("timestamps", timestamp);
        ret.put("signatures", signature);
        return ret;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    private static String createNonceStr() {
        return UUID.randomUUID().toString();
    }

    private static String createTimestamp() {
        return Long.toString(System.currentTimeMillis() / 1000);
    }
}

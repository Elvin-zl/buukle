package top.buukle.consumer.www.util.wechat;

import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.jedis.RedisString;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.www.vo.wechatApi.AccessToken;
import top.buukle.consumer.www.vo.wechatApi.JsApiTicket;

/**
 * 微信工具类
 */
public class WechatApiUtil {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(WechatApiUtil.class);

    /**
     * 获取并缓存授权码
     */
    public static void requestAndCacheAccessToken(String appid, String appsecret) {
        boolean isInit = true;
        while(true){
            // 第一休眠30秒
            if(isInit){
                try {
                    Thread.sleep(30 * 1000);
                    isInit = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                LOGGER.info("appid : {} , appsecret : {}" , appid,appsecret);
                AccessToken accessToken = CommonUtil.getAccessToken(appid, appsecret);
                if (null != accessToken) {
                    LOGGER.info("accessToken 初始化成功，具体信息 :{},将其加入缓存" , JsonUtil.toJSONString(accessToken));
                    RedisString.set("accessToken", accessToken.getAccessToken());
                    LOGGER.info("线程进入休眠,等待有效期的200秒前去请求新的accessToken");
                    Thread.sleep((accessToken.getExpiresIn() - 200) * 1000);
                } else {
                    LOGGER.info("出现异常,线程进入休眠等待一分钟，再次请求");
                    Thread.sleep(60 * 1000);
                }
            } catch (Exception e) {
                try {
                    LOGGER.info("出现异常,线程进入休眠等待一分钟，再次请求");
                    e.printStackTrace();
                    Thread.sleep(60 * 1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取并缓存jsapi通行证
     */
    public static void requestAndCacheJsApiTicket() {
        boolean isInit = true;
        while (true){
            // 第一休眠31秒
            if(isInit){
                try {
                    Thread.sleep(31 * 1000);
                    isInit = false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            try {
                String accessToken = RedisString.get("accessToken");
                JsApiTicket jsApiTicket;
                if(null != accessToken && !"".equals(accessToken)){
                    jsApiTicket = CommonUtil.getJsApiTicket(accessToken);
                    if (null != jsApiTicket) {
                        LOGGER.info("jsapiTicket 初始化成功,具体信息:{},将其加入缓存" , JsonUtil.toJSONString(jsApiTicket));
                        RedisString.set("jsapiTicket",jsApiTicket.getTicket());
                        LOGGER.info("线程进入休眠,等待有效期的200秒前去请求新的 jsApiTicket");
                        Thread.sleep((jsApiTicket.getExpiresIn() - 200) * 1000);
                    }
                }
                Thread.sleep(60 * 1000);
            } catch (Exception e) {
                try {
                    Thread.sleep(60 * 1000);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
        }
    }
}

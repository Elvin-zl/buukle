package top.buukle.consumer.cms.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import top.buukle.common.util.RSA.SignUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.consumer.cms.constants.CmsPrivateKeyConstant;

import static org.junit.Assert.assertEquals;

/**
 * security 接口签名
 */
@Configuration
public class SecuritySignInterceptor implements RequestInterceptor {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(SecuritySignInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if(requestTemplate.url().equals("/api/security/user/doLogin") || requestTemplate.url().equals("/api/security/user/authentication") || requestTemplate.url().equals("/api/security/user/setPermission")){
            try {
                requestTemplate.header(SignUtil.SECURITY_SIGN_KEY,SignUtil.sign(new String(requestTemplate.body()), CmsPrivateKeyConstant.SECURITY_API_PRIVATE_KEY));
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.info("签名异常!");
            }
        }
    }
}


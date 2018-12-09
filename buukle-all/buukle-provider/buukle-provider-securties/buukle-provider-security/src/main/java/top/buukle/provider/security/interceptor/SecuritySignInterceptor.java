package top.buukle.provider.security.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;
import top.buukle.common.util.RSA.SignUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.provider.security.constants.SecurityPrivateKeyConstant;

/**
 * security API接口签名
 */
@Configuration
public class SecuritySignInterceptor implements RequestInterceptor {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(SecuritySignInterceptor.class);

    @Override
    public void apply(RequestTemplate requestTemplate) {
        if(requestTemplate.url().startsWith("/api/")){
            try {
                requestTemplate.header(SignUtil.SECURITY_SIGN_KEY,SignUtil.sign(new String(requestTemplate.body()), SecurityPrivateKeyConstant.SECURITY_API_PRIVATE_KEY));
            } catch (Exception e) {
                e.printStackTrace();
                LOGGER.info("签名异常!");
            }
        }
    }
}


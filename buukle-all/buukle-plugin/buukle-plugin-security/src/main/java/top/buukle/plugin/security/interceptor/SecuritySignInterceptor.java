package top.buukle.plugin.security.interceptor;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

/**
 * security 接口验签
 */
@Configuration
public class SecuritySignInterceptor implements RequestInterceptor {
    @Override
    public void apply(RequestTemplate requestTemplate) {
        if(requestTemplate.url().equals("/api/security/user/doLogin") || requestTemplate.url().equals("/api/security/user/authentication") || requestTemplate.url().equals("/api/security/user/setPermission")){
            requestTemplate.header("token","11111111111111");
        }
    }
}


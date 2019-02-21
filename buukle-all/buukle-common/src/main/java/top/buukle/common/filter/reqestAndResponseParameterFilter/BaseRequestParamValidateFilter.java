package top.buukle.common.filter.reqestAndResponseParameterFilter;

import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseRequestValidator;
import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.DefaultRequestValidator;
import top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper.BaseRequestWrapper;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/6.
 * @Description :
 */
public class BaseRequestParamValidateFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    private BaseRequestValidator validator;

    public BaseRequestParamValidateFilter(BaseRequestValidator validator){
        this.validator = validator;
    }

    public BaseRequestParamValidateFilter(){
        this.validator = new DefaultRequestValidator();
    }

    private static final String STATIC_RESOURCE = "/static/";

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        // 静态资源不做过滤
        if(httpServletRequest.getRequestURI().startsWith(STATIC_RESOURCE)){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            BaseRequestWrapper baseRequestWrapper = new BaseRequestWrapper(httpServletRequest);
            String requestBody = baseRequestWrapper.getRequestBody();
            validator.doValidate(baseRequestWrapper,requestBody,servletResponse);
            filterChain.doFilter(baseRequestWrapper,servletResponse);
        }
    }
    @Override
    public void destroy() {

    }
}

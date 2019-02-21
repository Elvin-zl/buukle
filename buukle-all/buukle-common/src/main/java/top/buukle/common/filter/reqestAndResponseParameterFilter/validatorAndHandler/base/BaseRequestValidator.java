package top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper.BaseRequestWrapper;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.logger.BaseLogger;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description :
 */
public abstract class BaseRequestValidator {

    private static final BaseLogger LOGGER = BaseLogger.getLogger(BaseRequestValidator.class);
    /**
     * 参数校验入口(可重写)
     * @param httpServletRequest
     * @param requestBody
     * @param servletResponse
     * @return
     * @throws IOException
     */
    public BaseResponse doValidate(HttpServletRequest httpServletRequest, String requestBody, ServletResponse servletResponse) throws IOException {
        this.verify(requestBody,httpServletRequest);
        this.preValidate(httpServletRequest,requestBody);
        this.doValidate(httpServletRequest,httpServletRequest.getRequestURI(), requestBody, servletResponse);
        return null;
    }

    /**
     * 验签
     * @param requestBody
     * @param httpServletRequest
     */
    public abstract void verify(String requestBody, HttpServletRequest httpServletRequest);

    /**
     * 参数校验预处理(可重写)
     * @param httpServletRequest
     * @param requestBody
     */
    public void preValidate(HttpServletRequest httpServletRequest, String requestBody) {
        LOGGER.info("来源 :{},请求接口方法:{}开始",httpServletRequest.getRemoteAddr(),httpServletRequest.getRequestURI());
        LOGGER.info("请求参数 :{}",requestBody);
    }

    /**
     * 抽象参数校验方法(必须重写)
     * @param httpServletRequest
     * @param uri
     * @param requestBody
     * @param servletResponse
     * @throws IOException
     */
    public abstract void doValidate(HttpServletRequest httpServletRequest, String uri, String requestBody, ServletResponse servletResponse) throws IOException;

    /**
     * 将错误信息写到返回流中(可剧业务需求调用)
     * @param servletResponse
     * @param baseResponse
     * @throws IOException
     */
    protected void afterValidateWrong(ServletResponse servletResponse, BaseResponse baseResponse) throws IOException {
        servletResponse.setContentType("application/json; charset=utf-8");
        servletResponse.setCharacterEncoding("UTF-8");
        String userJson = null == baseResponse ?  JSON.toJSONString(new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_NULL)) : JSON.toJSONString(baseResponse);
        LOGGER.info("返回参数 :{} ",userJson);
        ServletOutputStream outputStream = servletResponse.getOutputStream();
        outputStream.write(userJson.getBytes("UTF-8"));
        outputStream.flush();
    }

    /**
     * 校验后处理将处理后
     * @param httpServletRequest
     * @param handledRequestBody
     * @throws IOException
     */
    protected void afterValidateHandle(HttpServletRequest httpServletRequest, String handledRequestBody) throws IOException {
       this.setRequestBody(httpServletRequest,handledRequestBody);
       // do something ...
    }

    /**
     * 将处理后的请求参数写回(可剧业务需求调用)
     * @param httpServletRequest
     * @param handledRequestBody
     * @throws IOException
     */
    protected void setRequestBody(HttpServletRequest httpServletRequest, String handledRequestBody) throws IOException {
        BaseRequestWrapper baseRequestWrapper = (BaseRequestWrapper) httpServletRequest;
        baseRequestWrapper.setRequestBody(handledRequestBody);
    }
}

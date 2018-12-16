package top.buukle.provider.security.filter.RquestValidatorAndResponseHanler;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections.CollectionUtils;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseRequestValidator;
import top.buukle.common.request.BaseRequest;
import top.buukle.common.response.BaseResponse;
import top.buukle.common.util.RSA.SignUtil;
import top.buukle.common.util.common.JsonUtil;
import top.buukle.common.util.common.SpringContextUtil;
import top.buukle.common.util.common.StringUtil;
import top.buukle.common.util.logger.BaseLogger;
import top.buukle.plugin.security.entity.BuukleSign;
import top.buukle.provider.security.service.BuukleSignService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description : api接口验签校验请求处理器
 * @Tips 继承BaseRequestValidator 自定义参数检验规则和异常返回response信息
 */
public class ApiSignRequestValidator extends BaseRequestValidator {


    private static final BaseLogger LOGGER = BaseLogger.getLogger(ApiSignRequestValidator.class);

    /**
     * 验签
     * @param requestBody
     * @param httpServletRequest
     */
    @Override
    public void verify(String requestBody, HttpServletRequest httpServletRequest) {
        Boolean verify;
        BaseRequest baseRequest;
        try {
            //获取公钥
            baseRequest = JsonUtil.parseObject(requestBody, BaseRequest.class);
            String applicationName = baseRequest.getRequestHead().getApplicationName();
            String operationId = baseRequest.getRequestHead().getOperationId();
            BuukleSignService buukleSignService = SpringContextUtil.getBean(BuukleSignService.class);
            List<BuukleSign> buukleSignByParas = buukleSignService.getUserBuukleSign(new BuukleSign(applicationName, operationId));
            verify  = SignUtil.verify(requestBody, this.validateSign(buukleSignByParas), httpServletRequest.getHeader(SignUtil.SECURITY_SIGN_KEY));
        } catch (Exception e) {
            e.printStackTrace();
            throw new BaseException(BaseResponseCode.BASE_REQUEST_SIGN_EXCEPTION);
        }
        if(!verify){
            LOGGER.info("验签失败参数 : {}" ,requestBody);
            throw new BaseException(BaseResponseCode.BASE_REQUEST_SIGN_WRONG);
        }
        LOGGER.info("{}应用下,用户:{}验签通过!",baseRequest.getRequestHead().getApplicationName(),baseRequest.getRequestHead().getOperationId());
    }

    /**
     * 校验公钥集合
     * @param buukleSignByParas
     * @return
     */
    private String validateSign(List<BuukleSign> buukleSignByParas) {
        if(CollectionUtils.isEmpty(buukleSignByParas)){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_SIGN_PUBLIC_KEY_NULL);
        }
        if(buukleSignByParas.size()>1){
            throw new BaseException(BaseResponseCode.BASE_REQUEST_SIGN_WRONG);
        }
        return buukleSignByParas.get(0).getPartnerKey();
    }

    /**
     * 重写参数校验方法
     * @param httpServletRequest
     * @param uri
     * @param requestBody
     * @param servletResponse
     */
    @Override
    public void doValidate(HttpServletRequest httpServletRequest, String uri, String requestBody, ServletResponse servletResponse) throws IOException {
        try {
            if(!uri.contains("uploadImageServlet")){
                String reqMethod = httpServletRequest.getMethod();
                if("POST".equals(reqMethod)){
                    if(uri.startsWith("/api/")){
                        //校验请求参数
                        BaseResponse baseResponse = this.doValidate(requestBody);
                        //校验失败
                        if(!baseResponse.isSuccess()){
                            this.afterValidateWrong(servletResponse,baseResponse);
                        }else{
                            this.afterValidateHandle(httpServletRequest,requestBody);
                        }
                    }
                }
            }
        }catch (Exception e){
            this.afterValidateWrong(servletResponse,new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_PARSE_INFO_LIST_WRONG));
        }
    }

    /**
     * 重载参数校验方法
     * @param requestBody
     * @return
     */
    private BaseResponse doValidate(String requestBody) {
        BaseRequest baseRequest = JSON.parseObject(requestBody, BaseRequest.class);
        if(null == baseRequest || baseRequest.getRequestHead() == null ||
                StringUtil.isEmpty(baseRequest.getRequestHead().getApplicationName()) ||
                StringUtil.isEmpty(baseRequest.getRequestHead().getOperationLoginName()) ||
                StringUtil.isEmpty(baseRequest.getRequestHead().getOperationId()) ||
                baseRequest.getRequestHead().getOperationDatetime() == null){
            LOGGER.info(BaseResponseCode.BASE_REQUEST_NULL.getMsg());
            return new BaseResponse.Builder().buildFailedOut(BaseResponseCode.BASE_REQUEST_NULL);
        }
        return new BaseResponse.Builder().buildSuccess();
    }
}

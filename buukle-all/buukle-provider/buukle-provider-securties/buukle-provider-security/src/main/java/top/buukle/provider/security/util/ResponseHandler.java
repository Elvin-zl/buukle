package top.buukle.provider.security.util;

import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseResponseParamHandler;
import top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper.BaseResponseWrapper;
import top.buukle.common.util.logger.BaseLogger;

import java.io.IOException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description :
 */
public class ResponseHandler extends BaseResponseParamHandler {


    private static final BaseLogger LOGGER = BaseLogger.getLogger(ResponseHandler.class);


    @Override
    public void handle(BaseResponseWrapper baseResponseWrapper) throws IOException {
        super.preHandle(baseResponseWrapper);
        this.doHandle(baseResponseWrapper);
    }

    /**
     * 重写处理方法
     * @param baseResponseWrapper
     */
    @Override
    protected void doHandle(BaseResponseWrapper baseResponseWrapper) throws IOException {

        LOGGER.info("返回值没有处理.. .. ");
//        String responseBody = baseResponseWrapper.getResponseBody();
//        BaseResponse baseResponse = JSON.parseObject(responseBody, BaseResponse.class);
//        baseResponse.setMsg(baseResponse.getMsg()+"--");
//        this.afterHandle(baseResponseWrapper,JSON.toJSONString(baseResponse));
    }
}

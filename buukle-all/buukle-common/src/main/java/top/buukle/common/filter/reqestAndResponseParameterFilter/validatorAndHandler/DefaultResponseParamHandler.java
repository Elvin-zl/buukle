package top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler;

import top.buukle.common.filter.reqestAndResponseParameterFilter.validatorAndHandler.base.BaseResponseParamHandler;
import top.buukle.common.filter.reqestAndResponseParameterFilter.wrapper.BaseResponseWrapper;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/7.
 * @Description : 默认参数检验类
 */
public  class DefaultResponseParamHandler extends BaseResponseParamHandler {

    /**
     * 重写默认处理方法
     * @param baseResponseWrapper
     */
    @Override
    protected void doHandle(BaseResponseWrapper baseResponseWrapper) {
        // 默认不作处理
    }
}

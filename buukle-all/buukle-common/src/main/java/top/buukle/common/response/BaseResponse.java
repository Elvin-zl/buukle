package top.buukle.common.response;

import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.util.common.StringUtil;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle buukle 公共响应规范
 */
public class BaseResponse<T>{

    /** 响应码常量 : 成功*/
    final public static String SUCCESS = "S";
    /** 响应码常量 : 失败*/
    final public static String FAILED = "F";
    /** 响应码常量 : 不明*/
    final public static String UNKNOWN = "T";
    /** 响应msg常量 : 失败*/
    private static final String FAILED_MSG = "失败 !";
    /** 响应msg常量 : 成功*/
    private static final String SUCCESS_MSG = "成功!";

    final public static String SYSTEM_BUSY = "系统异常";

    /** 响应头*/
    private ResponseHead responseHead;
    /** 系统内响应状态码*/
    private String status;
    /** 系统内响应信息*/
    private String msg;
    /** 系统内响应错误码*/
    private String code;
    /** 第三方/业务 响应体*/
    private ResponseBusiness business;


    public ResponseHead getResponseHead() {
        return responseHead;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseBusiness getBusiness() {
        if(null == business){
            return new ResponseBusiness();
        }
        return business;
    }

    public void setResponseHead(ResponseHead responseHead) {
        this.responseHead = responseHead;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setBusiness(ResponseBusiness business) {
        this.business = business;
    }


    public List<T> getListData(Class<T> clazz) {
        return this.getBusiness().getListData(clazz);
    }

    public T getDataWithIndex(Class<T> clazz,Integer index) {
        return (T) this.getBusiness().getDataWithIndex(clazz,index);
    }

    public Boolean isSuccess() {
        return StringUtil.isNotEmpty(status) && status.equals(SUCCESS);
    }

    /** 静态内部建造类*/
    public static class Builder{
        BaseResponse baseResponse = new BaseResponse();
        public Builder setStatus(String status) {
            baseResponse.status = status;
            return this;
        }

        public Builder setCode(String code) {
            baseResponse.code = code;
            return this;
        }

        public Builder setMsg(String msg) {
            baseResponse.msg = msg;
            return this;
        }

        public Builder setBusiness(ResponseBusiness bussiness) {
            baseResponse.business = bussiness;
            return this;
        }

        /** 基础build*/
        public BaseResponse build() {
            baseResponse.responseHead = new ResponseHead();
            return baseResponse;
        }

        /** 成功响应(不带业务响应参数)*/
        public BaseResponse buildSuccess() {
            baseResponse.status =  SUCCESS;
            baseResponse.setMsg(SUCCESS_MSG);
            return build();
        }
        /** 成功响应(带业务响应参数 数据)*/
        public BaseResponse buildSuccess(Object o) {
            baseResponse.status =  SUCCESS;
            baseResponse.business =  new ResponseBusiness(o);
            return build();
        }
        /** 系统内失败响应(带返回码)*/
        public BaseResponse buildFailedInner(BaseResponseCode baseResponseCode) {
            baseResponse.status = baseResponseCode.getStatus();
            baseResponse.code = baseResponseCode.getCode();
            baseResponse.msg = baseResponseCode.getMsg();
            return build();
        }
        /** 系统内失败响应(全局异常处理-自定义异常)*/
        public BaseResponse buildFailedInner(BaseException baseException) {
            baseResponse.status = baseException.getStatus();
            baseResponse.msg = baseException.getMsg();
            baseResponse.code = baseException.getCode();
            return build();
        }
        /** 系统内失败响应(全局异常处理-系统异常)
         * @param errorCount
         * */
        public BaseResponse buildFailedInner(AtomicLong errorCount) {
            //系统异常计数器加一
            errorCount.incrementAndGet() ;
            baseResponse.status = FAILED;
            baseResponse.msg = SYSTEM_BUSY;
            baseResponse.code = BaseResponseCode.FAILED.getCode() + ":" + errorCount;
            return build();
        }
        /** 失败响应(不带返回码)*/
        public BaseResponse buildFailed() {
            baseResponse.status = FAILED;
            baseResponse.msg = FAILED_MSG;
            return build();
        }
        /** 失败响应(不带返回码)*/
        public BaseResponse buildFailed(String msg) {
            baseResponse.status = FAILED;
            baseResponse.msg = msg;
            return build();
        }
        /** 第三方失败响应(带返回码)*/
        public BaseResponse buildFailedOut(BaseResponseCode baseResponseCode) {
            baseResponse.status = baseResponseCode.getStatus();
            baseResponse.code = baseResponseCode.getCode();
            baseResponse.msg = baseResponseCode.getMsg();
            baseResponse.business =  new ResponseBusiness(baseResponseCode);
            return build();
        }
    }
}


package top.buukle.common.request.out;

import com.alibaba.fastjson.JSON;
import top.buukle.common.constants.BaseResponseCode;
import top.buukle.common.exception.BaseException;
import top.buukle.common.request.RequestHead;
import top.buukle.common.vo.page.PageBounds;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
public class OutRequest<T>{

    /** 请求头*/
    private RequestHead requestHead;
    /** 请求参数*/
    private T info;
    /** String 扩展请求参数*/
    private String expandParameterString;
    /** Integer 扩展请求参数*/
    private Integer expandParameterInteger;

    private PageBounds pageBounds;

    public RequestHead getRequestHead() {
        return requestHead;
    }

    public void setRequestHead(RequestHead requestHead) {
        this.requestHead = requestHead;
    }

    public T getInfo(Class<T> clazz) {
        return JSON.parseObject(JSON.toJSONString(info),clazz);
    }

    public List<T> getInfoList(Class<T> clazz) {
        if(info instanceof List){
            return JSON.parseArray(JSON.toJSONString(info), clazz);
        }else{
            throw new BaseException(BaseResponseCode.BASE_REQUEST_FORMAT_INFO_LIST_WRONG);
        }
    }

    public PageBounds getPageBounds() {
        return pageBounds;
    }

    public void setPageBounds(PageBounds pageBounds) {
        this.pageBounds = pageBounds;
    }

    public Object getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public String getExpandParameterString() {
        return expandParameterString;
    }

    public void setExpandParameterString(String expandParameterString) {
        this.expandParameterString = expandParameterString;
    }

    public Integer getExpandParameterInteger() {
        return expandParameterInteger;
    }

    public void setExpandParameterInteger(Integer expandParameterInteger) {
        this.expandParameterInteger = expandParameterInteger;
    }

    /** 内部建造类*/
    public static class Builder{
        private static final String DEFAULT_LOGIN_NAME = "authenticationOrLoginSystem";
        private static final String DEFAULT_OPERATION_NAME = "authenticationOrLoginSystem";
        private static final String DEFAULT_OPERATION_ID = "-1";
        OutRequest outRequest = new OutRequest();
        RequestHead.Builder headBuilder = new RequestHead.Builder();

        /** 请求操作人登录名*/
        public Builder setOperationLoginName(String operationLoginName){
            headBuilder.setOperationLoginName(operationLoginName);
            return this;
        }

        /** 请求操作人姓名*/
        public Builder setOperationName(String operationName){
            headBuilder.setOperationLoginName(operationName);
            return this;
        }
        /** 请求操作人Id*/
        public Builder setOperationId(String operationId){
            headBuilder.setOperationId(operationId);
            return this;
        }
        /** 请求分页信息Id*/
        public Builder setPageBounds(PageBounds pageBounds){
            outRequest.setPageBounds(pageBounds);
            return this;
        }
        /** 基础build*/
        public OutRequest build(String applicationName, String operationId) {
            this.setOperationLoginName(DEFAULT_LOGIN_NAME);
            this.setOperationName(DEFAULT_OPERATION_NAME);
            this.setOperationId(operationId);
            outRequest.requestHead = headBuilder.build(applicationName);
            return outRequest;
        }
    }
}

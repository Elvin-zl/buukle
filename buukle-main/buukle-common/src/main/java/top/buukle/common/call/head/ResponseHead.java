/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: RequestHead
 * Author:   zhanglei1102
 * Date:     2019/7/26 15:38
 * Description: 请求头
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.common.call.head;

import top.buukle.common.call.code.BaseReturnEnum;
import top.buukle.common.exception.CommonException;
import top.buukle.common.status.StatusConstants;

import java.util.Date;

/**
 * @description 〈请求头〉
 * @author zhanglei1102
 * @create 2019/7/26
 * @since 1.0.0
 */
public class ResponseHead extends Head {

    /** 接口返回状态码*/
    private String status;
    /** 接口返回码*/
    private String code;
    /** 返回信息*/
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public static class Builder{
        public ResponseHead buildSuccess() {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(BaseReturnEnum.SUCCESS.getStatus());
            responseHead.setCode(BaseReturnEnum.SUCCESS.getCode());
            responseHead.setMsg(BaseReturnEnum.SUCCESS.getMsg());
            responseHead.setOperationTime(new Date());
            return responseHead;
        }
        public ResponseHead buildFailedInner(CommonException commonException) {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(commonException.getStatus());
            responseHead.setCode(commonException.getCode());
            responseHead.setMsg(commonException.getMsg());
            responseHead.setOperationTime(new Date());
            return responseHead;
        }
        public ResponseHead buildFailed(Exception exception) {
            ResponseHead responseHead = new ResponseHead();
            responseHead.setStatus(BaseReturnEnum.EXCEPTION.getStatus());
            responseHead.setCode(BaseReturnEnum.EXCEPTION.getCode());
            responseHead.setMsg(BaseReturnEnum.EXCEPTION.getMsg());
            responseHead.setOperationTime(new Date());
            return responseHead;
        }
    }
}
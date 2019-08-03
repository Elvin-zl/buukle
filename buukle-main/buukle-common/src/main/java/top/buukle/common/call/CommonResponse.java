package top.buukle.common.call;


import top.buukle.common.call.head.ResponseHead;
import top.buukle.common.exception.CommonException;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
public class CommonResponse<T> {
    /** 响应头*/
    private ResponseHead head;
    /** 响应体*/
    private T body;

    public CommonResponse (){

    }

    public CommonResponse(ResponseHead responseHead) {
        this.head = responseHead;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static class Builder {
        public CommonResponse buildSuccess(){
            return new CommonResponse(new ResponseHead.Builder().buildSuccess());
        }

        public CommonResponse buildFailedInner(CommonException commonException) {
            return new CommonResponse(new ResponseHead.Builder().buildFailedInner(commonException));
        }

        public CommonResponse buildFailed(Exception exception) {
            return new CommonResponse(new ResponseHead.Builder().buildFailed(exception));
        }
    }
}



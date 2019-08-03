package top.buukle.common.call;


import top.buukle.common.call.head.Head;

import java.util.Date;


/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
public class CommonRequest<T>{

    /** 请求头*/
    private Head head;
    /** 请求体*/
    private T body;

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public static class Builder {

        public static CommonRequest build(String applicationName) {
            CommonRequest commonRequest =  new CommonRequest<>();
            Head head  = new Head();
            head.setApplicationName(applicationName);
            head.setOperationTime(new Date());
            head.setOperator(applicationName);
            head.setOperatorId(applicationName);
            commonRequest.setHead(head);
            return commonRequest;
        }
    }
}



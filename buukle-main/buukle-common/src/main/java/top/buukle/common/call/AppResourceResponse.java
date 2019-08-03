package top.buukle.common.call;


import top.buukle.common.call.head.ResponseHead;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/9/19.
 * @Description : buukle 公共请求规范
 */
public class AppResourceResponse {
    /** 响应头*/
    private ResponseHead head;

    /** 已经注册的资源目录*/
    private List<String> registeredResourceList;
    /** 应用需要授权的目录*/
    private List<String> permResourceList;

    public AppResourceResponse (){

    }

    public AppResourceResponse(ResponseHead responseHead) {
        this.head = responseHead;
    }

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public List<String> getRegisteredResourceList() {
        return registeredResourceList;
    }

    public void setRegisteredResourceList(List<String> registeredResourceList) {
        this.registeredResourceList = registeredResourceList;
    }

    public List<String> getPermResourceList() {
        return permResourceList;
    }

    public void setPermResourceList(List<String> permResourceList) {
        this.permResourceList = permResourceList;
    }
}






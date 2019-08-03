package top.buukle.common.call;

import top.buukle.common.call.head.ResponseHead;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/2/12.
 * @Description : 上传响应
 */
public class UploadResponse {

    /** 响应头*/
    private ResponseHead head;
    /**  0 表示上传失败，1 表示上传成功*/
    private Integer success;
    /** 上传成功时才返回*/
    private String url;

    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

package top.buukle.common.response;

import top.buukle.common.util.common.NumberUtil;

/**
 * @Author elvin
 * @Date Created by elvin on 2019/2/12.
 * @Description : markdown返回包装对象
 */
public class MarkdownResponse {

    public static final Integer SUCCESS = NumberUtil.INTEGER_ONE;
    public static final Integer FAILD = NumberUtil.INTEGER_ZERO;

    /**  0 表示上传失败，1 表示上传成功*/
    private Integer success;

    private String message ;

    /** 上传成功时才返回*/
    private String url;

    public Integer getSuccess() {
        return success;
    }

    public void setSuccess(Integer success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

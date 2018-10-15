package top.buukle.provider.security.vo.response;


import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description :
 */
public class PageResponse <T>{

    /** 接口状态*/
    private String code;
    /** 提示文本*/
    private String msg;
    /** 数据长度*/
    private Integer count;
    /** 数据列表*/
    private List<T> data;
    /** 当前页*/
    private Integer page;
    /** 页长*/
    private Integer limit;


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

package top.buukle.common.vo.response;


import com.github.pagehelper.PageInfo;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
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
    /** 总条数*/
    private Long count;
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

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
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

    public static class Builder{

        private static final String SUCCESS = "成功!";
        private static final String SUCCESS_CODE = "0";

        PageResponse pageResponse = new PageResponse();

        public Builder setCode(String code) {
            pageResponse.code = code;
            return this;
        }
        public Builder setMsg(String msg) {
            pageResponse.msg = msg;
            return this;
        }
        public Builder setCount(Long count) {
            pageResponse.count = count;
            return this;
        }
        public <T> Builder setData(List<T> data) {
            if(CollectionUtils.isEmpty(pageResponse.data)){
                pageResponse.data = new ArrayList<T>();
            }
            pageResponse.data = data;
            return this;
        }
        public Builder setPage(Integer page) {
            pageResponse.page = page;
            return this;
        }
        public Builder setLimit(Integer limit) {
            pageResponse.limit = limit;
            return this;
        }
        public PageResponse build() {
            return pageResponse;
        }

        public <T> PageResponse<T> build(PageInfo<T> tPageInfo) {
            this.setCode(SUCCESS_CODE);
            this.setCount(tPageInfo.getTotal());
            this.setLimit(tPageInfo.getPageSize());
            this.setPage(tPageInfo.getPageNum());
            this.setMsg(SUCCESS);
            this.setData(tPageInfo.getList());
            return pageResponse;
        }

        public <T> PageResponse<T> build(List<T> voList, PageInfo tPageInfo) {
            this.setCode(SUCCESS_CODE);
            this.setCount(tPageInfo.getTotal());
            this.setLimit(tPageInfo.getPageSize());
            this.setMsg(SUCCESS);
            this.setPage(tPageInfo.getPageNum());
            this.setData(voList);
            return pageResponse;
        }
    }
}

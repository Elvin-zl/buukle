package top.buukle.provider.security.vo.query;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 前端分页参数包装类
 */
public class PageBounds {

    private Integer page;
    private Integer limit;

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

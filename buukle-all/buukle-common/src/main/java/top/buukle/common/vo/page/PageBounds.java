package top.buukle.common.vo.page;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 前端分页参数包装类
 */
public class PageBounds {

    private Integer page;
    private Integer limit;

    public PageBounds(int page, int limit) {
        this.page = page;
        this.limit = limit;
    }
    public PageBounds() {

    }
    public Integer getPage() {
        return null == page ? 0 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return null == limit ? 10 : limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }
}

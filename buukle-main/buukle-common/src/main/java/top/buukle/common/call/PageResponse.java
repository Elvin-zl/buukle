package top.buukle.common.call;

import top.buukle.common.call.head.ResponseHead;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 分页响应
 */
public class PageResponse{

    /** 响应头*/
    private ResponseHead head;
    /** 响应体*/
    private PageBody body;

    PageResponse(List<?> list, int pageNo, int pageSize, long total) {
        head = new ResponseHead.Builder().buildSuccess();
        body = new PageBody(list,pageNo,pageSize,total);
    }

    public PageResponse(List<?> list) {
        head = new ResponseHead.Builder().buildSuccess();
        body = new PageBody(list);
    }
    public ResponseHead getHead() {
        return head;
    }

    public void setHead(ResponseHead head) {
        this.head = head;
    }

    public PageBody getBody() {
        return body;
    }

    public void setBody(PageBody body) {
        this.body = body;
    }

    public static class Builder{
        public PageResponse build(List<?> list, int pageNo, int pageSize, long total) {
            return new PageResponse(list,pageNo,pageSize,total);
        }
        public PageResponse buildWithoutPage(List<?> list) {
            return new PageResponse(list);
        }
    }
    private class PageBody{
        private Integer pageNo = 1;
        private Integer pageSize = 10;
        private long total;
        private long totalPage;
        private List<?> list;
        PageBody(List<?> list, int pageNo, int pageSize, long total) {
            this.pageNo =  pageNo;
            this.pageSize =  pageSize == 0 ? this.pageSize : pageSize;
            this.total =  total;
            this.list =  list;
        }
        public PageBody(List<?> list) {
            this.list =  list;
        }
        public Integer getPageNo() {
            return pageNo;
        }

        public void setPageNo(Integer pageNo) {
            this.pageNo = pageNo;
        }

        public Integer getPageSize() {
            return pageSize;
        }

        public void setPageSize(Integer pageSize) {
            this.pageSize = pageSize;
        }

        public List<?> getList() {
            return list;
        }

        public void setList(List<?> list) {
            this.list = list;
        }

        public long getTotal() {
            return total;
        }

        public void setTotal(long total) {
            this.total = total;
        }

        public long getTotalPage() {
            return  total % pageSize > 0 ? 1 + (total / pageSize) : (total / pageSize);
        }

        public void setTotalPage(long totalPage) {
            this.totalPage = totalPage;
        }
    }
}


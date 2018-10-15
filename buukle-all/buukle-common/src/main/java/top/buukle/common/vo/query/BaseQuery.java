package top.buukle.common.vo.query;

import java.util.Date;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : buukle 查询基础包装类
 */
public class BaseQuery {

    /** 当前页码*/
    private Integer pageNo;
    /** 页长*/
    private Integer pageSize;
    /** 起始时间*/
    private Date startTime;
    /** 截止时间*/
    private Date endTime;
    /** 状态*/
    private Integer status;

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

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

package top.buukle.consumer.www.entity.vo;

import top.buukle.consumer.www.entity.ArticleInfo;

/**
* @author elvin
* @description  ArticleInfo 查询包装类
*/
public class ArticleInfoQuery extends ArticleInfo {

    /** 起始时间*/
    private String startTime ;

    /** 结束时间*/
    private String endTime ;

    /** 排序标识*/
    private Integer orderFlag ;

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getOrderFlag() {
        return orderFlag;
    }

    public void setOrderFlag(Integer orderFlag) {
        this.orderFlag = orderFlag;
    }
}
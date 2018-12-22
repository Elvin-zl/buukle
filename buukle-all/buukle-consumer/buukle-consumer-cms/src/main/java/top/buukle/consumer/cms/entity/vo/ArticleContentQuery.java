package top.buukle.consumer.cms .entity.vo;

import top.buukle.consumer.cms .entity. ArticleContent;

/**
* @author elvin
* @description  ArticleContent 查询包装类
*/
public class ArticleContentQuery extends ArticleContent{

    /** 起始时间*/
    private String startTime ;

    /** 结束时间*/
    private String endTime ;

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

}
package top.buukle.consumer.www .entity.vo;

import top.buukle.consumer.www .entity. TimelineComment;

/**
* @author elvin
* @description  TimelineComment 查询包装类
*/
public class TimelineCommentQuery extends TimelineComment{

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
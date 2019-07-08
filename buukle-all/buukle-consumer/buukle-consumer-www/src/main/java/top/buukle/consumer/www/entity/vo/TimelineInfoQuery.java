package top.buukle.consumer.www.entity.vo;

import top.buukle.consumer.www.entity. TimelineInfo;

/**
* @author elvin
* @description  TimelineInfo 查询包装类
*/
public class TimelineInfoQuery extends TimelineInfo{

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
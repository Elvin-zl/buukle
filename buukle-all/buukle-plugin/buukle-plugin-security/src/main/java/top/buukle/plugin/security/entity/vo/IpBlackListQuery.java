package top.buukle.plugin.security.entity.vo;

import top.buukle.plugin.security.entity.IpBlackList;

/**
* @author elvin
* @description  IpBlackList 查询包装类
*/
public class IpBlackListQuery extends IpBlackList{

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
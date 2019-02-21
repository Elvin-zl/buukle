package top.buukle.consumer.www.entity.vo;

import top.buukle.consumer.www.entity. UserArticlePraiseRelation;

/**
* @author elvin
* @description  UserArticlePraiseRelation 查询包装类
*/
public class UserArticlePraiseRelationQuery extends UserArticlePraiseRelation{

    /** 起始时间*/
    private String startTime ;

    /** 结束时间*/
    private String endTime ;

    private Boolean praiseFlag;

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

    public Boolean getPraiseFlag() {
        return praiseFlag;
    }

    public void setPraiseFlag(Boolean praiseFlag) {
        this.praiseFlag = praiseFlag;
    }
}
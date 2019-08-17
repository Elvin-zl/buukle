package top.buukle.security .entity.vo;

import top.buukle.security.entity.Menu;

/**
* @author elvin
* @description  Menu 查询包装类
*/
public class MenuQuery extends Menu implements BaseQuery{

    /** 当前页码*/
    private Integer page;
    /** 页长*/
    private Integer pageSize;
    /** 起始时间*/
    private String startTime;
    /** 截止时间*/
    private String endTime;
    /** 状态*/
    private String states;
    /** 应用编码*/
    private String applicationCode;

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }

    public String getStates() {
        if("null".equals(states)){
            return null;
        }
        return this.states;
    }

    public void setStates(String states) {
        if("null".equals(states)){
            states = null;
        }
        this.states = states;
    }

    public Integer getPage() {
        return page == null ? 1 : page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize == null ? 10 : pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

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
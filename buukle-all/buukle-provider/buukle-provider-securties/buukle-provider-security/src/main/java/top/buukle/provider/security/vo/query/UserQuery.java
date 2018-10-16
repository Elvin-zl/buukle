package top.buukle.provider.security.vo.query;

import top.buukle.provider.security.entity.User;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/10/14.
 * @Description : 用户查询包装类
 */
public class UserQuery extends User {

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

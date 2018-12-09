package top.buukle.common.dataIsolation;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/2.
 * @Description :  数据隔离关系对象
 */
public class IsolationRelation {

    /** 下级成员id集合*/
    private List<String> subCodeList;

    /** 用户级别*/
    private Integer userLevel;

    public List<String> getSubCodeList() {
        return subCodeList;
    }

    public void setSubCodeList(List<String> subCodeList) {
        this.subCodeList = subCodeList;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }
}

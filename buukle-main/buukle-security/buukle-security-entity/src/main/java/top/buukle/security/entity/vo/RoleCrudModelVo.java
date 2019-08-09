package top.buukle.security.entity.vo;

import top.buukle.security.entity.Role;

/**
* @author elvin
* @description  Role 查询包装类
*/
public class RoleCrudModelVo extends Role{


    /** 所属应用code*/
    private String applicationCode;
    /** 上级角色名*/
    private String superName;

    public String getSuperName() {
        return superName;
    }

    public void setSuperName(String superName) {
        this.superName = superName;
    }

    public String getApplicationCode() {
        return applicationCode;
    }

    public void setApplicationCode(String applicationCode) {
        this.applicationCode = applicationCode;
    }
}
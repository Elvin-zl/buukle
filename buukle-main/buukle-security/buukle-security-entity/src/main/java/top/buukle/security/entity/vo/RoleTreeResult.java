/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: RoleTreeResult
 * Author:   zhanglei1102
 * Date:     2019/8/13 17:52
 * Description: 角色树节点包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.entity.vo;

import top.buukle.security.entity.Role;

/**
 * @description 〈角色树节点包装类〉
 * @author zhanglei1102
 * @create 2019/8/13
 * @since 1.0.0
 */
public class RoleTreeResult extends Role{

    private boolean checked;
    private String name;
    private boolean nocheck;

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return super.getRoleName();
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }
}
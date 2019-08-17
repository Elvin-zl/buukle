/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: ZtreeNode
 * Author:   zhanglei1102
 * Date:     2019/8/14 16:06
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.entity.vo;

/**
 * @description 〈〉
 * @author zhanglei1102
 * @create 2019/8/14
 * @since 1.0.0
 */
public class ZtreeNode {

    private boolean checked;
    private boolean nocheck;
    private String name;
    private Integer id;
    private Integer pid;

    public boolean isNocheck() {
        return nocheck;
    }

    public void setNocheck(boolean nocheck) {
        this.nocheck = nocheck;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
/**
 * Copyright (C), 2015-2019  http://www.jd.com
 * FileName: ApplicationNode
 * Author:   zhanglei1102
 * Date:     2019/8/9 16:37
 * Description: 应用树节点包装类
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.entity.vo;

import java.util.List;

/**
 * @description 〈layui树节点包装类〉
 * @author zhanglei1102
 * @create 2019/8/9
 * @since 1.0.0
 */
public class LayUiSelectTreeNode {

    private String title;
    private Integer id;
    private boolean checked;
    private boolean spread;
    private List<LayUiSelectTreeNode> children;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<LayUiSelectTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<LayUiSelectTreeNode> children) {
        this.children = children;
    }
}
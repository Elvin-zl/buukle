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
public class LayUiTreeNode {

    private String name;
    private Integer id;
    private boolean spread = false;
    private List<LayUiTreeNode> children;

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

    public boolean isSpread() {
        return spread;
    }

    public void setSpread(boolean spread) {
        this.spread = spread;
    }

    public List<LayUiTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<LayUiTreeNode> children) {
        this.children = children;
    }
}
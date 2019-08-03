/**
 * Copyright (C), 2015-2019  http://www.buukle.top
 * FileName: MenuTreeNode
 * Author:   elvin
 * Date:     2019/8/3 21:57
 * Description: 菜单树节点
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package top.buukle.security.entity.vo;

import top.buukle.security.entity.Menu;

import java.util.List;

/**
 * @description 〈菜单树节点〉
 * @author elvin
 * @create 2019/8/3
 * @since 1.0.0
 */
public class MenuTreeNode extends Menu{

    private List<MenuTreeNode> subMenuList;

    public List<MenuTreeNode> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuTreeNode> subMenuList) {
        this.subMenuList = subMenuList;
    }
}
package top.buukle.consumer.www.vo;

import java.util.List;

/**
 * @Author elvin
 * @Date Created by elvin on 2018/12/22.
 * @Description : 文章分类树形数据结构vo
 */
public class ArticleCatTreeNodeVo {

    private Integer id;
    private Integer pid;
    private String name;
    private String alias;
    private List<ArticleCatTreeNodeVo> children;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public List<ArticleCatTreeNodeVo> getChildren() {
        return children;
    }

    public void setChildren(List<ArticleCatTreeNodeVo> children) {
        this.children = children;
    }

}

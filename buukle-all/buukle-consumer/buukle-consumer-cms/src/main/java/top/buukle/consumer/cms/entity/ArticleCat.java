package top.buukle.consumer.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https://github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class ArticleCat implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private Integer id;

    /**
     * 上级分类id
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private Long pid;

    /**
     * 用户代码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String user_id;

    /**
     * 业务员编码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String salesman_id;

    /**
     * 组别编码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String group_id;

    /**
     * 代理编码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String agent_id;

    /**
     * 平台编码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String platform_id;

    /**
     * 分类名
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String article_cat;

    /**
     * 描述
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String description;

    /**
     * 创建者(用户名)
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String creator;

    /**
     * 创建者代码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String creator_code;

    /**
     * 创建时间
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private Date gmt_created;

    /**
     * 修改者(用户名)
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String modifier;

    /**
     * 修改者代码
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String modifier_code;

    /**
     * 更新时间
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private Date gmt_modified;

    /**
     * 状态
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private Integer status;

    /**
     * 备用
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String bak01;

    /**
     * 备用
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String bak02;

    /**
     * 备用
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String bak03;

    /**
     * 备用
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String bak04;

    /**
     * 备用
     *
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private String bak05;

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..article_cat.id
     *
     * @return the value of buukle-cms..article_cat.id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.id
     *
     * @param id the value for buukle-cms..article_cat.id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.pid
     *
     * @return the value of buukle-cms..article_cat.pid
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public Long getPid() {
        return pid;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withPid(Long pid) {
        this.setPid(pid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.pid
     *
     * @param pid the value for buukle-cms..article_cat.pid
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.user_id
     *
     * @return the value of buukle-cms..article_cat.user_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getUser_id() {
        return user_id;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withUser_id(String user_id) {
        this.setUser_id(user_id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.user_id
     *
     * @param user_id the value for buukle-cms..article_cat.user_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.salesman_id
     *
     * @return the value of buukle-cms..article_cat.salesman_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getSalesman_id() {
        return salesman_id;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withSalesman_id(String salesman_id) {
        this.setSalesman_id(salesman_id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.salesman_id
     *
     * @param salesman_id the value for buukle-cms..article_cat.salesman_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setSalesman_id(String salesman_id) {
        this.salesman_id = salesman_id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.group_id
     *
     * @return the value of buukle-cms..article_cat.group_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getGroup_id() {
        return group_id;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withGroup_id(String group_id) {
        this.setGroup_id(group_id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.group_id
     *
     * @param group_id the value for buukle-cms..article_cat.group_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.agent_id
     *
     * @return the value of buukle-cms..article_cat.agent_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getAgent_id() {
        return agent_id;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withAgent_id(String agent_id) {
        this.setAgent_id(agent_id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.agent_id
     *
     * @param agent_id the value for buukle-cms..article_cat.agent_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setAgent_id(String agent_id) {
        this.agent_id = agent_id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.platform_id
     *
     * @return the value of buukle-cms..article_cat.platform_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getPlatform_id() {
        return platform_id;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withPlatform_id(String platform_id) {
        this.setPlatform_id(platform_id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.platform_id
     *
     * @param platform_id the value for buukle-cms..article_cat.platform_id
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setPlatform_id(String platform_id) {
        this.platform_id = platform_id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.article_cat
     *
     * @return the value of buukle-cms..article_cat.article_cat
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getArticle_cat() {
        return article_cat;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withArticle_cat(String article_cat) {
        this.setArticle_cat(article_cat);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.article_cat
     *
     * @param article_cat the value for buukle-cms..article_cat.article_cat
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setArticle_cat(String article_cat) {
        this.article_cat = article_cat;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.description
     *
     * @return the value of buukle-cms..article_cat.description
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.description
     *
     * @param description the value for buukle-cms..article_cat.description
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.creator
     *
     * @return the value of buukle-cms..article_cat.creator
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.creator
     *
     * @param creator the value for buukle-cms..article_cat.creator
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.creator_code
     *
     * @return the value of buukle-cms..article_cat.creator_code
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getCreator_code() {
        return creator_code;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withCreator_code(String creator_code) {
        this.setCreator_code(creator_code);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.creator_code
     *
     * @param creator_code the value for buukle-cms..article_cat.creator_code
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setCreator_code(String creator_code) {
        this.creator_code = creator_code;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.gmt_created
     *
     * @return the value of buukle-cms..article_cat.gmt_created
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public Date getGmt_created() {
        return gmt_created;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withGmt_created(Date gmt_created) {
        this.setGmt_created(gmt_created);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.gmt_created
     *
     * @param gmt_created the value for buukle-cms..article_cat.gmt_created
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setGmt_created(Date gmt_created) {
        this.gmt_created = gmt_created;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.modifier
     *
     * @return the value of buukle-cms..article_cat.modifier
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.modifier
     *
     * @param modifier the value for buukle-cms..article_cat.modifier
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.modifier_code
     *
     * @return the value of buukle-cms..article_cat.modifier_code
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getModifier_code() {
        return modifier_code;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withModifier_code(String modifier_code) {
        this.setModifier_code(modifier_code);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.modifier_code
     *
     * @param modifier_code the value for buukle-cms..article_cat.modifier_code
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setModifier_code(String modifier_code) {
        this.modifier_code = modifier_code;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.gmt_modified
     *
     * @return the value of buukle-cms..article_cat.gmt_modified
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public Date getGmt_modified() {
        return gmt_modified;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withGmt_modified(Date gmt_modified) {
        this.setGmt_modified(gmt_modified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.gmt_modified
     *
     * @param gmt_modified the value for buukle-cms..article_cat.gmt_modified
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.status
     *
     * @return the value of buukle-cms..article_cat.status
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.status
     *
     * @param status the value for buukle-cms..article_cat.status
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak01
     *
     * @return the value of buukle-cms..article_cat.bak01
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak01
     *
     * @param bak01 the value for buukle-cms..article_cat.bak01
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak02
     *
     * @return the value of buukle-cms..article_cat.bak02
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak02
     *
     * @param bak02 the value for buukle-cms..article_cat.bak02
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak03
     *
     * @return the value of buukle-cms..article_cat.bak03
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak03
     *
     * @param bak03 the value for buukle-cms..article_cat.bak03
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak04
     *
     * @return the value of buukle-cms..article_cat.bak04
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak04
     *
     * @param bak04 the value for buukle-cms..article_cat.bak04
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak05
     *
     * @return the value of buukle-cms..article_cat.bak05
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public ArticleCat withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak05
     *
     * @param bak05 the value for buukle-cms..article_cat.bak05
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05;
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", user_id=").append(user_id);
        sb.append(", salesman_id=").append(salesman_id);
        sb.append(", group_id=").append(group_id);
        sb.append(", agent_id=").append(agent_id);
        sb.append(", platform_id=").append(platform_id);
        sb.append(", article_cat=").append(article_cat);
        sb.append(", description=").append(description);
        sb.append(", creator=").append(creator);
        sb.append(", creator_code=").append(creator_code);
        sb.append(", gmt_created=").append(gmt_created);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifier_code=").append(modifier_code);
        sb.append(", gmt_modified=").append(gmt_modified);
        sb.append(", status=").append(status);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ArticleCat other = (ArticleCat) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getUser_id() == null ? other.getUser_id() == null : this.getUser_id().equals(other.getUser_id()))
            && (this.getSalesman_id() == null ? other.getSalesman_id() == null : this.getSalesman_id().equals(other.getSalesman_id()))
            && (this.getGroup_id() == null ? other.getGroup_id() == null : this.getGroup_id().equals(other.getGroup_id()))
            && (this.getAgent_id() == null ? other.getAgent_id() == null : this.getAgent_id().equals(other.getAgent_id()))
            && (this.getPlatform_id() == null ? other.getPlatform_id() == null : this.getPlatform_id().equals(other.getPlatform_id()))
            && (this.getArticle_cat() == null ? other.getArticle_cat() == null : this.getArticle_cat().equals(other.getArticle_cat()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreator_code() == null ? other.getCreator_code() == null : this.getCreator_code().equals(other.getCreator_code()))
            && (this.getGmt_created() == null ? other.getGmt_created() == null : this.getGmt_created().equals(other.getGmt_created()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifier_code() == null ? other.getModifier_code() == null : this.getModifier_code().equals(other.getModifier_code()))
            && (this.getGmt_modified() == null ? other.getGmt_modified() == null : this.getGmt_modified().equals(other.getGmt_modified()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()));
    }

    /**
     *
     * @mbg.generated Sun Dec 16 23:58:42 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getUser_id() == null) ? 0 : getUser_id().hashCode());
        result = prime * result + ((getSalesman_id() == null) ? 0 : getSalesman_id().hashCode());
        result = prime * result + ((getGroup_id() == null) ? 0 : getGroup_id().hashCode());
        result = prime * result + ((getAgent_id() == null) ? 0 : getAgent_id().hashCode());
        result = prime * result + ((getPlatform_id() == null) ? 0 : getPlatform_id().hashCode());
        result = prime * result + ((getArticle_cat() == null) ? 0 : getArticle_cat().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreator_code() == null) ? 0 : getCreator_code().hashCode());
        result = prime * result + ((getGmt_created() == null) ? 0 : getGmt_created().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifier_code() == null) ? 0 : getModifier_code().hashCode());
        result = prime * result + ((getGmt_modified() == null) ? 0 : getGmt_modified().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        return result;
    }
}
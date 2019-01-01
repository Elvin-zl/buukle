package top.buukle.consumer.portal.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class ArticleCat implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 上级分类id
     *
     */
    private Long pid;

    /**
     * 用户代码
     *
     */
    private String userId;

    /**
     * 业务员编码
     *
     */
    private String salesmanId;

    /**
     * 组别编码
     *
     */
    private String groupId;

    /**
     * 代理编码
     *
     */
    private String agentId;

    /**
     * 平台编码
     *
     */
    private String platformId;

    /**
     * 分类名
     *
     */
    private String articleCat;

    /**
     * 描述
     *
     */
    private String description;

    /**
     * 创建者(用户名)
     *
     */
    private String creator;

    /**
     * 创建者代码
     *
     */
    private String creatorCode;

    /**
     * 创建时间
     *
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     *
     */
    private String modifier;

    /**
     * 修改者代码
     *
     */
    private String modifierCode;

    /**
     * 更新时间
     *
     */
    private Date gmtModified;

    /**
     * 状态
     *
     */
    private Integer status;

    /**
     * 备注
     *
     */
    private String remark;

    /**
     * 备用
     *
     */
    private String bak01;

    /**
     * 备用
     *
     */
    private String bak02;

    /**
     * 备用
     *
     */
    private String bak03;

    /**
     * 备用
     *
     */
    private String bak04;

    /**
     * 备用
     *
     */
    private String bak05;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..article_cat.id
     *
     * @return the value of buukle-cms..article_cat.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public ArticleCat withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.id
     *
     * @param id the value for buukle-cms..article_cat.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.pid
     *
     * @return the value of buukle-cms..article_cat.pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     */
    public ArticleCat withPid(Long pid) {
        this.setPid(pid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.pid
     *
     * @param pid the value for buukle-cms..article_cat.pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.user_id
     *
     * @return the value of buukle-cms..article_cat.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public ArticleCat withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.user_id
     *
     * @param userId the value for buukle-cms..article_cat.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.salesman_id
     *
     * @return the value of buukle-cms..article_cat.salesman_id
     */
    public String getSalesmanId() {
        return salesmanId;
    }

    /**
     */
    public ArticleCat withSalesmanId(String salesmanId) {
        this.setSalesmanId(salesmanId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.salesman_id
     *
     * @param salesmanId the value for buukle-cms..article_cat.salesman_id
     */
    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId == null ? null : salesmanId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.group_id
     *
     * @return the value of buukle-cms..article_cat.group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     */
    public ArticleCat withGroupId(String groupId) {
        this.setGroupId(groupId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.group_id
     *
     * @param groupId the value for buukle-cms..article_cat.group_id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.agent_id
     *
     * @return the value of buukle-cms..article_cat.agent_id
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     */
    public ArticleCat withAgentId(String agentId) {
        this.setAgentId(agentId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.agent_id
     *
     * @param agentId the value for buukle-cms..article_cat.agent_id
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.platform_id
     *
     * @return the value of buukle-cms..article_cat.platform_id
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     */
    public ArticleCat withPlatformId(String platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.platform_id
     *
     * @param platformId the value for buukle-cms..article_cat.platform_id
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.article_cat
     *
     * @return the value of buukle-cms..article_cat.article_cat
     */
    public String getArticleCat() {
        return articleCat;
    }

    /**
     */
    public ArticleCat withArticleCat(String articleCat) {
        this.setArticleCat(articleCat);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.article_cat
     *
     * @param articleCat the value for buukle-cms..article_cat.article_cat
     */
    public void setArticleCat(String articleCat) {
        this.articleCat = articleCat == null ? null : articleCat.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.description
     *
     * @return the value of buukle-cms..article_cat.description
     */
    public String getDescription() {
        return description;
    }

    /**
     */
    public ArticleCat withDescription(String description) {
        this.setDescription(description);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.description
     *
     * @param description the value for buukle-cms..article_cat.description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.creator
     *
     * @return the value of buukle-cms..article_cat.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public ArticleCat withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.creator
     *
     * @param creator the value for buukle-cms..article_cat.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.creator_code
     *
     * @return the value of buukle-cms..article_cat.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public ArticleCat withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.creator_code
     *
     * @param creatorCode the value for buukle-cms..article_cat.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.gmt_created
     *
     * @return the value of buukle-cms..article_cat.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public ArticleCat withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..article_cat.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.modifier
     *
     * @return the value of buukle-cms..article_cat.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public ArticleCat withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.modifier
     *
     * @param modifier the value for buukle-cms..article_cat.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.modifier_code
     *
     * @return the value of buukle-cms..article_cat.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public ArticleCat withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.modifier_code
     *
     * @param modifierCode the value for buukle-cms..article_cat.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.gmt_modified
     *
     * @return the value of buukle-cms..article_cat.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public ArticleCat withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..article_cat.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.status
     *
     * @return the value of buukle-cms..article_cat.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public ArticleCat withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.status
     *
     * @param status the value for buukle-cms..article_cat.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.remark
     *
     * @return the value of buukle-cms..article_cat.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public ArticleCat withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.remark
     *
     * @param remark the value for buukle-cms..article_cat.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak01
     *
     * @return the value of buukle-cms..article_cat.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public ArticleCat withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak01
     *
     * @param bak01 the value for buukle-cms..article_cat.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak02
     *
     * @return the value of buukle-cms..article_cat.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public ArticleCat withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak02
     *
     * @param bak02 the value for buukle-cms..article_cat.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak03
     *
     * @return the value of buukle-cms..article_cat.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public ArticleCat withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak03
     *
     * @param bak03 the value for buukle-cms..article_cat.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak04
     *
     * @return the value of buukle-cms..article_cat.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public ArticleCat withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak04
     *
     * @param bak04 the value for buukle-cms..article_cat.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_cat.bak05
     *
     * @return the value of buukle-cms..article_cat.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public ArticleCat withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_cat.bak05
     *
     * @param bak05 the value for buukle-cms..article_cat.bak05
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", userId=").append(userId);
        sb.append(", salesmanId=").append(salesmanId);
        sb.append(", groupId=").append(groupId);
        sb.append(", agentId=").append(agentId);
        sb.append(", platformId=").append(platformId);
        sb.append(", articleCat=").append(articleCat);
        sb.append(", description=").append(description);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append("]");
        return sb.toString();
    }

    /**
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
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSalesmanId() == null ? other.getSalesmanId() == null : this.getSalesmanId().equals(other.getSalesmanId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getArticleCat() == null ? other.getArticleCat() == null : this.getArticleCat().equals(other.getArticleCat()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSalesmanId() == null) ? 0 : getSalesmanId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getArticleCat() == null) ? 0 : getArticleCat().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        return result;
    }
}
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
public class ArticleInfo implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private Integer id;

    /**
     * 题目
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String title;

    /**
     * 赞数
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private Long likeNumber;

    /**
     * 作者
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String ariticleAuthor;

    /**
     * 作者id
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String userId;

    /**
     * 业务员编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String salesmanId;

    /**
     * 组别编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String groupId;

    /**
     * 代理编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String agentId;

    /**
     * 平台编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String platformId;

    /**
     * 创建者(用户名)
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String creator;

    /**
     * 创建者代码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String creatorCode;

    /**
     * 创建时间
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String modifier;

    /**
     * 修改者代码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String modifierCode;

    /**
     * 更新时间
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private Date gmtModified;

    /**
     * 状态
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private Integer status;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String bak01;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String bak02;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String bak03;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String bak04;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String bak05;

    /**
     * 图片地址
     *
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private String images;

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..article_info.id
     *
     * @return the value of buukle-cms..article_info.id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.id
     *
     * @param id the value for buukle-cms..article_info.id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.title
     *
     * @return the value of buukle-cms..article_info.title
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withTitle(String title) {
        this.setTitle(title);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.title
     *
     * @param title the value for buukle-cms..article_info.title
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.like_number
     *
     * @return the value of buukle-cms..article_info.like_number
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public Long getLikeNumber() {
        return likeNumber;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withLikeNumber(Long likeNumber) {
        this.setLikeNumber(likeNumber);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.like_number
     *
     * @param likeNumber the value for buukle-cms..article_info.like_number
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setLikeNumber(Long likeNumber) {
        this.likeNumber = likeNumber;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.ariticle_author
     *
     * @return the value of buukle-cms..article_info.ariticle_author
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getAriticleAuthor() {
        return ariticleAuthor;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withAriticleAuthor(String ariticleAuthor) {
        this.setAriticleAuthor(ariticleAuthor);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.ariticle_author
     *
     * @param ariticleAuthor the value for buukle-cms..article_info.ariticle_author
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setAriticleAuthor(String ariticleAuthor) {
        this.ariticleAuthor = ariticleAuthor;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.user_id
     *
     * @return the value of buukle-cms..article_info.user_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.user_id
     *
     * @param userId the value for buukle-cms..article_info.user_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.salesman_id
     *
     * @return the value of buukle-cms..article_info.salesman_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getSalesmanId() {
        return salesmanId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withSalesmanId(String salesmanId) {
        this.setSalesmanId(salesmanId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.salesman_id
     *
     * @param salesmanId the value for buukle-cms..article_info.salesman_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.group_id
     *
     * @return the value of buukle-cms..article_info.group_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withGroupId(String groupId) {
        this.setGroupId(groupId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.group_id
     *
     * @param groupId the value for buukle-cms..article_info.group_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.agent_id
     *
     * @return the value of buukle-cms..article_info.agent_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withAgentId(String agentId) {
        this.setAgentId(agentId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.agent_id
     *
     * @param agentId the value for buukle-cms..article_info.agent_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.platform_id
     *
     * @return the value of buukle-cms..article_info.platform_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withPlatformId(String platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.platform_id
     *
     * @param platformId the value for buukle-cms..article_info.platform_id
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.creator
     *
     * @return the value of buukle-cms..article_info.creator
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.creator
     *
     * @param creator the value for buukle-cms..article_info.creator
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.creator_code
     *
     * @return the value of buukle-cms..article_info.creator_code
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.creator_code
     *
     * @param creatorCode the value for buukle-cms..article_info.creator_code
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.gmt_created
     *
     * @return the value of buukle-cms..article_info.gmt_created
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..article_info.gmt_created
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.modifier
     *
     * @return the value of buukle-cms..article_info.modifier
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.modifier
     *
     * @param modifier the value for buukle-cms..article_info.modifier
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.modifier_code
     *
     * @return the value of buukle-cms..article_info.modifier_code
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.modifier_code
     *
     * @param modifierCode the value for buukle-cms..article_info.modifier_code
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.gmt_modified
     *
     * @return the value of buukle-cms..article_info.gmt_modified
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..article_info.gmt_modified
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.status
     *
     * @return the value of buukle-cms..article_info.status
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.status
     *
     * @param status the value for buukle-cms..article_info.status
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.bak01
     *
     * @return the value of buukle-cms..article_info.bak01
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.bak01
     *
     * @param bak01 the value for buukle-cms..article_info.bak01
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.bak02
     *
     * @return the value of buukle-cms..article_info.bak02
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.bak02
     *
     * @param bak02 the value for buukle-cms..article_info.bak02
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.bak03
     *
     * @return the value of buukle-cms..article_info.bak03
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.bak03
     *
     * @param bak03 the value for buukle-cms..article_info.bak03
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.bak04
     *
     * @return the value of buukle-cms..article_info.bak04
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.bak04
     *
     * @param bak04 the value for buukle-cms..article_info.bak04
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.bak05
     *
     * @return the value of buukle-cms..article_info.bak05
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.bak05
     *
     * @param bak05 the value for buukle-cms..article_info.bak05
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_info.images
     *
     * @return the value of buukle-cms..article_info.images
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public String getImages() {
        return images;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public ArticleInfo withImages(String images) {
        this.setImages(images);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_info.images
     *
     * @param images the value for buukle-cms..article_info.images
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", likeNumber=").append(likeNumber);
        sb.append(", ariticleAuthor=").append(ariticleAuthor);
        sb.append(", userId=").append(userId);
        sb.append(", salesmanId=").append(salesmanId);
        sb.append(", groupId=").append(groupId);
        sb.append(", agentId=").append(agentId);
        sb.append(", platformId=").append(platformId);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", status=").append(status);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append(", images=").append(images);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
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
        ArticleInfo other = (ArticleInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTitle() == null ? other.getTitle() == null : this.getTitle().equals(other.getTitle()))
            && (this.getLikeNumber() == null ? other.getLikeNumber() == null : this.getLikeNumber().equals(other.getLikeNumber()))
            && (this.getAriticleAuthor() == null ? other.getAriticleAuthor() == null : this.getAriticleAuthor().equals(other.getAriticleAuthor()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSalesmanId() == null ? other.getSalesmanId() == null : this.getSalesmanId().equals(other.getSalesmanId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()))
            && (this.getImages() == null ? other.getImages() == null : this.getImages().equals(other.getImages()));
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:10 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTitle() == null) ? 0 : getTitle().hashCode());
        result = prime * result + ((getLikeNumber() == null) ? 0 : getLikeNumber().hashCode());
        result = prime * result + ((getAriticleAuthor() == null) ? 0 : getAriticleAuthor().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSalesmanId() == null) ? 0 : getSalesmanId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        result = prime * result + ((getImages() == null) ? 0 : getImages().hashCode());
        return result;
    }
}
package top.buukle.consumer.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class ArticleContent implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 文章主表id
     *
     */
    private Integer articleInfoId;

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
     *
     */
    private Integer status;

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
     * 文章内容
     *
     */
    private String articleContent;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..article_content.id
     *
     * @return the value of buukle-cms..article_content.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public ArticleContent withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.id
     *
     * @param id the value for buukle-cms..article_content.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.article_info_id
     *
     * @return the value of buukle-cms..article_content.article_info_id
     */
    public Integer getArticleInfoId() {
        return articleInfoId;
    }

    /**
     */
    public ArticleContent withArticleInfoId(Integer articleInfoId) {
        this.setArticleInfoId(articleInfoId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.article_info_id
     *
     * @param articleInfoId the value for buukle-cms..article_content.article_info_id
     */
    public void setArticleInfoId(Integer articleInfoId) {
        this.articleInfoId = articleInfoId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.creator
     *
     * @return the value of buukle-cms..article_content.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public ArticleContent withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.creator
     *
     * @param creator the value for buukle-cms..article_content.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.creator_code
     *
     * @return the value of buukle-cms..article_content.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public ArticleContent withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.creator_code
     *
     * @param creatorCode the value for buukle-cms..article_content.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.gmt_created
     *
     * @return the value of buukle-cms..article_content.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public ArticleContent withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..article_content.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.modifier
     *
     * @return the value of buukle-cms..article_content.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public ArticleContent withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.modifier
     *
     * @param modifier the value for buukle-cms..article_content.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.modifier_code
     *
     * @return the value of buukle-cms..article_content.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public ArticleContent withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.modifier_code
     *
     * @param modifierCode the value for buukle-cms..article_content.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.gmt_modified
     *
     * @return the value of buukle-cms..article_content.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public ArticleContent withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..article_content.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.status
     *
     * @return the value of buukle-cms..article_content.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public ArticleContent withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.status
     *
     * @param status the value for buukle-cms..article_content.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.bak01
     *
     * @return the value of buukle-cms..article_content.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public ArticleContent withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.bak01
     *
     * @param bak01 the value for buukle-cms..article_content.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.bak02
     *
     * @return the value of buukle-cms..article_content.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public ArticleContent withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.bak02
     *
     * @param bak02 the value for buukle-cms..article_content.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.bak03
     *
     * @return the value of buukle-cms..article_content.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public ArticleContent withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.bak03
     *
     * @param bak03 the value for buukle-cms..article_content.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.bak04
     *
     * @return the value of buukle-cms..article_content.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public ArticleContent withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.bak04
     *
     * @param bak04 the value for buukle-cms..article_content.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.bak05
     *
     * @return the value of buukle-cms..article_content.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public ArticleContent withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.bak05
     *
     * @param bak05 the value for buukle-cms..article_content.bak05
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_content.article_content
     *
     * @return the value of buukle-cms..article_content.article_content
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     */
    public ArticleContent withArticleContent(String articleContent) {
        this.setArticleContent(articleContent);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_content.article_content
     *
     * @param articleContent the value for buukle-cms..article_content.article_content
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent == null ? null : articleContent.trim();
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
        sb.append(", articleInfoId=").append(articleInfoId);
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
        sb.append(", articleContent=").append(articleContent);
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
        ArticleContent other = (ArticleContent) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getArticleInfoId() == null ? other.getArticleInfoId() == null : this.getArticleInfoId().equals(other.getArticleInfoId()))
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
            && (this.getArticleContent() == null ? other.getArticleContent() == null : this.getArticleContent().equals(other.getArticleContent()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getArticleInfoId() == null) ? 0 : getArticleInfoId().hashCode());
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
        result = prime * result + ((getArticleContent() == null) ? 0 : getArticleContent().hashCode());
        return result;
    }
}
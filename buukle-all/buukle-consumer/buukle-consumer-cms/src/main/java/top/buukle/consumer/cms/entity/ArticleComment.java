package top.buukle.consumer.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class ArticleComment implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 父级id
     *
     */
    private Integer pid;

    /**
     * 父级类型 0 : 评论 ; 1 : 文章
     *
     */
    private Integer pidType;

    /**
     * 文章主表id
     *
     */
    private Integer articleInfoId;

    /**
     * 评论信息
     *
     */
    private String comment;

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
     * This method returns the value of the database column buukle-cms..article_comment.id
     *
     * @return the value of buukle-cms..article_comment.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public ArticleComment withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.id
     *
     * @param id the value for buukle-cms..article_comment.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.pid
     *
     * @return the value of buukle-cms..article_comment.pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     */
    public ArticleComment withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.pid
     *
     * @param pid the value for buukle-cms..article_comment.pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.pid_type
     *
     * @return the value of buukle-cms..article_comment.pid_type
     */
    public Integer getPidType() {
        return pidType;
    }

    /**
     */
    public ArticleComment withPidType(Integer pidType) {
        this.setPidType(pidType);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.pid_type
     *
     * @param pidType the value for buukle-cms..article_comment.pid_type
     */
    public void setPidType(Integer pidType) {
        this.pidType = pidType;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.article_info_id
     *
     * @return the value of buukle-cms..article_comment.article_info_id
     */
    public Integer getArticleInfoId() {
        return articleInfoId;
    }

    /**
     */
    public ArticleComment withArticleInfoId(Integer articleInfoId) {
        this.setArticleInfoId(articleInfoId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.article_info_id
     *
     * @param articleInfoId the value for buukle-cms..article_comment.article_info_id
     */
    public void setArticleInfoId(Integer articleInfoId) {
        this.articleInfoId = articleInfoId;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.comment
     *
     * @return the value of buukle-cms..article_comment.comment
     */
    public String getComment() {
        return comment;
    }

    /**
     */
    public ArticleComment withComment(String comment) {
        this.setComment(comment);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.comment
     *
     * @param comment the value for buukle-cms..article_comment.comment
     */
    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.creator
     *
     * @return the value of buukle-cms..article_comment.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public ArticleComment withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.creator
     *
     * @param creator the value for buukle-cms..article_comment.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.creator_code
     *
     * @return the value of buukle-cms..article_comment.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public ArticleComment withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.creator_code
     *
     * @param creatorCode the value for buukle-cms..article_comment.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.gmt_created
     *
     * @return the value of buukle-cms..article_comment.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public ArticleComment withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..article_comment.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.modifier
     *
     * @return the value of buukle-cms..article_comment.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public ArticleComment withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.modifier
     *
     * @param modifier the value for buukle-cms..article_comment.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.modifier_code
     *
     * @return the value of buukle-cms..article_comment.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public ArticleComment withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.modifier_code
     *
     * @param modifierCode the value for buukle-cms..article_comment.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.gmt_modified
     *
     * @return the value of buukle-cms..article_comment.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public ArticleComment withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..article_comment.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.status
     *
     * @return the value of buukle-cms..article_comment.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public ArticleComment withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.status
     *
     * @param status the value for buukle-cms..article_comment.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.remark
     *
     * @return the value of buukle-cms..article_comment.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public ArticleComment withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.remark
     *
     * @param remark the value for buukle-cms..article_comment.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.bak01
     *
     * @return the value of buukle-cms..article_comment.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public ArticleComment withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.bak01
     *
     * @param bak01 the value for buukle-cms..article_comment.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.bak02
     *
     * @return the value of buukle-cms..article_comment.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public ArticleComment withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.bak02
     *
     * @param bak02 the value for buukle-cms..article_comment.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.bak03
     *
     * @return the value of buukle-cms..article_comment.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public ArticleComment withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.bak03
     *
     * @param bak03 the value for buukle-cms..article_comment.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.bak04
     *
     * @return the value of buukle-cms..article_comment.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public ArticleComment withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.bak04
     *
     * @param bak04 the value for buukle-cms..article_comment.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..article_comment.bak05
     *
     * @return the value of buukle-cms..article_comment.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public ArticleComment withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..article_comment.bak05
     *
     * @param bak05 the value for buukle-cms..article_comment.bak05
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
        sb.append(", pidType=").append(pidType);
        sb.append(", articleInfoId=").append(articleInfoId);
        sb.append(", comment=").append(comment);
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
        ArticleComment other = (ArticleComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPidType() == null ? other.getPidType() == null : this.getPidType().equals(other.getPidType()))
            && (this.getArticleInfoId() == null ? other.getArticleInfoId() == null : this.getArticleInfoId().equals(other.getArticleInfoId()))
            && (this.getComment() == null ? other.getComment() == null : this.getComment().equals(other.getComment()))
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
        result = prime * result + ((getPidType() == null) ? 0 : getPidType().hashCode());
        result = prime * result + ((getArticleInfoId() == null) ? 0 : getArticleInfoId().hashCode());
        result = prime * result + ((getComment() == null) ? 0 : getComment().hashCode());
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
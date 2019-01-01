package top.buukle.consumer.portal.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 用户与文章点赞关系表
 * @author 
 */
public class UserArticlePraiseRelation implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 用户id
     *
     */
    private String userId;

    /**
     * 作者id
     *
     */
    private Integer articleId;

    /**
     * 创建时间
     *
     */
    private Date gmtCreated;

    /**
     * 状态
     *
     */
    private Integer status;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..user_article_praise_relation.id
     *
     * @return the value of buukle-cms..user_article_praise_relation.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public UserArticlePraiseRelation withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_article_praise_relation.id
     *
     * @param id the value for buukle-cms..user_article_praise_relation.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_article_praise_relation.user_id
     *
     * @return the value of buukle-cms..user_article_praise_relation.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public UserArticlePraiseRelation withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_article_praise_relation.user_id
     *
     * @param userId the value for buukle-cms..user_article_praise_relation.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_article_praise_relation.article_id
     *
     * @return the value of buukle-cms..user_article_praise_relation.article_id
     */
    public Integer getArticleId() {
        return articleId;
    }

    /**
     */
    public UserArticlePraiseRelation withArticleId(Integer articleId) {
        this.setArticleId(articleId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_article_praise_relation.article_id
     *
     * @param articleId the value for buukle-cms..user_article_praise_relation.article_id
     */
    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_article_praise_relation.gmt_created
     *
     * @return the value of buukle-cms..user_article_praise_relation.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public UserArticlePraiseRelation withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_article_praise_relation.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..user_article_praise_relation.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_article_praise_relation.status
     *
     * @return the value of buukle-cms..user_article_praise_relation.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public UserArticlePraiseRelation withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_article_praise_relation.status
     *
     * @param status the value for buukle-cms..user_article_praise_relation.status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
        sb.append(", userId=").append(userId);
        sb.append(", articleId=").append(articleId);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", status=").append(status);
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
        UserArticlePraiseRelation other = (UserArticlePraiseRelation) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getArticleId() == null ? other.getArticleId() == null : this.getArticleId().equals(other.getArticleId()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getArticleId() == null) ? 0 : getArticleId().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
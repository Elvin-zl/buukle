package top.buukle.consumer.cms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 用户粉丝表
 * @author 
 */
public class UserFans implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 用户代码 : 生成规则待定,全局唯一
     *
     */
    private String userId;

    /**
     * 粉丝用户id
     *
     */
    private String userFansId;

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
     * 状态 0:新粉丝 1粉丝 -1已删除粉丝
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
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..user_fans.id
     *
     * @return the value of buukle-cms..user_fans.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public UserFans withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.id
     *
     * @param id the value for buukle-cms..user_fans.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.user_id
     *
     * @return the value of buukle-cms..user_fans.user_id
     */
    public String getUserId() {
        return userId;
    }

    /**
     */
    public UserFans withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.user_id
     *
     * @param userId the value for buukle-cms..user_fans.user_id
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.user_fans_id
     *
     * @return the value of buukle-cms..user_fans.user_fans_id
     */
    public String getUserFansId() {
        return userFansId;
    }

    /**
     */
    public UserFans withUserFansId(String userFansId) {
        this.setUserFansId(userFansId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.user_fans_id
     *
     * @param userFansId the value for buukle-cms..user_fans.user_fans_id
     */
    public void setUserFansId(String userFansId) {
        this.userFansId = userFansId == null ? null : userFansId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.creator
     *
     * @return the value of buukle-cms..user_fans.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public UserFans withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.creator
     *
     * @param creator the value for buukle-cms..user_fans.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.creator_code
     *
     * @return the value of buukle-cms..user_fans.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public UserFans withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.creator_code
     *
     * @param creatorCode the value for buukle-cms..user_fans.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.gmt_created
     *
     * @return the value of buukle-cms..user_fans.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public UserFans withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..user_fans.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.modifier
     *
     * @return the value of buukle-cms..user_fans.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public UserFans withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.modifier
     *
     * @param modifier the value for buukle-cms..user_fans.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.modifier_code
     *
     * @return the value of buukle-cms..user_fans.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public UserFans withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.modifier_code
     *
     * @param modifierCode the value for buukle-cms..user_fans.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.gmt_modified
     *
     * @return the value of buukle-cms..user_fans.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public UserFans withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..user_fans.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.status
     *
     * @return the value of buukle-cms..user_fans.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public UserFans withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.status
     *
     * @param status the value for buukle-cms..user_fans.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.bak01
     *
     * @return the value of buukle-cms..user_fans.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public UserFans withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.bak01
     *
     * @param bak01 the value for buukle-cms..user_fans.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.bak02
     *
     * @return the value of buukle-cms..user_fans.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public UserFans withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.bak02
     *
     * @param bak02 the value for buukle-cms..user_fans.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.bak03
     *
     * @return the value of buukle-cms..user_fans.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public UserFans withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.bak03
     *
     * @param bak03 the value for buukle-cms..user_fans.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.bak04
     *
     * @return the value of buukle-cms..user_fans.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public UserFans withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.bak04
     *
     * @param bak04 the value for buukle-cms..user_fans.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_fans.bak05
     *
     * @return the value of buukle-cms..user_fans.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public UserFans withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_fans.bak05
     *
     * @param bak05 the value for buukle-cms..user_fans.bak05
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
        sb.append(", userId=").append(userId);
        sb.append(", userFansId=").append(userFansId);
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
        UserFans other = (UserFans) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getUserFansId() == null ? other.getUserFansId() == null : this.getUserFansId().equals(other.getUserFansId()))
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
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getUserFansId() == null) ? 0 : getUserFansId().hashCode());
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
        return result;
    }
}
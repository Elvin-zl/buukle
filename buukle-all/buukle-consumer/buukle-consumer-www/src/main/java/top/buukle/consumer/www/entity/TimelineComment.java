package top.buukle.consumer.www.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class TimelineComment implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Integer id;

    /**
     * 父级id
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Integer pid;

    /**
     * 父级类型 0 : 评论 ; 1 : 文章
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Integer pidType;

    /**
     * 信息流主表id
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Integer timelineInfoId;

    /**
     * 评论信息
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String comment;

    /**
     * 创建者(用户名)
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String creator;

    /**
     * 创建者代码
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String creatorCode;

    /**
     * 创建时间
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String modifier;

    /**
     * 修改者代码
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String modifierCode;

    /**
     * 更新时间
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private Integer status;

    /**
     * 备注
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String remark;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String bak01;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String bak02;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String bak03;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String bak04;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private String bak05;

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.id
     *
     * @return the value of buukle-cms..timeline_comment.id
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.id
     *
     * @param id the value for buukle-cms..timeline_comment.id
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.pid
     *
     * @return the value of buukle-cms..timeline_comment.pid
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withPid(Integer pid) {
        this.setPid(pid);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.pid
     *
     * @param pid the value for buukle-cms..timeline_comment.pid
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.pid_type
     *
     * @return the value of buukle-cms..timeline_comment.pid_type
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Integer getPidType() {
        return pidType;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withPidType(Integer pidType) {
        this.setPidType(pidType);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.pid_type
     *
     * @param pidType the value for buukle-cms..timeline_comment.pid_type
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setPidType(Integer pidType) {
        this.pidType = pidType;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.timeline_info_id
     *
     * @return the value of buukle-cms..timeline_comment.timeline_info_id
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Integer getTimelineInfoId() {
        return timelineInfoId;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withTimelineInfoId(Integer timelineInfoId) {
        this.setTimelineInfoId(timelineInfoId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.timeline_info_id
     *
     * @param timelineInfoId the value for buukle-cms..timeline_comment.timeline_info_id
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setTimelineInfoId(Integer timelineInfoId) {
        this.timelineInfoId = timelineInfoId;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.comment
     *
     * @return the value of buukle-cms..timeline_comment.comment
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withComment(String comment) {
        this.setComment(comment);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.comment
     *
     * @param comment the value for buukle-cms..timeline_comment.comment
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.creator
     *
     * @return the value of buukle-cms..timeline_comment.creator
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.creator
     *
     * @param creator the value for buukle-cms..timeline_comment.creator
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.creator_code
     *
     * @return the value of buukle-cms..timeline_comment.creator_code
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.creator_code
     *
     * @param creatorCode the value for buukle-cms..timeline_comment.creator_code
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.gmt_created
     *
     * @return the value of buukle-cms..timeline_comment.gmt_created
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..timeline_comment.gmt_created
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.modifier
     *
     * @return the value of buukle-cms..timeline_comment.modifier
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.modifier
     *
     * @param modifier the value for buukle-cms..timeline_comment.modifier
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.modifier_code
     *
     * @return the value of buukle-cms..timeline_comment.modifier_code
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.modifier_code
     *
     * @param modifierCode the value for buukle-cms..timeline_comment.modifier_code
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.gmt_modified
     *
     * @return the value of buukle-cms..timeline_comment.gmt_modified
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..timeline_comment.gmt_modified
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.status
     *
     * @return the value of buukle-cms..timeline_comment.status
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.status
     *
     * @param status the value for buukle-cms..timeline_comment.status
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.remark
     *
     * @return the value of buukle-cms..timeline_comment.remark
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.remark
     *
     * @param remark the value for buukle-cms..timeline_comment.remark
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.bak01
     *
     * @return the value of buukle-cms..timeline_comment.bak01
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.bak01
     *
     * @param bak01 the value for buukle-cms..timeline_comment.bak01
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.bak02
     *
     * @return the value of buukle-cms..timeline_comment.bak02
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.bak02
     *
     * @param bak02 the value for buukle-cms..timeline_comment.bak02
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.bak03
     *
     * @return the value of buukle-cms..timeline_comment.bak03
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.bak03
     *
     * @param bak03 the value for buukle-cms..timeline_comment.bak03
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.bak04
     *
     * @return the value of buukle-cms..timeline_comment.bak04
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.bak04
     *
     * @param bak04 the value for buukle-cms..timeline_comment.bak04
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_comment.bak05
     *
     * @return the value of buukle-cms..timeline_comment.bak05
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public TimelineComment withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_comment.bak05
     *
     * @param bak05 the value for buukle-cms..timeline_comment.bak05
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
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
        sb.append(", timelineInfoId=").append(timelineInfoId);
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
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
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
        TimelineComment other = (TimelineComment) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPid() == null ? other.getPid() == null : this.getPid().equals(other.getPid()))
            && (this.getPidType() == null ? other.getPidType() == null : this.getPidType().equals(other.getPidType()))
            && (this.getTimelineInfoId() == null ? other.getTimelineInfoId() == null : this.getTimelineInfoId().equals(other.getTimelineInfoId()))
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
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPid() == null) ? 0 : getPid().hashCode());
        result = prime * result + ((getPidType() == null) ? 0 : getPidType().hashCode());
        result = prime * result + ((getTimelineInfoId() == null) ? 0 : getTimelineInfoId().hashCode());
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

    /**
     *
     * @mbg.generated Thu Jul 04 20:18:20 CST 2019
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        pid("pid", "pid", "INTEGER", false),
        pidType("pid_type", "pidType", "INTEGER", false),
        timelineInfoId("timeline_info_id", "timelineInfoId", "INTEGER", false),
        comment("comment", "comment", "VARCHAR", false),
        creator("creator", "creator", "VARCHAR", false),
        creatorCode("creator_code", "creatorCode", "VARCHAR", false),
        gmtCreated("gmt_created", "gmtCreated", "TIMESTAMP", false),
        modifier("modifier", "modifier", "VARCHAR", false),
        modifierCode("modifier_code", "modifierCode", "VARCHAR", false),
        gmtModified("gmt_modified", "gmtModified", "TIMESTAMP", false),
        status("status", "status", "INTEGER", false),
        remark("remark", "remark", "VARCHAR", false),
        bak01("bak01", "bak01", "VARCHAR", false),
        bak02("bak02", "bak02", "VARCHAR", false),
        bak03("bak03", "bak03", "VARCHAR", false),
        bak04("bak04", "bak04", "VARCHAR", false),
        bak05("bak05", "bak05", "VARCHAR", false);

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private final String column;

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private final boolean isColumnNameDelimited;

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private final String javaProperty;

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        private final String jdbcType;

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String value() {
            return this.column;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String getValue() {
            return this.column;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         *
         * @mbg.generated Thu Jul 04 20:18:20 CST 2019
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}
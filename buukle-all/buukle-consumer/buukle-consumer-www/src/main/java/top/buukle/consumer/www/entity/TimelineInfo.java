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
public class TimelineInfo implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Integer id;

    /**
     * 话题
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String topic;

    /**
     * 赞数
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Integer likeNumber;

    /**
     * 浏览量
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Integer scanNumber;

    /**
     * 作者
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String author;

    /**
     * 作者id
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String userId;

    /**
     * 业务员编码
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String salesmanId;

    /**
     * 组别编码
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String groupId;

    /**
     * 代理编码
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String agentId;

    /**
     * 平台编码
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String platformId;

    /**
     * 创建者(用户名)
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String creator;

    /**
     * 创建者代码
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String creatorCode;

    /**
     * 创建时间
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String modifier;

    /**
     * 修改者代码
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String modifierCode;

    /**
     * 更新时间
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Date gmtModified;

    /**
     * 审核者id
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String auditorCode;

    /**
     * 审核者
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String auditor;

    /**
     * 审核时间
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Date gmtAuditor;

    /**
     * 状态:-2假删除 \r\n -1草稿0封禁1发布成功2真删除3发布待审核4解禁待审核5解禁审核不通过6草稿7处理中
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private Integer status;

    /**
     * 备注
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String remark;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String bak01;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String bak02;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String bak03;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String bak04;

    /**
     * 备用
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String bak05;

    /**
     * 内容
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String content;

    /**
     * 图片地址
     *
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private String images;

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.id
     *
     * @return the value of buukle-cms..timeline_info.id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.id
     *
     * @param id the value for buukle-cms..timeline_info.id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.topic
     *
     * @return the value of buukle-cms..timeline_info.topic
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getTopic() {
        return topic;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withTopic(String topic) {
        this.setTopic(topic);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.topic
     *
     * @param topic the value for buukle-cms..timeline_info.topic
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setTopic(String topic) {
        this.topic = topic;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.like_number
     *
     * @return the value of buukle-cms..timeline_info.like_number
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Integer getLikeNumber() {
        return likeNumber;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withLikeNumber(Integer likeNumber) {
        this.setLikeNumber(likeNumber);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.like_number
     *
     * @param likeNumber the value for buukle-cms..timeline_info.like_number
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setLikeNumber(Integer likeNumber) {
        this.likeNumber = likeNumber;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.scan_number
     *
     * @return the value of buukle-cms..timeline_info.scan_number
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Integer getScanNumber() {
        return scanNumber;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withScanNumber(Integer scanNumber) {
        this.setScanNumber(scanNumber);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.scan_number
     *
     * @param scanNumber the value for buukle-cms..timeline_info.scan_number
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setScanNumber(Integer scanNumber) {
        this.scanNumber = scanNumber;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.author
     *
     * @return the value of buukle-cms..timeline_info.author
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getAuthor() {
        return author;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withAuthor(String author) {
        this.setAuthor(author);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.author
     *
     * @param author the value for buukle-cms..timeline_info.author
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.user_id
     *
     * @return the value of buukle-cms..timeline_info.user_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.user_id
     *
     * @param userId the value for buukle-cms..timeline_info.user_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.salesman_id
     *
     * @return the value of buukle-cms..timeline_info.salesman_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getSalesmanId() {
        return salesmanId;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withSalesmanId(String salesmanId) {
        this.setSalesmanId(salesmanId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.salesman_id
     *
     * @param salesmanId the value for buukle-cms..timeline_info.salesman_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.group_id
     *
     * @return the value of buukle-cms..timeline_info.group_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withGroupId(String groupId) {
        this.setGroupId(groupId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.group_id
     *
     * @param groupId the value for buukle-cms..timeline_info.group_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.agent_id
     *
     * @return the value of buukle-cms..timeline_info.agent_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withAgentId(String agentId) {
        this.setAgentId(agentId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.agent_id
     *
     * @param agentId the value for buukle-cms..timeline_info.agent_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.platform_id
     *
     * @return the value of buukle-cms..timeline_info.platform_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withPlatformId(String platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.platform_id
     *
     * @param platformId the value for buukle-cms..timeline_info.platform_id
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.creator
     *
     * @return the value of buukle-cms..timeline_info.creator
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.creator
     *
     * @param creator the value for buukle-cms..timeline_info.creator
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.creator_code
     *
     * @return the value of buukle-cms..timeline_info.creator_code
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.creator_code
     *
     * @param creatorCode the value for buukle-cms..timeline_info.creator_code
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.gmt_created
     *
     * @return the value of buukle-cms..timeline_info.gmt_created
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..timeline_info.gmt_created
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.modifier
     *
     * @return the value of buukle-cms..timeline_info.modifier
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.modifier
     *
     * @param modifier the value for buukle-cms..timeline_info.modifier
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.modifier_code
     *
     * @return the value of buukle-cms..timeline_info.modifier_code
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.modifier_code
     *
     * @param modifierCode the value for buukle-cms..timeline_info.modifier_code
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.gmt_modified
     *
     * @return the value of buukle-cms..timeline_info.gmt_modified
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..timeline_info.gmt_modified
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.auditor_code
     *
     * @return the value of buukle-cms..timeline_info.auditor_code
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getAuditorCode() {
        return auditorCode;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withAuditorCode(String auditorCode) {
        this.setAuditorCode(auditorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.auditor_code
     *
     * @param auditorCode the value for buukle-cms..timeline_info.auditor_code
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setAuditorCode(String auditorCode) {
        this.auditorCode = auditorCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.auditor
     *
     * @return the value of buukle-cms..timeline_info.auditor
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getAuditor() {
        return auditor;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withAuditor(String auditor) {
        this.setAuditor(auditor);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.auditor
     *
     * @param auditor the value for buukle-cms..timeline_info.auditor
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.gmt_auditor
     *
     * @return the value of buukle-cms..timeline_info.gmt_auditor
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Date getGmtAuditor() {
        return gmtAuditor;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withGmtAuditor(Date gmtAuditor) {
        this.setGmtAuditor(gmtAuditor);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.gmt_auditor
     *
     * @param gmtAuditor the value for buukle-cms..timeline_info.gmt_auditor
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setGmtAuditor(Date gmtAuditor) {
        this.gmtAuditor = gmtAuditor;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.status
     *
     * @return the value of buukle-cms..timeline_info.status
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.status
     *
     * @param status the value for buukle-cms..timeline_info.status
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.remark
     *
     * @return the value of buukle-cms..timeline_info.remark
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.remark
     *
     * @param remark the value for buukle-cms..timeline_info.remark
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.bak01
     *
     * @return the value of buukle-cms..timeline_info.bak01
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.bak01
     *
     * @param bak01 the value for buukle-cms..timeline_info.bak01
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.bak02
     *
     * @return the value of buukle-cms..timeline_info.bak02
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.bak02
     *
     * @param bak02 the value for buukle-cms..timeline_info.bak02
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.bak03
     *
     * @return the value of buukle-cms..timeline_info.bak03
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.bak03
     *
     * @param bak03 the value for buukle-cms..timeline_info.bak03
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.bak04
     *
     * @return the value of buukle-cms..timeline_info.bak04
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.bak04
     *
     * @param bak04 the value for buukle-cms..timeline_info.bak04
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.bak05
     *
     * @return the value of buukle-cms..timeline_info.bak05
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.bak05
     *
     * @param bak05 the value for buukle-cms..timeline_info.bak05
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.content
     *
     * @return the value of buukle-cms..timeline_info.content
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withContent(String content) {
        this.setContent(content);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.content
     *
     * @param content the value for buukle-cms..timeline_info.content
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method returns the value of the database column buukle-cms..timeline_info.images
     *
     * @return the value of buukle-cms..timeline_info.images
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public String getImages() {
        return images;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public TimelineInfo withImages(String images) {
        this.setImages(images);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..timeline_info.images
     *
     * @param images the value for buukle-cms..timeline_info.images
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public void setImages(String images) {
        this.images = images;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", topic=").append(topic);
        sb.append(", likeNumber=").append(likeNumber);
        sb.append(", scanNumber=").append(scanNumber);
        sb.append(", author=").append(author);
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
        sb.append(", auditorCode=").append(auditorCode);
        sb.append(", auditor=").append(auditor);
        sb.append(", gmtAuditor=").append(gmtAuditor);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", bak01=").append(bak01);
        sb.append(", bak02=").append(bak02);
        sb.append(", bak03=").append(bak03);
        sb.append(", bak04=").append(bak04);
        sb.append(", bak05=").append(bak05);
        sb.append(", content=").append(content);
        sb.append(", images=").append(images);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
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
        TimelineInfo other = (TimelineInfo) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTopic() == null ? other.getTopic() == null : this.getTopic().equals(other.getTopic()))
            && (this.getLikeNumber() == null ? other.getLikeNumber() == null : this.getLikeNumber().equals(other.getLikeNumber()))
            && (this.getScanNumber() == null ? other.getScanNumber() == null : this.getScanNumber().equals(other.getScanNumber()))
            && (this.getAuthor() == null ? other.getAuthor() == null : this.getAuthor().equals(other.getAuthor()))
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
            && (this.getAuditorCode() == null ? other.getAuditorCode() == null : this.getAuditorCode().equals(other.getAuditorCode()))
            && (this.getAuditor() == null ? other.getAuditor() == null : this.getAuditor().equals(other.getAuditor()))
            && (this.getGmtAuditor() == null ? other.getGmtAuditor() == null : this.getGmtAuditor().equals(other.getGmtAuditor()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()))
            && (this.getContent() == null ? other.getContent() == null : this.getContent().equals(other.getContent()))
            && (this.getImages() == null ? other.getImages() == null : this.getImages().equals(other.getImages()));
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTopic() == null) ? 0 : getTopic().hashCode());
        result = prime * result + ((getLikeNumber() == null) ? 0 : getLikeNumber().hashCode());
        result = prime * result + ((getScanNumber() == null) ? 0 : getScanNumber().hashCode());
        result = prime * result + ((getAuthor() == null) ? 0 : getAuthor().hashCode());
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
        result = prime * result + ((getAuditorCode() == null) ? 0 : getAuditorCode().hashCode());
        result = prime * result + ((getAuditor() == null) ? 0 : getAuditor().hashCode());
        result = prime * result + ((getGmtAuditor() == null) ? 0 : getGmtAuditor().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        result = prime * result + ((getContent() == null) ? 0 : getContent().hashCode());
        result = prime * result + ((getImages() == null) ? 0 : getImages().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated Thu Jul 04 15:39:50 CST 2019
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        topic("topic", "topic", "VARCHAR", false),
        likeNumber("like_number", "likeNumber", "INTEGER", false),
        scanNumber("scan_number", "scanNumber", "INTEGER", false),
        author("author", "author", "VARCHAR", false),
        userId("user_id", "userId", "VARCHAR", false),
        salesmanId("salesman_id", "salesmanId", "VARCHAR", false),
        groupId("group_id", "groupId", "VARCHAR", false),
        agentId("agent_id", "agentId", "VARCHAR", false),
        platformId("platform_id", "platformId", "VARCHAR", false),
        creator("creator", "creator", "VARCHAR", false),
        creatorCode("creator_code", "creatorCode", "VARCHAR", false),
        gmtCreated("gmt_created", "gmtCreated", "TIMESTAMP", false),
        modifier("modifier", "modifier", "VARCHAR", false),
        modifierCode("modifier_code", "modifierCode", "VARCHAR", false),
        gmtModified("gmt_modified", "gmtModified", "TIMESTAMP", false),
        auditorCode("auditor_code", "auditorCode", "VARCHAR", false),
        auditor("auditor", "auditor", "VARCHAR", false),
        gmtAuditor("gmt_auditor", "gmtAuditor", "TIMESTAMP", false),
        status("status", "status", "INTEGER", false),
        remark("remark", "remark", "VARCHAR", false),
        bak01("bak01", "bak01", "VARCHAR", false),
        bak02("bak02", "bak02", "VARCHAR", false),
        bak03("bak03", "bak03", "VARCHAR", false),
        bak04("bak04", "bak04", "VARCHAR", false),
        bak05("bak05", "bak05", "VARCHAR", false),
        content("content", "content", "LONGVARCHAR", false),
        images("images", "images", "LONGVARCHAR", false);

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        private static final String BEGINNING_DELIMITER = "\"";

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        private static final String ENDING_DELIMITER = "\"";

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        private final String column;

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        private final boolean isColumnNameDelimited;

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        private final String javaProperty;

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        private final String jdbcType;

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        public String value() {
            return this.column;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        public String getValue() {
            return this.column;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         *
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
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
         * @mbg.generated Thu Jul 04 15:39:50 CST 2019
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
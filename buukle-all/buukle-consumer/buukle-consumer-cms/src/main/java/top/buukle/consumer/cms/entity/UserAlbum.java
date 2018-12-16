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
public class UserAlbum implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private Integer id;

    /**
     * 用户id
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private Integer userId;

    /**
     * 业务员编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String salesmanId;

    /**
     * 组别编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String groupId;

    /**
     * 代理编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String agentId;

    /**
     * 平台编码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String platformId;

    /**
     * 相册名称
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String albumName;

    /**
     * 相册描述
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String albumDesc;

    /**
     * 创建者(用户名)
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String creator;

    /**
     * 创建者代码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String creatorCode;

    /**
     * 创建时间
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String modifier;

    /**
     * 修改者代码
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String modifierCode;

    /**
     * 更新时间
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private Integer status;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String bak01;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String bak02;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String bak03;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String bak04;

    /**
     * 备用
     *
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private String bak05;

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-cms..user_album.id
     *
     * @return the value of buukle-cms..user_album.id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.id
     *
     * @param id the value for buukle-cms..user_album.id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.user_id
     *
     * @return the value of buukle-cms..user_album.user_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withUserId(Integer userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.user_id
     *
     * @param userId the value for buukle-cms..user_album.user_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.salesman_id
     *
     * @return the value of buukle-cms..user_album.salesman_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getSalesmanId() {
        return salesmanId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withSalesmanId(String salesmanId) {
        this.setSalesmanId(salesmanId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.salesman_id
     *
     * @param salesmanId the value for buukle-cms..user_album.salesman_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.group_id
     *
     * @return the value of buukle-cms..user_album.group_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withGroupId(String groupId) {
        this.setGroupId(groupId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.group_id
     *
     * @param groupId the value for buukle-cms..user_album.group_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.agent_id
     *
     * @return the value of buukle-cms..user_album.agent_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withAgentId(String agentId) {
        this.setAgentId(agentId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.agent_id
     *
     * @param agentId the value for buukle-cms..user_album.agent_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.platform_id
     *
     * @return the value of buukle-cms..user_album.platform_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withPlatformId(String platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.platform_id
     *
     * @param platformId the value for buukle-cms..user_album.platform_id
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.album_name
     *
     * @return the value of buukle-cms..user_album.album_name
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withAlbumName(String albumName) {
        this.setAlbumName(albumName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.album_name
     *
     * @param albumName the value for buukle-cms..user_album.album_name
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.album_desc
     *
     * @return the value of buukle-cms..user_album.album_desc
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getAlbumDesc() {
        return albumDesc;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withAlbumDesc(String albumDesc) {
        this.setAlbumDesc(albumDesc);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.album_desc
     *
     * @param albumDesc the value for buukle-cms..user_album.album_desc
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setAlbumDesc(String albumDesc) {
        this.albumDesc = albumDesc;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.creator
     *
     * @return the value of buukle-cms..user_album.creator
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.creator
     *
     * @param creator the value for buukle-cms..user_album.creator
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.creator_code
     *
     * @return the value of buukle-cms..user_album.creator_code
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.creator_code
     *
     * @param creatorCode the value for buukle-cms..user_album.creator_code
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.gmt_created
     *
     * @return the value of buukle-cms..user_album.gmt_created
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..user_album.gmt_created
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.modifier
     *
     * @return the value of buukle-cms..user_album.modifier
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.modifier
     *
     * @param modifier the value for buukle-cms..user_album.modifier
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.modifier_code
     *
     * @return the value of buukle-cms..user_album.modifier_code
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.modifier_code
     *
     * @param modifierCode the value for buukle-cms..user_album.modifier_code
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.gmt_modified
     *
     * @return the value of buukle-cms..user_album.gmt_modified
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..user_album.gmt_modified
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.status
     *
     * @return the value of buukle-cms..user_album.status
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.status
     *
     * @param status the value for buukle-cms..user_album.status
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak01
     *
     * @return the value of buukle-cms..user_album.bak01
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak01
     *
     * @param bak01 the value for buukle-cms..user_album.bak01
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak02
     *
     * @return the value of buukle-cms..user_album.bak02
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak02
     *
     * @param bak02 the value for buukle-cms..user_album.bak02
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak03
     *
     * @return the value of buukle-cms..user_album.bak03
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak03
     *
     * @param bak03 the value for buukle-cms..user_album.bak03
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak04
     *
     * @return the value of buukle-cms..user_album.bak04
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak04
     *
     * @param bak04 the value for buukle-cms..user_album.bak04
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak05
     *
     * @return the value of buukle-cms..user_album.bak05
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public UserAlbum withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak05
     *
     * @param bak05 the value for buukle-cms..user_album.bak05
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05;
    }

    /**
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", salesmanId=").append(salesmanId);
        sb.append(", groupId=").append(groupId);
        sb.append(", agentId=").append(agentId);
        sb.append(", platformId=").append(platformId);
        sb.append(", albumName=").append(albumName);
        sb.append(", albumDesc=").append(albumDesc);
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
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
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
        UserAlbum other = (UserAlbum) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getSalesmanId() == null ? other.getSalesmanId() == null : this.getSalesmanId().equals(other.getSalesmanId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()))
            && (this.getAgentId() == null ? other.getAgentId() == null : this.getAgentId().equals(other.getAgentId()))
            && (this.getPlatformId() == null ? other.getPlatformId() == null : this.getPlatformId().equals(other.getPlatformId()))
            && (this.getAlbumName() == null ? other.getAlbumName() == null : this.getAlbumName().equals(other.getAlbumName()))
            && (this.getAlbumDesc() == null ? other.getAlbumDesc() == null : this.getAlbumDesc().equals(other.getAlbumDesc()))
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
     *
     * @mbg.generated Mon Dec 17 00:04:20 CST 2018
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getSalesmanId() == null) ? 0 : getSalesmanId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        result = prime * result + ((getAgentId() == null) ? 0 : getAgentId().hashCode());
        result = prime * result + ((getPlatformId() == null) ? 0 : getPlatformId().hashCode());
        result = prime * result + ((getAlbumName() == null) ? 0 : getAlbumName().hashCode());
        result = prime * result + ((getAlbumDesc() == null) ? 0 : getAlbumDesc().hashCode());
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
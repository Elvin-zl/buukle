package top.buukle.consumer.www.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class UserAlbum implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 用户id
     *
     */
    private Integer userId;

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
     * 相册名称
     *
     */
    private String albumName;

    /**
     * 相册描述
     *
     */
    private String albumDesc;

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
     * This method returns the value of the database column buukle-cms..user_album.id
     *
     * @return the value of buukle-cms..user_album.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public UserAlbum withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.id
     *
     * @param id the value for buukle-cms..user_album.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.user_id
     *
     * @return the value of buukle-cms..user_album.user_id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     */
    public UserAlbum withUserId(Integer userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.user_id
     *
     * @param userId the value for buukle-cms..user_album.user_id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.salesman_id
     *
     * @return the value of buukle-cms..user_album.salesman_id
     */
    public String getSalesmanId() {
        return salesmanId;
    }

    /**
     */
    public UserAlbum withSalesmanId(String salesmanId) {
        this.setSalesmanId(salesmanId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.salesman_id
     *
     * @param salesmanId the value for buukle-cms..user_album.salesman_id
     */
    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId == null ? null : salesmanId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.group_id
     *
     * @return the value of buukle-cms..user_album.group_id
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     */
    public UserAlbum withGroupId(String groupId) {
        this.setGroupId(groupId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.group_id
     *
     * @param groupId the value for buukle-cms..user_album.group_id
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.agent_id
     *
     * @return the value of buukle-cms..user_album.agent_id
     */
    public String getAgentId() {
        return agentId;
    }

    /**
     */
    public UserAlbum withAgentId(String agentId) {
        this.setAgentId(agentId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.agent_id
     *
     * @param agentId the value for buukle-cms..user_album.agent_id
     */
    public void setAgentId(String agentId) {
        this.agentId = agentId == null ? null : agentId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.platform_id
     *
     * @return the value of buukle-cms..user_album.platform_id
     */
    public String getPlatformId() {
        return platformId;
    }

    /**
     */
    public UserAlbum withPlatformId(String platformId) {
        this.setPlatformId(platformId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.platform_id
     *
     * @param platformId the value for buukle-cms..user_album.platform_id
     */
    public void setPlatformId(String platformId) {
        this.platformId = platformId == null ? null : platformId.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.album_name
     *
     * @return the value of buukle-cms..user_album.album_name
     */
    public String getAlbumName() {
        return albumName;
    }

    /**
     */
    public UserAlbum withAlbumName(String albumName) {
        this.setAlbumName(albumName);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.album_name
     *
     * @param albumName the value for buukle-cms..user_album.album_name
     */
    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.album_desc
     *
     * @return the value of buukle-cms..user_album.album_desc
     */
    public String getAlbumDesc() {
        return albumDesc;
    }

    /**
     */
    public UserAlbum withAlbumDesc(String albumDesc) {
        this.setAlbumDesc(albumDesc);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.album_desc
     *
     * @param albumDesc the value for buukle-cms..user_album.album_desc
     */
    public void setAlbumDesc(String albumDesc) {
        this.albumDesc = albumDesc == null ? null : albumDesc.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.creator
     *
     * @return the value of buukle-cms..user_album.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public UserAlbum withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.creator
     *
     * @param creator the value for buukle-cms..user_album.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.creator_code
     *
     * @return the value of buukle-cms..user_album.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public UserAlbum withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.creator_code
     *
     * @param creatorCode the value for buukle-cms..user_album.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.gmt_created
     *
     * @return the value of buukle-cms..user_album.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public UserAlbum withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..user_album.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.modifier
     *
     * @return the value of buukle-cms..user_album.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public UserAlbum withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.modifier
     *
     * @param modifier the value for buukle-cms..user_album.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.modifier_code
     *
     * @return the value of buukle-cms..user_album.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public UserAlbum withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.modifier_code
     *
     * @param modifierCode the value for buukle-cms..user_album.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.gmt_modified
     *
     * @return the value of buukle-cms..user_album.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public UserAlbum withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..user_album.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.status
     *
     * @return the value of buukle-cms..user_album.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public UserAlbum withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.status
     *
     * @param status the value for buukle-cms..user_album.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.remark
     *
     * @return the value of buukle-cms..user_album.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public UserAlbum withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.remark
     *
     * @param remark the value for buukle-cms..user_album.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak01
     *
     * @return the value of buukle-cms..user_album.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public UserAlbum withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak01
     *
     * @param bak01 the value for buukle-cms..user_album.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak02
     *
     * @return the value of buukle-cms..user_album.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public UserAlbum withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak02
     *
     * @param bak02 the value for buukle-cms..user_album.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak03
     *
     * @return the value of buukle-cms..user_album.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public UserAlbum withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak03
     *
     * @param bak03 the value for buukle-cms..user_album.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak04
     *
     * @return the value of buukle-cms..user_album.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public UserAlbum withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak04
     *
     * @param bak04 the value for buukle-cms..user_album.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..user_album.bak05
     *
     * @return the value of buukle-cms..user_album.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public UserAlbum withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..user_album.bak05
     *
     * @param bak05 the value for buukle-cms..user_album.bak05
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
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        return result;
    }
}
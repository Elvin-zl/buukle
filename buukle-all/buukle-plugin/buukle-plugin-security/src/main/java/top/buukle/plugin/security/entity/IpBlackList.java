package top.buukle.plugin.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class IpBlackList implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * 黑名ip
     *
     */
    private String ip;

    /**
     * 解禁时间
     *
     */
    private Date gmtOpen;

    /**
     * 创建时间
     *
     */
    private Date gmtCreated;

    /**
     * 创建者
     *
     */
    private String creator;

    /**
     * 创建类型
     *
     */
    private Integer creatorType;

    /**
     * 创建者编码
     *
     */
    private String creatorCode;

    /**
     * 更新时间
     *
     */
    private Date gmtModified;

    /**
     * 更新者
     *
     */
    private String modifier;

    /**
     * 更新者类型
     *
     */
    private Integer modifierType;

    /**
     * 更新者编码
     *
     */
    private String modifierCode;

    /**
     * 状态
     *
     */
    private Integer status;

    /**
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.id
     *
     * @return the value of buukle-security..ip_black_list.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public IpBlackList withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.id
     *
     * @param id the value for buukle-security..ip_black_list.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.ip
     *
     * @return the value of buukle-security..ip_black_list.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     */
    public IpBlackList withIp(String ip) {
        this.setIp(ip);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.ip
     *
     * @param ip the value for buukle-security..ip_black_list.ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.gmt_open
     *
     * @return the value of buukle-security..ip_black_list.gmt_open
     */
    public Date getGmtOpen() {
        return gmtOpen;
    }

    /**
     */
    public IpBlackList withGmtOpen(Date gmtOpen) {
        this.setGmtOpen(gmtOpen);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.gmt_open
     *
     * @param gmtOpen the value for buukle-security..ip_black_list.gmt_open
     */
    public void setGmtOpen(Date gmtOpen) {
        this.gmtOpen = gmtOpen;
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.gmt_created
     *
     * @return the value of buukle-security..ip_black_list.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public IpBlackList withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.gmt_created
     *
     * @param gmtCreated the value for buukle-security..ip_black_list.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.creator
     *
     * @return the value of buukle-security..ip_black_list.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public IpBlackList withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.creator
     *
     * @param creator the value for buukle-security..ip_black_list.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.creator_type
     *
     * @return the value of buukle-security..ip_black_list.creator_type
     */
    public Integer getCreatorType() {
        return creatorType;
    }

    /**
     */
    public IpBlackList withCreatorType(Integer creatorType) {
        this.setCreatorType(creatorType);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.creator_type
     *
     * @param creatorType the value for buukle-security..ip_black_list.creator_type
     */
    public void setCreatorType(Integer creatorType) {
        this.creatorType = creatorType;
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.creator_code
     *
     * @return the value of buukle-security..ip_black_list.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public IpBlackList withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.creator_code
     *
     * @param creatorCode the value for buukle-security..ip_black_list.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.gmt_modified
     *
     * @return the value of buukle-security..ip_black_list.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public IpBlackList withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.gmt_modified
     *
     * @param gmtModified the value for buukle-security..ip_black_list.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.modifier
     *
     * @return the value of buukle-security..ip_black_list.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public IpBlackList withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.modifier
     *
     * @param modifier the value for buukle-security..ip_black_list.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.modifier_type
     *
     * @return the value of buukle-security..ip_black_list.modifier_type
     */
    public Integer getModifierType() {
        return modifierType;
    }

    /**
     */
    public IpBlackList withModifierType(Integer modifierType) {
        this.setModifierType(modifierType);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.modifier_type
     *
     * @param modifierType the value for buukle-security..ip_black_list.modifier_type
     */
    public void setModifierType(Integer modifierType) {
        this.modifierType = modifierType;
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.modifier_code
     *
     * @return the value of buukle-security..ip_black_list.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public IpBlackList withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.modifier_code
     *
     * @param modifierCode the value for buukle-security..ip_black_list.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..ip_black_list.status
     *
     * @return the value of buukle-security..ip_black_list.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public IpBlackList withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..ip_black_list.status
     *
     * @param status the value for buukle-security..ip_black_list.status
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
        sb.append(", ip=").append(ip);
        sb.append(", gmtOpen=").append(gmtOpen);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", creator=").append(creator);
        sb.append(", creatorType=").append(creatorType);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierType=").append(modifierType);
        sb.append(", modifierCode=").append(modifierCode);
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
        IpBlackList other = (IpBlackList) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getGmtOpen() == null ? other.getGmtOpen() == null : this.getGmtOpen().equals(other.getGmtOpen()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorType() == null ? other.getCreatorType() == null : this.getCreatorType().equals(other.getCreatorType()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierType() == null ? other.getModifierType() == null : this.getModifierType().equals(other.getModifierType()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getGmtOpen() == null) ? 0 : getGmtOpen().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorType() == null) ? 0 : getCreatorType().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierType() == null) ? 0 : getModifierType().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
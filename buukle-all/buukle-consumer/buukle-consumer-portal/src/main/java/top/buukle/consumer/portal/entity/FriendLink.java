package top.buukle.consumer.portal.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class FriendLink implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * logo
     *
     */
    private String logo;

    /**
     * 链接
     *
     */
    private String url;

    /**
     * 连接描述
     *
     */
    private String linkDesc;

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
     * 中文姓名昵称
     *
     */
    private String nameCn;

    /**
     * 中文姓名全称
     *
     */
    private String fullNameCn;

    /**
     * 英文姓名昵称
     *
     */
    private String nameEn;

    /**
     * 英文姓名全称
     *
     */
    private String fullNameEn;

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
     * This method returns the value of the database column buukle-cms..friend_link.id
     *
     * @return the value of buukle-cms..friend_link.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public FriendLink withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.id
     *
     * @param id the value for buukle-cms..friend_link.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.logo
     *
     * @return the value of buukle-cms..friend_link.logo
     */
    public String getLogo() {
        return logo;
    }

    /**
     */
    public FriendLink withLogo(String logo) {
        this.setLogo(logo);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.logo
     *
     * @param logo the value for buukle-cms..friend_link.logo
     */
    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.url
     *
     * @return the value of buukle-cms..friend_link.url
     */
    public String getUrl() {
        return url;
    }

    /**
     */
    public FriendLink withUrl(String url) {
        this.setUrl(url);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.url
     *
     * @param url the value for buukle-cms..friend_link.url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.link_desc
     *
     * @return the value of buukle-cms..friend_link.link_desc
     */
    public String getLinkDesc() {
        return linkDesc;
    }

    /**
     */
    public FriendLink withLinkDesc(String linkDesc) {
        this.setLinkDesc(linkDesc);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.link_desc
     *
     * @param linkDesc the value for buukle-cms..friend_link.link_desc
     */
    public void setLinkDesc(String linkDesc) {
        this.linkDesc = linkDesc == null ? null : linkDesc.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.creator
     *
     * @return the value of buukle-cms..friend_link.creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     */
    public FriendLink withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.creator
     *
     * @param creator the value for buukle-cms..friend_link.creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.creator_code
     *
     * @return the value of buukle-cms..friend_link.creator_code
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     */
    public FriendLink withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.creator_code
     *
     * @param creatorCode the value for buukle-cms..friend_link.creator_code
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.gmt_created
     *
     * @return the value of buukle-cms..friend_link.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public FriendLink withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.gmt_created
     *
     * @param gmtCreated the value for buukle-cms..friend_link.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.modifier
     *
     * @return the value of buukle-cms..friend_link.modifier
     */
    public String getModifier() {
        return modifier;
    }

    /**
     */
    public FriendLink withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.modifier
     *
     * @param modifier the value for buukle-cms..friend_link.modifier
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.modifier_code
     *
     * @return the value of buukle-cms..friend_link.modifier_code
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     */
    public FriendLink withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.modifier_code
     *
     * @param modifierCode the value for buukle-cms..friend_link.modifier_code
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.gmt_modified
     *
     * @return the value of buukle-cms..friend_link.gmt_modified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     */
    public FriendLink withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.gmt_modified
     *
     * @param gmtModified the value for buukle-cms..friend_link.gmt_modified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.name_cn
     *
     * @return the value of buukle-cms..friend_link.name_cn
     */
    public String getNameCn() {
        return nameCn;
    }

    /**
     */
    public FriendLink withNameCn(String nameCn) {
        this.setNameCn(nameCn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.name_cn
     *
     * @param nameCn the value for buukle-cms..friend_link.name_cn
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.full_name_cn
     *
     * @return the value of buukle-cms..friend_link.full_name_cn
     */
    public String getFullNameCn() {
        return fullNameCn;
    }

    /**
     */
    public FriendLink withFullNameCn(String fullNameCn) {
        this.setFullNameCn(fullNameCn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.full_name_cn
     *
     * @param fullNameCn the value for buukle-cms..friend_link.full_name_cn
     */
    public void setFullNameCn(String fullNameCn) {
        this.fullNameCn = fullNameCn == null ? null : fullNameCn.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.name_en
     *
     * @return the value of buukle-cms..friend_link.name_en
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     */
    public FriendLink withNameEn(String nameEn) {
        this.setNameEn(nameEn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.name_en
     *
     * @param nameEn the value for buukle-cms..friend_link.name_en
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.full_name_en
     *
     * @return the value of buukle-cms..friend_link.full_name_en
     */
    public String getFullNameEn() {
        return fullNameEn;
    }

    /**
     */
    public FriendLink withFullNameEn(String fullNameEn) {
        this.setFullNameEn(fullNameEn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.full_name_en
     *
     * @param fullNameEn the value for buukle-cms..friend_link.full_name_en
     */
    public void setFullNameEn(String fullNameEn) {
        this.fullNameEn = fullNameEn == null ? null : fullNameEn.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.status
     *
     * @return the value of buukle-cms..friend_link.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public FriendLink withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.status
     *
     * @param status the value for buukle-cms..friend_link.status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.remark
     *
     * @return the value of buukle-cms..friend_link.remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     */
    public FriendLink withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.remark
     *
     * @param remark the value for buukle-cms..friend_link.remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.bak01
     *
     * @return the value of buukle-cms..friend_link.bak01
     */
    public String getBak01() {
        return bak01;
    }

    /**
     */
    public FriendLink withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.bak01
     *
     * @param bak01 the value for buukle-cms..friend_link.bak01
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.bak02
     *
     * @return the value of buukle-cms..friend_link.bak02
     */
    public String getBak02() {
        return bak02;
    }

    /**
     */
    public FriendLink withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.bak02
     *
     * @param bak02 the value for buukle-cms..friend_link.bak02
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.bak03
     *
     * @return the value of buukle-cms..friend_link.bak03
     */
    public String getBak03() {
        return bak03;
    }

    /**
     */
    public FriendLink withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.bak03
     *
     * @param bak03 the value for buukle-cms..friend_link.bak03
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.bak04
     *
     * @return the value of buukle-cms..friend_link.bak04
     */
    public String getBak04() {
        return bak04;
    }

    /**
     */
    public FriendLink withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.bak04
     *
     * @param bak04 the value for buukle-cms..friend_link.bak04
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-cms..friend_link.bak05
     *
     * @return the value of buukle-cms..friend_link.bak05
     */
    public String getBak05() {
        return bak05;
    }

    /**
     */
    public FriendLink withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-cms..friend_link.bak05
     *
     * @param bak05 the value for buukle-cms..friend_link.bak05
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
        sb.append(", logo=").append(logo);
        sb.append(", url=").append(url);
        sb.append(", linkDesc=").append(linkDesc);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", nameCn=").append(nameCn);
        sb.append(", fullNameCn=").append(fullNameCn);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", fullNameEn=").append(fullNameEn);
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
        FriendLink other = (FriendLink) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getLogo() == null ? other.getLogo() == null : this.getLogo().equals(other.getLogo()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getLinkDesc() == null ? other.getLinkDesc() == null : this.getLinkDesc().equals(other.getLinkDesc()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getNameCn() == null ? other.getNameCn() == null : this.getNameCn().equals(other.getNameCn()))
            && (this.getFullNameCn() == null ? other.getFullNameCn() == null : this.getFullNameCn().equals(other.getFullNameCn()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getFullNameEn() == null ? other.getFullNameEn() == null : this.getFullNameEn().equals(other.getFullNameEn()))
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
        result = prime * result + ((getLogo() == null) ? 0 : getLogo().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getLinkDesc() == null) ? 0 : getLinkDesc().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getNameCn() == null) ? 0 : getNameCn().hashCode());
        result = prime * result + ((getFullNameCn() == null) ? 0 : getFullNameCn().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getFullNameEn() == null) ? 0 : getFullNameEn().hashCode());
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
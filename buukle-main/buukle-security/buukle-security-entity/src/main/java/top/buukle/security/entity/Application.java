package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * Ӧ
 *
 * @author 
 */
public class Application implements Serializable {
    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private String code;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private String name;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private String creator;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private String modifierCode;

    /**
     * ״̬
     *
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private Integer status;

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security..application.id
     *
     * @return the value of buukle-security..application.id
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.id
     *
     * @param id the value for buukle-security..application.id
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security..application.code
     *
     * @return the value of buukle-security..application.code
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public String getCode() {
        return code;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withCode(String code) {
        this.setCode(code);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.code
     *
     * @param code the value for buukle-security..application.code
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..application.name
     *
     * @return the value of buukle-security..application.name
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withName(String name) {
        this.setName(name);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.name
     *
     * @param name the value for buukle-security..application.name
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..application.gmt_created
     *
     * @return the value of buukle-security..application.gmt_created
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.gmt_created
     *
     * @param gmtCreated the value for buukle-security..application.gmt_created
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security..application.creator
     *
     * @return the value of buukle-security..application.creator
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.creator
     *
     * @param creator the value for buukle-security..application.creator
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..application.creator_code
     *
     * @return the value of buukle-security..application.creator_code
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.creator_code
     *
     * @param creatorCode the value for buukle-security..application.creator_code
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..application.gmt_modified
     *
     * @return the value of buukle-security..application.gmt_modified
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.gmt_modified
     *
     * @param gmtModified the value for buukle-security..application.gmt_modified
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security..application.modifier
     *
     * @return the value of buukle-security..application.modifier
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.modifier
     *
     * @param modifier the value for buukle-security..application.modifier
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..application.modifier_code
     *
     * @return the value of buukle-security..application.modifier_code
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.modifier_code
     *
     * @param modifierCode the value for buukle-security..application.modifier_code
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..application.status
     *
     * @return the value of buukle-security..application.status
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public Application withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..application.status
     *
     * @param status the value for buukle-security..application.status
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
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
        Application other = (Application) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCode() == null ? other.getCode() == null : this.getCode().equals(other.getCode()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    /**
     *
     * @mbg.generated Sat Aug 03 21:35:16 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCode() == null) ? 0 : getCode().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
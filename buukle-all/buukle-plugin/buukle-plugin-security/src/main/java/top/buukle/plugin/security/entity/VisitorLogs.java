package top.buukle.plugin.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By elvin
 * Description:
 * 
 * @author 
 */
public class VisitorLogs implements Serializable {
    /**
     * 主键id
     *
     */
    private Integer id;

    /**
     * ip地址
     *
     */
    private String ip;

    /**
     * 访问时间
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
     * This method returns the value of the database column buukle-security..visitor_logs.id
     *
     * @return the value of buukle-security..visitor_logs.id
     */
    public Integer getId() {
        return id;
    }

    /**
     */
    public VisitorLogs withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..visitor_logs.id
     *
     * @param id the value for buukle-security..visitor_logs.id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security..visitor_logs.ip
     *
     * @return the value of buukle-security..visitor_logs.ip
     */
    public String getIp() {
        return ip;
    }

    /**
     */
    public VisitorLogs withIp(String ip) {
        this.setIp(ip);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..visitor_logs.ip
     *
     * @param ip the value for buukle-security..visitor_logs.ip
     */
    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..visitor_logs.gmt_created
     *
     * @return the value of buukle-security..visitor_logs.gmt_created
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     */
    public VisitorLogs withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..visitor_logs.gmt_created
     *
     * @param gmtCreated the value for buukle-security..visitor_logs.gmt_created
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security..visitor_logs.status
     *
     * @return the value of buukle-security..visitor_logs.status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     */
    public VisitorLogs withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..visitor_logs.status
     *
     * @param status the value for buukle-security..visitor_logs.status
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
        VisitorLogs other = (VisitorLogs) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
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
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }
}
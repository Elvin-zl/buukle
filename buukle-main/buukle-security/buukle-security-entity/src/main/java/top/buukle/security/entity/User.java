package top.buukle.security.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * Created By MBG-GUI-EXTENSION https:// github.com/spawpaw/mybatis-generator-gui-extension
 * Description:
 * 
 *
 * @author 
 */
public class User implements Serializable {
    /**
     * 主键id
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer id;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String userId;

    /**
     * 区域id
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer areaId;

    /**
     * 区域管理员 0 不是 1 是
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer areaAdmin;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String username;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String password;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String nameCn;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String fullNameCn;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String nameEn;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String fullNameEn;

    /**
     * 赞数
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer praise;

    /**
     * 粉丝数量
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer fans;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String email;

    /**
     * 手机号
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer phone;

    /**
     * 性别 : 0 女 1 男
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer sex;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer age;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String sign;

    /**
     * 登录策略 1: 一周 0:系统默认时间
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer loginStrategy;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String headUrl;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String theme;

    /**
     * 主题id
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer themeId;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String remark;

    /**
     * 最近登陆时间
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Date gmtLastLogin;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Date gmtCreated;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String creator;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String creatorCode;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Date gmtModified;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String modifier;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String modifierCode;

    /**
     * 状态
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private Integer status;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String bak01;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String bak02;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String bak03;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String bak04;

    /**
     *
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private String bak05;

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method returns the value of the database column buukle-security..user.id
     *
     * @return the value of buukle-security..user.id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withId(Integer id) {
        this.setId(id);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.id
     *
     * @param id the value for buukle-security..user.id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method returns the value of the database column buukle-security..user.user_id
     *
     * @return the value of buukle-security..user.user_id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withUserId(String userId) {
        this.setUserId(userId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.user_id
     *
     * @param userId the value for buukle-security..user.user_id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.area_id
     *
     * @return the value of buukle-security..user.area_id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withAreaId(Integer areaId) {
        this.setAreaId(areaId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.area_id
     *
     * @param areaId the value for buukle-security..user.area_id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * This method returns the value of the database column buukle-security..user.area_admin
     *
     * @return the value of buukle-security..user.area_admin
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getAreaAdmin() {
        return areaAdmin;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withAreaAdmin(Integer areaAdmin) {
        this.setAreaAdmin(areaAdmin);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.area_admin
     *
     * @param areaAdmin the value for buukle-security..user.area_admin
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setAreaAdmin(Integer areaAdmin) {
        this.areaAdmin = areaAdmin;
    }

    /**
     * This method returns the value of the database column buukle-security..user.username
     *
     * @return the value of buukle-security..user.username
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withUsername(String username) {
        this.setUsername(username);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.username
     *
     * @param username the value for buukle-security..user.username
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.password
     *
     * @return the value of buukle-security..user.password
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withPassword(String password) {
        this.setPassword(password);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.password
     *
     * @param password the value for buukle-security..user.password
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.name_cn
     *
     * @return the value of buukle-security..user.name_cn
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getNameCn() {
        return nameCn;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withNameCn(String nameCn) {
        this.setNameCn(nameCn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.name_cn
     *
     * @param nameCn the value for buukle-security..user.name_cn
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.full_name_cn
     *
     * @return the value of buukle-security..user.full_name_cn
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getFullNameCn() {
        return fullNameCn;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withFullNameCn(String fullNameCn) {
        this.setFullNameCn(fullNameCn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.full_name_cn
     *
     * @param fullNameCn the value for buukle-security..user.full_name_cn
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setFullNameCn(String fullNameCn) {
        this.fullNameCn = fullNameCn == null ? null : fullNameCn.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.name_en
     *
     * @return the value of buukle-security..user.name_en
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withNameEn(String nameEn) {
        this.setNameEn(nameEn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.name_en
     *
     * @param nameEn the value for buukle-security..user.name_en
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.full_name_en
     *
     * @return the value of buukle-security..user.full_name_en
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getFullNameEn() {
        return fullNameEn;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withFullNameEn(String fullNameEn) {
        this.setFullNameEn(fullNameEn);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.full_name_en
     *
     * @param fullNameEn the value for buukle-security..user.full_name_en
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setFullNameEn(String fullNameEn) {
        this.fullNameEn = fullNameEn == null ? null : fullNameEn.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.praise
     *
     * @return the value of buukle-security..user.praise
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getPraise() {
        return praise;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withPraise(Integer praise) {
        this.setPraise(praise);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.praise
     *
     * @param praise the value for buukle-security..user.praise
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setPraise(Integer praise) {
        this.praise = praise;
    }

    /**
     * This method returns the value of the database column buukle-security..user.fans
     *
     * @return the value of buukle-security..user.fans
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getFans() {
        return fans;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withFans(Integer fans) {
        this.setFans(fans);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.fans
     *
     * @param fans the value for buukle-security..user.fans
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setFans(Integer fans) {
        this.fans = fans;
    }

    /**
     * This method returns the value of the database column buukle-security..user.email
     *
     * @return the value of buukle-security..user.email
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withEmail(String email) {
        this.setEmail(email);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.email
     *
     * @param email the value for buukle-security..user.email
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.phone
     *
     * @return the value of buukle-security..user.phone
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getPhone() {
        return phone;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withPhone(Integer phone) {
        this.setPhone(phone);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.phone
     *
     * @param phone the value for buukle-security..user.phone
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    /**
     * This method returns the value of the database column buukle-security..user.sex
     *
     * @return the value of buukle-security..user.sex
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getSex() {
        return sex;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withSex(Integer sex) {
        this.setSex(sex);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.sex
     *
     * @param sex the value for buukle-security..user.sex
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * This method returns the value of the database column buukle-security..user.age
     *
     * @return the value of buukle-security..user.age
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getAge() {
        return age;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withAge(Integer age) {
        this.setAge(age);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.age
     *
     * @param age the value for buukle-security..user.age
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * This method returns the value of the database column buukle-security..user.sign
     *
     * @return the value of buukle-security..user.sign
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getSign() {
        return sign;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withSign(String sign) {
        this.setSign(sign);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.sign
     *
     * @param sign the value for buukle-security..user.sign
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setSign(String sign) {
        this.sign = sign == null ? null : sign.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.login_strategy
     *
     * @return the value of buukle-security..user.login_strategy
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getLoginStrategy() {
        return loginStrategy;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withLoginStrategy(Integer loginStrategy) {
        this.setLoginStrategy(loginStrategy);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.login_strategy
     *
     * @param loginStrategy the value for buukle-security..user.login_strategy
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setLoginStrategy(Integer loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    /**
     * This method returns the value of the database column buukle-security..user.head_url
     *
     * @return the value of buukle-security..user.head_url
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getHeadUrl() {
        return headUrl;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withHeadUrl(String headUrl) {
        this.setHeadUrl(headUrl);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.head_url
     *
     * @param headUrl the value for buukle-security..user.head_url
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl == null ? null : headUrl.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.theme
     *
     * @return the value of buukle-security..user.theme
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getTheme() {
        return theme;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withTheme(String theme) {
        this.setTheme(theme);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.theme
     *
     * @param theme the value for buukle-security..user.theme
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.theme_id
     *
     * @return the value of buukle-security..user.theme_id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getThemeId() {
        return themeId;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withThemeId(Integer themeId) {
        this.setThemeId(themeId);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.theme_id
     *
     * @param themeId the value for buukle-security..user.theme_id
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    /**
     * This method returns the value of the database column buukle-security..user.remark
     *
     * @return the value of buukle-security..user.remark
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withRemark(String remark) {
        this.setRemark(remark);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.remark
     *
     * @param remark the value for buukle-security..user.remark
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.gmt_last_login
     *
     * @return the value of buukle-security..user.gmt_last_login
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Date getGmtLastLogin() {
        return gmtLastLogin;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withGmtLastLogin(Date gmtLastLogin) {
        this.setGmtLastLogin(gmtLastLogin);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.gmt_last_login
     *
     * @param gmtLastLogin the value for buukle-security..user.gmt_last_login
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setGmtLastLogin(Date gmtLastLogin) {
        this.gmtLastLogin = gmtLastLogin;
    }

    /**
     * This method returns the value of the database column buukle-security..user.gmt_created
     *
     * @return the value of buukle-security..user.gmt_created
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withGmtCreated(Date gmtCreated) {
        this.setGmtCreated(gmtCreated);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.gmt_created
     *
     * @param gmtCreated the value for buukle-security..user.gmt_created
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * This method returns the value of the database column buukle-security..user.creator
     *
     * @return the value of buukle-security..user.creator
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getCreator() {
        return creator;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withCreator(String creator) {
        this.setCreator(creator);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.creator
     *
     * @param creator the value for buukle-security..user.creator
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.creator_code
     *
     * @return the value of buukle-security..user.creator_code
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withCreatorCode(String creatorCode) {
        this.setCreatorCode(creatorCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.creator_code
     *
     * @param creatorCode the value for buukle-security..user.creator_code
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.gmt_modified
     *
     * @return the value of buukle-security..user.gmt_modified
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withGmtModified(Date gmtModified) {
        this.setGmtModified(gmtModified);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.gmt_modified
     *
     * @param gmtModified the value for buukle-security..user.gmt_modified
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * This method returns the value of the database column buukle-security..user.modifier
     *
     * @return the value of buukle-security..user.modifier
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getModifier() {
        return modifier;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withModifier(String modifier) {
        this.setModifier(modifier);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.modifier
     *
     * @param modifier the value for buukle-security..user.modifier
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.modifier_code
     *
     * @return the value of buukle-security..user.modifier_code
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withModifierCode(String modifierCode) {
        this.setModifierCode(modifierCode);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.modifier_code
     *
     * @param modifierCode the value for buukle-security..user.modifier_code
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.status
     *
     * @return the value of buukle-security..user.status
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withStatus(Integer status) {
        this.setStatus(status);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.status
     *
     * @param status the value for buukle-security..user.status
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method returns the value of the database column buukle-security..user.bak01
     *
     * @return the value of buukle-security..user.bak01
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getBak01() {
        return bak01;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withBak01(String bak01) {
        this.setBak01(bak01);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.bak01
     *
     * @param bak01 the value for buukle-security..user.bak01
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.bak02
     *
     * @return the value of buukle-security..user.bak02
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getBak02() {
        return bak02;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withBak02(String bak02) {
        this.setBak02(bak02);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.bak02
     *
     * @param bak02 the value for buukle-security..user.bak02
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.bak03
     *
     * @return the value of buukle-security..user.bak03
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getBak03() {
        return bak03;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withBak03(String bak03) {
        this.setBak03(bak03);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.bak03
     *
     * @param bak03 the value for buukle-security..user.bak03
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.bak04
     *
     * @return the value of buukle-security..user.bak04
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getBak04() {
        return bak04;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withBak04(String bak04) {
        this.setBak04(bak04);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.bak04
     *
     * @param bak04 the value for buukle-security..user.bak04
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * This method returns the value of the database column buukle-security..user.bak05
     *
     * @return the value of buukle-security..user.bak05
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public String getBak05() {
        return bak05;
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public User withBak05(String bak05) {
        this.setBak05(bak05);
        return this;
    }

    /**
     * This method sets the value of the database column buukle-security..user.bak05
     *
     * @param bak05 the value for buukle-security..user.bak05
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userId=").append(userId);
        sb.append(", areaId=").append(areaId);
        sb.append(", areaAdmin=").append(areaAdmin);
        sb.append(", username=").append(username);
        sb.append(", password=").append(password);
        sb.append(", nameCn=").append(nameCn);
        sb.append(", fullNameCn=").append(fullNameCn);
        sb.append(", nameEn=").append(nameEn);
        sb.append(", fullNameEn=").append(fullNameEn);
        sb.append(", praise=").append(praise);
        sb.append(", fans=").append(fans);
        sb.append(", email=").append(email);
        sb.append(", phone=").append(phone);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", sign=").append(sign);
        sb.append(", loginStrategy=").append(loginStrategy);
        sb.append(", headUrl=").append(headUrl);
        sb.append(", theme=").append(theme);
        sb.append(", themeId=").append(themeId);
        sb.append(", remark=").append(remark);
        sb.append(", gmtLastLogin=").append(gmtLastLogin);
        sb.append(", gmtCreated=").append(gmtCreated);
        sb.append(", creator=").append(creator);
        sb.append(", creatorCode=").append(creatorCode);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append(", modifierCode=").append(modifierCode);
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
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getAreaId() == null ? other.getAreaId() == null : this.getAreaId().equals(other.getAreaId()))
            && (this.getAreaAdmin() == null ? other.getAreaAdmin() == null : this.getAreaAdmin().equals(other.getAreaAdmin()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getNameCn() == null ? other.getNameCn() == null : this.getNameCn().equals(other.getNameCn()))
            && (this.getFullNameCn() == null ? other.getFullNameCn() == null : this.getFullNameCn().equals(other.getFullNameCn()))
            && (this.getNameEn() == null ? other.getNameEn() == null : this.getNameEn().equals(other.getNameEn()))
            && (this.getFullNameEn() == null ? other.getFullNameEn() == null : this.getFullNameEn().equals(other.getFullNameEn()))
            && (this.getPraise() == null ? other.getPraise() == null : this.getPraise().equals(other.getPraise()))
            && (this.getFans() == null ? other.getFans() == null : this.getFans().equals(other.getFans()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getSign() == null ? other.getSign() == null : this.getSign().equals(other.getSign()))
            && (this.getLoginStrategy() == null ? other.getLoginStrategy() == null : this.getLoginStrategy().equals(other.getLoginStrategy()))
            && (this.getHeadUrl() == null ? other.getHeadUrl() == null : this.getHeadUrl().equals(other.getHeadUrl()))
            && (this.getTheme() == null ? other.getTheme() == null : this.getTheme().equals(other.getTheme()))
            && (this.getThemeId() == null ? other.getThemeId() == null : this.getThemeId().equals(other.getThemeId()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getGmtLastLogin() == null ? other.getGmtLastLogin() == null : this.getGmtLastLogin().equals(other.getGmtLastLogin()))
            && (this.getGmtCreated() == null ? other.getGmtCreated() == null : this.getGmtCreated().equals(other.getGmtCreated()))
            && (this.getCreator() == null ? other.getCreator() == null : this.getCreator().equals(other.getCreator()))
            && (this.getCreatorCode() == null ? other.getCreatorCode() == null : this.getCreatorCode().equals(other.getCreatorCode()))
            && (this.getGmtModified() == null ? other.getGmtModified() == null : this.getGmtModified().equals(other.getGmtModified()))
            && (this.getModifier() == null ? other.getModifier() == null : this.getModifier().equals(other.getModifier()))
            && (this.getModifierCode() == null ? other.getModifierCode() == null : this.getModifierCode().equals(other.getModifierCode()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getBak01() == null ? other.getBak01() == null : this.getBak01().equals(other.getBak01()))
            && (this.getBak02() == null ? other.getBak02() == null : this.getBak02().equals(other.getBak02()))
            && (this.getBak03() == null ? other.getBak03() == null : this.getBak03().equals(other.getBak03()))
            && (this.getBak04() == null ? other.getBak04() == null : this.getBak04().equals(other.getBak04()))
            && (this.getBak05() == null ? other.getBak05() == null : this.getBak05().equals(other.getBak05()));
    }

    /**
     *
     * @mbg.generated Thu Aug 01 00:52:22 CST 2019
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getAreaId() == null) ? 0 : getAreaId().hashCode());
        result = prime * result + ((getAreaAdmin() == null) ? 0 : getAreaAdmin().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getNameCn() == null) ? 0 : getNameCn().hashCode());
        result = prime * result + ((getFullNameCn() == null) ? 0 : getFullNameCn().hashCode());
        result = prime * result + ((getNameEn() == null) ? 0 : getNameEn().hashCode());
        result = prime * result + ((getFullNameEn() == null) ? 0 : getFullNameEn().hashCode());
        result = prime * result + ((getPraise() == null) ? 0 : getPraise().hashCode());
        result = prime * result + ((getFans() == null) ? 0 : getFans().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getSign() == null) ? 0 : getSign().hashCode());
        result = prime * result + ((getLoginStrategy() == null) ? 0 : getLoginStrategy().hashCode());
        result = prime * result + ((getHeadUrl() == null) ? 0 : getHeadUrl().hashCode());
        result = prime * result + ((getTheme() == null) ? 0 : getTheme().hashCode());
        result = prime * result + ((getThemeId() == null) ? 0 : getThemeId().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getGmtLastLogin() == null) ? 0 : getGmtLastLogin().hashCode());
        result = prime * result + ((getGmtCreated() == null) ? 0 : getGmtCreated().hashCode());
        result = prime * result + ((getCreator() == null) ? 0 : getCreator().hashCode());
        result = prime * result + ((getCreatorCode() == null) ? 0 : getCreatorCode().hashCode());
        result = prime * result + ((getGmtModified() == null) ? 0 : getGmtModified().hashCode());
        result = prime * result + ((getModifier() == null) ? 0 : getModifier().hashCode());
        result = prime * result + ((getModifierCode() == null) ? 0 : getModifierCode().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getBak01() == null) ? 0 : getBak01().hashCode());
        result = prime * result + ((getBak02() == null) ? 0 : getBak02().hashCode());
        result = prime * result + ((getBak03() == null) ? 0 : getBak03().hashCode());
        result = prime * result + ((getBak04() == null) ? 0 : getBak04().hashCode());
        result = prime * result + ((getBak05() == null) ? 0 : getBak05().hashCode());
        return result;
    }
}
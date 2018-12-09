package top.buukle.provider.security.entity;

import java.util.Date;

public class User {
    /**
     * 主键id
     */
    private Integer id;

    /**
     * 登录名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户身份级别 :  0:boss级别 1:平台级别 2:代理界别 3:区域管理员级别 4: 业务员级别 5:小白级别
     */
    private Integer userLevel;

    /**
     * 用户平台代码
     */
    private String platformId;

    /**
     * 用户代理商代码
     */
    private String agentId;

    /**
     * 用户区域代码
     */
    private String groupId;

    /**
     * 用户业务员代码
     */
    private String salesmanId;

    /**
     * 用户代码 : 生成规则待定,全局唯一
     */
    private String userId;

    /**
     * 粉丝数目
     */
    private String fansNumber;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 性别 1：男 0：女
     */
    private String gender;

    /**
     * 年龄
     */
    private String age;

    /**
     * 签名
     */
    private String slogen;

    /**
     * 登录策略 1: 一周 0:系统默认时间
     */
    private Integer loginStrategy;

    /**
     * 头像url
     */
    private String headImageUrl;

    /**
     * 头像静态服务器数据库id
     */
    private String headImageId;

    /**
     * 主题
     */
    private String theme;

    /**
     * 主题id
     */
    private Integer themeId;

    /**
     * 创建者(用户名)
     */
    private String creator;

    /**
     * 创建者代码
     */
    private String creatorCode;

    /**
     * 创建时间
     */
    private Date gmtCreated;

    /**
     * 修改者(用户名)
     */
    private String modifier;

    /**
     * 修改者代码
     */
    private String modifierCode;

    /**
     * 更新时间
     */
    private Date gmtModified;

    /**
     * 中文姓名昵称
     */
    private String nameCn;

    /**
     * 中文姓名全称
     */
    private String fullNameCn;

    /**
     * 英文姓名昵称
     */
    private String nameEn;

    /**
     * 英文姓名全称
     */
    private String fullNameEn;

    /**
     * 状态 1：启用 0：停用 -1 : 删除
     */
    private Integer status;

    /**
     * 备用
     */
    private String bak01;

    /**
     * 备用
     */
    private String bak02;

    /**
     * 备用
     */
    private String bak03;

    /**
     * 备用
     */
    private String bak04;

    /**
     * 备用
     */
    private String bak05;

    /**
     * 主键id
     * @return id 主键id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 主键id
     * @param id 主键id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 登录名
     * @return username 登录名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 登录名
     * @param username 登录名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 用户代码 : 生成规则待定,全局唯一
     * @return user_id 用户代码 : 生成规则待定,全局唯一
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 用户代码 : 生成规则待定,全局唯一
     * @param userId 用户代码 : 生成规则待定,全局唯一
     */
    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    /**
     * 粉丝数目
     * @return fans_number 粉丝数目
     */
    public String getFansNumber() {
        return fansNumber;
    }

    /**
     * 粉丝数目
     * @param fansNumber 粉丝数目
     */
    public void setFansNumber(String fansNumber) {
        this.fansNumber = fansNumber == null ? null : fansNumber.trim();
    }

    /**
     * 手机号码
     * @return phone 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 性别 1：男 0：女
     * @return gender 性别 1：男 0：女
     */
    public String getGender() {
        return gender;
    }

    /**
     * 性别 1：男 0：女
     * @param gender 性别 1：男 0：女
     */
    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public String getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    /**
     * 签名
     * @return slogen 签名
     */
    public String getSlogen() {
        return slogen;
    }

    /**
     * 签名
     * @param slogen 签名
     */
    public void setSlogen(String slogen) {
        this.slogen = slogen == null ? null : slogen.trim();
    }

    /**
     * 登录策略 1: 一周 0:系统默认时间
     * @return login_strategy 登录策略 1: 一周 0:系统默认时间
     */
    public Integer getLoginStrategy() {
        return loginStrategy;
    }

    /**
     * 登录策略 1: 一周 0:系统默认时间
     * @param loginStrategy 登录策略 1: 一周 0:系统默认时间
     */
    public void setLoginStrategy(Integer loginStrategy) {
        this.loginStrategy = loginStrategy;
    }

    /**
     * 头像url
     * @return head_image_url 头像url
     */
    public String getHeadImageUrl() {
        return headImageUrl;
    }

    /**
     * 头像url
     * @param headImageUrl 头像url
     */
    public void setHeadImageUrl(String headImageUrl) {
        this.headImageUrl = headImageUrl == null ? null : headImageUrl.trim();
    }

    /**
     * 头像静态服务器数据库id
     * @return head_image_id 头像静态服务器数据库id
     */
    public String getHeadImageId() {
        return headImageId;
    }

    /**
     * 头像静态服务器数据库id
     * @param headImageId 头像静态服务器数据库id
     */
    public void setHeadImageId(String headImageId) {
        this.headImageId = headImageId == null ? null : headImageId.trim();
    }

    /**
     * 主题
     * @return theme 主题
     */
    public String getTheme() {
        return theme;
    }

    /**
     * 主题
     * @param theme 主题
     */
    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    /**
     * 主题id
     * @return theme_id 主题id
     */
    public Integer getThemeId() {
        return themeId;
    }

    /**
     * 主题id
     * @param themeId 主题id
     */
    public void setThemeId(Integer themeId) {
        this.themeId = themeId;
    }

    /**
     * 创建者(用户名)
     * @return creator 创建者(用户名)
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 创建者(用户名)
     * @param creator 创建者(用户名)
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * 创建者代码
     * @return creator_code 创建者代码
     */
    public String getCreatorCode() {
        return creatorCode;
    }

    /**
     * 创建者代码
     * @param creatorCode 创建者代码
     */
    public void setCreatorCode(String creatorCode) {
        this.creatorCode = creatorCode == null ? null : creatorCode.trim();
    }

    /**
     * 创建时间
     * @return gmt_created 创建时间
     */
    public Date getGmtCreated() {
        return gmtCreated;
    }

    /**
     * 创建时间
     * @param gmtCreated 创建时间
     */
    public void setGmtCreated(Date gmtCreated) {
        this.gmtCreated = gmtCreated;
    }

    /**
     * 修改者(用户名)
     * @return modifier 修改者(用户名)
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 修改者(用户名)
     * @param modifier 修改者(用户名)
     */
    public void setModifier(String modifier) {
        this.modifier = modifier == null ? null : modifier.trim();
    }

    /**
     * 修改者代码
     * @return modifier_code 修改者代码
     */
    public String getModifierCode() {
        return modifierCode;
    }

    /**
     * 修改者代码
     * @param modifierCode 修改者代码
     */
    public void setModifierCode(String modifierCode) {
        this.modifierCode = modifierCode == null ? null : modifierCode.trim();
    }

    /**
     * 更新时间
     * @return gmt_modified 更新时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 更新时间
     * @param gmtModified 更新时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 中文姓名昵称
     * @return name_cn 中文姓名昵称
     */
    public String getNameCn() {
        return nameCn;
    }

    /**
     * 中文姓名昵称
     * @param nameCn 中文姓名昵称
     */
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    /**
     * 中文姓名全称
     * @return full_name_cn 中文姓名全称
     */
    public String getFullNameCn() {
        return fullNameCn;
    }

    /**
     * 中文姓名全称
     * @param fullNameCn 中文姓名全称
     */
    public void setFullNameCn(String fullNameCn) {
        this.fullNameCn = fullNameCn == null ? null : fullNameCn.trim();
    }

    /**
     * 英文姓名昵称
     * @return name_en 英文姓名昵称
     */
    public String getNameEn() {
        return nameEn;
    }

    /**
     * 英文姓名昵称
     * @param nameEn 英文姓名昵称
     */
    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    /**
     * 英文姓名全称
     * @return full_name_en 英文姓名全称
     */
    public String getFullNameEn() {
        return fullNameEn;
    }

    /**
     * 英文姓名全称
     * @param fullNameEn 英文姓名全称
     */
    public void setFullNameEn(String fullNameEn) {
        this.fullNameEn = fullNameEn == null ? null : fullNameEn.trim();
    }

    /**
     * 状态 1：启用 0：停用 -1 : 删除
     * @return status 状态 1：启用 0：停用 -1 : 删除
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态 1：启用 0：停用 -1 : 删除
     * @param status 状态 1：启用 0：停用 -1 : 删除
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备用
     * @return bak01 备用
     */
    public String getBak01() {
        return bak01;
    }

    /**
     * 备用
     * @param bak01 备用
     */
    public void setBak01(String bak01) {
        this.bak01 = bak01 == null ? null : bak01.trim();
    }

    /**
     * 备用
     * @return bak02 备用
     */
    public String getBak02() {
        return bak02;
    }

    /**
     * 备用
     * @param bak02 备用
     */
    public void setBak02(String bak02) {
        this.bak02 = bak02 == null ? null : bak02.trim();
    }

    /**
     * 备用
     * @return bak03 备用
     */
    public String getBak03() {
        return bak03;
    }

    /**
     * 备用
     * @param bak03 备用
     */
    public void setBak03(String bak03) {
        this.bak03 = bak03 == null ? null : bak03.trim();
    }

    /**
     * 备用
     * @return bak04 备用
     */
    public String getBak04() {
        return bak04;
    }

    /**
     * 备用
     * @param bak04 备用
     */
    public void setBak04(String bak04) {
        this.bak04 = bak04 == null ? null : bak04.trim();
    }

    /**
     * 备用
     * @return bak05 备用
     */
    public String getBak05() {
        return bak05;
    }

    /**
     * 备用
     * @param bak05 备用
     */
    public void setBak05(String bak05) {
        this.bak05 = bak05 == null ? null : bak05.trim();
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getPlatformId() {
        return platformId;
    }

    public void setPlatformId(String platformId) {
        this.platformId = platformId;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getSalesmanId() {
        return salesmanId;
    }

    public void setSalesmanId(String salesmanId) {
        this.salesmanId = salesmanId;
    }
}
package com.dolphin422.system.model.user;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "sys_user")
public class SysUserModel {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 登录帐号
     */
    @Column(name = "login_account")
    private String loginAccount;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户名称
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 性别
     */
    private Boolean gender;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 级别
     */
    private Boolean level;

    /**
     * 生日
     */
    private String birthday;

    /**
     * 个性签名
     */
    @Column(name = "personal_signature")
    private String personalSignature;

    /**
     * 移动电话
     */
    @Column(name = "mobile_phone")
    private String mobilePhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 应用id
     */
    @Column(name = "app_id")
    private String appId;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标识
     */
    @Column(name = "is_deleted")
    private Boolean isDeleted;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取登录帐号
     *
     * @return login_account - 登录帐号
     */
    public String getLoginAccount() {
        return loginAccount;
    }

    /**
     * 设置登录帐号
     *
     * @param loginAccount 登录帐号
     */
    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取用户名称
     *
     * @return user_name - 用户名称
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名称
     *
     * @param userName 用户名称
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取昵称
     *
     * @return nickname - 昵称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置昵称
     *
     * @param nickname 昵称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    /**
     * 获取性别
     *
     * @return gender - 性别
     */
    public Boolean getGender() {
        return gender;
    }

    /**
     * 设置性别
     *
     * @param gender 性别
     */
    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    /**
     * 获取状态
     *
     * @return status - 状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取级别
     *
     * @return level - 级别
     */
    public Boolean getLevel() {
        return level;
    }

    /**
     * 设置级别
     *
     * @param level 级别
     */
    public void setLevel(Boolean level) {
        this.level = level;
    }

    /**
     * 获取生日
     *
     * @return birthday - 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 设置生日
     *
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取个性签名
     *
     * @return personal_signature - 个性签名
     */
    public String getPersonalSignature() {
        return personalSignature;
    }

    /**
     * 设置个性签名
     *
     * @param personalSignature 个性签名
     */
    public void setPersonalSignature(String personalSignature) {
        this.personalSignature = personalSignature;
    }

    /**
     * 获取移动电话
     *
     * @return mobile_phone - 移动电话
     */
    public String getMobilePhone() {
        return mobilePhone;
    }

    /**
     * 设置移动电话
     *
     * @param mobilePhone 移动电话
     */
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    /**
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取应用id
     *
     * @return app_id - 应用id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用id
     *
     * @param appId 应用id
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * 获取删除标识
     *
     * @return is_deleted - 删除标识
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * 设置删除标识
     *
     * @param isDeleted 删除标识
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * 获取创建时间
     *
     * @return gmt_create - 创建时间
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * 设置创建时间
     *
     * @param gmtCreate 创建时间
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * 获取创建者
     *
     * @return creator - 创建者
     */
    public String getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(String creator) {
        this.creator = creator;
    }

    /**
     * 获取修改时间
     *
     * @return gmt_modified - 修改时间
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * 设置修改时间
     *
     * @param gmtModified 修改时间
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    /**
     * 获取修改者
     *
     * @return modifier - 修改者
     */
    public String getModifier() {
        return modifier;
    }

    /**
     * 设置修改者
     *
     * @param modifier 修改者
     */
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", loginAccount=").append(loginAccount);
        sb.append(", password=").append(password);
        sb.append(", userName=").append(userName);
        sb.append(", nickname=").append(nickname);
        sb.append(", gender=").append(gender);
        sb.append(", status=").append(status);
        sb.append(", level=").append(level);
        sb.append(", birthday=").append(birthday);
        sb.append(", personalSignature=").append(personalSignature);
        sb.append(", mobilePhone=").append(mobilePhone);
        sb.append(", email=").append(email);
        sb.append(", appId=").append(appId);
        sb.append(", remark=").append(remark);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", creator=").append(creator);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", modifier=").append(modifier);
        sb.append("]");
        return sb.toString();
    }
}

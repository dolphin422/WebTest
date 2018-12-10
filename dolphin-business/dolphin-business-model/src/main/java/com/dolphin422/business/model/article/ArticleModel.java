package com.dolphin422.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ar_article")
public class ArticleModel {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 文章标题
     */
    private String title;

    /**
     * 摘要
     */
    private String abstract;

    /**
     * 内容ID
     */
    @Column(name = "content_id")
    private String contentId;

    /**
     * 所属用户ID
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * 状态( 0 草稿, 1发布)
     */
    private Boolean status;

    /**
     * 文章来源(0原创 1转载)
     */
    @Column(name = "article_source")
    private Boolean articleSource;

    /**
     * 阅读量
     */
    @Column(name = "click_rate")
    private Integer clickRate;

    /**
     * 文章访问权限(0 public ; 1 private)
     */
    private Boolean permission;

    /**
     * 应用ID
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
     * 创建者
     */
    private String creater;

    /**
     * 创建时间
     */
    @Column(name = "gmt_create")
    private Date gmtCreate;

    /**
     * 修改者
     */
    private String modifier;

    /**
     * 修改时间
     */
    @Column(name = "gmt_modified")
    private Date gmtModified;

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
     * 获取文章标题
     *
     * @return title - 文章标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置文章标题
     *
     * @param title 文章标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取摘要
     *
     * @return abstract - 摘要
     */
    public String getAbstract() {
        return abstract;
    }

    /**
     * 设置摘要
     *
     * @param abstract 摘要
     */
    public void setAbstract(String abstract) {
        this.abstract = abstract;
    }

    /**
     * 获取内容ID
     *
     * @return content_id - 内容ID
     */
    public String getContentId() {
        return contentId;
    }

    /**
     * 设置内容ID
     *
     * @param contentId 内容ID
     */
    public void setContentId(String contentId) {
        this.contentId = contentId;
    }

    /**
     * 获取所属用户ID
     *
     * @return user_id - 所属用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置所属用户ID
     *
     * @param userId 所属用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取状态( 0 草稿, 1发布)
     *
     * @return status - 状态( 0 草稿, 1发布)
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态( 0 草稿, 1发布)
     *
     * @param status 状态( 0 草稿, 1发布)
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取文章来源(0原创 1转载)
     *
     * @return article_source - 文章来源(0原创 1转载)
     */
    public Boolean getArticleSource() {
        return articleSource;
    }

    /**
     * 设置文章来源(0原创 1转载)
     *
     * @param articleSource 文章来源(0原创 1转载)
     */
    public void setArticleSource(Boolean articleSource) {
        this.articleSource = articleSource;
    }

    /**
     * 获取阅读量
     *
     * @return click_rate - 阅读量
     */
    public Integer getClickRate() {
        return clickRate;
    }

    /**
     * 设置阅读量
     *
     * @param clickRate 阅读量
     */
    public void setClickRate(Integer clickRate) {
        this.clickRate = clickRate;
    }

    /**
     * 获取文章访问权限(0 public ; 1 private)
     *
     * @return permission - 文章访问权限(0 public ; 1 private)
     */
    public Boolean getPermission() {
        return permission;
    }

    /**
     * 设置文章访问权限(0 public ; 1 private)
     *
     * @param permission 文章访问权限(0 public ; 1 private)
     */
    public void setPermission(Boolean permission) {
        this.permission = permission;
    }

    /**
     * 获取应用ID
     *
     * @return app_id - 应用ID
     */
    public String getAppId() {
        return appId;
    }

    /**
     * 设置应用ID
     *
     * @param appId 应用ID
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
     * 获取创建者
     *
     * @return creater - 创建者
     */
    public String getCreater() {
        return creater;
    }

    /**
     * 设置创建者
     *
     * @param creater 创建者
     */
    public void setCreater(String creater) {
        this.creater = creater;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", title=").append(title);
        sb.append(", abstract=").append(abstract);
        sb.append(", contentId=").append(contentId);
        sb.append(", userId=").append(userId);
        sb.append(", status=").append(status);
        sb.append(", articleSource=").append(articleSource);
        sb.append(", clickRate=").append(clickRate);
        sb.append(", permission=").append(permission);
        sb.append(", appId=").append(appId);
        sb.append(", remark=").append(remark);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", creater=").append(creater);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", modifier=").append(modifier);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append("]");
        return sb.toString();
    }
}
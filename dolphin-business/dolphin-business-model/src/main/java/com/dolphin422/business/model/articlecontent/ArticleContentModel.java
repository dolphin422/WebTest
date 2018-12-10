package com.dolphin422.generator.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "ar_article_content")
public class ArticleContentModel {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 文章ID
     */
    @Column(name = "article_id")
    private String articleId;

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
     * 具体内容
     */
    @Column(name = "article_content")
    private String articleContent;

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
     * 获取文章ID
     *
     * @return article_id - 文章ID
     */
    public String getArticleId() {
        return articleId;
    }

    /**
     * 设置文章ID
     *
     * @param articleId 文章ID
     */
    public void setArticleId(String articleId) {
        this.articleId = articleId;
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

    /**
     * 获取具体内容
     *
     * @return article_content - 具体内容
     */
    public String getArticleContent() {
        return articleContent;
    }

    /**
     * 设置具体内容
     *
     * @param articleContent 具体内容
     */
    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", articleId=").append(articleId);
        sb.append(", appId=").append(appId);
        sb.append(", remark=").append(remark);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", creater=").append(creater);
        sb.append(", gmtCreate=").append(gmtCreate);
        sb.append(", modifier=").append(modifier);
        sb.append(", gmtModified=").append(gmtModified);
        sb.append(", articleContent=").append(articleContent);
        sb.append("]");
        return sb.toString();
    }
}
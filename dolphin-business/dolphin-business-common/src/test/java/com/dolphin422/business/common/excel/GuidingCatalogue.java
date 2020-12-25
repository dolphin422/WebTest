package com.dolphin422.business.common.excel;


import java.io.Serializable;

/**
 * @author DamonJT WIN
 * @description
 * @createDate 2019-11-12 16:17
 */
public class GuidingCatalogue implements Serializable {

    private static final long serialVersionUID = 2104663211961895500L;
    /**
     * 目录id
     */
    private String catalogGuid;


    private String regionGuid;

    private String regionCode;

    private Integer year;

    /**
     * 购买主体
     */
    private String purSubjectGuid;

    private String purSubjectCode;

    private String purSubjectName;

    /**
     * 目录层级节点
     */
    private String catalogNode;

    private String catalogCode;

    private String catalogName;

    private Integer leafNode;

    private String fatherCatalogGuid;

    private String fatherCatalogCode;

    private String fatherCatalogName;

    private String startDate;

    private String endDate;

    private String catalogTotalCount;

    /**
     * 目录说明
     */
    private String catalogExplain;

    private String remark;

    private String createUserGuid;

    private String createUser;

    //private java.util.Date createDate;

    private String modiUserGuid;

    private String modiUser;

    //private java.util.Date modiDate;

    private Integer catalogCodeOrder;

    public String getCatalogGuid() {
        return catalogGuid;
    }

    public void setCatalogGuid(String catalogGuid) {
        this.catalogGuid = catalogGuid;
    }

    public String getRegionGuid() {
        return regionGuid;
    }

    public void setRegionGuid(String regionGuid) {
        this.regionGuid = regionGuid;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getPurSubjectGuid() {
        return purSubjectGuid;
    }

    public void setPurSubjectGuid(String purSubjectGuid) {
        this.purSubjectGuid = purSubjectGuid;
    }

    public String getPurSubjectCode() {
        return purSubjectCode;
    }

    public void setPurSubjectCode(String purSubjectCode) {
        this.purSubjectCode = purSubjectCode;
    }

    public String getPurSubjectName() {
        return purSubjectName;
    }

    public void setPurSubjectName(String purSubjectName) {
        this.purSubjectName = purSubjectName;
    }

    public String getCatalogNode() {
        return catalogNode;
    }

    public void setCatalogNode(String catalogNode) {
        this.catalogNode = catalogNode;
    }

    public String getCatalogCode() {
        return catalogCode;
    }

    public void setCatalogCode(String catalogCode) {
        this.catalogCode = catalogCode;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public Integer getLeafNode() {
        return leafNode;
    }

    public void setLeafNode(Integer leafNode) {
        this.leafNode = leafNode;
    }

    public String getFatherCatalogGuid() {
        return fatherCatalogGuid;
    }

    public void setFatherCatalogGuid(String fatherCatalogGuid) {
        this.fatherCatalogGuid = fatherCatalogGuid;
    }

    public String getFatherCatalogCode() {
        return fatherCatalogCode;
    }

    public void setFatherCatalogCode(String fatherCatalogCode) {
        this.fatherCatalogCode = fatherCatalogCode;
    }

    public String getFatherCatalogName() {
        return fatherCatalogName;
    }

    public void setFatherCatalogName(String fatherCatalogName) {
        this.fatherCatalogName = fatherCatalogName;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCatalogTotalCount() {
        return catalogTotalCount;
    }

    public void setCatalogTotalCount(String catalogTotalCount) {
        this.catalogTotalCount = catalogTotalCount;
    }

    public String getCatalogExplain() {
        return catalogExplain;
    }

    public void setCatalogExplain(String catalogExplain) {
        this.catalogExplain = catalogExplain;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getCreateUserGuid() {
        return createUserGuid;
    }

    public void setCreateUserGuid(String createUserGuid) {
        this.createUserGuid = createUserGuid;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getModiUserGuid() {
        return modiUserGuid;
    }

    public void setModiUserGuid(String modiUserGuid) {
        this.modiUserGuid = modiUserGuid;
    }

    public String getModiUser() {
        return modiUser;
    }

    public void setModiUser(String modiUser) {
        this.modiUser = modiUser;
    }

    public Integer getCatalogCodeOrder() {
        return catalogCodeOrder;
    }

    public void setCatalogCodeOrder(Integer catalogCodeOrder) {
        this.catalogCodeOrder = catalogCodeOrder;
    }

    @Override
    public String toString() {
        return "GuidingCatalogue{" +
            "catalogGuid='" + catalogGuid + '\'' +
            ", regionGuid='" + regionGuid + '\'' +
            ", regionCode='" + regionCode + '\'' +
            ", year=" + year +
            ", purSubjectGuid='" + purSubjectGuid + '\'' +
            ", purSubjectCode='" + purSubjectCode + '\'' +
            ", purSubjectName='" + purSubjectName + '\'' +
            ", catalogNode='" + catalogNode + '\'' +
            ", catalogCode='" + catalogCode + '\'' +
            ", catalogName='" + catalogName + '\'' +
            ", leafNode=" + leafNode +
            ", fatherCatalogGuid='" + fatherCatalogGuid + '\'' +
            ", fatherCatalogCode='" + fatherCatalogCode + '\'' +
            ", fatherCatalogName='" + fatherCatalogName + '\'' +
            ", startDate='" + startDate + '\'' +
            ", endDate='" + endDate + '\'' +
            ", catalogTotalCount='" + catalogTotalCount + '\'' +
            ", catalogExplain='" + catalogExplain + '\'' +
            ", remark='" + remark + '\'' +
            ", createUserGuid='" + createUserGuid + '\'' +
            ", createUser='" + createUser + '\'' +
            ", modiUserGuid='" + modiUserGuid + '\'' +
            ", modiUser='" + modiUser + '\'' +
            ", catalogCodeOrder=" + catalogCodeOrder +
            '}';
    }
}

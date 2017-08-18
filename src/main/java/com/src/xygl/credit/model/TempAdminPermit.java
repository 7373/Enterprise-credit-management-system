/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_admin_permit 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_admin_permit")
public class TempAdminPermit implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 行政许可决定书文号
     */
    @Column(name = "AdminDocNO")
    private String adminDocNO;

    /**
     * 项目名称
     */
    @Column(name = "ProjectName")
    private String projectName;

    /**
     * 审批类别
     */
    @Column(name = "CheckType")
    private String checkType;

    /**
     * 行政相对人名称
     */
    @Column(name = "AdminCounterpartName")
    private String adminCounterpartName;

    /**
     * 许可内容
     */
    @Column(name = "LicenceContent")
    private String licenceContent;

    /**
     * 许可决定日期
     */
    @Column(name = "LicenceDecideDate")
    private Date licenceDecideDate;

    /**
     * 许可截止日期
     */
    @Column(name = "LicenceEndDate")
    private Date licenceEndDate;

    /**
     * 许可机关
     */
    @Column(name = "LicenceUnit")
    private String licenceUnit;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    /**
     * 批次号
     */
    @Column(name = "BatchNO")
    private String batchNO;

    /**
     * 0:未删除，1:已删除
     */
    @Column(name = "IsUse")
    private String isUse;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取行政许可决定书文号
     *
     * @return AdminDocNO - 行政许可决定书文号
     */
    public String getAdminDocNO() {
        return adminDocNO;
    }

    /**
     * 设置行政许可决定书文号
     *
     * @param adminDocNO 行政许可决定书文号
     */
    public void setAdminDocNO(String adminDocNO) {
        this.adminDocNO = adminDocNO;
    }

    /**
     * 获取项目名称
     *
     * @return ProjectName - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取审批类别
     *
     * @return CheckType - 审批类别
     */
    public String getCheckType() {
        return checkType;
    }

    /**
     * 设置审批类别
     *
     * @param checkType 审批类别
     */
    public void setCheckType(String checkType) {
        this.checkType = checkType;
    }

    /**
     * 获取行政相对人名称
     *
     * @return AdminCounterpartName - 行政相对人名称
     */
    public String getAdminCounterpartName() {
        return adminCounterpartName;
    }

    /**
     * 设置行政相对人名称
     *
     * @param adminCounterpartName 行政相对人名称
     */
    public void setAdminCounterpartName(String adminCounterpartName) {
        this.adminCounterpartName = adminCounterpartName;
    }

    /**
     * 获取许可内容
     *
     * @return LicenceContent - 许可内容
     */
    public String getLicenceContent() {
        return licenceContent;
    }

    /**
     * 设置许可内容
     *
     * @param licenceContent 许可内容
     */
    public void setLicenceContent(String licenceContent) {
        this.licenceContent = licenceContent;
    }

    /**
     * 获取许可决定日期
     *
     * @return LicenceDecideDate - 许可决定日期
     */
    public Date getLicenceDecideDate() {
        return licenceDecideDate;
    }

    /**
     * 设置许可决定日期
     *
     * @param licenceDecideDate 许可决定日期
     */
    public void setLicenceDecideDate(Date licenceDecideDate) {
        this.licenceDecideDate = licenceDecideDate;
    }

    /**
     * 获取许可截止日期
     *
     * @return LicenceEndDate - 许可截止日期
     */
    public Date getLicenceEndDate() {
        return licenceEndDate;
    }

    /**
     * 设置许可截止日期
     *
     * @param licenceEndDate 许可截止日期
     */
    public void setLicenceEndDate(Date licenceEndDate) {
        this.licenceEndDate = licenceEndDate;
    }

    /**
     * 获取许可机关
     *
     * @return LicenceUnit - 许可机关
     */
    public String getLicenceUnit() {
        return licenceUnit;
    }

    /**
     * 设置许可机关
     *
     * @param licenceUnit 许可机关
     */
    public void setLicenceUnit(String licenceUnit) {
        this.licenceUnit = licenceUnit;
    }

    /**
     * @return ImportDept
     */
    public String getImportDept() {
        return importDept;
    }

    /**
     * @param importDept
     */
    public void setImportDept(String importDept) {
        this.importDept = importDept;
    }

    /**
     * @return ImportTime
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * @param importTime
     */
    public void setImportTime(Date importTime) {
        this.importTime = importTime;
    }

    /**
     * 获取批次号
     *
     * @return BatchNO - 批次号
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * 设置批次号
     *
     * @param batchNO 批次号
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    /**
     * 获取0:未删除，1:已删除
     *
     * @return IsUse - 0:未删除，1:已删除
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * 设置0:未删除，1:已删除
     *
     * @param isUse 0:未删除，1:已删除
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
}
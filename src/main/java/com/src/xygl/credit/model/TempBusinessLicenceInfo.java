/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  temp_business_licence_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_business_licence_info")
public class TempBusinessLicenceInfo implements Serializable {
	
	@Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 业户名称
     */
    @Column(name = "OwnerName")
    private String ownerName;

    /**
     * 社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 经营许可证书
     */
    @Column(name = "BusinessLicence")
    private String businessLicence;

    /**
     * 法人代表
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 注册地址
     */
    @Column(name = "RegistAddr")
    private String registAddr;

    /**
     * 经营资质
     */
    @Column(name = "ManageQualify")
    private String manageQualify;

    /**
     * 注册日期（开业）
     */
    @Column(name = "RegistDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date registDate;

    /**
     * 有效期起
     */
    @Column(name = "ValidTermStart")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date validTermStart;

    /**
     * 有效期止
     */
    @Column(name = "ValidTermEnd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date validTermEnd;

    /**
     * 经营范围
     */
    @Column(name = "ManageRange")
    private String manageRange;

    /**
     * 1:客运经营许可信息,2:货运经营许可信息,3:出租车经营许可信息,4:场站经营许可信息
     */
    @Column(name = "LicenceType")
    private String licenceType;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

    /**
     * 0:未删除  1：删除
     */
    @Column(name = "IsUse")
    private String isUse;

    private static final long serialVersionUID = 1L;


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
     * 获取业户名称
     *
     * @return OwnerName - 业户名称
     */
    public String getOwnerName() {
        return ownerName;
    }

    /**
     * 设置业户名称
     *
     * @param ownerName 业户名称
     */
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    /**
     * 获取社会信用代码/组织机构代码/工商注册号
     *
     * @return Unicode - 社会信用代码/组织机构代码/工商注册号
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置社会信用代码/组织机构代码/工商注册号
     *
     * @param unicode 社会信用代码/组织机构代码/工商注册号
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取经营许可证书
     *
     * @return BusinessLicence - 经营许可证书
     */
    public String getBusinessLicence() {
        return businessLicence;
    }

    /**
     * 设置经营许可证书
     *
     * @param businessLicence 经营许可证书
     */
    public void setBusinessLicence(String businessLicence) {
        this.businessLicence = businessLicence;
    }

    /**
     * 获取法人代表
     *
     * @return LegalPerson - 法人代表
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法人代表
     *
     * @param legalPerson 法人代表
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取注册地址
     *
     * @return RegistAddr - 注册地址
     */
    public String getRegistAddr() {
        return registAddr;
    }

    /**
     * 设置注册地址
     *
     * @param registAddr 注册地址
     */
    public void setRegistAddr(String registAddr) {
        this.registAddr = registAddr;
    }

    /**
     * 获取经营资质
     *
     * @return ManageQualify - 经营资质
     */
    public String getManageQualify() {
        return manageQualify;
    }

    /**
     * 设置经营资质
     *
     * @param manageQualify 经营资质
     */
    public void setManageQualify(String manageQualify) {
        this.manageQualify = manageQualify;
    }

    /**
     * 获取注册日期（开业）
     *
     * @return RegistDate - 注册日期（开业）
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * 设置注册日期（开业）
     *
     * @param registDate 注册日期（开业）
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    /**
     * 获取有效期起
     *
     * @return ValidTermStart - 有效期起
     */
    public Date getValidTermStart() {
        return validTermStart;
    }

    /**
     * 设置有效期起
     *
     * @param validTermStart 有效期起
     */
    public void setValidTermStart(Date validTermStart) {
        this.validTermStart = validTermStart;
    }

    /**
     * 获取有效期止
     *
     * @return ValidTermEnd - 有效期止
     */
    public Date getValidTermEnd() {
        return validTermEnd;
    }

    /**
     * 设置有效期止
     *
     * @param validTermEnd 有效期止
     */
    public void setValidTermEnd(Date validTermEnd) {
        this.validTermEnd = validTermEnd;
    }

    /**
     * 获取经营范围
     *
     * @return ManageRange - 经营范围
     */
    public String getManageRange() {
        return manageRange;
    }

    /**
     * 设置经营范围
     *
     * @param manageRange 经营范围
     */
    public void setManageRange(String manageRange) {
        this.manageRange = manageRange;
    }

    /**
     * 获取1:客运经营许可信息,2:货运经营许可信息,3:出租车经营许可信息,4:场站经营许可信息
     *
     * @return LicenceType - 1:客运经营许可信息,2:货运经营许可信息,3:出租车经营许可信息,4:场站经营许可信息
     */
    public String getLicenceType() {
        return licenceType;
    }

    /**
     * 设置1:客运经营许可信息,2:货运经营许可信息,3:出租车经营许可信息,4:场站经营许可信息
     *
     * @param licenceType 1:客运经营许可信息,2:货运经营许可信息,3:出租车经营许可信息,4:场站经营许可信息
     */
    public void setLicenceType(String licenceType) {
        this.licenceType = licenceType;
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
     * @return BatchNO
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * @param batchNO
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
    }

    /**
     * 获取0:未删除  1：删除
     *
     * @return IsUse - 0:未删除  1：删除
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * 设置0:未删除  1：删除
     *
     * @param isUse 0:未删除  1：删除
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
}
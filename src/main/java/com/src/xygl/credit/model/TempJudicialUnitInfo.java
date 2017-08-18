/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_judicial_unit_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_judicial_unit_info")
public class TempJudicialUnitInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 机构名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 执业许可证号码
     */
    @Column(name = "LicenceNO")
    private String licenceNO;

    /**
     * 社会信用代码/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 负责人/法人代表
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 主要职能
     */
    @Column(name = "MainFunction")
    private String mainFunction;

    /**
     * 机构地址
     */
    @Column(name = "UnitAddr")
    private String unitAddr;

    /**
     * 0:基层法律服务所信息,1:律师事务所信息,2:公证机构基本信息
     */
    @Column(name = "UnitType")
    private String unitType;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

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
     * 获取机构名称
     *
     * @return UnitName - 机构名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置机构名称
     *
     * @param unitName 机构名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取执业许可证号码
     *
     * @return LicenceNO - 执业许可证号码
     */
    public String getLicenceNO() {
        return licenceNO;
    }

    /**
     * 设置执业许可证号码
     *
     * @param licenceNO 执业许可证号码
     */
    public void setLicenceNO(String licenceNO) {
        this.licenceNO = licenceNO;
    }

    /**
     * 获取社会信用代码/组织机构代码
     *
     * @return Unicode - 社会信用代码/组织机构代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置社会信用代码/组织机构代码
     *
     * @param unicode 社会信用代码/组织机构代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取负责人/法人代表
     *
     * @return LegalPerson - 负责人/法人代表
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置负责人/法人代表
     *
     * @param legalPerson 负责人/法人代表
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取主要职能
     *
     * @return MainFunction - 主要职能
     */
    public String getMainFunction() {
        return mainFunction;
    }

    /**
     * 设置主要职能
     *
     * @param mainFunction 主要职能
     */
    public void setMainFunction(String mainFunction) {
        this.mainFunction = mainFunction;
    }

    /**
     * 获取机构地址
     *
     * @return UnitAddr - 机构地址
     */
    public String getUnitAddr() {
        return unitAddr;
    }

    /**
     * 设置机构地址
     *
     * @param unitAddr 机构地址
     */
    public void setUnitAddr(String unitAddr) {
        this.unitAddr = unitAddr;
    }

    /**
     * 获取0:基层法律服务所信息,1:律师事务所信息,2:公证机构基本信息
     *
     * @return UnitType - 0:基层法律服务所信息,1:律师事务所信息,2:公证机构基本信息
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * 设置0:基层法律服务所信息,1:律师事务所信息,2:公证机构基本信息
     *
     * @param unitType 0:基层法律服务所信息,1:律师事务所信息,2:公证机构基本信息
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType;
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
     * @return IsUse
     */
    public String getIsUse() {
        return isUse;
    }

    /**
     * @param isUse
     */
    public void setIsUse(String isUse) {
        this.isUse = isUse;
    }
}
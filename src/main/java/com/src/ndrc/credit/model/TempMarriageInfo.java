/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_marriage_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_marriage_info")
public class TempMarriageInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 民政局内码
     */
    @Column(name = "CivilAdminUnitCode")
    private String civilAdminUnitCode;

    /**
     * 男方姓名
     */
    @Column(name = "ManName")
    private String manName;

    /**
     * 男方证件类型
     */
    @Column(name = "ManCertType")
    private String manCertType;

    /**
     * 男方证件号码
     */
    @Column(name = "manCertNO")
    private String manCertNO;

    /**
     * 男方常驻户口所在地
     */
    @Column(name = "ManResidenceLoc")
    private String manResidenceLoc;

    /**
     * 女方姓名
     */
    @Column(name = "WoManName")
    private String woManName;

    /**
     * 女方证件类别
     */
    @Column(name = "WoManCertType")
    private String woManCertType;

    /**
     * 女方证件号码
     */
    @Column(name = "WoManCertNO")
    private String woManCertNO;

    /**
     * 女方常驻户口所在地
     */
    @Column(name = "WoManResidenceLoc")
    private String woManResidenceLoc;

    /**
     * 登记日期
     */
    @Column(name = "RegistDate")
    private Date registDate;

    /**
     * 证字号
     */
    @Column(name = "CertNum")
    private String certNum;

    /**
     * 承办机构
     */
    @Column(name = "UndertakeUnit")
    private String undertakeUnit;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

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
     * 获取民政局内码
     *
     * @return CivilAdminUnitCode - 民政局内码
     */
    public String getCivilAdminUnitCode() {
        return civilAdminUnitCode;
    }

    /**
     * 设置民政局内码
     *
     * @param civilAdminUnitCode 民政局内码
     */
    public void setCivilAdminUnitCode(String civilAdminUnitCode) {
        this.civilAdminUnitCode = civilAdminUnitCode;
    }

    /**
     * 获取男方姓名
     *
     * @return ManName - 男方姓名
     */
    public String getManName() {
        return manName;
    }

    /**
     * 设置男方姓名
     *
     * @param manName 男方姓名
     */
    public void setManName(String manName) {
        this.manName = manName;
    }

    /**
     * 获取男方证件类型
     *
     * @return ManCertType - 男方证件类型
     */
    public String getManCertType() {
        return manCertType;
    }

    /**
     * 设置男方证件类型
     *
     * @param manCertType 男方证件类型
     */
    public void setManCertType(String manCertType) {
        this.manCertType = manCertType;
    }

    /**
     * 获取男方证件号码
     *
     * @return manCertNO - 男方证件号码
     */
    public String getManCertNO() {
        return manCertNO;
    }

    /**
     * 设置男方证件号码
     *
     * @param manCertNO 男方证件号码
     */
    public void setManCertNO(String manCertNO) {
        this.manCertNO = manCertNO;
    }

    /**
     * 获取男方常驻户口所在地
     *
     * @return ManResidenceLoc - 男方常驻户口所在地
     */
    public String getManResidenceLoc() {
        return manResidenceLoc;
    }

    /**
     * 设置男方常驻户口所在地
     *
     * @param manResidenceLoc 男方常驻户口所在地
     */
    public void setManResidenceLoc(String manResidenceLoc) {
        this.manResidenceLoc = manResidenceLoc;
    }

    /**
     * 获取女方姓名
     *
     * @return WoManName - 女方姓名
     */
    public String getWoManName() {
        return woManName;
    }

    /**
     * 设置女方姓名
     *
     * @param woManName 女方姓名
     */
    public void setWoManName(String woManName) {
        this.woManName = woManName;
    }

    /**
     * 获取女方证件类别
     *
     * @return WoManCertType - 女方证件类别
     */
    public String getWoManCertType() {
        return woManCertType;
    }

    /**
     * 设置女方证件类别
     *
     * @param woManCertType 女方证件类别
     */
    public void setWoManCertType(String woManCertType) {
        this.woManCertType = woManCertType;
    }

    /**
     * 获取女方证件号码
     *
     * @return WoManCertNO - 女方证件号码
     */
    public String getWoManCertNO() {
        return woManCertNO;
    }

    /**
     * 设置女方证件号码
     *
     * @param woManCertNO 女方证件号码
     */
    public void setWoManCertNO(String woManCertNO) {
        this.woManCertNO = woManCertNO;
    }

    /**
     * 获取女方常驻户口所在地
     *
     * @return WoManResidenceLoc - 女方常驻户口所在地
     */
    public String getWoManResidenceLoc() {
        return woManResidenceLoc;
    }

    /**
     * 设置女方常驻户口所在地
     *
     * @param woManResidenceLoc 女方常驻户口所在地
     */
    public void setWoManResidenceLoc(String woManResidenceLoc) {
        this.woManResidenceLoc = woManResidenceLoc;
    }

    /**
     * 获取登记日期
     *
     * @return RegistDate - 登记日期
     */
    public Date getRegistDate() {
        return registDate;
    }

    /**
     * 设置登记日期
     *
     * @param registDate 登记日期
     */
    public void setRegistDate(Date registDate) {
        this.registDate = registDate;
    }

    /**
     * 获取证字号
     *
     * @return CertNum - 证字号
     */
    public String getCertNum() {
        return certNum;
    }

    /**
     * 设置证字号
     *
     * @param certNum 证字号
     */
    public void setCertNum(String certNum) {
        this.certNum = certNum;
    }

    /**
     * 获取承办机构
     *
     * @return UndertakeUnit - 承办机构
     */
    public String getUndertakeUnit() {
        return undertakeUnit;
    }

    /**
     * 设置承办机构
     *
     * @param undertakeUnit 承办机构
     */
    public void setUndertakeUnit(String undertakeUnit) {
        this.undertakeUnit = undertakeUnit;
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
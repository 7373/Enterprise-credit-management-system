/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_many_qy_base_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_many_qy_base_info")
public class TempManyQyBaseInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * uid
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 企业名称
     */
    @Column(name = "QyName")
    private String qyName;

    /**
     * 社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 法人代表
     */
    @Column(name = "LegalPersonName")
    private String legalPersonName;

    /**
     * 地址
     */
    @Column(name = "Addr")
    private String addr;

    /**
     * 邮政编码
     */
    @Column(name = "ZipCode")
    private String zipCode;

    /**
     * 企业资质等级
     */
    @Column(name = "QualifyLevel")
    private String qualifyLevel;

    /**
     * 资质证书编号
     */
    @Column(name = "QualifyNo")
    private String qualifyNo;

    /**
     * 有效期开始时间
     */
    @Column(name = "ValidityBegin")
    private Date validityBegin;

    /**
     * 有效期结束时间
     */
    @Column(name = "ValidtyEnd")
    private Date validtyEnd;

    /**
     * 导入部门
     */
    @Column(name = "ImportDept")
    private String importDept;

    /**
     * 导入日期
     */
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
     * 获取uid
     *
     * @return uid - uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置uid
     *
     * @param uid uid
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取企业名称
     *
     * @return QyName - 企业名称
     */
    public String getQyName() {
        return qyName;
    }

    /**
     * 设置企业名称
     *
     * @param qyName 企业名称
     */
    public void setQyName(String qyName) {
        this.qyName = qyName;
    }

    /**
     * 获取社会信用代码/组织机构代码/工商注册号
     *
     * @return Uniscid - 社会信用代码/组织机构代码/工商注册号
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置社会信用代码/组织机构代码/工商注册号
     *
     * @param uniscid 社会信用代码/组织机构代码/工商注册号
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取法人代表
     *
     * @return LegalPersonName - 法人代表
     */
    public String getLegalPersonName() {
        return legalPersonName;
    }

    /**
     * 设置法人代表
     *
     * @param legalPersonName 法人代表
     */
    public void setLegalPersonName(String legalPersonName) {
        this.legalPersonName = legalPersonName;
    }

    /**
     * 获取地址
     *
     * @return Addr - 地址
     */
    public String getAddr() {
        return addr;
    }

    /**
     * 设置地址
     *
     * @param addr 地址
     */
    public void setAddr(String addr) {
        this.addr = addr;
    }

    /**
     * 获取邮政编码
     *
     * @return ZipCode - 邮政编码
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮政编码
     *
     * @param zipCode 邮政编码
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取企业资质等级
     *
     * @return QualifyLevel - 企业资质等级
     */
    public String getQualifyLevel() {
        return qualifyLevel;
    }

    /**
     * 设置企业资质等级
     *
     * @param qualifyLevel 企业资质等级
     */
    public void setQualifyLevel(String qualifyLevel) {
        this.qualifyLevel = qualifyLevel;
    }

    /**
     * 获取资质证书编号
     *
     * @return QualifyNo - 资质证书编号
     */
    public String getQualifyNo() {
        return qualifyNo;
    }

    /**
     * 设置资质证书编号
     *
     * @param qualifyNo 资质证书编号
     */
    public void setQualifyNo(String qualifyNo) {
        this.qualifyNo = qualifyNo;
    }

    /**
     * 获取有效期开始时间
     *
     * @return ValidityBegin - 有效期开始时间
     */
    public Date getValidityBegin() {
        return validityBegin;
    }

    /**
     * 设置有效期开始时间
     *
     * @param validityBegin 有效期开始时间
     */
    public void setValidityBegin(Date validityBegin) {
        this.validityBegin = validityBegin;
    }

    /**
     * 获取有效期结束时间
     *
     * @return ValidtyEnd - 有效期结束时间
     */
    public Date getValidtyEnd() {
        return validtyEnd;
    }

    /**
     * 设置有效期结束时间
     *
     * @param validtyEnd 有效期结束时间
     */
    public void setValidtyEnd(Date validtyEnd) {
        this.validtyEnd = validtyEnd;
    }

    /**
     * 获取导入部门
     *
     * @return ImportDept - 导入部门
     */
    public String getImportDept() {
        return importDept;
    }

    /**
     * 设置导入部门
     *
     * @param importDept 导入部门
     */
    public void setImportDept(String importDept) {
        this.importDept = importDept;
    }

    /**
     * 获取导入日期
     *
     * @return ImportTime - 导入日期
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * 设置导入日期
     *
     * @param importTime 导入日期
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
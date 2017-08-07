/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_finance_guarantee_company 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_finance_guarantee_company")
public class TempFinanceGuaranteeCompany implements Serializable {
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
     * 企业社会信用代码/工商注册号/组织机构代码
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 经营许可证
     */
    @Column(name = "BusinessLicense")
    private String businessLicense;

    /**
     * 注册资本
     */
    @Column(name = "RegisCapital")
    private String regisCapital;

    /**
     * 法定代表人
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 公司地址
     */
    @Column(name = "CompanyAddr")
    private String companyAddr;

    /**
     * 业务范围
     */
    @Column(name = "BusinessScope")
    private String businessScope;

    /**
     * 变更事项（法定代表、总经理、董事、监事等）
     */
    @Column(name = "ChangeMsg")
    private String changeMsg;

    /**
     * 信用等级
     */
    @Column(name = "CreditRate")
    private String creditRate;

    /**
     * 导入部门
     */
    @Column(name = "ImportDept")
    private String importDept;

    /**
     * 导入时间
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
     * 获取企业社会信用代码/工商注册号/组织机构代码
     *
     * @return Uniscid - 企业社会信用代码/工商注册号/组织机构代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置企业社会信用代码/工商注册号/组织机构代码
     *
     * @param uniscid 企业社会信用代码/工商注册号/组织机构代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取经营许可证
     *
     * @return BusinessLicense - 经营许可证
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置经营许可证
     *
     * @param businessLicense 经营许可证
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 获取注册资本
     *
     * @return RegisCapital - 注册资本
     */
    public String getRegisCapital() {
        return regisCapital;
    }

    /**
     * 设置注册资本
     *
     * @param regisCapital 注册资本
     */
    public void setRegisCapital(String regisCapital) {
        this.regisCapital = regisCapital;
    }

    /**
     * 获取法定代表人
     *
     * @return LegalPerson - 法定代表人
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人
     *
     * @param legalPerson 法定代表人
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取公司地址
     *
     * @return CompanyAddr - 公司地址
     */
    public String getCompanyAddr() {
        return companyAddr;
    }

    /**
     * 设置公司地址
     *
     * @param companyAddr 公司地址
     */
    public void setCompanyAddr(String companyAddr) {
        this.companyAddr = companyAddr;
    }

    /**
     * 获取业务范围
     *
     * @return BusinessScope - 业务范围
     */
    public String getBusinessScope() {
        return businessScope;
    }

    /**
     * 设置业务范围
     *
     * @param businessScope 业务范围
     */
    public void setBusinessScope(String businessScope) {
        this.businessScope = businessScope;
    }

    /**
     * 获取变更事项（法定代表、总经理、董事、监事等）
     *
     * @return ChangeMsg - 变更事项（法定代表、总经理、董事、监事等）
     */
    public String getChangeMsg() {
        return changeMsg;
    }

    /**
     * 设置变更事项（法定代表、总经理、董事、监事等）
     *
     * @param changeMsg 变更事项（法定代表、总经理、董事、监事等）
     */
    public void setChangeMsg(String changeMsg) {
        this.changeMsg = changeMsg;
    }

    /**
     * 获取信用等级
     *
     * @return CreditRate - 信用等级
     */
    public String getCreditRate() {
        return creditRate;
    }

    /**
     * 设置信用等级
     *
     * @param creditRate 信用等级
     */
    public void setCreditRate(String creditRate) {
        this.creditRate = creditRate;
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
     * 获取导入时间
     *
     * @return ImportTime - 导入时间
     */
    public Date getImportTime() {
        return importTime;
    }

    /**
     * 设置导入时间
     *
     * @param importTime 导入时间
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
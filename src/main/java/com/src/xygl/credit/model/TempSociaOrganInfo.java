/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_socia_organ_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_socia_organ_info")
public class TempSociaOrganInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 社会信用代码/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 登记证号
     */
    @Column(name = "RegistNO")
    private String registNO;

    /**
     * 单位名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 法定代表人(负责人)
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 法定代表人(负责人)身份证件号
     */
    @Column(name = "LegalPersonCertNO")
    private String legalPersonCertNO;

    /**
     * 注册地址
     */
    @Column(name = "RegistAddr")
    private String registAddr;

    /**
     * 电话号码
     */
    @Column(name = "Tel")
    private String tel;

    /**
     * 邮编
     */
    @Column(name = "ZipCode")
    private String zipCode;

    /**
     * 业务范围
     */
    @Column(name = "BusinessRange")
    private String businessRange;

    /**
     * 开办资金
     */
    @Column(name = "StartFund")
    private String startFund;

    /**
     * 发证日期
     */
    @Column(name = "IssueDate")
    private Date issueDate;

    /**
     * 是否注销
     */
    @Column(name = "IsCancel")
    private String isCancel;

    /**
     * 注销原因
     */
    @Column(name = "CancelReason")
    private String cancelReason;

    /**
     * 注销文件
     */
    @Column(name = "CancelFile")
    private String cancelFile;

    /**
     * 注销登记日期
     */
    @Column(name = "CancelRegistDate")
    private Date cancelRegistDate;

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
     * 获取登记证号
     *
     * @return RegistNO - 登记证号
     */
    public String getRegistNO() {
        return registNO;
    }

    /**
     * 设置登记证号
     *
     * @param registNO 登记证号
     */
    public void setRegistNO(String registNO) {
        this.registNO = registNO;
    }

    /**
     * 获取单位名称
     *
     * @return UnitName - 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名称
     *
     * @param unitName 单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取法定代表人(负责人)
     *
     * @return LegalPerson - 法定代表人(负责人)
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人(负责人)
     *
     * @param legalPerson 法定代表人(负责人)
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取法定代表人(负责人)身份证件号
     *
     * @return LegalPersonCertNO - 法定代表人(负责人)身份证件号
     */
    public String getLegalPersonCertNO() {
        return legalPersonCertNO;
    }

    /**
     * 设置法定代表人(负责人)身份证件号
     *
     * @param legalPersonCertNO 法定代表人(负责人)身份证件号
     */
    public void setLegalPersonCertNO(String legalPersonCertNO) {
        this.legalPersonCertNO = legalPersonCertNO;
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
     * 获取电话号码
     *
     * @return Tel - 电话号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置电话号码
     *
     * @param tel 电话号码
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * 获取邮编
     *
     * @return ZipCode - 邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     *
     * @param zipCode 邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * 获取业务范围
     *
     * @return BusinessRange - 业务范围
     */
    public String getBusinessRange() {
        return businessRange;
    }

    /**
     * 设置业务范围
     *
     * @param businessRange 业务范围
     */
    public void setBusinessRange(String businessRange) {
        this.businessRange = businessRange;
    }

    /**
     * 获取开办资金
     *
     * @return StartFund - 开办资金
     */
    public String getStartFund() {
        return startFund;
    }

    /**
     * 设置开办资金
     *
     * @param startFund 开办资金
     */
    public void setStartFund(String startFund) {
        this.startFund = startFund;
    }

    /**
     * 获取发证日期
     *
     * @return IssueDate - 发证日期
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * 设置发证日期
     *
     * @param issueDate 发证日期
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * 获取是否注销
     *
     * @return IsCancel - 是否注销
     */
    public String getIsCancel() {
        return isCancel;
    }

    /**
     * 设置是否注销
     *
     * @param isCancel 是否注销
     */
    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel;
    }

    /**
     * 获取注销原因
     *
     * @return CancelReason - 注销原因
     */
    public String getCancelReason() {
        return cancelReason;
    }

    /**
     * 设置注销原因
     *
     * @param cancelReason 注销原因
     */
    public void setCancelReason(String cancelReason) {
        this.cancelReason = cancelReason;
    }

    /**
     * 获取注销文件
     *
     * @return CancelFile - 注销文件
     */
    public String getCancelFile() {
        return cancelFile;
    }

    /**
     * 设置注销文件
     *
     * @param cancelFile 注销文件
     */
    public void setCancelFile(String cancelFile) {
        this.cancelFile = cancelFile;
    }

    /**
     * 获取注销登记日期
     *
     * @return CancelRegistDate - 注销登记日期
     */
    public Date getCancelRegistDate() {
        return cancelRegistDate;
    }

    /**
     * 设置注销登记日期
     *
     * @param cancelRegistDate 注销登记日期
     */
    public void setCancelRegistDate(Date cancelRegistDate) {
        this.cancelRegistDate = cancelRegistDate;
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
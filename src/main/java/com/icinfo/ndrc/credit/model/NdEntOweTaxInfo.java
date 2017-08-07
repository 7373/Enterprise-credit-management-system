/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_ent_owe_tax_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_ent_owe_tax_info")
public class NdEntOweTaxInfo implements Serializable {
    @Id
    @Column(name = "id")

    private Integer id;
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 纳税人名称
     */
    @Column(name = "TaxerName")
    private String taxerName;

    /**
     * 统一社会信用代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 法定代表人（负责人或业主姓名〕
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 注册地址
     */
    @Column(name = "RegistAddr")
    private String registAddr;

    /**
     * 欠税税种
     */
    @Column(name = "OweTaxType")
    private String oweTaxType;

    /**
     * 欠税金额
     */
    @Column(name = "OweTaxAmount")
    private String oweTaxAmount;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "enterprise_id")
    private String enterprise_id;

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
     * 获取纳税人名称
     *
     * @return TaxerName - 纳税人名称
     */
    public String getTaxerName() {
        return taxerName;
    }

    /**
     * 设置纳税人名称
     *
     * @param taxerName 纳税人名称
     */
    public void setTaxerName(String taxerName) {
        this.taxerName = taxerName;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return Unicode - 统一社会信用代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param unicode 统一社会信用代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取法定代表人（负责人或业主姓名〕
     *
     * @return LegalPerson - 法定代表人（负责人或业主姓名〕
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人（负责人或业主姓名〕
     *
     * @param legalPerson 法定代表人（负责人或业主姓名〕
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
     * 获取欠税税种
     *
     * @return OweTaxType - 欠税税种
     */
    public String getOweTaxType() {
        return oweTaxType;
    }

    /**
     * 设置欠税税种
     *
     * @param oweTaxType 欠税税种
     */
    public void setOweTaxType(String oweTaxType) {
        this.oweTaxType = oweTaxType;
    }

    /**
     * 获取欠税金额
     *
     * @return OweTaxAmount - 欠税金额
     */
    public String getOweTaxAmount() {
        return oweTaxAmount;
    }

    /**
     * 设置欠税金额
     *
     * @param oweTaxAmount 欠税金额
     */
    public void setOweTaxAmount(String oweTaxAmount) {
        this.oweTaxAmount = oweTaxAmount;
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
     * @return enterprise_id
     */
    public String getEnterprise_id() {
        return enterprise_id;
    }

    /**
     * @param enterprise_id
     */
    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }
}
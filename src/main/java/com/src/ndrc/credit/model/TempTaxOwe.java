/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_tax_owe 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_tax_owe")
public class TempTaxOwe implements Serializable {
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
     * 纳税人名称
     */
    @Column(name = "TaxPersonName")
    private String taxPersonName;

    /**
     * 统一社会信用代码
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 法定代表人(负责人或业主姓名)
     */
    @Column(name = "LegalPerson")
    private String legalPerson;

    /**
     * 注册地址
     */
    @Column(name = "RegAddr")
    private String regAddr;

    /**
     * 欠税税种
     */
    @Column(name = "TaxName")
    private String taxName;

    /**
     * 欠税金额
     */
    @Column(name = "TaxMoney")
    private String taxMoney;

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
     * 获取纳税人名称
     *
     * @return TaxPersonName - 纳税人名称
     */
    public String getTaxPersonName() {
        return taxPersonName;
    }

    /**
     * 设置纳税人名称
     *
     * @param taxPersonName 纳税人名称
     */
    public void setTaxPersonName(String taxPersonName) {
        this.taxPersonName = taxPersonName;
    }

    /**
     * 获取统一社会信用代码
     *
     * @return Uniscid - 统一社会信用代码
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置统一社会信用代码
     *
     * @param uniscid 统一社会信用代码
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取法定代表人(负责人或业主姓名)
     *
     * @return LegalPerson - 法定代表人(负责人或业主姓名)
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 设置法定代表人(负责人或业主姓名)
     *
     * @param legalPerson 法定代表人(负责人或业主姓名)
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    /**
     * 获取注册地址
     *
     * @return RegAddr - 注册地址
     */
    public String getRegAddr() {
        return regAddr;
    }

    /**
     * 设置注册地址
     *
     * @param regAddr 注册地址
     */
    public void setRegAddr(String regAddr) {
        this.regAddr = regAddr;
    }

    /**
     * 获取欠税税种
     *
     * @return TaxName - 欠税税种
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * 设置欠税税种
     *
     * @param taxName 欠税税种
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    /**
     * 获取欠税金额
     *
     * @return TaxMoney - 欠税金额
     */
    public String getTaxMoney() {
        return taxMoney;
    }

    /**
     * 设置欠税金额
     *
     * @param taxMoney 欠税金额
     */
    public void setTaxMoney(String taxMoney) {
        this.taxMoney = taxMoney;
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
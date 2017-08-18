/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_tax_credit_level 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月27日
 */
@Table(name = "nd_tax_credit_level")
public class NdTaxCreditLevel implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 信用等级
     */
    @Column(name = "CreditLevel")
    private String creditLevel;

    /**
     * 统一社会信用代码
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 纳税人名称
     */
    @Column(name = "TaxName")
    private String taxName;

    @Column(name = "enterprise_id")
    private String enterprise_id;

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
     * 获取信用等级
     *
     * @return CreditLevel - 信用等级
     */
    public String getCreditLevel() {
        return creditLevel;
    }

    /**
     * 设置信用等级
     *
     * @param creditLevel 信用等级
     */
    public void setCreditLevel(String creditLevel) {
        this.creditLevel = creditLevel;
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
     * 获取纳税人名称
     *
     * @return TaxName - 纳税人名称
     */
    public String getTaxName() {
        return taxName;
    }

    /**
     * 设置纳税人名称
     *
     * @param taxName 纳税人名称
     */
    public void setTaxName(String taxName) {
        this.taxName = taxName;
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
}
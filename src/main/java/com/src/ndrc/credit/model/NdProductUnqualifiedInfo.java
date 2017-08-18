/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_product_unqualified_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_product_unqualified_info")
public class NdProductUnqualifiedInfo implements Serializable {
    @Id
    @Column(name = "id")

    private Integer id;
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 产品名称
     */
    @Column(name = "ProductName")
    private String productName;

    /**
     * 商标
     */
    @Column(name = "TradeMark")
    private String tradeMark;

    /**
     * 规格型号
     */
    @Column(name = "StandardModel")
    private String standardModel;

    /**
     * 生产日期/批号
     */
    @Column(name = "ManufactureDate")
    private String manufactureDate;

    /**
     * 产品分类
     */
    @Column(name = "ProductClassify")
    private String productClassify;

    /**
     * 承检机构
     */
    @Column(name = "TestUnit")
    private String testUnit;

    /**
     * 抽查日期
     */
    @Column(name = "CheckDate")
    private Date checkDate;

    /**
     * 抽查级别
     */
    @Column(name = "CheckLevel")
    private String checkLevel;

    /**
     * 抽查结果
     */
    @Column(name = "CheckResult")
    private String checkResult;

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
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
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
     * 获取产品名称
     *
     * @return ProductName - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取商标
     *
     * @return TradeMark - 商标
     */
    public String getTradeMark() {
        return tradeMark;
    }

    /**
     * 设置商标
     *
     * @param tradeMark 商标
     */
    public void setTradeMark(String tradeMark) {
        this.tradeMark = tradeMark;
    }

    /**
     * 获取规格型号
     *
     * @return StandardModel - 规格型号
     */
    public String getStandardModel() {
        return standardModel;
    }

    /**
     * 设置规格型号
     *
     * @param standardModel 规格型号
     */
    public void setStandardModel(String standardModel) {
        this.standardModel = standardModel;
    }

    /**
     * 获取生产日期/批号
     *
     * @return ManufactureDate - 生产日期/批号
     */
    public String getManufactureDate() {
        return manufactureDate;
    }

    /**
     * 设置生产日期/批号
     *
     * @param manufactureDate 生产日期/批号
     */
    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    /**
     * 获取产品分类
     *
     * @return ProductClassify - 产品分类
     */
    public String getProductClassify() {
        return productClassify;
    }

    /**
     * 设置产品分类
     *
     * @param productClassify 产品分类
     */
    public void setProductClassify(String productClassify) {
        this.productClassify = productClassify;
    }

    /**
     * 获取承检机构
     *
     * @return TestUnit - 承检机构
     */
    public String getTestUnit() {
        return testUnit;
    }

    /**
     * 设置承检机构
     *
     * @param testUnit 承检机构
     */
    public void setTestUnit(String testUnit) {
        this.testUnit = testUnit;
    }

    /**
     * 获取抽查日期
     *
     * @return CheckDate - 抽查日期
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置抽查日期
     *
     * @param checkDate 抽查日期
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
    }

    /**
     * 获取抽查级别
     *
     * @return CheckLevel - 抽查级别
     */
    public String getCheckLevel() {
        return checkLevel;
    }

    /**
     * 设置抽查级别
     *
     * @param checkLevel 抽查级别
     */
    public void setCheckLevel(String checkLevel) {
        this.checkLevel = checkLevel;
    }

    /**
     * 获取抽查结果
     *
     * @return CheckResult - 抽查结果
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置抽查结果
     *
     * @param checkResult 抽查结果
     */
    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
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
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
 * 描述:    temp_seed_manage_permit 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月20日
 */
@Table(name = "temp_seed_manage_permit")
public class TempSeedManagePermit implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 企业名称（自然人姓名）
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 许可证编号
     */
    @Column(name = "LicenceNO")
    private String licenceNO;

    /**
     * 发证日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "IssueTime")
    private Date issueTime;

    /**
     * 有效期限
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "TermEnd")
    private Date termEnd;

    /**
     * 生产地点
     */
    @Column(name = "ProduceLoc")
    private String produceLoc;

    /**
     * 生产经营种类
     */
    @Column(name = "ManageType")
    private String manageType;

    @Column(name = "ImportDept")
    private String importDept;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

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
     * 获取企业名称（自然人姓名）
     *
     * @return EntName - 企业名称（自然人姓名）
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称（自然人姓名）
     *
     * @param entName 企业名称（自然人姓名）
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）
     *
     * @return Unicode - 法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）
     *
     * @param unicode 法人社会信用代码/组织机构代码/工商注册号或工商登记号（自然人身份证号）
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取许可证编号
     *
     * @return LicenceNO - 许可证编号
     */
    public String getLicenceNO() {
        return licenceNO;
    }

    /**
     * 设置许可证编号
     *
     * @param licenceNO 许可证编号
     */
    public void setLicenceNO(String licenceNO) {
        this.licenceNO = licenceNO;
    }

    /**
     * 获取发证日期
     *
     * @return IssueTime - 发证日期
     */
    public Date getIssueTime() {
        return issueTime;
    }

    /**
     * 设置发证日期
     *
     * @param issueTime 发证日期
     */
    public void setIssueTime(Date issueTime) {
        this.issueTime = issueTime;
    }

    /**
     * 获取有效期限
     *
     * @return TermEnd - 有效期限
     */
    public Date getTermEnd() {
        return termEnd;
    }

    /**
     * 设置有效期限
     *
     * @param termEnd 有效期限
     */
    public void setTermEnd(Date termEnd) {
        this.termEnd = termEnd;
    }

    /**
     * 获取生产地点
     *
     * @return ProduceLoc - 生产地点
     */
    public String getProduceLoc() {
        return produceLoc;
    }

    /**
     * 设置生产地点
     *
     * @param produceLoc 生产地点
     */
    public void setProduceLoc(String produceLoc) {
        this.produceLoc = produceLoc;
    }

    /**
     * 获取生产经营种类
     *
     * @return ManageType - 生产经营种类
     */
    public String getManageType() {
        return manageType;
    }

    /**
     * 设置生产经营种类
     *
     * @param manageType 生产经营种类
     */
    public void setManageType(String manageType) {
        this.manageType = manageType;
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
}
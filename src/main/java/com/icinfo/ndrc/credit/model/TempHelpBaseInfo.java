/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_help_base_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_help_base_info")
public class TempHelpBaseInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    @Column(name = "Name")
    private String name;

    /**
     * 救助证证号
     */
    @Column(name = "HelpCertNO")
    private String helpCertNO;

    /**
     * 救助证发证时间
     */
    @Column(name = "HelpIssueDate")
    private Date helpIssueDate;

    /**
     * 有效期（起止日期）
     */
    @Column(name = "ValidTerm")
    private Date validTerm;

    /**
     * 身份证号
     */
    @Column(name = "CertNO")
    private String certNO;

    /**
     * 最近一次低保金发放时间
     */
    @Column(name = "ReleaseDate")
    private Date releaseDate;

    /**
     * 最近一次低保金发放金额
     */
    @Column(name = "ReleaseAmount")
    private String releaseAmount;

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
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取救助证证号
     *
     * @return HelpCertNO - 救助证证号
     */
    public String getHelpCertNO() {
        return helpCertNO;
    }

    /**
     * 设置救助证证号
     *
     * @param helpCertNO 救助证证号
     */
    public void setHelpCertNO(String helpCertNO) {
        this.helpCertNO = helpCertNO;
    }

    /**
     * 获取救助证发证时间
     *
     * @return HelpIssueDate - 救助证发证时间
     */
    public Date getHelpIssueDate() {
        return helpIssueDate;
    }

    /**
     * 设置救助证发证时间
     *
     * @param helpIssueDate 救助证发证时间
     */
    public void setHelpIssueDate(Date helpIssueDate) {
        this.helpIssueDate = helpIssueDate;
    }

    /**
     * 获取有效期（起止日期）
     *
     * @return ValidTerm - 有效期（起止日期）
     */
    public Date getValidTerm() {
        return validTerm;
    }

    /**
     * 设置有效期（起止日期）
     *
     * @param validTerm 有效期（起止日期）
     */
    public void setValidTerm(Date validTerm) {
        this.validTerm = validTerm;
    }

    /**
     * 获取身份证号
     *
     * @return CertNO - 身份证号
     */
    public String getCertNO() {
        return certNO;
    }

    /**
     * 设置身份证号
     *
     * @param certNO 身份证号
     */
    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }

    /**
     * 获取最近一次低保金发放时间
     *
     * @return ReleaseDate - 最近一次低保金发放时间
     */
    public Date getReleaseDate() {
        return releaseDate;
    }

    /**
     * 设置最近一次低保金发放时间
     *
     * @param releaseDate 最近一次低保金发放时间
     */
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * 获取最近一次低保金发放金额
     *
     * @return ReleaseAmount - 最近一次低保金发放金额
     */
    public String getReleaseAmount() {
        return releaseAmount;
    }

    /**
     * 设置最近一次低保金发放金额
     *
     * @param releaseAmount 最近一次低保金发放金额
     */
    public void setReleaseAmount(String releaseAmount) {
        this.releaseAmount = releaseAmount;
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
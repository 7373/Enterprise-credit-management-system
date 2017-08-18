/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_law_firm_assess_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年07月03日
 */
@Table(name = "temp_law_firm_assess_info")
public class TempLawFirmAssessInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 机构名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 社会信用代码/工商注册号/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 主管机关
     */
    @Column(name = "CompetentOrgan")
    private String competentOrgan;

    /**
     * 考核结果
     */
    @Column(name = "CheckResult")
    private String checkResult;

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
     * 获取机构名称
     *
     * @return UnitName - 机构名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置机构名称
     *
     * @param unitName 机构名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取社会信用代码/工商注册号/组织机构代码
     *
     * @return Unicode - 社会信用代码/工商注册号/组织机构代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置社会信用代码/工商注册号/组织机构代码
     *
     * @param unicode 社会信用代码/工商注册号/组织机构代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取主管机关
     *
     * @return CompetentOrgan - 主管机关
     */
    public String getCompetentOrgan() {
        return competentOrgan;
    }

    /**
     * 设置主管机关
     *
     * @param competentOrgan 主管机关
     */
    public void setCompetentOrgan(String competentOrgan) {
        this.competentOrgan = competentOrgan;
    }

    /**
     * 获取考核结果
     *
     * @return CheckResult - 考核结果
     */
    public String getCheckResult() {
        return checkResult;
    }

    /**
     * 设置考核结果
     *
     * @param checkResult 考核结果
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
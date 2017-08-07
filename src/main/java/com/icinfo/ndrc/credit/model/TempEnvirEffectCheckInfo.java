/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_envir_effect_check_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_envir_effect_check_info")
public class TempEnvirEffectCheckInfo implements Serializable {
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
     * 项目类型
     */
    @Column(name = "ProjectType")
    private String projectType;

    /**
     * 审批（批准）文号
     */
    @Column(name = "CheckNO")
    private String checkNO;

    /**
     * 审批（批准）事项
     */
    @Column(name = "CheckMatter")
    private String checkMatter;

    /**
     * 审批（批准）机关
     */
    @Column(name = "CheckUnit")
    private String checkUnit;

    /**
     * 审批（批准）日期
     */
    @Column(name = "CheckDate")
    private Date checkDate;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

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
     * 获取项目类型
     *
     * @return ProjectType - 项目类型
     */
    public String getProjectType() {
        return projectType;
    }

    /**
     * 设置项目类型
     *
     * @param projectType 项目类型
     */
    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    /**
     * 获取审批（批准）文号
     *
     * @return CheckNO - 审批（批准）文号
     */
    public String getCheckNO() {
        return checkNO;
    }

    /**
     * 设置审批（批准）文号
     *
     * @param checkNO 审批（批准）文号
     */
    public void setCheckNO(String checkNO) {
        this.checkNO = checkNO;
    }

    /**
     * 获取审批（批准）事项
     *
     * @return CheckMatter - 审批（批准）事项
     */
    public String getCheckMatter() {
        return checkMatter;
    }

    /**
     * 设置审批（批准）事项
     *
     * @param checkMatter 审批（批准）事项
     */
    public void setCheckMatter(String checkMatter) {
        this.checkMatter = checkMatter;
    }

    /**
     * 获取审批（批准）机关
     *
     * @return CheckUnit - 审批（批准）机关
     */
    public String getCheckUnit() {
        return checkUnit;
    }

    /**
     * 设置审批（批准）机关
     *
     * @param checkUnit 审批（批准）机关
     */
    public void setCheckUnit(String checkUnit) {
        this.checkUnit = checkUnit;
    }

    /**
     * 获取审批（批准）日期
     *
     * @return CheckDate - 审批（批准）日期
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置审批（批准）日期
     *
     * @param checkDate 审批（批准）日期
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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
/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_review_acceptance_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_review_acceptance_info")
public class TempReviewAcceptanceInfo implements Serializable {
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
     * 项目名称
     */
    @Column(name = "ProjectName")
    private String projectName;

    /**
     * 新增变压器容量
     */
    @Column(name = "NewTransFormerCapacity")
    private String newTransFormerCapacity;

    /**
     * 项目年综合能耗
     */
    @Column(name = "EnergyConsumption")
    private String energyConsumption;

    /**
     * 项目单位增加值能耗
     */
    @Column(name = "AddValue")
    private String addValue;

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
     * 获取项目名称
     *
     * @return ProjectName - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取新增变压器容量
     *
     * @return NewTransFormerCapacity - 新增变压器容量
     */
    public String getNewTransFormerCapacity() {
        return newTransFormerCapacity;
    }

    /**
     * 设置新增变压器容量
     *
     * @param newTransFormerCapacity 新增变压器容量
     */
    public void setNewTransFormerCapacity(String newTransFormerCapacity) {
        this.newTransFormerCapacity = newTransFormerCapacity;
    }

    /**
     * 获取项目年综合能耗
     *
     * @return EnergyConsumption - 项目年综合能耗
     */
    public String getEnergyConsumption() {
        return energyConsumption;
    }

    /**
     * 设置项目年综合能耗
     *
     * @param energyConsumption 项目年综合能耗
     */
    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    /**
     * 获取项目单位增加值能耗
     *
     * @return AddValue - 项目单位增加值能耗
     */
    public String getAddValue() {
        return addValue;
    }

    /**
     * 设置项目单位增加值能耗
     *
     * @param addValue 项目单位增加值能耗
     */
    public void setAddValue(String addValue) {
        this.addValue = addValue;
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
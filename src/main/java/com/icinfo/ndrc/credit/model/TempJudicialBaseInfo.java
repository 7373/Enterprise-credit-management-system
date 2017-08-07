/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_judicial_base_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_judicial_base_info")
public class TempJudicialBaseInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 身份证号
     */
    @Column(name = "IdCard")
    private String idCard;

    /**
     * 执业证号
     */
    @Column(name = "WorkCertNO")
    private String workCertNO;

    /**
     * 执业机构
     */
    @Column(name = "WorkUnit")
    private String workUnit;

    /**
     * 职称级别
     */
    @Column(name = "TitleLevel")
    private String titleLevel;

    /**
     * 执业范围
     */
    @Column(name = "WorkRange")
    private String workRange;

    /**
     * 律师基本信息,基层法律服务工作者基本信息,公证员基本信息
     */
    @Column(name = "Type")
    private String type;

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
     * 获取姓名
     *
     * @return Name - 姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置姓名
     *
     * @param name 姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取身份证号
     *
     * @return IdCard - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取执业证号
     *
     * @return WorkCertNO - 执业证号
     */
    public String getWorkCertNO() {
        return workCertNO;
    }

    /**
     * 设置执业证号
     *
     * @param workCertNO 执业证号
     */
    public void setWorkCertNO(String workCertNO) {
        this.workCertNO = workCertNO;
    }

    /**
     * 获取执业机构
     *
     * @return WorkUnit - 执业机构
     */
    public String getWorkUnit() {
        return workUnit;
    }

    /**
     * 设置执业机构
     *
     * @param workUnit 执业机构
     */
    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
    }

    /**
     * 获取职称级别
     *
     * @return TitleLevel - 职称级别
     */
    public String getTitleLevel() {
        return titleLevel;
    }

    /**
     * 设置职称级别
     *
     * @param titleLevel 职称级别
     */
    public void setTitleLevel(String titleLevel) {
        this.titleLevel = titleLevel;
    }

    /**
     * 获取执业范围
     *
     * @return WorkRange - 执业范围
     */
    public String getWorkRange() {
        return workRange;
    }

    /**
     * 设置执业范围
     *
     * @param workRange 执业范围
     */
    public void setWorkRange(String workRange) {
        this.workRange = workRange;
    }

    /**
     * 获取律师基本信息,基层法律服务工作者基本信息,公证员基本信息
     *
     * @return Type - 律师基本信息,基层法律服务工作者基本信息,公证员基本信息
     */
    public String getType() {
        return type;
    }

    /**
     * 设置律师基本信息,基层法律服务工作者基本信息,公证员基本信息
     *
     * @param type 律师基本信息,基层法律服务工作者基本信息,公证员基本信息
     */
    public void setType(String type) {
        this.type = type;
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
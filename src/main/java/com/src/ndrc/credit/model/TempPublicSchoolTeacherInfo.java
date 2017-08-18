/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_public_school_teacher_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月28日
 */
@Table(name = "temp_public_school_teacher_info")
public class TempPublicSchoolTeacherInfo implements Serializable {
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
     * 身份证信息
     */
    @Column(name = "IdCard")
    private String idCard;

    /**
     * 资格种类
     */
    @Column(name = "QuaType")
    private String quaType;

    /**
     * 发证机构
     */
    @Column(name = "IssueUnit")
    private String issueUnit;

    /**
     * 发证时间
     */
    @Column(name = "IssueDate")
    private Date issueDate;

    /**
     * 所获临安市级及以上荣誉和颁布时间
     */
    @Column(name = "GainHonorDate")
    private Date gainHonorDate;

    @Column(name = "ImportDept")
    private String importDept;

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
     * 获取身份证信息
     *
     * @return IdCard - 身份证信息
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 设置身份证信息
     *
     * @param idCard 身份证信息
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取资格种类
     *
     * @return QuaType - 资格种类
     */
    public String getQuaType() {
        return quaType;
    }

    /**
     * 设置资格种类
     *
     * @param quaType 资格种类
     */
    public void setQuaType(String quaType) {
        this.quaType = quaType;
    }

    /**
     * 获取发证机构
     *
     * @return IssueUnit - 发证机构
     */
    public String getIssueUnit() {
        return issueUnit;
    }

    /**
     * 设置发证机构
     *
     * @param issueUnit 发证机构
     */
    public void setIssueUnit(String issueUnit) {
        this.issueUnit = issueUnit;
    }

    /**
     * 获取发证时间
     *
     * @return IssueDate - 发证时间
     */
    public Date getIssueDate() {
        return issueDate;
    }

    /**
     * 设置发证时间
     *
     * @param issueDate 发证时间
     */
    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    /**
     * 获取所获临安市级及以上荣誉和颁布时间
     *
     * @return GainHonorDate - 所获临安市级及以上荣誉和颁布时间
     */
    public Date getGainHonorDate() {
        return gainHonorDate;
    }

    /**
     * 设置所获临安市级及以上荣誉和颁布时间
     *
     * @param gainHonorDate 所获临安市级及以上荣誉和颁布时间
     */
    public void setGainHonorDate(Date gainHonorDate) {
        this.gainHonorDate = gainHonorDate;
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
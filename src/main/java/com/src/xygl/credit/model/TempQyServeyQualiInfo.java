/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_qy_servey_quali_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_qy_servey_quali_info")
public class TempQyServeyQualiInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    /**
     * Id
     */
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 测绘单位名称
     */
    @Column(name = "QyName")
    private String qyName;

    /**
     * 测绘单位法人代表
     */
    @Column(name = "QyLegalPerson")
    private String qyLegalPerson;

    /**
     * 测绘单位地址
     */
    @Column(name = "QyAddr")
    private String qyAddr;

    /**
     * 测绘资质等级及编号
     */
    @Column(name = "QualifyLevelAndNO")
    private String qualifyLevelAndNO;

    /**
     * 测绘资质有效期
     */
    @Column(name = "QualifyPeriod")
    private Date qualifyPeriod;

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
     * 获取测绘单位名称
     *
     * @return QyName - 测绘单位名称
     */
    public String getQyName() {
        return qyName;
    }

    /**
     * 设置测绘单位名称
     *
     * @param qyName 测绘单位名称
     */
    public void setQyName(String qyName) {
        this.qyName = qyName;
    }

    /**
     * 获取测绘单位法人代表
     *
     * @return QyLegalPerson - 测绘单位法人代表
     */
    public String getQyLegalPerson() {
        return qyLegalPerson;
    }

    /**
     * 设置测绘单位法人代表
     *
     * @param qyLegalPerson 测绘单位法人代表
     */
    public void setQyLegalPerson(String qyLegalPerson) {
        this.qyLegalPerson = qyLegalPerson;
    }

    /**
     * 获取测绘单位地址
     *
     * @return QyAddr - 测绘单位地址
     */
    public String getQyAddr() {
        return qyAddr;
    }

    /**
     * 设置测绘单位地址
     *
     * @param qyAddr 测绘单位地址
     */
    public void setQyAddr(String qyAddr) {
        this.qyAddr = qyAddr;
    }

    /**
     * 获取测绘资质等级及编号
     *
     * @return QualifyLevelAndNO - 测绘资质等级及编号
     */
    public String getQualifyLevelAndNO() {
        return qualifyLevelAndNO;
    }

    /**
     * 设置测绘资质等级及编号
     *
     * @param qualifyLevelAndNO 测绘资质等级及编号
     */
    public void setQualifyLevelAndNO(String qualifyLevelAndNO) {
        this.qualifyLevelAndNO = qualifyLevelAndNO;
    }

    /**
     * 获取测绘资质有效期
     *
     * @return QualifyPeriod - 测绘资质有效期
     */
    public Date getQualifyPeriod() {
        return qualifyPeriod;
    }

    /**
     * 设置测绘资质有效期
     *
     * @param qualifyPeriod 测绘资质有效期
     */
    public void setQualifyPeriod(Date qualifyPeriod) {
        this.qualifyPeriod = qualifyPeriod;
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
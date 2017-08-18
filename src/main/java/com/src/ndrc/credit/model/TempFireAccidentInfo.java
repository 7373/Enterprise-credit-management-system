/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_fire_accident_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_fire_accident_info")
public class TempFireAccidentInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 事故名称
     */
    @Column(name = "AccidentName")
    private String accidentName;

    /**
     * 单位名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 单位社会信用代码/工商注册号/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 发生日期
     */
    @Column(name = "OccurDate")
    private Date occurDate;

    /**
     * 事故原因
     */
    @Column(name = "AccidentReason")
    private String accidentReason;

    /**
     * 死亡人数
     */
    @Column(name = "DeathNum")
    private String deathNum;

    /**
     * 重伤人数
     */
    @Column(name = "InjuredNum")
    private String injuredNum;

    /**
     * 财产损失
     */
    @Column(name = "PropertyLoss")
    private String propertyLoss;

    @Column(name = "ImportDept")
    private String importDept;

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
     * 获取事故名称
     *
     * @return AccidentName - 事故名称
     */
    public String getAccidentName() {
        return accidentName;
    }

    /**
     * 设置事故名称
     *
     * @param accidentName 事故名称
     */
    public void setAccidentName(String accidentName) {
        this.accidentName = accidentName;
    }

    /**
     * 获取单位名称
     *
     * @return UnitName - 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名称
     *
     * @param unitName 单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取单位社会信用代码/工商注册号/组织机构代码
     *
     * @return Unicode - 单位社会信用代码/工商注册号/组织机构代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置单位社会信用代码/工商注册号/组织机构代码
     *
     * @param unicode 单位社会信用代码/工商注册号/组织机构代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取发生日期
     *
     * @return OccurDate - 发生日期
     */
    public Date getOccurDate() {
        return occurDate;
    }

    /**
     * 设置发生日期
     *
     * @param occurDate 发生日期
     */
    public void setOccurDate(Date occurDate) {
        this.occurDate = occurDate;
    }

    /**
     * 获取事故原因
     *
     * @return AccidentReason - 事故原因
     */
    public String getAccidentReason() {
        return accidentReason;
    }

    /**
     * 设置事故原因
     *
     * @param accidentReason 事故原因
     */
    public void setAccidentReason(String accidentReason) {
        this.accidentReason = accidentReason;
    }

    /**
     * 获取死亡人数
     *
     * @return DeathNum - 死亡人数
     */
    public String getDeathNum() {
        return deathNum;
    }

    /**
     * 设置死亡人数
     *
     * @param deathNum 死亡人数
     */
    public void setDeathNum(String deathNum) {
        this.deathNum = deathNum;
    }

    /**
     * 获取重伤人数
     *
     * @return InjuredNum - 重伤人数
     */
    public String getInjuredNum() {
        return injuredNum;
    }

    /**
     * 设置重伤人数
     *
     * @param injuredNum 重伤人数
     */
    public void setInjuredNum(String injuredNum) {
        this.injuredNum = injuredNum;
    }

    /**
     * 获取财产损失
     *
     * @return PropertyLoss - 财产损失
     */
    public String getPropertyLoss() {
        return propertyLoss;
    }

    /**
     * 设置财产损失
     *
     * @param propertyLoss 财产损失
     */
    public void setPropertyLoss(String propertyLoss) {
        this.propertyLoss = propertyLoss;
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
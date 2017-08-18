/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_reward_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "nd_reward_info")
public class NdRewardInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 获奖单位（场所）名称
     */
    @Column(name = "RewardUnitName")
    private String rewardUnitName;

    /**
     * 单位（场所）类型
     */
    @Column(name = "UnitType")
    private String unitType;

    /**
     * 地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 所在区域
     */
    @Column(name = "TheArea")
    private String theArea;

    /**
     * 奖励名称
     */
    @Column(name = "RewardName")
    private String rewardName;

    /**
     * 奖励级别
     */
    @Column(name = "RewardClass")
    private String rewardClass;

    /**
     * 奖励时间
     */
    @Column(name = "RewardTime")
    private Date rewardTime;

    /**
     * 颁奖单位
     */
    @Column(name = "AwardUnit")
    private String awardUnit;

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
     * 获取获奖单位（场所）名称
     *
     * @return RewardUnitName - 获奖单位（场所）名称
     */
    public String getRewardUnitName() {
        return rewardUnitName;
    }

    /**
     * 设置获奖单位（场所）名称
     *
     * @param rewardUnitName 获奖单位（场所）名称
     */
    public void setRewardUnitName(String rewardUnitName) {
        this.rewardUnitName = rewardUnitName;
    }

    /**
     * 获取单位（场所）类型
     *
     * @return UnitType - 单位（场所）类型
     */
    public String getUnitType() {
        return unitType;
    }

    /**
     * 设置单位（场所）类型
     *
     * @param unitType 单位（场所）类型
     */
    public void setUnitType(String unitType) {
        this.unitType = unitType;
    }

    /**
     * 获取地址
     *
     * @return Address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取所在区域
     *
     * @return TheArea - 所在区域
     */
    public String getTheArea() {
        return theArea;
    }

    /**
     * 设置所在区域
     *
     * @param theArea 所在区域
     */
    public void setTheArea(String theArea) {
        this.theArea = theArea;
    }

    /**
     * 获取奖励名称
     *
     * @return RewardName - 奖励名称
     */
    public String getRewardName() {
        return rewardName;
    }

    /**
     * 设置奖励名称
     *
     * @param rewardName 奖励名称
     */
    public void setRewardName(String rewardName) {
        this.rewardName = rewardName;
    }

    /**
     * 获取奖励级别
     *
     * @return RewardClass - 奖励级别
     */
    public String getRewardClass() {
        return rewardClass;
    }

    /**
     * 设置奖励级别
     *
     * @param rewardClass 奖励级别
     */
    public void setRewardClass(String rewardClass) {
        this.rewardClass = rewardClass;
    }

    /**
     * 获取奖励时间
     *
     * @return RewardTime - 奖励时间
     */
    public Date getRewardTime() {
        return rewardTime;
    }

    /**
     * 设置奖励时间
     *
     * @param rewardTime 奖励时间
     */
    public void setRewardTime(Date rewardTime) {
        this.rewardTime = rewardTime;
    }

    /**
     * 获取颁奖单位
     *
     * @return AwardUnit - 颁奖单位
     */
    public String getAwardUnit() {
        return awardUnit;
    }

    /**
     * 设置颁奖单位
     *
     * @param awardUnit 颁奖单位
     */
    public void setAwardUnit(String awardUnit) {
        this.awardUnit = awardUnit;
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
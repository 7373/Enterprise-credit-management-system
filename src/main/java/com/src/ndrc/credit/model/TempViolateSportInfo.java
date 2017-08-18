/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_violate_sport_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "temp_violate_sport_info")
public class TempViolateSportInfo implements Serializable {
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
     * 处理时间
     */
    @Column(name = "DealTime")
    private Date dealTime;

    /**
     * 处理事由
     */
    @Column(name = "DealReson")
    private String dealReson;

    /**
     * 处理情况
     */
    @Column(name = "DealSituation")
    private String dealSituation;

    /**
     * 当事人姓名
     */
    @Column(name = "PartyName")
    private String partyName;

    /**
     * 身份证号
     */
    @Column(name = "IdCard")
    private String idCard;

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
     * 获取处理时间
     *
     * @return DealTime - 处理时间
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * 设置处理时间
     *
     * @param dealTime 处理时间
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 获取处理事由
     *
     * @return DealReson - 处理事由
     */
    public String getDealReson() {
        return dealReson;
    }

    /**
     * 设置处理事由
     *
     * @param dealReson 处理事由
     */
    public void setDealReson(String dealReson) {
        this.dealReson = dealReson;
    }

    /**
     * 获取处理情况
     *
     * @return DealSituation - 处理情况
     */
    public String getDealSituation() {
        return dealSituation;
    }

    /**
     * 设置处理情况
     *
     * @param dealSituation 处理情况
     */
    public void setDealSituation(String dealSituation) {
        this.dealSituation = dealSituation;
    }

    /**
     * 获取当事人姓名
     *
     * @return PartyName - 当事人姓名
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * 设置当事人姓名
     *
     * @param partyName 当事人姓名
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
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
/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_admin_punish 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_admin_punish")
public class TempAdminPunish implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 行政处罚决定文书号
     */
    @Column(name = "PunishDocNO")
    private String punishDocNO;

    /**
     * 处罚名称
     */
    @Column(name = "PunishName")
    private String punishName;

    /**
     * 处罚类别
     */
    @Column(name = "PunishType")
    private String punishType;

    /**
     * 处罚事由
     */
    @Column(name = "PunishReason")
    private String punishReason;

    /**
     * 处罚依据
     */
    @Column(name = "PunishBasis")
    private String punishBasis;

    /**
     * 行政相对人名称
     */
    @Column(name = "AdminCounterpartName")
    private String adminCounterpartName;

    /**
     * 处罚结果
     */
    @Column(name = "PunishResult")
    private String punishResult;

    /**
     * 行政处罚决定日期
     */
    @Column(name = "PunishDate")
    private Date punishDate;

    /**
     * 处罚机关
     */
    @Column(name = "PunishOffice")
    private String punishOffice;

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
     * 获取行政处罚决定文书号
     *
     * @return PunishDocNO - 行政处罚决定文书号
     */
    public String getPunishDocNO() {
        return punishDocNO;
    }

    /**
     * 设置行政处罚决定文书号
     *
     * @param punishDocNO 行政处罚决定文书号
     */
    public void setPunishDocNO(String punishDocNO) {
        this.punishDocNO = punishDocNO;
    }

    /**
     * 获取处罚名称
     *
     * @return PunishName - 处罚名称
     */
    public String getPunishName() {
        return punishName;
    }

    /**
     * 设置处罚名称
     *
     * @param punishName 处罚名称
     */
    public void setPunishName(String punishName) {
        this.punishName = punishName;
    }

    /**
     * 获取处罚类别
     *
     * @return PunishType - 处罚类别
     */
    public String getPunishType() {
        return punishType;
    }

    /**
     * 设置处罚类别
     *
     * @param punishType 处罚类别
     */
    public void setPunishType(String punishType) {
        this.punishType = punishType;
    }

    /**
     * 获取处罚事由
     *
     * @return PunishReason - 处罚事由
     */
    public String getPunishReason() {
        return punishReason;
    }

    /**
     * 设置处罚事由
     *
     * @param punishReason 处罚事由
     */
    public void setPunishReason(String punishReason) {
        this.punishReason = punishReason;
    }

    /**
     * 获取处罚依据
     *
     * @return PunishBasis - 处罚依据
     */
    public String getPunishBasis() {
        return punishBasis;
    }

    /**
     * 设置处罚依据
     *
     * @param punishBasis 处罚依据
     */
    public void setPunishBasis(String punishBasis) {
        this.punishBasis = punishBasis;
    }

    /**
     * 获取行政相对人名称
     *
     * @return AdminCounterpartName - 行政相对人名称
     */
    public String getAdminCounterpartName() {
        return adminCounterpartName;
    }

    /**
     * 设置行政相对人名称
     *
     * @param adminCounterpartName 行政相对人名称
     */
    public void setAdminCounterpartName(String adminCounterpartName) {
        this.adminCounterpartName = adminCounterpartName;
    }

    /**
     * 获取处罚结果
     *
     * @return PunishResult - 处罚结果
     */
    public String getPunishResult() {
        return punishResult;
    }

    /**
     * 设置处罚结果
     *
     * @param punishResult 处罚结果
     */
    public void setPunishResult(String punishResult) {
        this.punishResult = punishResult;
    }

    /**
     * 获取行政处罚决定日期
     *
     * @return PunishDate - 行政处罚决定日期
     */
    public Date getPunishDate() {
        return punishDate;
    }

    /**
     * 设置行政处罚决定日期
     *
     * @param punishDate 行政处罚决定日期
     */
    public void setPunishDate(Date punishDate) {
        this.punishDate = punishDate;
    }

    /**
     * 获取处罚机关
     *
     * @return PunishOffice - 处罚机关
     */
    public String getPunishOffice() {
        return punishOffice;
    }

    /**
     * 设置处罚机关
     *
     * @param punishOffice 处罚机关
     */
    public void setPunishOffice(String punishOffice) {
        this.punishOffice = punishOffice;
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
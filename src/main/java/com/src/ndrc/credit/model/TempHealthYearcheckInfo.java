/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:  temp_health_yearcheck_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_health_yearcheck_info")
public class TempHealthYearcheckInfo implements Serializable {

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 机构名称
     */
    @Column(name = "UnName")
    private String unName;

    /**
     * 社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Uniscid")
    private String uniscid;

    /**
     * 下一校验日期
     */
    @Column(name = "NextCheckDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date nextCheckDate;

    /**
     * 许可日期开始
     */
    @Column(name = "ValDateStart")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date valDateStart;

    /**
     * 许可日期结束
     */
    @Column(name = "ValDateEnd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date valDateEnd;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

    @Column(name = "IsUse")
    private String isUse;

    private static final long serialVersionUID = 1L;


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
     * @return UnName - 机构名称
     */
    public String getUnName() {
        return unName;
    }

    /**
     * 设置机构名称
     *
     * @param unName 机构名称
     */
    public void setUnName(String unName) {
        this.unName = unName;
    }

    /**
     * 获取社会信用代码/组织机构代码/工商注册号
     *
     * @return Uniscid - 社会信用代码/组织机构代码/工商注册号
     */
    public String getUniscid() {
        return uniscid;
    }

    /**
     * 设置社会信用代码/组织机构代码/工商注册号
     *
     * @param uniscid 社会信用代码/组织机构代码/工商注册号
     */
    public void setUniscid(String uniscid) {
        this.uniscid = uniscid;
    }

    /**
     * 获取下一校验日期
     *
     * @return NextCheckDate - 下一校验日期
     */
    public Date getNextCheckDate() {
        return nextCheckDate;
    }

    /**
     * 设置下一校验日期
     *
     * @param nextCheckDate 下一校验日期
     */
    public void setNextCheckDate(Date nextCheckDate) {
        this.nextCheckDate = nextCheckDate;
    }

    /**
     * 获取许可日期开始
     *
     * @return ValDateStart - 许可日期开始
     */
    public Date getValDateStart() {
        return valDateStart;
    }

    /**
     * 设置许可日期开始
     *
     * @param valDateStart 许可日期开始
     */
    public void setValDateStart(Date valDateStart) {
        this.valDateStart = valDateStart;
    }

    /**
     * 获取许可日期结束
     *
     * @return ValDateEnd - 许可日期结束
     */
    public Date getValDateEnd() {
        return valDateEnd;
    }

    /**
     * 设置许可日期结束
     *
     * @param valDateEnd 许可日期结束
     */
    public void setValDateEnd(Date valDateEnd) {
        this.valDateEnd = valDateEnd;
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
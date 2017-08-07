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
 * 描述:  temp_health_licence_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_health_licence_info")
public class TempHealthLicenceInfo implements Serializable {

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
     * 地址
     */
    @Column(name = "Address")
    private String address;

    /**
     * 组成形式
     */
    @Column(name = "OpForm")
    private String opForm;

    /**
     * 执业许可证登记号
     */
    @Column(name = "LicNO")
    private String licNO;

    /**
     * 机构类别
     */
    @Column(name = "UnType")
    private String unType;

    /**
     * 诊疗科目
     */
    @Column(name = "SpeType")
    private String speType;

    /**
     * 法人代表
     */
    @Column(name = "LeRep")
    private String leRep;

    /**
     * 负责人
     */
    @Column(name = "ChargePeo")
    private String chargePeo;

    /**
     * 许可项目
     */
    @Column(name = "LicPro")
    private String licPro;

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

    /**
     * 发证机关
     */
    @Column(name = "CerIssue")
    private String cerIssue;

    /**
     * 发证日期
     */
    @Column(name = "CerDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date cerDate;
    
    @Column(name ="Source")
    private String source;

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
     * 获取组成形式
     *
     * @return OpForm - 组成形式
     */
    public String getOpForm() {
        return opForm;
    }

    /**
     * 设置组成形式
     *
     * @param opForm 组成形式
     */
    public void setOpForm(String opForm) {
        this.opForm = opForm;
    }

    /**
     * 获取执业许可证登记号
     *
     * @return LicNO - 执业许可证登记号
     */
    public String getLicNO() {
        return licNO;
    }

    /**
     * 设置执业许可证登记号
     *
     * @param licNO 执业许可证登记号
     */
    public void setLicNO(String licNO) {
        this.licNO = licNO;
    }

    /**
     * 获取机构类别
     *
     * @return UnType - 机构类别
     */
    public String getUnType() {
        return unType;
    }

    /**
     * 设置机构类别
     *
     * @param unType 机构类别
     */
    public void setUnType(String unType) {
        this.unType = unType;
    }

    /**
     * 获取诊疗科目
     *
     * @return SpeType - 诊疗科目
     */
    public String getSpeType() {
        return speType;
    }

    /**
     * 设置诊疗科目
     *
     * @param speType 诊疗科目
     */
    public void setSpeType(String speType) {
        this.speType = speType;
    }

    /**
     * 获取法人代表
     *
     * @return LeRep - 法人代表
     */
    public String getLeRep() {
        return leRep;
    }

    /**
     * 设置法人代表
     *
     * @param leRep 法人代表
     */
    public void setLeRep(String leRep) {
        this.leRep = leRep;
    }

    /**
     * 获取负责人
     *
     * @return ChargePeo - 负责人
     */
    public String getChargePeo() {
        return chargePeo;
    }

    /**
     * 设置负责人
     *
     * @param chargePeo 负责人
     */
    public void setChargePeo(String chargePeo) {
        this.chargePeo = chargePeo;
    }

    /**
     * 获取许可项目
     *
     * @return LicPro - 许可项目
     */
    public String getLicPro() {
        return licPro;
    }

    /**
     * 设置许可项目
     *
     * @param licPro 许可项目
     */
    public void setLicPro(String licPro) {
        this.licPro = licPro;
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
     * 获取发证机关
     *
     * @return CerIssue - 发证机关
     */
    public String getCerIssue() {
        return cerIssue;
    }

    /**
     * 设置发证机关
     *
     * @param cerIssue 发证机关
     */
    public void setCerIssue(String cerIssue) {
        this.cerIssue = cerIssue;
    }

    /**
     * 获取发证日期
     *
     * @return CerDate - 发证日期
     */
    public Date getCerDate() {
        return cerDate;
    }

    /**
     * 设置发证日期
     *
     * @param cerDate 发证日期
     */
    public void setCerDate(Date cerDate) {
        this.cerDate = cerDate;
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

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
    
    
}
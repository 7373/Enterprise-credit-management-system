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
 * 描述:  temp_health_quali_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_health_quali_info")
public class TempHealthQualiInfo implements Serializable {

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 姓名
     */
    @Column(name = "PeoName")
    private String peoName;

    /**
     * 性别
     */
    @Column(name = "Sex")
    private String sex;

    /**
     * 身份证号
     */
    @Column(name = "IdNO")
    private String idNO;

    /**
     * 职业类别
     */
    @Column(name = "PraType")
    private String praType;

    /**
     * 职业范围
     */
    @Column(name = "PraScope")
    private String praScope;

    /**
     * 机构名称
     */
    @Column(name = "UnName")
    private String unName;

    /**
     * 医师/护士执业证书编号
     */
    @Column(name = "CerNO")
    private String cerNO;

    /**
     * 技术专业
     */
    @Column(name = "TecType")
    private String tecType;

    /**
     * 技术职称
     */
    @Column(name = "TecName")
    private String tecName;

    /**
     * 许可项目
     */
    @Column(name = "LicPro")
    private String licPro;

    @Column(name = "Source")
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


    public String getPeoName() {
		return peoName;
	}

	public void setPeoName(String peoName) {
		this.peoName = peoName;
	}

	/**
     * 获取性别
     *
     * @return Sex - 性别
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置性别
     *
     * @param sex 性别
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取身份证号
     *
     * @return IdNO - 身份证号
     */
    public String getIdNO() {
        return idNO;
    }

    /**
     * 设置身份证号
     *
     * @param idNO 身份证号
     */
    public void setIdNO(String idNO) {
        this.idNO = idNO;
    }

    /**
     * 获取职业类别
     *
     * @return PraType - 职业类别
     */
    public String getPraType() {
        return praType;
    }

    /**
     * 设置职业类别
     *
     * @param praType 职业类别
     */
    public void setPraType(String praType) {
        this.praType = praType;
    }

    /**
     * 获取职业范围
     *
     * @return PraScope - 职业范围
     */
    public String getPraScope() {
        return praScope;
    }

    /**
     * 设置职业范围
     *
     * @param praScope 职业范围
     */
    public void setPraScope(String praScope) {
        this.praScope = praScope;
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
     * 获取医师/护士执业证书编号
     *
     * @return CerNO - 医师/护士执业证书编号
     */
    public String getCerNO() {
        return cerNO;
    }

    /**
     * 设置医师/护士执业证书编号
     *
     * @param cerNO 医师/护士执业证书编号
     */
    public void setCerNO(String cerNO) {
        this.cerNO = cerNO;
    }

    /**
     * 获取技术专业
     *
     * @return TecType - 技术专业
     */
    public String getTecType() {
        return tecType;
    }

    /**
     * 设置技术专业
     *
     * @param tecType 技术专业
     */
    public void setTecType(String tecType) {
        this.tecType = tecType;
    }

    /**
     * 获取技术职称
     *
     * @return TecName - 技术职称
     */
    public String getTecName() {
        return tecName;
    }

    /**
     * 设置技术职称
     *
     * @param tecName 技术职称
     */
    public void setTecName(String tecName) {
        this.tecName = tecName;
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
     * @return Source
     */
    public String getSource() {
        return source;
    }

    /**
     * @param source
     */
    public void setSource(String source) {
        this.source = source;
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
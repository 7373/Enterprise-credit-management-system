/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述:    nd_towm_skill_cert_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_towm_skill_cert_info")
public class NdTowmSkillCertInfo implements Serializable {
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
     * 身份证号码
     */
    @Column(name = "IdCard")
    private String idCard;

    /**
     * 证件类型
     */
    @Column(name = "CertType")
    private String certType;

    /**
     * 证件号码
     */
    @Column(name = "CertNO")
    private String certNO;

    /**
     * 证书编号
     */
    @Column(name = "CertNumber")
    private String certNumber;

    /**
     * 专业技术职称种类
     */
    @Column(name = "TitleType")
    private String titleType;

    /**
     * 职称级别
     */
    @Column(name = "TitleClass")
    private String titleClass;

    /**
     * 授予时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "GrantDate")
    private Date grantDate;

    /**
     * 评定组织
     */
    @Column(name = "EvaluateUnit")
    private String evaluateUnit;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

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
     * 获取身份证号码
     *
     * @return IdCard - 身份证号码
     */
    public String getIdCard() {
        return idCard;
    }
    
    public String getIdCardDesc() {
    	if(StringUtils.isNotBlank(idCard))
    		 return idCard.substring(0, 10) + "********";
        return idCard;
    }

    /**
     * 设置身份证号码
     *
     * @param idCard 身份证号码
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取证件类型
     *
     * @return CertType - 证件类型
     */
    public String getCertType() {
        return certType;
    }

    /**
     * 设置证件类型
     *
     * @param certType 证件类型
     */
    public void setCertType(String certType) {
        this.certType = certType;
    }

    /**
     * 获取证件号码
     *
     * @return CertNO - 证件号码
     */
    public String getCertNO() {
        return certNO;
    }

    /**
     * 设置证件号码
     *
     * @param certNO 证件号码
     */
    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }

    /**
     * 获取证书编号
     *
     * @return CertNumber - 证书编号
     */
    public String getCertNumber() {
        return certNumber;
    }

    /**
     * 设置证书编号
     *
     * @param certNumber 证书编号
     */
    public void setCertNumber(String certNumber) {
        this.certNumber = certNumber;
    }

    /**
     * 获取专业技术职称种类
     *
     * @return TitleType - 专业技术职称种类
     */
    public String getTitleType() {
        return titleType;
    }

    /**
     * 设置专业技术职称种类
     *
     * @param titleType 专业技术职称种类
     */
    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    /**
     * 获取职称级别
     *
     * @return TitleClass - 职称级别
     */
    public String getTitleClass() {
        return titleClass;
    }

    /**
     * 设置职称级别
     *
     * @param titleClass 职称级别
     */
    public void setTitleClass(String titleClass) {
        this.titleClass = titleClass;
    }

    /**
     * 获取授予时间
     *
     * @return GrantDate - 授予时间
     */
    public Date getGrantDate() {
        return grantDate;
    }

    /**
     * 设置授予时间
     *
     * @param grantDate 授予时间
     */
    public void setGrantDate(Date grantDate) {
        this.grantDate = grantDate;
    }

    /**
     * 获取评定组织
     *
     * @return EvaluateUnit - 评定组织
     */
    public String getEvaluateUnit() {
        return evaluateUnit;
    }

    /**
     * 设置评定组织
     *
     * @param evaluateUnit 评定组织
     */
    public void setEvaluateUnit(String evaluateUnit) {
        this.evaluateUnit = evaluateUnit;
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
}
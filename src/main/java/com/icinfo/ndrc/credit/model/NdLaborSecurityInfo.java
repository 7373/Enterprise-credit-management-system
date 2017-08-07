/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_labor_security_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月21日
 */
@Table(name = "nd_labor_security_info")
public class NdLaborSecurityInfo implements Serializable {
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
     * 所属年月
     */
    @Column(name = "TheYears")
    private String theYears;

    /**
     * 身份证号
     */
    @Column(name = "IdCard")
    private String idCard;

    /**
     * 社会保障号
     */
    @Column(name = "SocialSecurityNum")
    private String socialSecurityNum;

    /**
     * 性别
     */
    @Column(name = "sex")
    private String sex;

    /**
     * 出生日期
     */
    @Column(name = "BirthDate")
    private Date birthDate;

    /**
     * 参保单位名称
     */
    @Column(name = "InsuredUnitName")
    private String insuredUnitName;

    /**
     * 参保单位社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 是否参加养老保险
     */
    @Column(name = "IsHasPensionSafe")
    private String isHasPensionSafe;

    /**
     * 是否参加医疗保险
     */
    @Column(name = "IsHasMedicalSafe")
    private String isHasMedicalSafe;

    /**
     * 是否参加失业保险
     */
    @Column(name = "IsHasUnemploySafe")
    private String isHasUnemploySafe;

    /**
     * 是否参加工伤保险
     */
    @Column(name = "IsHasHurtSafe")
    private String isHasHurtSafe;

    /**
     * 是否参加生育保险
     */
    @Column(name = "IsHasBirthSafe")
    private String isHasBirthSafe;

    /**
     * 是否按月领取基本养老金
     */
    @Column(name = "IsGetPensionMonthly")
    private String isGetPensionMonthly;

    @Column(name = "enterprise_id")
    private String enterprise_id;

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
     * 获取所属年月
     *
     * @return TheYears - 所属年月
     */
    public String getTheYears() {
        return theYears;
    }

    /**
     * 设置所属年月
     *
     * @param theYears 所属年月
     */
    public void setTheYears(String theYears) {
        this.theYears = theYears;
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
     * 获取社会保障号
     *
     * @return SocialSecurityNum - 社会保障号
     */
    public String getSocialSecurityNum() {
        return socialSecurityNum;
    }

    /**
     * 设置社会保障号
     *
     * @param socialSecurityNum 社会保障号
     */
    public void setSocialSecurityNum(String socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }

    /**
     * 获取性别
     *
     * @return sex - 性别
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
     * 获取出生日期
     *
     * @return BirthDate - 出生日期
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * 设置出生日期
     *
     * @param birthDate 出生日期
     */
    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * 获取参保单位名称
     *
     * @return InsuredUnitName - 参保单位名称
     */
    public String getInsuredUnitName() {
        return insuredUnitName;
    }

    /**
     * 设置参保单位名称
     *
     * @param insuredUnitName 参保单位名称
     */
    public void setInsuredUnitName(String insuredUnitName) {
        this.insuredUnitName = insuredUnitName;
    }

    /**
     * 获取参保单位社会信用代码/组织机构代码/工商注册号
     *
     * @return Unicode - 参保单位社会信用代码/组织机构代码/工商注册号
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置参保单位社会信用代码/组织机构代码/工商注册号
     *
     * @param unicode 参保单位社会信用代码/组织机构代码/工商注册号
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取是否参加养老保险
     *
     * @return IsHasPensionSafe - 是否参加养老保险
     */
    public String getIsHasPensionSafe() {
        return isHasPensionSafe;
    }

    /**
     * 设置是否参加养老保险
     *
     * @param isHasPensionSafe 是否参加养老保险
     */
    public void setIsHasPensionSafe(String isHasPensionSafe) {
        this.isHasPensionSafe = isHasPensionSafe;
    }

    /**
     * 获取是否参加医疗保险
     *
     * @return IsHasMedicalSafe - 是否参加医疗保险
     */
    public String getIsHasMedicalSafe() {
        return isHasMedicalSafe;
    }

    /**
     * 设置是否参加医疗保险
     *
     * @param isHasMedicalSafe 是否参加医疗保险
     */
    public void setIsHasMedicalSafe(String isHasMedicalSafe) {
        this.isHasMedicalSafe = isHasMedicalSafe;
    }

    /**
     * 获取是否参加失业保险
     *
     * @return IsHasUnemploySafe - 是否参加失业保险
     */
    public String getIsHasUnemploySafe() {
        return isHasUnemploySafe;
    }

    /**
     * 设置是否参加失业保险
     *
     * @param isHasUnemploySafe 是否参加失业保险
     */
    public void setIsHasUnemploySafe(String isHasUnemploySafe) {
        this.isHasUnemploySafe = isHasUnemploySafe;
    }

    /**
     * 获取是否参加工伤保险
     *
     * @return IsHasHurtSafe - 是否参加工伤保险
     */
    public String getIsHasHurtSafe() {
        return isHasHurtSafe;
    }

    /**
     * 设置是否参加工伤保险
     *
     * @param isHasHurtSafe 是否参加工伤保险
     */
    public void setIsHasHurtSafe(String isHasHurtSafe) {
        this.isHasHurtSafe = isHasHurtSafe;
    }

    /**
     * 获取是否参加生育保险
     *
     * @return IsHasBirthSafe - 是否参加生育保险
     */
    public String getIsHasBirthSafe() {
        return isHasBirthSafe;
    }

    /**
     * 设置是否参加生育保险
     *
     * @param isHasBirthSafe 是否参加生育保险
     */
    public void setIsHasBirthSafe(String isHasBirthSafe) {
        this.isHasBirthSafe = isHasBirthSafe;
    }

    /**
     * 获取是否按月领取基本养老金
     *
     * @return IsGetPensionMonthly - 是否按月领取基本养老金
     */
    public String getIsGetPensionMonthly() {
        return isGetPensionMonthly;
    }

    /**
     * 设置是否按月领取基本养老金
     *
     * @param isGetPensionMonthly 是否按月领取基本养老金
     */
    public void setIsGetPensionMonthly(String isGetPensionMonthly) {
        this.isGetPensionMonthly = isGetPensionMonthly;
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
/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_low_living_people_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_low_living_people_info")
public class TempLowLivingPeopleInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 人员编号
     */
    @Column(name = "PeopleNO")
    private String peopleNO;

    /**
     * 身份证号
     */
    @Column(name = "CertNO")
    private String certNO;

    /**
     * 户编号
     */
    @Column(name = "HomeNO")
    private String homeNO;

    /**
     * 与户主关系
     */
    @Column(name = "RelationWithHouseholder")
    private String relationWithHouseholder;

    /**
     * 姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 性别
     */
    @Column(name = "Sex")
    private String sex;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "BatchNO")
    private String batchNO;

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
     * 获取人员编号
     *
     * @return PeopleNO - 人员编号
     */
    public String getPeopleNO() {
        return peopleNO;
    }

    /**
     * 设置人员编号
     *
     * @param peopleNO 人员编号
     */
    public void setPeopleNO(String peopleNO) {
        this.peopleNO = peopleNO;
    }

    /**
     * 获取身份证号
     *
     * @return CertNO - 身份证号
     */
    public String getCertNO() {
        return certNO;
    }

    /**
     * 设置身份证号
     *
     * @param certNO 身份证号
     */
    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }

    /**
     * 获取户编号
     *
     * @return HomeNO - 户编号
     */
    public String getHomeNO() {
        return homeNO;
    }

    /**
     * 设置户编号
     *
     * @param homeNO 户编号
     */
    public void setHomeNO(String homeNO) {
        this.homeNO = homeNO;
    }

    /**
     * 获取与户主关系
     *
     * @return RelationWithHouseholder - 与户主关系
     */
    public String getRelationWithHouseholder() {
        return relationWithHouseholder;
    }

    /**
     * 设置与户主关系
     *
     * @param relationWithHouseholder 与户主关系
     */
    public void setRelationWithHouseholder(String relationWithHouseholder) {
        this.relationWithHouseholder = relationWithHouseholder;
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
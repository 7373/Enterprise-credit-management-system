/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    temp_low_living_home_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_low_living_home_info")
public class TempLowLivingHomeInfo implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 户编号
     */
    @Column(name = "HomeNO")
    private String homeNO;

    /**
     * 户主姓名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 户主身份证号
     */
    @Column(name = "CertNO")
    private String certNO;

    /**
     * 家庭居住地址
     */
    @Column(name = "HomeAddr")
    private String homeAddr;

    /**
     * 家庭户籍地址
     */
    @Column(name = "PermanentAddr")
    private String permanentAddr;

    /**
     * 救助类别
     */
    @Column(name = "HelpType")
    private String helpType;

    /**
     * 救助证号
     */
    @Column(name = "HelpCertNO")
    private String helpCertNO;

    /**
     * 家庭享受待遇人数
     */
    @Column(name = "BenefitsNum")
    private String benefitsNum;

    /**
     * 家庭人口
     */
    @Column(name = "FamilyPopulation")
    private String familyPopulation;

    /**
     * 本次救助待遇享受期限
     */
    @Column(name = "EnjoyHelpDate")
    private Date enjoyHelpDate;

    /**
     * 最近一次审批时间
     */
    @Column(name = "RecentCheckDate")
    private Date recentCheckDate;

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
     * 获取户主姓名
     *
     * @return Name - 户主姓名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置户主姓名
     *
     * @param name 户主姓名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取户主身份证号
     *
     * @return CertNO - 户主身份证号
     */
    public String getCertNO() {
        return certNO;
    }

    /**
     * 设置户主身份证号
     *
     * @param certNO 户主身份证号
     */
    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }

    /**
     * 获取家庭居住地址
     *
     * @return HomeAddr - 家庭居住地址
     */
    public String getHomeAddr() {
        return homeAddr;
    }

    /**
     * 设置家庭居住地址
     *
     * @param homeAddr 家庭居住地址
     */
    public void setHomeAddr(String homeAddr) {
        this.homeAddr = homeAddr;
    }

    /**
     * 获取家庭户籍地址
     *
     * @return PermanentAddr - 家庭户籍地址
     */
    public String getPermanentAddr() {
        return permanentAddr;
    }

    /**
     * 设置家庭户籍地址
     *
     * @param permanentAddr 家庭户籍地址
     */
    public void setPermanentAddr(String permanentAddr) {
        this.permanentAddr = permanentAddr;
    }

    /**
     * 获取救助类别
     *
     * @return HelpType - 救助类别
     */
    public String getHelpType() {
        return helpType;
    }

    /**
     * 设置救助类别
     *
     * @param helpType 救助类别
     */
    public void setHelpType(String helpType) {
        this.helpType = helpType;
    }

    /**
     * 获取救助证号
     *
     * @return HelpCertNO - 救助证号
     */
    public String getHelpCertNO() {
        return helpCertNO;
    }

    /**
     * 设置救助证号
     *
     * @param helpCertNO 救助证号
     */
    public void setHelpCertNO(String helpCertNO) {
        this.helpCertNO = helpCertNO;
    }

    /**
     * 获取家庭享受待遇人数
     *
     * @return BenefitsNum - 家庭享受待遇人数
     */
    public String getBenefitsNum() {
        return benefitsNum;
    }

    /**
     * 设置家庭享受待遇人数
     *
     * @param benefitsNum 家庭享受待遇人数
     */
    public void setBenefitsNum(String benefitsNum) {
        this.benefitsNum = benefitsNum;
    }

    /**
     * 获取家庭人口
     *
     * @return FamilyPopulation - 家庭人口
     */
    public String getFamilyPopulation() {
        return familyPopulation;
    }

    /**
     * 设置家庭人口
     *
     * @param familyPopulation 家庭人口
     */
    public void setFamilyPopulation(String familyPopulation) {
        this.familyPopulation = familyPopulation;
    }

    /**
     * 获取本次救助待遇享受期限
     *
     * @return EnjoyHelpDate - 本次救助待遇享受期限
     */
    public Date getEnjoyHelpDate() {
        return enjoyHelpDate;
    }

    /**
     * 设置本次救助待遇享受期限
     *
     * @param enjoyHelpDate 本次救助待遇享受期限
     */
    public void setEnjoyHelpDate(Date enjoyHelpDate) {
        this.enjoyHelpDate = enjoyHelpDate;
    }

    /**
     * 获取最近一次审批时间
     *
     * @return RecentCheckDate - 最近一次审批时间
     */
    public Date getRecentCheckDate() {
        return recentCheckDate;
    }

    /**
     * 设置最近一次审批时间
     *
     * @param recentCheckDate 最近一次审批时间
     */
    public void setRecentCheckDate(Date recentCheckDate) {
        this.recentCheckDate = recentCheckDate;
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
/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.gateway.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

/**
 * 描述:    nd_punish 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月23日
 */
@Table(name = "nd_punish")
public class NdPunish implements Serializable {
    @Id
    @Column(name = "id")
   private Integer id;

    @Column(name = "uid")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 企业标识
     */
    @Column(name = "EnterpriseID")
    private String enterpriseID;

    /**
     * 企业名称
     */
    @Column(name = "EntName")
    private String entName;

    /**
     * 部门
     */
    @Column(name = "Dept")
    private String dept;

    /**
     * 案件名称
     */
    @Column(name = "CaseName")
    private String caseName;

    /**
     * 案号
     */
    @Column(name = "CaseNo")
    private String caseNo;

    @Column(name = "StartDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date startDate;

    @Column(name = "EndDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endDate;
    
    @Column(name="InputDate")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date inputDate;
    
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
     * 获取企业标识
     *
     * @return EnterpriseID - 企业标识
     */
    public String getEnterpriseID() {
        return enterpriseID;
    }

    /**
     * 设置企业标识
     *
     * @param enterpriseID 企业标识
     */
    public void setEnterpriseID(String enterpriseID) {
        this.enterpriseID = enterpriseID;
    }

    /**
     * 获取企业名称
     *
     * @return EntName - 企业名称
     */
    public String getEntName() {
        return entName;
    }

    /**
     * 设置企业名称
     *
     * @param entName 企业名称
     */
    public void setEntName(String entName) {
        this.entName = entName;
    }

    /**
     * 获取部门
     *
     * @return Dept - 部门
     */
    public String getDept() {
        return dept;
    }

    /**
     * 设置部门
     *
     * @param dept 部门
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * 获取案件名称
     *
     * @return CaseName - 案件名称
     */
    public String getCaseName() {
        return caseName;
    }

    /**
     * 设置案件名称
     *
     * @param caseName 案件名称
     */
    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    /**
     * 获取案号
     *
     * @return CaseNo - 案号
     */
    public String getCaseNo() {
        return caseNo;
    }

    /**
     * 设置案号
     *
     * @param caseNo 案号
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }

    /**
     * @return StartDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return EndDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @param inputDate
     */
	public Date getInputDate() {
		return inputDate;
	}

    /**
     * @param inputDate
     */
	public void setInputDate(Date inputDate) {
		this.inputDate = inputDate;
	}
    
}
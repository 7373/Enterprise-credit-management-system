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
 * 描述:    temp_redblack_list 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月16日
 */
@Table(name = "temp_redblack_list")
public class TempRedBlackList implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 当事人姓名/单位名称
     */
    @Column(name = "PartyName")
    private String partyName;

    /**
     * 身份证号/社会信用代码/组织机构代码/工商注册号
     */
    @Column(name = "CertNO")
    private String certNO;

    /**
     * 列入红/黑名单事由
     */
    @Column(name = "Inclusion")
    private String inclusion;

    /**
     * 发生时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "OccurrDate")
    private Date occurrDate;

    /**
     * 列入名单时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "IncludeListDate")
    private Date includeListDate;

    @Column(name = "ImportDept")
    private String importDept;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Column(name = "ImportTime")
    private Date importTime;
    
    //批次号
    @Column(name="BatchNO")
    private String batchNO;
    
    //q:企业，g:个人
    @Column(name="PartyType")
    private String partyType;

    //r:红名单，b:黑名单
    @Column(name="ListType")
    private String listType;
    
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
     * 获取当事人姓名/单位名称
     *
     * @return PartyName - 当事人姓名/单位名称
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * 设置当事人姓名/单位名称
     *
     * @param partyName 当事人姓名/单位名称
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    /**
     * 获取身份证号/社会信用代码/组织机构代码/工商注册号
     *
     * @return CertNO - 身份证号/社会信用代码/组织机构代码/工商注册号
     */
    public String getCertNO() {
        return certNO;
    }

    /**
     * 设置身份证号/社会信用代码/组织机构代码/工商注册号
     *
     * @param certNO 身份证号/社会信用代码/组织机构代码/工商注册号
     */
    public void setCertNO(String certNO) {
        this.certNO = certNO;
    }

    /**
     * 获取列入红/黑名单事由
     *
     * @return Inclusion - 列入红/黑名单事由
     */
    public String getInclusion() {
        return inclusion;
    }

    /**
     * 设置列入红/黑名单事由
     *
     * @param inclusion 列入红/黑名单事由
     */
    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
    }

    /**
     * 获取发生时间
     *
     * @return OccurrDate - 发生时间
     */
    public Date getOccurrDate() {
        return occurrDate;
    }

    /**
     * 设置发生时间
     *
     * @param occurrDate 发生时间
     */
    public void setOccurrDate(Date occurrDate) {
        this.occurrDate = occurrDate;
    }

    /**
     * 获取列入名单时间
     *
     * @return IncludeListDate - 列入名单时间
     */
    public Date getIncludeListDate() {
        return includeListDate;
    }

    /**
     * 设置列入名单时间
     *
     * @param includeListDate 列入名单时间
     */
    public void setIncludeListDate(Date includeListDate) {
        this.includeListDate = includeListDate;
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

	public String getBatchNO() {
		return batchNO;
	}

	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}

	public String getPartyType() {
		return partyType;
	}

	public void setPartyType(String partyType) {
		this.partyType = partyType;
	}

	public String getListType() {
		return listType;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

}
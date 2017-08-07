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
 * 描述:    nd_red_black_list 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月19日
 */
@Table(name = "nd_red_black_list")
public class NdRedBlackList implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;

    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 姓名/企业名称
     */
    @Column(name = "PartyName")
    private String partyName;

    /**
     * 身份证号
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 数据来源
     */
    @Column(name = "ImportDept")
    private String importDept;

    /**
     * 列入事由
     */
    @Column(name = "Inclusion")
    private String inclusion;

    /**
     * 发生日期
     */
    @Column(name = "OccurrDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date occurrDate;

    /**
     * 列入名单日期
     */
    @Column(name = "IncludeListDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date includeListDate;

    /**
     * r:红，b:黑
     */
    @Column(name = "ListType")
    private String listType;

    /**
     * 企业唯一标示
     */
    @Column(name = "enterprise_id")
    private String enterprise_id;

    /**
     * q:企业,g:个人
     */
    @Column(name = "PartyType")
    private String partyType;

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
     * 获取姓名/企业名称
     *
     * @return PartyName - 姓名/企业名称
     */
    public String getPartyName() {
        return partyName;
    }

    /**
     * 设置姓名/企业名称
     *
     * @param partyName 姓名/企业名称
     */
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }



    /**
     * 获取列入事由
     *
     * @return Inclusion - 列入事由
     */
    public String getInclusion() {
        return inclusion;
    }

    /**
     * 设置列入事由
     *
     * @param inclusion 列入事由
     */
    public void setInclusion(String inclusion) {
        this.inclusion = inclusion;
    }

    /**
     * 获取发生日期
     *
     * @return OccurrDate - 发生日期
     */
    public Date getOccurrDate() {
        return occurrDate;
    }

    /**
     * 设置发生日期
     *
     * @param occurrDate 发生日期
     */
    public void setOccurrDate(Date occurrDate) {
        this.occurrDate = occurrDate;
    }

    /**
     * 获取列入名单日期
     *
     * @return IncludeListDate - 列入名单日期
     */
    public Date getIncludeListDate() {
        return includeListDate;
    }

    /**
     * 设置列入名单日期
     *
     * @param includeListDate 列入名单日期
     */
    public void setIncludeListDate(Date includeListDate) {
        this.includeListDate = includeListDate;
    }

    /**
     * 获取r:红，b:黑
     *
     * @return ListType - r:红，b:黑
     */
    public String getListType() {
        return listType;
    }

    /**
     * 设置r:红，b:黑
     *
     * @param listType r:红，b:黑
     */
    public void setListType(String listType) {
        this.listType = listType;
    }

    /**
     * 获取企业唯一标示
     *
     * @return enterprise_id - 企业唯一标示
     */
    public String getEnterprise_id() {
        return enterprise_id;
    }

    /**
     * 设置企业唯一标示
     *
     * @param enterprise_id 企业唯一标示
     */
    public void setEnterprise_id(String enterprise_id) {
        this.enterprise_id = enterprise_id;
    }

    /**
     * 获取q:企业,g:个人
     *
     * @return PartyType - q:企业,g:个人
     */
    public String getPartyType() {
        return partyType;
    }

    /**
     * 设置q:企业,g:个人
     *
     * @param partyType q:企业,g:个人
     */
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }

	public String getUnicode() {
		return unicode;
	}

	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}

	public String getImportDept() {
		return importDept;
	}

	public void setImportDept(String importDept) {
		this.importDept = importDept;
	}
    
    
}
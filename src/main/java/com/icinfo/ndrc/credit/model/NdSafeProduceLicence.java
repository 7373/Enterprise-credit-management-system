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
 * 描述:    nd_safe_produce_licence 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月21日
 */
@Table(name = "nd_safe_produce_licence")
public class NdSafeProduceLicence implements Serializable {
    @Id
    @Column(name = "id")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    private Integer id;

    @Column(name = "uid")
    private String uid;
    
    @Column(name = "EntName")
    private String entName;
    
    @Column(name = "Unicode")
    private String unicode;
    /**
     * 是否需要安全生产许可证，0：需要，1：不需要。
     */
    @Column(name = "IsNeedLicence")
    private String isNeedLicence;

    /**
     * 许可证号码
     */
    @Column(name = "LicenceNO")
    private String licenceNO;

    /**
     * 许可证范围
     */
    @Column(name = "LicenceRange")
    private String licenceRange;

    /**
     * 许可证有效时间
     */
    @Column(name = "LicenceEndTime")
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date licenceEndTime;

    @Column(name = "ImportDept")
    private String importDept;

    @Column(name = "ImportTime")
    private Date importTime;

    @Column(name = "enterprise_id")
    private String enterprise_id;

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
     * @return IsNeedLicence
     */
    public String getIsNeedLicence() {
        return isNeedLicence;
    }

    /**
     * @param isNeedLicence
     */
    public void setIsNeedLicence(String isNeedLicence) {
        this.isNeedLicence = isNeedLicence;
    }

    /**
     * @return LicenceNO
     */
    public String getLicenceNO() {
        return licenceNO;
    }

    /**
     * @param licenceNO
     */
    public void setLicenceNO(String licenceNO) {
        this.licenceNO = licenceNO;
    }

    /**
     * @return LicenceRange 
     */
    public String getLicenceRange() {
        return licenceRange;
    }

    /**
     * @param licenceRange
     */
    public void setLicenceRange(String licenceRange) {
        this.licenceRange = licenceRange;
    }

    /**
     * @return LicenceEndTime 
     */
    public Date getLicenceEndTime() {
        return licenceEndTime;
    }

    /**
     * @param licenceEndTime
     */
    public void setLicenceEndTime(Date licenceEndTime) {
        this.licenceEndTime = licenceEndTime;
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

	public String getEntName() {
		return entName;
	}

	public void setEntName(String entName) {
		this.entName = entName;
	}

	public String getUnicode() {
		return unicode;
	}

	public void setUnicode(String unicode) {
		this.unicode = unicode;
	}
    
    
}
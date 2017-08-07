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
 * 描述:    temp_safe_produce_licence 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月20日
 */
@Table(name = "temp_safe_produce_licence")
public class TempSafeProduceLincence implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    @Column(name="EntName")
    private String entName;
    
    @Column(name="Unicode")
    private String unicode;
    /**
     * 是否需要申请安全生产许可证,0:需要,1:不需要
     */
    
    @Column(name = "IsNeedLicence")
    private String isNeedLicence;

    /**
     * 许可证号码
     */
    @Column(name = "LicenceNO")
    private String licenceNO;

    /**
     * 许可范围
     */
    @Column(name = "LicenceRange")
    private String licenceRange;

    /**
     * 许可证有效期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone="GMT+8")
    @Column(name = "LicenceEndTime")
    private Date licenceEndTime;

    @Column(name = "ImportDept")
    private String importDept;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    @Column(name = "ImportTime")
    private Date importTime;

    /**
     * Excel上传的时候自动生成的uuid,方便删除
     */
    @Column(name = "BatchNO")
    private String batchNO;

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
     * 获取是否需要申请安全生产许可证,0:需要,1:不需要
     *
     * @return IsNeedLicence - 是否需要申请安全生产许可证,0:需要,1:不需要
     */
    public String getIsNeedLicence() {
        return isNeedLicence;
    }

    /**
     * 设置是否需要申请安全生产许可证,0:需要,1:不需要
     *
     * @param isNeedLicence 是否需要申请安全生产许可证,0:需要,1:不需要
     */
    public void setIsNeedLicence(String isNeedLicence) {
        this.isNeedLicence = isNeedLicence;
    }

    /**
     * 获取许可证号码
     *
     * @return LicenceNO - 许可证号码
     */
    public String getLicenceNO() {
        return licenceNO;
    }

    /**
     * 设置许可证号码
     *
     * @param licenceNO 许可证号码
     */
    public void setLicenceNO(String licenceNO) {
        this.licenceNO = licenceNO;
    }

    /**
     * 获取许可范围
     *
     * @return LicenceRange - 许可范围
     */
    public String getLicenceRange() {
        return licenceRange;
    }

    /**
     * 设置许可范围
     *
     * @param licenceRange 许可范围
     */
    public void setLicenceRange(String licenceRange) {
        this.licenceRange = licenceRange;
    }

    /**
     * 获取许可证有效期
     *
     * @return LicenceEndTime - 许可证有效期
     */
    public Date getLicenceEndTime() {
        return licenceEndTime;
    }

    /**
     * 设置许可证有效期
     *
     * @param licenceEndTime 许可证有效期
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
     * 获取Excel上传的时候自动生成的uuid,方便删除
     *
     * @return BatchNO - Excel上传的时候自动生成的uuid,方便删除
     */
    public String getBatchNO() {
        return batchNO;
    }

    /**
     * 设置Excel上传的时候自动生成的uuid,方便删除
     *
     * @param batchNO Excel上传的时候自动生成的uuid,方便删除
     */
    public void setBatchNO(String batchNO) {
        this.batchNO = batchNO;
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
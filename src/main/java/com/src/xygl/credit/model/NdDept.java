/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_dept 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月19日
 */
@Table(name = "nd_dept")
public class NdDept implements Serializable {
    @Id
    @Column(name = "id")
    private Integer id;
    
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator="select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 部门code
     */
    @Column(name = "dep_code")
    private String depCode;

    /**
     * 上级code
     */
    @Column(name = "dep_pcode")
    private String depPcode;

    /**
     * 部门名称
     */
    @Column(name = "dep_name")
    private String depName;

    /**
     * 部门所属系统类别
     */
    @Column(name = "dep_sys_type")
    private String depSysType;

    @Column(name = "dep_set_date")
    private Date depSetDate;

    /**
     * 设置人
     */
    @Column(name = "dep_set_name")
    private String depSetName;

    @Column(name = "dep_remark")
    private String depRemark;

    /**
     * 排序
     */
    @Column(name = "dep_order_no")
    private String depOrderNO;

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

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}

	public String getDepPcode() {
		return depPcode;
	}

	public void setDepPcode(String depPcode) {
		this.depPcode = depPcode;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getDepSysType() {
		return depSysType;
	}

	public void setDepSysType(String depSysType) {
		this.depSysType = depSysType;
	}

	public Date getDepSetDate() {
		return depSetDate;
	}

	public void setDepSetDate(Date depSetDate) {
		this.depSetDate = depSetDate;
	}

	public String getDepSetName() {
		return depSetName;
	}

	public void setDepSetName(String depSetName) {
		this.depSetName = depSetName;
	}

	public String getDepRemark() {
		return depRemark;
	}

	public void setDepRemark(String depRemark) {
		this.depRemark = depRemark;
	}

	public String getDepOrderNO() {
		return depOrderNO;
	}

	public void setDepOrderNO(String depOrderNO) {
		this.depOrderNO = depOrderNO;
	}

    
}
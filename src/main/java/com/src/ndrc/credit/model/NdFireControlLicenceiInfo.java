/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述:    nd_fire_control_licence_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * @author framework generator
 * @date 2017年06月30日
 */
@Table(name = "nd_fire_control_licence_info")
public class NdFireControlLicenceiInfo implements Serializable {
    @Id
    @Column(name = "id")
 
    private Integer id;
	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    @Column(name = "uid")
    private String uid;

    /**
     * 项目名称
     */
    @Column(name = "ProjectName")
    private String projectName;

    /**
     * 单位社会信用代码/工商注册号/组织机构代码
     */
    @Column(name = "Unicode")
    private String unicode;

    /**
     * 单位名称
     */
    @Column(name = "UnitName")
    private String unitName;

    /**
     * 审批类型
     */
    @Column(name = "CheckCategory")
    private String checkCategory;

    /**
     * 审批文号
     */
    @Column(name = "CheckDocNO")
    private String checkDocNO;

    /**
     * 审批时间
     */
    @Column(name = "CheckDate")
    private Date checkDate;

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
     * 获取项目名称
     *
     * @return ProjectName - 项目名称
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称
     *
     * @param projectName 项目名称
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * 获取单位社会信用代码/工商注册号/组织机构代码
     *
     * @return Unicode - 单位社会信用代码/工商注册号/组织机构代码
     */
    public String getUnicode() {
        return unicode;
    }

    /**
     * 设置单位社会信用代码/工商注册号/组织机构代码
     *
     * @param unicode 单位社会信用代码/工商注册号/组织机构代码
     */
    public void setUnicode(String unicode) {
        this.unicode = unicode;
    }

    /**
     * 获取单位名称
     *
     * @return UnitName - 单位名称
     */
    public String getUnitName() {
        return unitName;
    }

    /**
     * 设置单位名称
     *
     * @param unitName 单位名称
     */
    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    /**
     * 获取审批类型
     *
     * @return CheckCategory - 审批类型
     */
    public String getCheckCategory() {
        return checkCategory;
    }

    /**
     * 设置审批类型
     *
     * @param checkCategory 审批类型
     */
    public void setCheckCategory(String checkCategory) {
        this.checkCategory = checkCategory;
    }

    /**
     * 获取审批文号
     *
     * @return CheckDocNO - 审批文号
     */
    public String getCheckDocNO() {
        return checkDocNO;
    }

    /**
     * 设置审批文号
     *
     * @param checkDocNO 审批文号
     */
    public void setCheckDocNO(String checkDocNO) {
        this.checkDocNO = checkDocNO;
    }

    /**
     * 获取审批时间
     *
     * @return CheckDate - 审批时间
     */
    public Date getCheckDate() {
        return checkDate;
    }

    /**
     * 设置审批时间
     *
     * @param checkDate 审批时间
     */
    public void setCheckDate(Date checkDate) {
        this.checkDate = checkDate;
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
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年7月3日上午8:21:17
	 * @return the enterprise_id
	 */
	public String getEnterprise_id() {
		return enterprise_id;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年7月3日上午8:21:17
	 * @param enterprise_id the enterprise_id to set
	 */
	public void setEnterprise_id(String enterprise_id) {
		this.enterprise_id = enterprise_id;
	}
    
}
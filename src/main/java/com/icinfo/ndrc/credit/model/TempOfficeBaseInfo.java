/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 */
package com.icinfo.ndrc.credit.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 * 描述: temp_office_base_info 对应的实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 * 
 * @author framework generator
 * @date 2017年06月29日
 */
@Table(name = "temp_office_base_info")
public class TempOfficeBaseInfo implements Serializable {
	@Id
	@Column(name = "id")
	private Integer id;

	@Before
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
	@Column(name = "uid")
	private String uid;

	/**
	 * 姓名
	 */
	@Column(name = "Name")
	private String name;

	/**
	 * 身份证号码
	 */
	@Column(name = "IdCard")
	private String idCard;

	/**
	 * 职务
	 */
	@Column(name = "Post")
	private String post;

	@Column(name = "ImportDept")
	private String importDept;

	@Column(name = "ImportTime")
	private Date importTime;

	/**
	 * 0:未删除，1:已删除
	 */
	@Column(name = "IsUse")
	private String isUse;

	/**
	 * 
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
	 * @param name
	 *            姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取身份证号码
	 *
	 * @return IdCard - 身份证号码
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 设置身份证号码
	 *
	 * @param idCard
	 *            身份证号码
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 获取职务
	 *
	 * @return Post - 职务
	 */
	public String getPost() {
		return post;
	}

	/**
	 * 设置职务
	 *
	 * @param post
	 *            职务
	 */
	public void setPost(String post) {
		this.post = post;
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
	 * 获取0:未删除，1:已删除
	 *
	 * @return IsUse - 0:未删除，1:已删除
	 */
	public String getIsUse() {
		return isUse;
	}

	/**
	 * 设置0:未删除，1:已删除
	 *
	 * @param isUse
	 *            0:未删除，1:已删除
	 */
	public void setIsUse(String isUse) {
		this.isUse = isUse;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月29日下午4:00:35
	 * @return the batchNO
	 */
	public String getBatchNO() {
		return batchNO;
	}

	/**
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * 
	 * @author ranah
	 * @when 2017年6月29日下午4:00:35
	 * @param batchNO
	 *            the batchNO to set
	 */
	public void setBatchNO(String batchNO) {
		this.batchNO = batchNO;
	}
}
/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.dto;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.ndrc.gateway.model.NdPunish;

/**
 * 描述:    nd_punish 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
public class NdPunishDto extends NdPunish {
	
	@Column(name="Type")
	private String type;
	
	@Column(name="EntName")
	private String name;
	
	@Column(name="CaseName")
	private String title;
	
	@Column(name="StartDate")
	@JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
	private Date decideTime;
	
	@Column(name="dept_name")
	private String deptName;
	
	
	@Column(name="CountNum")
	private String countNum;
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDecideTime() {
		return decideTime;
	}

	public void setDecideTime(Date decideTime) {
		this.decideTime = decideTime;
	}


	public String getCountNum() {
		return countNum;
	}

	public void setCountNum(String countNum) {
		this.countNum = countNum;
	}
	

}
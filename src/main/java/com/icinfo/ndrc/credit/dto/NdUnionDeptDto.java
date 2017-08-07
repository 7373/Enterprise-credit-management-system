/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.dto;

import java.util.Date;

import com.icinfo.ndrc.credit.model.NdUnionDept;

/**
 * 描述:    nd_union_dept 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
public class NdUnionDeptDto extends NdUnionDept {
	
	// 联系人
	private String contactsName;
	
	//联系电话
	private String contactsTel;
	
	// 发起部门
	private String contactsDepName;
	
	// 联系邮箱
	private String contactsMail;
	
	// 协查原因
	private String assistReason;
	
	// 处理结果 1 已处理 0 待处理
	private String handleStatue;
	
	// 发起时间
	private Date  createTime;
	
	// 接收部门
	private String recDepName;

	
	
	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsTel() {
		return contactsTel;
	}

	public void setContactsTel(String contactsTel) {
		this.contactsTel = contactsTel;
	}

	public String getContactsDepName() {
		return contactsDepName;
	}

	public void setContactsDepName(String contactsDepName) {
		this.contactsDepName = contactsDepName;
	}

	public String getContactsMail() {
		return contactsMail;
	}

	public void setContactsMail(String contactsMail) {
		this.contactsMail = contactsMail;
	}

	public String getHandleStatue() {
		return handleStatue;
	}

	public void setHandleStatue(String handleStatue) {
		this.handleStatue = handleStatue;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRecDepName() {
		return recDepName;
	}

	public void setRecDepName(String recDepName) {
		this.recDepName = recDepName;
	}

	public String getAssistReason() {
		return assistReason;
	}

	public void setAssistReason(String assistReason) {
		this.assistReason = assistReason;
	}

}
/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.dto;

import com.icinfo.ndrc.credit.model.NdDept;

/**
 * 描述:    nd_dept 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
public class NdDeptDto extends NdDept {
	
	private String parentid;
	
	private String Nocheck;
	
	private String IsParent;

	public String getParentid() {
		return parentid;
	}

	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getNocheck() {
		return Nocheck;
	}

	public void setNocheck(String nocheck) {
		Nocheck = nocheck;
	}

	public String getIsParent() {
		return IsParent;
	}

	public void setIsParent(String isParent) {
		IsParent = isParent;
	}
}
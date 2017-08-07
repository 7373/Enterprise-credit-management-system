/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.dto;

import java.util.List;

import com.icinfo.ndrc.credit.model.NdUnionDept;
import com.icinfo.ndrc.credit.model.NdUnionInfo;
import com.icinfo.ndrc.credit.model.NdUnionObj;

/**
 * 描述:    nd_union_info 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
public class NdUnionInfoDto extends NdUnionInfo {
	
	private List<NdUnionObj> unionObjList;
	
	private List<NdUnionDept> unionDeptList;


	public List<NdUnionObj> getUnionObjList() {
		return unionObjList;
	}

	public void setUnionObjList(List<NdUnionObj> unionObjList) {
		this.unionObjList = unionObjList;
	}

	public List<NdUnionDept> getUnionDeptList() {
		return unionDeptList;
	}

	public void setUnionDeptList(List<NdUnionDept> unionDeptList) {
		this.unionDeptList = unionDeptList;
	}
	
	
	
	
}


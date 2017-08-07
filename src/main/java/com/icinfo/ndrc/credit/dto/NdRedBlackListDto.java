/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.dto;

import java.util.Date;

import javax.persistence.Column;

import com.icinfo.ndrc.credit.model.NdRedBlackList;

/**
 * 描述:    nd_red_black_list 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
public class NdRedBlackListDto extends NdRedBlackList {
	/**
	 *
	 */
	private String listType;//红黑类型

	private Date includeListDateStart;
	private Date includeListDateEnd;
	
	@Column(name="CountRedBlack")
	private Integer countRedBlack;
	

	public Date getIncludeListDateStart() {
		return includeListDateStart;
	}

	public void setIncludeListDateStart(Date includeListDateStart) {
		this.includeListDateStart = includeListDateStart;
	}

	public Date getIncludeListDateEnd() {
		return includeListDateEnd;
	}

	public void setIncludeListDateEnd(Date includeListDateEnd) {
		this.includeListDateEnd = includeListDateEnd;
	}

	public String getListType() {
		if(super.getListType()!=null){
			return super.getListType().equals("r")?"红名单":"黑名单";
		}
		else
		return null;
	}

	public void setListType(String listType) {
		this.listType = listType;
	}

	public Integer getCountRedBlack() {
		return countRedBlack;
	}

	public void setCountRedBlack(Integer countRedBlack) {
		this.countRedBlack = countRedBlack;
	}
	
	
}
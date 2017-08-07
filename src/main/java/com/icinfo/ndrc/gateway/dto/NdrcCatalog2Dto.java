/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.dto;

import javax.persistence.Column;

import com.icinfo.ndrc.gateway.model.NdrcCatalog2;

/**
 * 描述:    NDRC_CATALOG2 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
public class NdrcCatalog2Dto extends NdrcCatalog2 {
	
	@Column(name = "CatalogName1")
	private String catalogName1;

	public String getCatalogName1() {
		return catalogName1;
	}

	public void setCatalogName1(String catalogName1) {
		this.catalogName1 = catalogName1;
	}
	
}
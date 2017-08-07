/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.dto;

import javax.persistence.Column;

import com.icinfo.ndrc.gateway.model.NdrcNewsPublish;

/**
 * 描述:    NDRC_NEWS_PUBLISH 对应的DTO类.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
public class NdrcNewsPublishDto extends NdrcNewsPublish {
	
	@Column(name="Count")
	private Integer count;//统计出的个数

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}
	
	
}
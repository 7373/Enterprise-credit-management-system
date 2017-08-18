/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.dto.NdLicenseDto;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.model.NdLicense;

/**
 * 描述:    nd_license 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
public interface INdLicenseService extends BaseService {
	/**
	 * 查询行政许可信息
	 * @param map
	 * @return
	 */
	List<NdLicenseDto> selectListByMap(PageRequest request);
	
	/**
	 * 七天双公示查询
	 * @param request
	 * @return
	 */
	public List<NdLicenseDto> selectSevenDoubleList(PageRequest request);
	
	/**
	 * 查询指定uid的七天双公示内容（许可）
	 * @param uid
	 * @return
	 */
	public NdLicense selectSevenDoubleListDetail(String uid);
	/**
	 * 七天双公示内容许可的数目和最新导入时间
	 * @return
	 */
	public NdLicenseDto selectCountAndTime();
}
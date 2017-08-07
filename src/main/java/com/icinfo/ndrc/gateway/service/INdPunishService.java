/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import java.util.List;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.model.NdPunish;

/**
 * 描述:    nd_punish 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
public interface INdPunishService extends BaseService {
	
	/**
	 * 查询行政处罚信息
	 * @param request
	 * @return
	 */
	List<NdPunishDto> selectListByMap(PageRequest request);
	
	/**
	 * 查询指定uid的七天双公示内容（处罚）
	 * @param uid
	 * @return
	 */
	public NdPunish selectSevenDoubleListDetail(String uid);
	
	/**
	 * 七天双公示内容处罚的数目和最新导入时间
	 * @return
	 */
	public NdPunishDto selectCountAndTime();
	
}
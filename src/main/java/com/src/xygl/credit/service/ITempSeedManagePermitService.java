/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempSeedManagePermitDto;
import com.icinfo.ndrc.credit.model.TempSeedManagePermit;

/**
 * 描述:    temp_seed_manage_permit 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
public interface ITempSeedManagePermitService extends BaseService,IBatchService {
	
	/**
	 * 读取Excel存取
	 * @author zjj
	 */
	public String record(String deptName,HSSFSheet sheet,String bacthNO) throws Exception;
	
	/**
	 * dataTable分页查询
	 * @author fanzhen
	 * @date 20170620
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TempSeedManagePermit> findMsg(PageRequest request) throws Exception;
	
	/**
	 * 根据dto来删除记录
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int deleteByDto(TempSeedManagePermitDto dto) throws Exception;
}
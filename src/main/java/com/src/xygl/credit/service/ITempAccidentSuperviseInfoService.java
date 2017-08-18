/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempAccidentSuperviseInfoDto;
import com.icinfo.ndrc.credit.model.TempAccidentSuperviseInfo;

/**
 * 描述:    temp_accident_supervise_info 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
public interface ITempAccidentSuperviseInfoService extends BaseService,IBatchService{
	
	/**
	 * 插入TempAccidentSuperviseInfo的Bean
	 * @author fanzhen
	 * @date 20170616
	 * @param info
	 * @return
	 * @throws Exception
	 */
	public int Insert(TempAccidentSuperviseInfo info) throws Exception;
	/**
	 * 读取Excel存取
	 * @author fanzhen
	 * @date 20170616
	 * @param sheet
	 * @throws Exception
	 */
	public String record(String deptName,HSSFSheet sheet,String uid) throws Exception;
	
	/**
	 * 查询
	 * @author fanzhen
	 * @date 20170619
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<TempAccidentSuperviseInfo> findMsg(PageRequest request) throws Exception;
	
	/**
	 * 删除
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int deleteByDto(TempAccidentSuperviseInfoDto dto) throws Exception;
}
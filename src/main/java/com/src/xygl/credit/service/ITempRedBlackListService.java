/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.credit.dto.TempRedBlackListDto;
import com.icinfo.ndrc.credit.model.TempRedBlackList;

/**
 * 描述:    temp_redblack_list 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月16日
 */
public interface ITempRedBlackListService extends BaseService,IBatchService {
	/**
	 * 解析Excel为红黑名单时保存到数据库中
	 * @author fanzhen
	 * @date 20170616
	 * @param sheet
	 * @throws Exception
	 */
	public String record(String deptName,HSSFSheet sheet,String batchNO,String listType) throws Exception;
	
	/**
	 * dataTable 分页查询
	 * @author fanzhen
	 * @date 20170620
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TempRedBlackList> findMsg(PageRequest request) throws Exception;
	/**
	 * 根据红黑名单dto来删除信息
	 * @author fanzhen
	 * @date 20170620
	 * @param dto
	 * @return
	 * @throws Exception
	 */
	public int deleteByDto(TempRedBlackListDto dto) throws Exception;
}
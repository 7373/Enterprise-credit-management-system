/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.TempSafeProduceLincenceDto;
import com.icinfo.ndrc.credit.model.TempSafeProduceLincence;
import com.icinfo.ndrc.credit.service.ITempSafeProduceLincenceService;

/**
 * 描述:    temp_safe_produce_licence 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
@Controller()
@RequestMapping("/tempSafeProduceLincence")
public class TempSafeProduceLincenceController extends BaseController {
	
	@Autowired
	private ITempSafeProduceLincenceService tempSafeProduceLincenceService;
	
	@RequestMapping("/findMsg")
	@ResponseBody
	public PageResponse<TempSafeProduceLincence> findMsg(PageRequest request) throws Exception{
		
		List<TempSafeProduceLincence> data = tempSafeProduceLincenceService.findMsg(request);
		return new PageResponse<TempSafeProduceLincence>(data);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(TempSafeProduceLincenceDto dto) throws Exception{
		
		int i = tempSafeProduceLincenceService.deleteByDto(dto);
		if(i==1){
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.error("删除失败，请稍后重试");
	}
}
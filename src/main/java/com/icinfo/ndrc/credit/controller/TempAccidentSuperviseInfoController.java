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
import com.icinfo.ndrc.credit.dto.TempAccidentSuperviseInfoDto;
import com.icinfo.ndrc.credit.model.TempAccidentSuperviseInfo;
import com.icinfo.ndrc.credit.service.ITempAccidentSuperviseInfoService;

@Controller
@RequestMapping("/tempAccidentSuperviseInfo")
public class TempAccidentSuperviseInfoController extends BaseController{
	
	@Autowired
	private ITempAccidentSuperviseInfoService tempAccidentSuperviseInfoService;

	@RequestMapping("/findMsg")
	@ResponseBody
	public PageResponse<TempAccidentSuperviseInfo> findMsg(PageRequest request) throws Exception{
		List<TempAccidentSuperviseInfo>  list = tempAccidentSuperviseInfoService.findMsg(request);
		return new PageResponse<TempAccidentSuperviseInfo>(list);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult deleteByDto(TempAccidentSuperviseInfoDto dto) throws Exception{
		int i = tempAccidentSuperviseInfoService.deleteByDto(dto);
		if(i==1){
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.error("删除失败,稍后再试");
	}
}

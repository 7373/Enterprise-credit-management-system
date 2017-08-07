/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.TempRedBlackListDto;
import com.icinfo.ndrc.credit.model.TempRedBlackList;
import com.icinfo.ndrc.credit.service.ITempRedBlackListService;

/**
 * 描述: 
 *
 * 
 */
@Controller
@RequestMapping("/credit/redblack")
public class RedblackListController extends BaseController {


	@Autowired
	private ITempRedBlackListService tempRedBlackListService;

   /**
    * 黑白名单跳转
    * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
    * @author  ranah
    * @when   2017年6月13日上午11:40:26
    * @return
    * @throws Exception
    */
    /**
     * 红名单查询
     * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
     * @author  ranah
     * @when   2017年6月13日下午4:44:15
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/red")
	public ModelAndView views() throws Exception {
		ModelAndView mv = new ModelAndView("credit/system/red_list");
		return mv;
	}
	/**
	 * 黑名单查询
	 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
	 * @author  ranah
	 * @when   2017年6月13日下午4:44:30
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/black")
	public ModelAndView bkviews() throws Exception {
		
		return new ModelAndView("credit/system/black_list");
	}
	
	@RequestMapping("/findMsg")
	@ResponseBody
	public PageResponse<TempRedBlackList> findMsg(PageRequest request) throws Exception{
		List<TempRedBlackList> data = tempRedBlackListService.findMsg(request);
		return new PageResponse<TempRedBlackList>(data);
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public AjaxResult delete(TempRedBlackListDto redListDto) throws Exception{
		
		int i = tempRedBlackListService.deleteByDto(redListDto);
		if(i==1){
			return AjaxResult.success("删除成功");
		}
		return AjaxResult.error("删除失败，请稍后重试");
	}
	
}
/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyun.oss.common.comm.ServiceClient.Request;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.dto.NdCommendRewardInfoDto;
import com.icinfo.ndrc.credit.service.INdCommendRewardInfoService;

/**
 * 描述:    nd_commend_reward_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Controller
@RequestMapping("/credit/ndCommendRewardInfo")
public class NdCommendRewardInfoController extends BaseController {
	@Autowired
	INdCommendRewardInfoService ndCommendRewardInfoService;
	/**
	 * 查询奖彰信息
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/list")
	@ResponseBody
	public PageResponse<NdCommendRewardInfoDto> list(PageRequest request) throws Exception{
		List<NdCommendRewardInfoDto>ndCommendRewardInfoList= ndCommendRewardInfoService.getRedBlackList(request);
		return new PageResponse<NdCommendRewardInfoDto>(ndCommendRewardInfoList);
		
	}
	
}
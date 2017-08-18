/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.credit.model.NdEnvironmentEvaluateInfo;
import com.icinfo.ndrc.credit.model.NdProductUnqualifiedInfo;
import com.icinfo.ndrc.credit.service.INdEnvironmentEvaluateInfoService;
import com.icinfo.ndrc.credit.service.INdProductUnqualifiedInfoService;

/**
 * 描述:    nd_product_unqualified_info 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月30日
 */
@Controller
@RequestMapping("/credit/ndProductUnqualifiedInfo")
/**
 * 
 * Copyright© 2003-2017 浙江汇信科技有限公司, All Rights Reserved.
 * @author  ranah
 * @when   2017年6月30日下午2:05:09
 */
public class NdProductUnqualifiedInfoController extends BaseController {

	@Autowired
	INdProductUnqualifiedInfoService ndProductUnqualifiedInfoService;
	/**
	 * 获取数据
	 * @author rah
	 */

	@RequestMapping({ "/data.json" })
	@ResponseBody
	public PageResponse<NdProductUnqualifiedInfo> doGetList(PageRequest request) throws Exception {
		List<NdProductUnqualifiedInfo> data = ndProductUnqualifiedInfoService.selectList(request);
		return new PageResponse<NdProductUnqualifiedInfo>(data);
	}
}
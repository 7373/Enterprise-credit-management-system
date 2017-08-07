/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.credit.service.impl;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.credit.mapper.NdUnionDeptMapper;
import com.icinfo.ndrc.credit.model.NdUnionDept;
import com.icinfo.ndrc.credit.service.INdTempService;
import com.icinfo.ndrc.credit.service.INdUnionDeptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

/**
 * 描述:    nd_union_dept 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
@Service("ndTempService")
public class NdTempServiceImpl extends MyBatisServiceSupport implements INdTempService {

	@Override
	public ModelAndView doGetViews(String deptNO) throws Exception {
		ModelAndView mv = new ModelAndView();
		switch(deptNO){
		case "ZF330682001": new ModelAndView("/");//卫计局
			break;
		case "ZF330682002": mv = new ModelAndView("/");//环保局
			break;
		case "ZF330682003": mv = new ModelAndView("/");//国税局
			break;
		case "ZF330682004": mv = new ModelAndView("/");//编办
			break;
		case "ZF330682005": mv = new ModelAndView("/");//民政局
			break;
		case "ZF330682006": mv = new ModelAndView("/");//经信局
			break;
		case "ZF330682007": mv = new ModelAndView("/");//公安局
			break;
		case "ZF330682008": mv = new ModelAndView("/");//消防大队
			break;
		case "ZF330682009": mv = new ModelAndView("credit/system/temp/tempAgriculture");//林业局（农业局）
			break;
		case "ZF330682010": mv = new ModelAndView("/");//文广新局
			break;
		case "ZF330682011": mv = new ModelAndView("/");//司法局
			break;
		case "ZF330682012": mv = new ModelAndView("/");//人社局
			break;
		case "ZF330682013": mv = new ModelAndView("/");//市场监管局
			break;
		case "ZF330682014": mv = new ModelAndView("/");//国土资源局
			break;
		case "ZF330682015": mv = new ModelAndView("credit/system/temp/tempSafety");//安监局
			break;
		case "ZF330682016": mv = new ModelAndView("/");//华数数字电视
			break;
		}
		return mv;
	}	
}

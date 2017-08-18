package com.icinfo.ndrc.credit.service;

import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.core.service.BaseService;

/**
 * 所有导入Excel相关信息表的父接口，便于删除
 * @author fanzhen
 * @date 20170619
 *
 */
public interface INdTempService extends BaseService{
	/**
	 * 获取部门查询页面
	 * @author zjj
	 */
	public ModelAndView doGetViews(String deptNO)throws Exception;
}

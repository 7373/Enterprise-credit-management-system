/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.ndrc.gateway.dto.NdrcCatalog2Dto;
import com.icinfo.ndrc.gateway.model.NdrcCatalog1;
import com.icinfo.ndrc.gateway.model.NdrcCatalog2;
import com.icinfo.ndrc.gateway.service.INdrcCatalog1Service;
import com.icinfo.ndrc.gateway.service.INdrcCatalog2Service;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    NDRC_CATALOG2 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月09日
 */
@Controller
@RequestMapping({"/gateway/backstage/catalog"})
public class NdrcCatalog2Controller extends BaseController {
	
	@Autowired
	INdrcCatalog2Service ndrcCatalog2Service;
	
	@Autowired
	INdrcCatalog1Service ndrcCatalog1Service;
	
	
	/**
	 * 进入频道/栏目管理页面
	 * @author liuguangju
	 * @date 2017-06-09
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "views", method = RequestMethod.GET)
	public ModelAndView views(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/catalog_list");
		return mv;
	}
	
	/**
	 * 分页获取频道/栏目页面的目录信息
	 * @author liuguangju
	 * @date 2017-06-09
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/doGetCatalogList.json", "list.xml" })
	@ResponseBody
	public PageResponse<NdrcCatalog2Dto> doGetNewsPublishList(PageRequest request) throws Exception {
		List<NdrcCatalog2Dto> ndrcCatalog = ndrcCatalog2Service.queryPage(request);
		return new PageResponse<NdrcCatalog2Dto>(ndrcCatalog);
	}
	
	
	/**
	 * 根据一级目录查找对应的二级目录
	 * @author liuguangju	
	 * @date 2017-06-09
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/selectCatalog2ByUID")
	@ResponseBody
	public List<NdrcCatalog2> selectCatalog2(String uid) throws Exception {	
		List<NdrcCatalog2> ndrcCatalog2List = ndrcCatalog2Service.selectCatalog2(uid);
		
		return ndrcCatalog2List;
	}
	
	
	/**
	 * 进入频道/栏目新增页面
	 * @author liuguangju	
	 * @date 2017-06-12
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/enAdd", method = RequestMethod.GET)
	public ModelAndView enAdd() throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/catalog_add");
		List<NdrcCatalog1> ndrcCatalog1List = ndrcCatalog1Service.selectNdrcCatalog1();
		mv.addObject("CatalogOneList", ndrcCatalog1List);
		return mv;
	}
	
	/**
	 * 查询所有的目录
	 * @author liuguangju
	 * @date 20017-06-12
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.POST)
	@ResponseBody
	public List<NdrcCatalog2> selectCatalog2() throws Exception{
		List<NdrcCatalog2> catalog = ndrcCatalog2Service.selectCatalog2();
		return catalog;
	}
	
	/**
	 * 保存新增目录
	 * @author liuguangju	
	 * @date 2017-06-12
	 * @param catalog
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult saveCatalog(@RequestBody NdrcCatalog2 catalog) throws Exception {
		List<NdrcCatalog2> ndrcCatalog2List = ndrcCatalog2Service.selectCatalog2();
		catalog.setCreateTime(new Date());
		if(ndrcCatalog2List.size()!=0){
			catalog.setCatalogCode(ndrcCatalog2List.get(ndrcCatalog2List.size()-1).getCatalogCode()+1);
		}else{
			catalog.setCatalogCode(2000);//code的起始值
		}
		
		if(ndrcCatalog2Service.saveCatalog(catalog)>0){
			return AjaxResult.success("新增目录成功");
		}
		return AjaxResult.error("新增目录失败");
	}
	
	
	
	/**
	 * 删除目录
	 * @author liuguangju
	 * @date 2017-06-12
	 * @param uid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult deleteCatalog(String uid) throws Exception {
		NdrcCatalog2 ndrcCatalog2 = new NdrcCatalog2();
		ndrcCatalog2.setUID(uid);
		ndrcCatalog2.setIsDel("1");;
		if(ndrcCatalog2Service.deleteCatalog(ndrcCatalog2)>0){
			return AjaxResult.success("删除目录成功!");
		}
		return AjaxResult.error("删除目录同失败!");
	}
}
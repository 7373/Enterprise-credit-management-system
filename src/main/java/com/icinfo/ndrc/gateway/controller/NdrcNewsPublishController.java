/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.icinfo.framework.common.ajax.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.icinfo.ndrc.gateway.model.NdrcCatalog1;
import com.icinfo.ndrc.gateway.model.NdrcNewsPublish;
import com.icinfo.ndrc.gateway.service.INdrcCatalog1Service;
import com.icinfo.ndrc.gateway.service.INdrcNewsPublishService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;

/**
 * 描述:    NDRC_NEWS_PUBLISH 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月08日
 */
@Controller
@RequestMapping({"/gateway/backstage/publish","/gateway/reception/publish"})
public class NdrcNewsPublishController extends BaseController {
	@Autowired
	INdrcNewsPublishService ndrcNewsPublishService;
	
	@Autowired
	INdrcCatalog1Service ndrcCatalog1Service;
	
	/**
	 * 进入内容采编页面
	 * @author liuguangju
	 * @date 2017-06-08
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "views", method = RequestMethod.GET)
	public ModelAndView views(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/news_publish_list");
		
		List<NdrcCatalog1> ndrcCatalog1List = ndrcCatalog1Service.selectNdrcCatalog1();//查询所有一级目录
		mv.addObject("ndrcCatalog1List", ndrcCatalog1List);
		return mv;
	}

	/**
	 * 分页获取新闻资讯发布信息
	 * @author liuguangju
	 * @date 2017-06-08
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/doGetNewsPublishList.json", "doGetNewsPublishList.xml" })
	@ResponseBody
	public PageResponse<NdrcNewsPublish> doGetNewsPublishList(PageRequest request) throws Exception {
		List<NdrcNewsPublish> ndrcNewsPublish = ndrcNewsPublishService.queryPage(request);
		return new PageResponse<NdrcNewsPublish>(ndrcNewsPublish);
	}
	
	/**
	 * 进入内容采编-新增页面
	 * 并获取一级目录
	 * @author liuguangju
	 * @date 2017-06-09
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/enAdd", method = RequestMethod.GET)
	public ModelAndView enAdd() throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/news_publish_add");
		
		List<NdrcCatalog1> ndrcCatalog1List = ndrcCatalog1Service.selectNdrcCatalog1();
		mv.addObject("ndrcCatalog1List", ndrcCatalog1List);
		return mv;
	}

	
	/**
	 * 新增内容采编
	 * @author liuguangju	
	 * @date	2017-06-13
	 * @param newsPublish
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult addNewsPublish(@RequestBody NdrcNewsPublish newsPublish, HttpSession session) throws Exception {
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		newsPublish.setCreateTime(new Date());
		newsPublish.setUpdateTime(new Date());
		if(newsPublish.getState().equals("1")){//1：发布
			newsPublish.setPublishTime(new Date());
			newsPublish.setPublisher(user.getRealName());
		}
		if(ndrcNewsPublishService.saveNewsCatalog(newsPublish)>0){
			return AjaxResult.success("新增资讯成功");
		}
		return AjaxResult.error("新增资讯失败");
	}
	
	
	
	
	/**
	 * 进入内容采编-新增页面
	 * @author ylr
	 * @date 2017-06-12
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getCreditDynamic", method = RequestMethod.GET)
	@ResponseBody
	public PageResponse getCreditDynamic(PageRequest request) throws Exception {
		List<NdrcNewsPublish> publishList = ndrcNewsPublishService.queryPage(request);
		return new PageResponse(publishList);
	}

	/**
	 * 进入内容采编-新增页面
	 * @author ylr
	 * @date 2017-06-12
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/getPublishDetail", method = RequestMethod.GET)
	@ResponseBody
	public ModelAndView getPublishDetail(String menu,String item,String uid) throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/reception/publish_detail");
		NdrcNewsPublish publish = ndrcNewsPublishService.getPublishDetail(uid);
		mv.addObject("menu",menu);
		mv.addObject("item",item);
		mv.addObject("publish",publish);
		return mv;
	}
	
	
	/**
	 * 删除内容采编
	 * @author liuguangju	
	 * @date 2017-06-13
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult deleteNewsPublish(String uid) throws Exception {
		
		NdrcNewsPublish ndrcNewsPublish = new NdrcNewsPublish();
		ndrcNewsPublish.setUID(uid);
		ndrcNewsPublish.setIsDel("1");
		ndrcNewsPublish.setUpdateTime(new Date());
		
		if(ndrcNewsPublishService.updateNewsPublish(ndrcNewsPublish)>0){
			return AjaxResult.success("删除内容采编成功!");
		}
		return AjaxResult.error("删除内容采编失败!");
	}
	
	/**
	 * 内容采编（发布）
	 * @author liuguangju
	 * @date 2017-06-13
	 * @param uid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/publish", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult publishNewsPublish(String uid, HttpSession session) throws Exception {
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		NdrcNewsPublish publish =ndrcNewsPublishService.getPublishDetail(uid);
		if("2008".equals(publish.getType2Code())){
			if(publish.getFilePath().equals(null) || "".equals(publish.getFilePath())){
				return AjaxResult.error("发布未成功请上传视频");
			}
		}
		NdrcNewsPublish ndrcNewsPublish = new NdrcNewsPublish();
		ndrcNewsPublish.setUID(uid);
		ndrcNewsPublish.setUpdateTime(new Date());
		ndrcNewsPublish.setPublisher(user.getRealName());
		ndrcNewsPublish.setPublishTime(new Date());
		ndrcNewsPublish.setState("1");
		
		if(ndrcNewsPublishService.updateNewsPublish(ndrcNewsPublish)>0){
			return AjaxResult.success("内容采编发布成功!");
		}
		return AjaxResult.error("内容采编发布失败!");
	}
	
	/**
	 * 内容采编（暂停）
	 * @author liuguangju
	 * @date 2017-06-13
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/stop", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult stopNewsPublish(String uid) throws Exception {
		NdrcNewsPublish ndrcNewsPublish = new NdrcNewsPublish();
		ndrcNewsPublish.setUID(uid);
		ndrcNewsPublish.setUpdateTime(new Date());
		ndrcNewsPublish.setState("0");
		
		if(ndrcNewsPublishService.updateNewsPublish(ndrcNewsPublish)>0){
			return AjaxResult.success("内容采编暂停成功!");
		}
		return AjaxResult.error("内容采编暂停失败!");
	}
	
	
	/**
	 * 内容采编（查看）
	 * @author liuguangju
	 * @date 2017-06-13
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(String uid) throws Exception {
		ModelAndView view = new ModelAndView("gateway/biz/backstage/news_publish_view");
		NdrcNewsPublish ndrcNewsPublish = new NdrcNewsPublish();
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("UID", uid);
		List<NdrcNewsPublish> ndrcNewsPublishList = ndrcNewsPublishService.doGetNewsPublishList(qryMap);
		if (ndrcNewsPublishList.size() > 0)
			ndrcNewsPublish = ndrcNewsPublishList.get(0);
		view.addObject("newsPublish", ndrcNewsPublish);
		return view;
	}
	
	
	/**
	 * 进入修改页面
	 * @author liuguangju
	 * @date 2017-06-14
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/enEdit", method = RequestMethod.GET)
	public ModelAndView enEdit(String uid) throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/news_publish_edit");
		NdrcNewsPublish ndrcNewsPublish = new NdrcNewsPublish();
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("UID", uid);
		List<NdrcNewsPublish> ndrcNewsPublishList = ndrcNewsPublishService.doGetNewsPublishList(qryMap);
		if (ndrcNewsPublishList.size() > 0)
			ndrcNewsPublish = ndrcNewsPublishList.get(0);
		mv.addObject("newsPublish", ndrcNewsPublish);
		
		List<NdrcCatalog1> ndrcCatalog1List = ndrcCatalog1Service.selectNdrcCatalog1();//查询所有一级目录
		mv.addObject("ndrcCatalog1List", ndrcCatalog1List);
		
		return mv;
	}
	
	/**
	 * 修改内容采编
	 * @author liuguangju
	 * @date 2017-06-14
	 * @param newsPublish
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult editNewsPublish(@RequestBody NdrcNewsPublish newsPublish, HttpSession session) throws Exception {
		if(newsPublish.getState().equals("1")){//1：发布
			if("2008".equals(newsPublish.getType2Code())){
				if(newsPublish.getFilePath().equals(null) || "".equals(newsPublish.getFilePath())){
					return AjaxResult.error("发布未成功请上传视频");
				}
			}
			newsPublish.setPublishTime(new Date());
			SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
			newsPublish.setPublisher(user.getRealName());
		}
		if(ndrcNewsPublishService.updateNewsPublish(newsPublish)>0){
			return AjaxResult.success("内容采编修改成功!");
		}
		return AjaxResult.error("内容采编修改失败!");
	}
	
	@RequestMapping("/playVideo")
	@ResponseBody
	public ModelAndView test(String filePath) throws IOException {
		ModelAndView mv= new ModelAndView("gateway/biz/reception/video");
		mv.addObject("filePath", filePath);
		return mv;
		
	}
	
}
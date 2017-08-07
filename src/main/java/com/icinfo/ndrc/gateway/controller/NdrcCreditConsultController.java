/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.icinfo.ndrc.gateway.dto.NdrcCreditConsultDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.ndrc.gateway.model.NdrcCreditConsult;
import com.icinfo.ndrc.gateway.service.INdrcCreditConsultService;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;


/**
 * 描述:    NDRC_CREDIT_CONSULT 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Controller
@RequestMapping({"/gateway/reception/consult","/gateway/backstage/consult"})
public class NdrcCreditConsultController extends BaseController {
	
	@Autowired
    private INdrcCreditConsultService ndrcCreditConsultService;
	
	/**
	 * 进入信用咨询页面
	 * @author liuguangju
	 * @date 2017-06-14
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "views", method = RequestMethod.GET)
	public ModelAndView views(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/credit_consult_list");
		return mv;
	}
	
	
	/**
	 * 获取信用咨询信息
	 * @author liuguangju
	 * @date 2017-06-14
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/doGetCreditConsultList.json", "doGetCreditConsultList.xml" })
	@ResponseBody
	public PageResponse<NdrcCreditConsult> doGetCreditConsultList(PageRequest request) throws Exception {
		List<NdrcCreditConsult> ndrcCreditConsult = ndrcCreditConsultService.queryPage(request);
		return new PageResponse<NdrcCreditConsult>(ndrcCreditConsult);
	}
	
    

    /**
     * 信用咨询表单提交
     * @author ylr
     * @date 2017-06-14
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/creditConsultValidate", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResult creditConsultValidate(NdrcCreditConsult consult) throws Exception {
        ndrcCreditConsultService.doSaveCreditConsult(consult);
        return AjaxResult.success("已咨询！");
    }
    
    
    
    /**
     * 进入信用咨询详情页面
     * @author liuguangju
     * @date 2017-06-14
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
	public ModelAndView show(String uid) throws Exception {
		ModelAndView view = new ModelAndView("gateway/biz/backstage/credit_consult_view");
		
		NdrcCreditConsult ndrcCreditConsult = new NdrcCreditConsult();
		ndrcCreditConsult = showMessage(uid);
		view.addObject("ndrcCreditConsult",ndrcCreditConsult);
		return view;
	}
    
    
    /**
     * 进入信用咨询回复页面
     * @author liuguangju
     * @date 2017-06-14
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/showReplay", method = RequestMethod.GET)
	public ModelAndView showReplay(String uid) throws Exception {
		ModelAndView view = new ModelAndView("gateway/biz/backstage/credit_consult_replay");
		NdrcCreditConsult ndrcCreditConsult = new NdrcCreditConsult();
		ndrcCreditConsult = showMessage(uid);
		view.addObject("ndrcCreditConsult",ndrcCreditConsult);
		return view;
	}
    
    /**
     * 获取信用咨询信息
     * @author liuguangju
     * @date 2017-06-14
     * @param uid
     * @return
     * @throws Exception
     */
    private NdrcCreditConsult showMessage(String uid) throws Exception{
    	NdrcCreditConsult ndrcCreditConsult = new NdrcCreditConsult();
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("uid", uid);
		List<NdrcCreditConsult> ndrcCreditConsultList = ndrcCreditConsultService.doGetCreditConsult(qryMap);
		if(ndrcCreditConsultList.size()>0){
			ndrcCreditConsult = ndrcCreditConsultList.get(0);
		}
		
		return ndrcCreditConsult;
    }
    
    /**
     * 回复咨询
     * @author liuguangju
     * @date 2017-06-15
     * @param ndrcCreditConsult
     * @param session
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/replay", method = RequestMethod.POST)
    @ResponseBody
	public AjaxResult replayCreditConsult(@RequestBody NdrcCreditConsult ndrcCreditConsult, HttpSession session) throws Exception {
		ndrcCreditConsult.setOptTime(new Date());
		ndrcCreditConsult.setMessageStatus(1);
    	if(ndrcCreditConsultService.updateCreditConsult(ndrcCreditConsult)>0){
			return AjaxResult.success("回复成功!");
		}
		return AjaxResult.error("回复失败!");
	}


	/**
	 * 获取反馈信息
	 * @author ylr
	 * @date 2017-06-15
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({ "/feedbacklist.json", "feedbacklist.xml" })
	@ResponseBody
	public PageResponse<NdrcCreditConsult> feedbacklist(PageRequest request) throws Exception {
		List<NdrcCreditConsult> feedback = ndrcCreditConsultService.selectFeedBack(request);
		return new PageResponse<NdrcCreditConsult>(feedback);
	}


}
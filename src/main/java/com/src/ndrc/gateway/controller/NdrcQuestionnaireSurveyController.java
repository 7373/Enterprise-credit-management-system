/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageResponse;
import com.icinfo.ndrc.gateway.model.NdrcQuestionnaireSurvey;
import com.icinfo.ndrc.gateway.service.INdrcQuestionnaireSurveyService;
import com.icinfo.ndrc.support.Constants;
import com.icinfo.ndrc.system.model.SysUser;


/**
 * 描述:    NDRC_QUESTIONNAIRE_SURVEY 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
@Controller
@RequestMapping({"/gateway/backstage/questionnaire","/gateway/reception/questionnaire"})
public class NdrcQuestionnaireSurveyController extends BaseController {
	
	@Autowired
	INdrcQuestionnaireSurveyService	questionnaireService;
	
	/**
	 * 进入问卷调查页面
	 * @author liuguangju
	 * @date 2017-06-15
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="views",method=RequestMethod.GET)
	public ModelAndView views(HttpSession session)throws Exception{
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/questionnaire_survey_list");
		return mv;
	}
	
	/**
	 * 获取问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-15
	 * @param request
	 * @return
	 * @throws Exception
	 */
	@RequestMapping({"/doGetQuestionnaireSurveyList.json","doGetQuestionnaireSurveyList.xml"})
	@ResponseBody
	public PageResponse<NdrcQuestionnaireSurvey> doGetQuestionnaireSurveyList(PageRequest request) throws Exception{
		List<NdrcQuestionnaireSurvey> ndrcQuestionnaireSurvey = questionnaireService.queryPage(request);
		return new PageResponse<NdrcQuestionnaireSurvey>(ndrcQuestionnaireSurvey);
	}
	
	/**
	 * 删除问卷调查
	 * @author liuguangju
	 * @date 20017-06-15
	 * @param uid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult deleteQuestionnaire(String uid,HttpSession session)throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		NdrcQuestionnaireSurvey questionnaire = new NdrcQuestionnaireSurvey();
		questionnaire.setUid(uid);
		questionnaire.setIsDel("1");
		questionnaire.setChanger(user.getRealName());
		questionnaire.setChangeTime(new Date());
		questionnaire.setChangerId(user.getUid());
		if(questionnaireService.updateQuestionnaire(questionnaire)>0){
			return AjaxResult.success("删除问卷调查成功");
		}
		return AjaxResult.error("删除问卷调查失败");
		
	}
	
	/**
	 * 进入问卷调查查看
	 * @author liuguangju
	 * @date 2017-06-16
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="show",method = RequestMethod.GET)
	public ModelAndView show(String uid)throws Exception{
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/questionnaire_survey_view");
		NdrcQuestionnaireSurvey questionnaire = showMessage(uid);
		mv.addObject("questionnaire", questionnaire);
		return mv;
	}
	
	
	/**
	 * 进入问卷调查编辑
	 * @author liuguangju
	 * @date 2017-06-16
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="enEdit",method = RequestMethod.GET)
	public ModelAndView enEdit(String uid) throws Exception{
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/questionnaire_survey_edit");
		NdrcQuestionnaireSurvey questionnaire = showMessage(uid);
		mv.addObject("questionnaire", questionnaire);
		return mv;
	}
	
	/**
	 * 根据uid获取问卷调查信息
	 * @param uid
	 * @return
	 * @throws Exception
	 */
	private NdrcQuestionnaireSurvey showMessage(String uid) throws Exception{
		NdrcQuestionnaireSurvey questionnaire = new NdrcQuestionnaireSurvey();
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("uid", uid);
		List<NdrcQuestionnaireSurvey> questionnaireList = questionnaireService.doGetQuestion(qryMap);
		if(questionnaireList.size()>0){
			questionnaire = questionnaireList.get(0);
		}
		return questionnaire;
	}
	
	/**
	 * 进入问卷调查新增页面
	 * @author liuguangju
	 * @date 2017-06-19
	 * @return
	 */
	@RequestMapping(value="enAdd",method = RequestMethod.GET)
	public ModelAndView enAdd(){
		ModelAndView mv = new ModelAndView("gateway/biz/backstage/questionnaire_survey_add");
		return mv;
	}
	
	
	
	
	
	/**
	 * 编辑问卷调查
	 * @author liuguangju
	 * @date 2017-06-19
	 * @param questionnaire
	 * @param flag
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="edit",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult edit(NdrcQuestionnaireSurvey questionnaire,String flag,HttpSession session) throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		
		if("0".equals(flag)){//提交
			if(questionnaireService.updateQuestionnaire(questionnaire)>0){
				return AjaxResult.success("修改问卷调查成功");
			}
			return AjaxResult.error("修改问卷调查失败");
		}else if("1".equals(flag) ){//发布
			doGetQuestionNaireBean(questionnaire, user);
			if(questionnaireService.updateQuestionnaire(questionnaire)>0){
				return AjaxResult.success("发布问卷调查成功");
			}
			return AjaxResult.error("发布问卷调查失败");
			
		}
		return AjaxResult.error("操作问卷调查失败");
	}
	
	
	
	/**
	 * 新增问卷调查
	 * @author liuguangju
	 * @date 2017-06-19
	 * @param questionnaire
	 * @param flag
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="add",method = RequestMethod.POST)
	@ResponseBody
	public AjaxResult add(NdrcQuestionnaireSurvey questionnaire,String flag,HttpSession session)throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		
		if("0".equals(flag)){//提交
			questionnaire.setPublishState("0");
			questionnaire.setIsDel("0");
			if(questionnaireService.saveQuestionnaire(questionnaire)>0){
				return AjaxResult.success("添加问卷调查成功");
			}
			return AjaxResult.error("添加问卷调查失败");
		}else if("1".equals(flag) ){//发布
			if(questionnaireService.saveQuestionnaire(doGetQuestionNaireBean(questionnaire, user))>0){
				return AjaxResult.success("发布问卷调查成功");
			}
			return AjaxResult.error("发布问卷调查失败");
			
		}
		return AjaxResult.error("操作问卷调查失败");
	}

	/**
	 * 发布问卷调查发布时
	 * 设置所有发布状态为0
	 * 设置修改人和发布人相关信息
	 * @author liuguangju
	 * @date 2017-06-19
	 * @param questionnaire
	 * @param user
	 * @return
	 * @throws Exception
	 */
	private NdrcQuestionnaireSurvey doGetQuestionNaireBean(NdrcQuestionnaireSurvey questionnaire, SysUser user) throws Exception {
		//将所有的状态置为0
		questionnaireService.setPublishState("0");
		
		questionnaire.setIsDel("0");
		questionnaire.setPublishState("1");
		questionnaire.setCreateTime(new Date());
		questionnaire.setChanger(user.getRealName());
		questionnaire.setChangerId(user.getUid());
		questionnaire.setChangeTime(new Date());
		questionnaire.setPublisher(user.getRealName());
		questionnaire.setPublisherId(user.getUid());
		return questionnaire;
	}
	
	/**
	 * 问卷调查发布（已保存后的发布）
	 * @param uid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="publish",method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult publish(String uid, HttpSession session)throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		NdrcQuestionnaireSurvey questionnaire = new NdrcQuestionnaireSurvey();
			questionnaire.setUid(uid);
			doGetQuestionNaireBean(questionnaire, user);
			if(questionnaireService.updateQuestionnaire(questionnaire)>0){
				return AjaxResult.success("发布问卷调查成功");
			}
			return AjaxResult.error("发布问卷调查失败");
	}
	
	/**
	 * 暂停问卷调查
	 * @param uid
	 * @param session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="stop",method = RequestMethod.GET)
	@ResponseBody
	public AjaxResult stop(String uid,HttpSession session) throws Exception{
		SysUser user = (SysUser) session.getAttribute(Constants.SESSION_SYS_USER);
		NdrcQuestionnaireSurvey questionnaire = new NdrcQuestionnaireSurvey();
		questionnaire.setUid(uid);
		questionnaire.setCreateTime(new Date());
		questionnaire.setChanger(user.getRealName());
		questionnaire.setChangerId(user.getUid());
		questionnaire.setChangeTime(new Date());
		questionnaire.setPublisher(user.getRealName());
		questionnaire.setPublisherId(user.getUid());
		questionnaire.setPublishState("0");
		if(questionnaireService.updateQuestionnaire(questionnaire)>0){
			return AjaxResult.success("暂停问卷调查成功");
		}
		return AjaxResult.error("暂停问卷调查失败");
		
	}
	
	@RequestMapping(value="/doGetQuestionnaireSurvey")
	@ResponseBody
	public AjaxResult doGetQuestionnaireSurvey()throws Exception{
		NdrcQuestionnaireSurvey ndrcQuestionnaire = new NdrcQuestionnaireSurvey();
		Map<String ,Object> qryMap = new HashMap<String ,Object>();
		qryMap.put("publishState", "1");
		List<NdrcQuestionnaireSurvey> ndrcQuestionnaireList = questionnaireService.doGetQuestion(qryMap);
		if(ndrcQuestionnaireList.size()>0)
			ndrcQuestionnaire = ndrcQuestionnaireList.get(0);
		return AjaxResult.success("成功！",ndrcQuestionnaire);
	}
	
	
} 
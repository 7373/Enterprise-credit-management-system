/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.icinfo.framework.common.ajax.AjaxResult;
import com.icinfo.framework.core.web.BaseController;
import com.icinfo.ndrc.gateway.model.NdrcSurveyResult;
import com.icinfo.ndrc.gateway.service.INdrcSurveyResultService;

/**
 * 描述:    NDRC_SURVEY_RESULT 对应的Controller类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Controller
@RequestMapping({"/gateway/reception/surveyresult","/gateway/backstage/surveyresult"})
public class NdrcSurveyResultController extends BaseController {
    @Autowired
    private INdrcSurveyResultService ndrcSurveyResultService;

    /**
     * 进入问卷echarts
     * @author ylr
     * @date 2017-06-14
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/doEnBarGraph", method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView views(String uid) throws Exception {
        ModelAndView mv = new ModelAndView("gateway/biz/reception/survey_bar");
        mv.addObject("uid", uid);
        return mv;
    }

    /**
     * 获取问卷echarts数据
     * @author ylr
     * @date 2017-06-14
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/barshow", method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult barshow(String problemID) throws Exception {
        JSONArray arr= ndrcSurveyResultService.doGetSurveyResultCount(problemID);
        return AjaxResult.success("result",arr);
    }

    /**
     * 问卷调查结果保存
     * @author liuguangju
     * @param option
     * @param uid
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/save",method = RequestMethod.GET)
    @ResponseBody
    public AjaxResult save(String option,String uid)throws Exception{
    	NdrcSurveyResult surveyResult = new NdrcSurveyResult();
    	switch(option){
    	case "optionA":surveyResult.setOptionA(1);break;
    	case "optionB":surveyResult.setOptionB(1);break;
    	case "optionC":surveyResult.setOptionC(1);break;
    	case "optionD":surveyResult.setOptionD(1);break;
    	case "optionE":surveyResult.setOptionE(1);break;
    	case "optionF":surveyResult.setOptionF(1);break;
    	}
    	surveyResult.setProblemID(uid);
    	surveyResult.setCreateTime(new Date());
    	if(ndrcSurveyResultService.saveSurveyResult(surveyResult)>0){
			return AjaxResult.success("提交问卷调查结果成功");
		}
		return AjaxResult.error("提交问卷调查结果失败");
    }


}
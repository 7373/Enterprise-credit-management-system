/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.model.NdrcQuestionnaireSurvey;


/**
 * 描述:    NDRC_QUESTIONNAIRE_SURVEY 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
public interface INdrcQuestionnaireSurveyService extends BaseService {
	
	/**
	 * 获取问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-15
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NdrcQuestionnaireSurvey> queryPage(PageRequest request)throws Exception;
	
	/**
	 * 更新问卷调查内容
	 * @author liuguangju
	 * @date 2017-06-15
	 * @param questionnaire
	 * @return
	 * @throws Exception
	 */
	public Integer updateQuestionnaire(NdrcQuestionnaireSurvey questionnaire)throws Exception;
	
	/**
	 * 获取问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-16
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<NdrcQuestionnaireSurvey> doGetQuestion(Map<String,Object> qryMap)throws Exception;
	
	/**
	 * 保存问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-16
	 * @param questionnaire
	 * @return
	 * @throws Exception
	 */
	public Integer saveQuestionnaire(NdrcQuestionnaireSurvey questionnaire)throws Exception;
	
	
	public Integer setPublishState(String state)throws Exception;
}
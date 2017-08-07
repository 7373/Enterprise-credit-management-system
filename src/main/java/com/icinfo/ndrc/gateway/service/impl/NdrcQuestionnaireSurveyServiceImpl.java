/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.mapper.NdrcQuestionnaireSurveyMapper;
import com.icinfo.ndrc.gateway.model.NdrcQuestionnaireSurvey;
import com.icinfo.ndrc.gateway.service.INdrcQuestionnaireSurveyService;

/**
 * 描述:    NDRC_QUESTIONNAIRE_SURVEY 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
@Service
public class NdrcQuestionnaireSurveyServiceImpl extends MyBatisServiceSupport implements INdrcQuestionnaireSurveyService {

	@Autowired
	NdrcQuestionnaireSurveyMapper questionnaireMapper;
	
	/**
	 * 获取问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-15
	 */
	@Override
	public List<NdrcQuestionnaireSurvey> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return questionnaireMapper.selectNdrcQuestionSurveyMapper(request.getParams());
	}

	
	/**
	 * 更新问卷调查内容
	 * @author liuguangju
	 * @date 2017-06-15
	 */
	@Override
	public Integer updateQuestionnaire(NdrcQuestionnaireSurvey questionnaire) throws Exception {
		if(questionnaire == null || isEmpty(questionnaire.getUid())){
			System.out.println("======================");
			return null;
		}
        Example example = new Example(NdrcQuestionnaireSurvey.class);
        example.createCriteria().andEqualTo("uid",questionnaire.getUid());
		return questionnaireMapper.updateByExampleSelective(questionnaire, example);
	}


	/**
	 * 获取问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-16
	 */
	@Override
	public List<NdrcQuestionnaireSurvey> doGetQuestion(Map<String, Object> qryMap) throws Exception {
		return questionnaireMapper.selectNdrcQuestionSurveyMapper(qryMap);
	}


	/**
	 * 保存问卷调查信息
	 * @author liuguangju
	 * @date 2017-06-16
	 */
	@Override
	public Integer saveQuestionnaire(NdrcQuestionnaireSurvey questionnaire) throws Exception {
		return questionnaireMapper.insert(questionnaire);
	}


	@Override
	public Integer setPublishState(String state) throws Exception {
		return questionnaireMapper.setPublishState(state);
	}
}
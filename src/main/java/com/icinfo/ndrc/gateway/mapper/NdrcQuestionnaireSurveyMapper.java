/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月15日
 * @version 2.0
 */
package com.icinfo.ndrc.gateway.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.gateway.model.NdrcQuestionnaireSurvey;
import com.icinfo.framework.mybatis.mapper.common.Mapper;

/**
 * 描述:    NDRC_QUESTIONNAIRE_SURVEY 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
public interface NdrcQuestionnaireSurveyMapper extends Mapper<NdrcQuestionnaireSurvey> {
	
	List<NdrcQuestionnaireSurvey> selectNdrcQuestionSurveyMapper(Map<String,Object> qryMap);
	
	Integer setPublishState(String state);
}
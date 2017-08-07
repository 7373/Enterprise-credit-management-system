/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月21日
 * @version 2.0
 */
package com.icinfo.ndrc.gateway.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.gateway.model.NdrcSurveyResult;

/**
 * 描述:    NDRC_SURVEY_RESULT 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
public interface NdrcSurveyResultMapper extends Mapper<NdrcSurveyResult> {

    NdrcSurveyResult doGetSurveyResultCount(String problemID);
}
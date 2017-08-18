/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;

import com.alibaba.fastjson.JSONArray;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.gateway.model.NdrcCreditConsult;
import com.icinfo.ndrc.gateway.model.NdrcSurveyResult;

import java.util.List;

/**
 * 描述:    NDRC_SURVEY_RESULT 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
public interface INdrcSurveyResultService extends BaseService {

    /**
     * 查询问卷统计
     * @author ylr
     * @date 2017-06-14
     * @return
     * @throws Exception
     */
    JSONArray doGetSurveyResultCount(String problemID)throws Exception;
    
    /**
     *  问卷调查结果保存
     * @author liuguangju
     * @param surveyResult
     * @return
     * @throws Exception
     */
    Integer saveSurveyResult(NdrcSurveyResult surveyResult)throws Exception;

}
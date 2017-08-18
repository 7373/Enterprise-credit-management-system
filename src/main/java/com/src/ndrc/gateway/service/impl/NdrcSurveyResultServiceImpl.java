/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.ndrc.gateway.mapper.NdrcSurveyResultMapper;
import com.icinfo.ndrc.gateway.model.NdrcSurveyResult;
import com.icinfo.ndrc.gateway.service.INdrcSurveyResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 描述:    NDRC_SURVEY_RESULT 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月21日
 */
@Service
public class NdrcSurveyResultServiceImpl extends MyBatisServiceSupport implements INdrcSurveyResultService {

    @Autowired
    private NdrcSurveyResultMapper ndrcSurveyResultMapper;

    /**
     *@Description 获取问卷统计
     *@author ylr
     *@date 2017-06-21
     */
    @Override
    public JSONArray doGetSurveyResultCount(String problemID) throws Exception {
        JSONArray arr = new JSONArray();
        JSONArray arr1 = new JSONArray();
        JSONObject obj = new JSONObject();
        NdrcSurveyResult result = ndrcSurveyResultMapper.doGetSurveyResultCount(problemID);
        	arr1.add(result!=null?result.getOptionA():0);
        	arr1.add(result!=null?result.getOptionB():0);
        	arr1.add(result!=null?result.getOptionC():0);
        	arr1.add(result!=null?result.getOptionD():0);
        	arr1.add(result!=null?result.getOptionE():0);
        	arr1.add(result!=null?result.getOptionF():0);

        obj.put("maxnum",result!=null?getMaxNum(result):10);

        arr.add(arr1);
        arr.add(obj);
        return arr;
    }
    public Integer getMaxNum(NdrcSurveyResult result)throws Exception{
        List<Integer> numlist = new ArrayList<Integer>();
        numlist.add(result.getOptionA());
        numlist.add(result.getOptionB());
        numlist.add(result.getOptionC());
        numlist.add(result.getOptionD());
        numlist.add(result.getOptionE());
        numlist.add(result.getOptionF());
        Integer max = Collections.max(numlist);
        return max+max/2;
    }
    
    /**
     *  问卷调查结果保存插入数据库
     * @author liuguangju
     */
	@Override
	public Integer saveSurveyResult(NdrcSurveyResult surveyResult) throws Exception {
		return ndrcSurveyResultMapper.insertSelective(surveyResult);
	}

}
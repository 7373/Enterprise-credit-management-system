/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service.impl;


import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icinfo.ndrc.gateway.mapper.NdrcCreditConsultMapper;
import com.icinfo.ndrc.gateway.model.NdrcCatalog2;
import com.icinfo.ndrc.gateway.model.NdrcCreditConsult;


import com.icinfo.ndrc.gateway.service.INdrcCreditConsultService;
import com.icinfo.framework.core.service.support.MyBatisServiceSupport;
import com.icinfo.framework.mybatis.mapper.entity.Example;
import com.icinfo.framework.mybatis.pagehelper.PageHelper;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.util.Date;

/**
 * 描述:    NDRC_CREDIT_CONSULT 对应的Service接口实现类.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
@Service
public class NdrcCreditConsultServiceImpl extends MyBatisServiceSupport implements INdrcCreditConsultService {


    @Autowired
    private NdrcCreditConsultMapper ndrcCreditConsultMapper;

    /**
     * 信用咨询数据新增
     *
     * @return
     * @throws Exception
     */
    public Integer doSaveCreditConsult(NdrcCreditConsult consult) throws Exception{
        consult.setCreateTime(new Date());
        consult.setMessageStatus(0);
        return ndrcCreditConsultMapper.insert(consult);
    }



	/**
	 * 获取信用咨询信息
	 * @author liuguangju
	 * @date 2017-06-14
	 */
	@Override
	public List<NdrcCreditConsult> queryPage(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndrcCreditConsultMapper.selectNdrcCreditConsultMapper(request.getParams());
	}



	/**
	 *  获取信用咨询信息
     * @author liuguangju
     * @date 2017-06-14
	 */
	@Override
	public List<NdrcCreditConsult> doGetCreditConsult(Map<String, Object> qryMap) throws Exception {
		
		return ndrcCreditConsultMapper.selectNdrcCreditConsultMapper(qryMap);
	}



	/**
	 * 更新咨询信息
     * @author liuguangju
     * @date 2017-06-15
	 */
	@Override
	public Integer updateCreditConsult(NdrcCreditConsult consult) throws Exception {
		if (consult == null || isEmpty(consult.getUid())){
			System.out.println("===================");
            return null;
        }
        Example example = new Example(NdrcCreditConsult.class);
        example.createCriteria().andEqualTo("uid", consult.getUid());
		return ndrcCreditConsultMapper.updateByExampleSelective(consult, example);
	}

	@Override
	public List<NdrcCreditConsult> selectFeedBack(PageRequest request) throws Exception {
		PageHelper.startPage(request.getPageNum(),request.getLength());
		return ndrcCreditConsultMapper.selectFeedBack(request.getParams());
	}
}
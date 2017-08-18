/*
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. 
 */
package com.icinfo.ndrc.gateway.service;
import java.util.List;
import java.util.Map;

import com.icinfo.ndrc.gateway.model.NdrcCreditConsult;
import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;


/**
 * 描述:    NDRC_CREDIT_CONSULT 对应的Service接口.<br>
 *
 * @author framework generator
 * @date 2017年06月14日
 */
public interface INdrcCreditConsultService extends BaseService {
	
	/**
	 * 获取信用咨询信息
	 * @author liuguangju
	 * @date 2017-06-14
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<NdrcCreditConsult> queryPage(PageRequest request)throws Exception;
    /**
     * 信用咨询数据新增
     *
     * @return
     * @throws Exception
     */
    public Integer doSaveCreditConsult(NdrcCreditConsult consult) throws Exception;
    
    /**
     *  获取信用咨询信息
     * @author liuguangju
     * @date 2017-06-14
     * @param qryMap
     * @return
     * @throws Exception
     */
    List<NdrcCreditConsult> doGetCreditConsult(Map<String,Object> qryMap) throws Exception;
    
    /**
     * 更新咨询信息
     * @author liuguangju
     * @date 2017-06-15
     * @param consult
     * @return
     * @throws Exception
     */
    public Integer updateCreditConsult(NdrcCreditConsult consult) throws Exception;
	/**
	 * 反馈
	 * @author ylr
	 * @date 2017-06-14
	 * @param request
	 * @return
	 * @throws Exception
	 */
	List<NdrcCreditConsult> selectFeedBack(PageRequest request)throws Exception;


}
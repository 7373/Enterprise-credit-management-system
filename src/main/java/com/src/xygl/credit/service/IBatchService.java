package com.icinfo.ndrc.credit.service;

import com.icinfo.framework.core.service.BaseService;

/**
 * 所有导入Excel相关信息表的父接口，便于删除
 * @author fanzhen
 * @date 20170619
 *
 */
public interface IBatchService extends BaseService{

	/**
	 * 删除指定批次号的信息
	 * @author fanzhen
	 * @date 20170619
	 * @param batchId
	 * @throws Exception
	 */
	public void deleteByBatchNo(String batchNO) throws Exception;
}

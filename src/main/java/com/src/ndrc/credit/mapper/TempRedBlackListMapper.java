/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月16日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.TempRedBlackList;

/**
 * 描述:    temp_redblack_list 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月16日
 */
public interface TempRedBlackListMapper extends Mapper<TempRedBlackList> {
	
	/**
	 * 通过batchId删除元素
	 * @author fanzhen
	 * @date 20170619
	 * @param batchId
	 */
	public void deleteByBatchNo(String batchNO);
	
	/**
	 * 根据map来查询
	 * @author fanzhen
	 * @date 20170620
	 * @param map
	 * @return
	 */
	public List<TempRedBlackList> findMsg(Map<String,Object> map);
}
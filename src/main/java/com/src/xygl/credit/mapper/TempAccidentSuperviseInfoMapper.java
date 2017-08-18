/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月15日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.TempAccidentSuperviseInfoDto;
import com.icinfo.ndrc.credit.model.TempAccidentSuperviseInfo;

/**
 * 描述:    temp_accident_supervise_info 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月15日
 */
public interface TempAccidentSuperviseInfoMapper extends Mapper<TempAccidentSuperviseInfo> {
	
	/**
	 * 通过batchId删除元素
	 * @author fanzhen
	 * @date 20170619
	 * @param batchId
	 */
	public void deleteByBatchNo(String batchNO);
	/**
	 * 查询
	 * @author fanzhen
	 * @date 20170619
	 * @param map
	 * @return
	 * @throws Exception
	 */
	public List<TempAccidentSuperviseInfo> findMsg(Map<String,Object> map);
	
}
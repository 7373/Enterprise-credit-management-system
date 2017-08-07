/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月20日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.model.TempSeedManagePermit;

/**
 * 描述:    temp_seed_manage_permit 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月20日
 */
public interface TempSeedManagePermitMapper extends Mapper<TempSeedManagePermit> {
	
	/**
	 * 根据map查询信息
	 * @author fanzhen
	 * @date 20170620
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<TempSeedManagePermit> findByMap(Map<String,Object> map) throws Exception;
}
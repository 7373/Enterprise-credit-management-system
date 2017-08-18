/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月23日
 * @version 2.0
 */
package com.icinfo.ndrc.system.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.system.dto.NdSysLogDto;
import com.icinfo.ndrc.system.model.NdSysLog;

/**
 * 描述:    nd_sys_log 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
public interface NdSysLogMapper extends Mapper<NdSysLog> {
	/**
	 * 查询日志信息
	 * @param map
	 * @return
	 */
	List<NdSysLogDto> selectListByMap(Map<String,Object> map);
	
}
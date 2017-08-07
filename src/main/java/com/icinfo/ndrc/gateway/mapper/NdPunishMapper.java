/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月23日
 * @version 2.0
 */
package com.icinfo.ndrc.gateway.mapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.gateway.dto.NdPunishDto;
import com.icinfo.ndrc.gateway.model.NdPunish;

/**
 * 描述:    nd_punish 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月23日
 */
public interface NdPunishMapper extends Mapper<NdPunish> {
	/**
	 * 查询企业处罚信息
	 * @param map
	 * @return
	 */
	List<NdPunishDto> selectListByMap(Map<String, Object> map);
		
	/**
	 * 查询处罚信息个数
	 * @return
	 */
	String doCountNum();	
	/**
	 * 查询最新处罚导入时间
	 * @return
	 */
	Date doGetInputTimeLatest();
}
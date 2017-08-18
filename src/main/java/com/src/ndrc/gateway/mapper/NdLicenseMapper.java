/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月22日
 * @version 2.0
 */
package com.icinfo.ndrc.gateway.mapper;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.gateway.dto.NdLicenseDto;
import com.icinfo.ndrc.gateway.model.NdLicense;

/**
 * 描述:    nd_license 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月22日
 */
public interface NdLicenseMapper extends Mapper<NdLicense> {
	/**
	 * 查询行政许可信息
	 * @param map
	 * @return
	 */
	List<NdLicenseDto> selectListByMap(Map<String, Object> map);
	
	List<NdLicenseDto> selectSevenDoubleList(Map<String, Object> map);
	/**
	 * 查询许可信息个数
	 * @return
	 */
	String doCountNum();	
	/**
	 * 查询最新许可导入时间
	 * @return
	 */
	List<Date> doCountAndInputInfo();
	
}
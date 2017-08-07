/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月17日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.NdUnionDeptDto;
import com.icinfo.ndrc.credit.model.NdUnionDept;

/**
 * 描述:    nd_union_dept 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月17日
 */
public interface NdUnionDeptMapper extends Mapper<NdUnionDept> {
	
	
	/**
	 * 获取列表
	 * 
	 * @param request
	 * @return
	 * @throws Exception
	 */
	public List<NdUnionDeptDto> pageQuery(Map<String,Object> map) throws Exception;
}
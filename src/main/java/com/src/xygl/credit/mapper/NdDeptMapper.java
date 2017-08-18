/**
 * Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved. <br/>
 * 描述: TODO <br/>
 *
 * @author framework generator
 * @date 2017年06月19日
 * @version 2.0
 */
package com.icinfo.ndrc.credit.mapper;

import java.util.List;
import java.util.Map;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.credit.dto.NdDeptDto;
import com.icinfo.ndrc.credit.model.NdDept;

/**
 * 描述:    nd_dept 对应的Mapper接口.<br>
 *
 * @author framework generator
 * @date 2017年06月19日
 */
public interface NdDeptMapper extends Mapper<NdDept> {
	
	List<NdDeptDto> selectNdDeptList();
	
	List<NdDept> selectNdDeptByMap(Map<String,Object> qryMap);
	
	/**
	 * 更加部门编号查找
	 * @author fanzhen
	 * @date 20170616
	 * @return
	 * @throws Exception
	 */
	public NdDept findByDepCode(String depcode);
}
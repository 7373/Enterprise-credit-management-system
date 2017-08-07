/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import java.util.List;
import java.util.Map;
import com.icinfo.ndrc.system.dto.SysUserDto;
import com.icinfo.ndrc.system.model.SysUser;


/**
 * 描述:  SysUser Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年04月05日
 */
public interface SysUserMapper extends Mapper<SysUser> {
	
	List<SysUser> selectList(Map<String,Object> qryMap);
	SysUserDto selectSysuerForCredit(String uid);


}
/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.system.model.SysRole;

import java.util.List;

/**
 * 描述:  SysRole Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年04月05日
 */
public interface SysRoleMapper extends Mapper<SysRole> {
    List<SysRole> selectAllByRoleType(String roleType);
}
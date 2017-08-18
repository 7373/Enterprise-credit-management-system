/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.mapper;

import com.icinfo.framework.mybatis.mapper.common.Mapper;
import com.icinfo.ndrc.system.model.SysPermision;

import java.util.List;
import java.util.Map;

/**
 * 描述:  SysPermision Mapper接口.<br>
 *
 * @author framework generator
 * @date 2016年04月14日
 */
public interface SysPermisionMapper extends Mapper<SysPermision> {
    /**
     * 查询用户权限
     *
     * @param params
     * @return
     */
    List<SysPermision> selectUserPermisions(Map<String, Object> params);
}
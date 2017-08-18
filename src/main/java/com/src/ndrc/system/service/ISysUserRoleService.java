/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.ndrc.system.model.SysUserRole;

import java.util.List;

/**
 * 描述:  用户角色业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysUserRoleService extends BaseService {
    /**
     * 通过主键删除用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByPrimaryKey(String id) throws Exception;

    /**
     * 删除用户所有角色
     *
     * @param userId
     * @return
     * @throws Exception
     */
    int deleteByUserId(String userId) throws Exception;

    /**
     * 添加用户角色
     *
     * @param userRoles
     * @return
     * @throws Exception
     */
    int insert(List<SysUserRole> userRoles) throws Exception;

    /**
     * 获取用户角色信息
     *
     * @param userId
     * @return
     * @throws Exception
     */
    List<SysUserRole> selectByUserId(String userId) throws Exception;
}

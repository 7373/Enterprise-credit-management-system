/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.ndrc.system.model.SysRolePermision;

import java.util.List;

/**
 * 描述:  角色资源业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysRolePermisionService extends BaseService {
    /**
     * 查询角色的全部权限
     *
     * @param roleId
     * @return
     */
    List<SysRolePermision> selectAllRolePermision(String roleId) throws Exception;

    /**
     * 添加用户角色
     *
     * @param permision
     * @return
     * @throws Exception
     */
    int insert(SysRolePermision permision) throws Exception;

    /**
     * 删除角色所有权限
     *
     * @param roleId
     * @return
     * @throws Exception
     */
    int deleteByRoleId(String roleId) throws Exception;

    /**
     * 添加角色权限
     *
     * @param permisions
     * @return
     * @throws Exception
     */
    int insert(List<SysRolePermision> permisions) throws Exception;
}

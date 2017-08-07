/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.system.model.SysRole;

import java.util.List;

/**
 * 描述:  系统用户角色业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysRoleService extends BaseService {
    /**
     * 添加用户角色
     *
     * @param sysRole
     * @return
     * @throws Exception
     */
    int insert(SysRole sysRole, String[] permisions) throws Exception;

    /**
     * 更新用户角色
     *
     * @param sysRole
     * @return
     * @throws Exception
     */
    int update(SysRole sysRole, String[] permitions) throws Exception;

    /**
     * 删除用户角色
     *
     * @param id
     * @return
     * @throws Exception
     */
    int deleteByPrimaryKey(String uid) throws Exception;

    /**
     * 通过UID查询用户角色
     *
     * @param uid
     * @return
     * @throws Exception
     */
    SysRole selectByUID(String id) throws Exception;

    /**
     * 查询角色列表
     *
     * @return
     * @throws Exception
     */
    List<SysRole> queryPage(PageRequest request,String roleType);

    /**
     * 获取所有角色信息
     *
     * @return
     * @throws Exception
     */
    List<SysRole> selectAllByRoleType(String roleType) throws Exception;
}

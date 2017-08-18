/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.service;

import com.icinfo.framework.core.service.BaseService;
import com.icinfo.framework.mybatis.pagehelper.datatables.PageRequest;
import com.icinfo.ndrc.system.dto.SysUserDto;
import com.icinfo.ndrc.system.model.SysUser;

import java.util.List;

/**
 * 描述:  系统用户业务.<br>
 *
 * @author xiajunwei
 * @date 2016年04月14日
 */
public interface ISysUserService extends BaseService {
    /**
     * 增加系统用户
     *
     * @param sysUser
     * @param roles
     * @return
     * @throws Exception
     */
    int insert(SysUser sysUser, String[] roles) throws Exception;

    /**
     * 更新用户信息
     *
     * @param sysUser
     * @param roles
     * @return
     * @throws Exception
     */
    int update(SysUser sysUser, String[] roles) throws Exception;

    /**
     * 通过UID删除用户
     *
     * @param primaryKey
     * @return
     */
    int deleteByUID(String primaryKey) throws Exception;

    /**
     * 系统用户列表
     *
     * @param request
     * @return
     */
    List<SysUser> queryPage(PageRequest request) throws Exception;

    /**
     * 通过UID加载指定的用户信息
     *
     * @param uid
     * @return
     */
    SysUser select(String uid) throws Exception;

    /**
     * 通过UID加载指定的用户信息
     *
     * @param uid
     * @return
     */
    SysUserDto selectForCredit(String uid) throws Exception;

    /**
     * 加载指定用户名的用户信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    SysUser selectByUserName(String username) throws Exception;
    /**
     * 修改密码
     * @param sysUser
     * @return
     * @throws Exception
     */
    int updatePass(SysUser sysUser) throws Exception;
    /**
     * 加载指定用户名的用户信息
     *
     * @param username
     * @return
     * @throws Exception
     */
    SysUser selectByUserNameAndUserType(String username,String userType) throws Exception;
    
}

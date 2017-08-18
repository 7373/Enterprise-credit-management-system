/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 描述:  SysUserRole 实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 *
 * @author framework generator
 * @date 2016年04月05日
 */
@Table(name = "SYS_USER_ROLE")
public class SysUserRole implements Serializable {
	@Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 用户ID
     */
    @Column(name = "UR_USER_ID")
    private String userId;

    /**
     * 角色ID
     */
    @Column(name = "UR_ROLE_ID")
    private String roleId;


    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取用户ID
     *
     * @return UR_USER_ID - 用户ID
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户ID
     *
     * @param userId 用户ID
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取角色ID
     *
     * @return UR_ROLE_ID - 角色ID
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * 设置角色ID
     *
     * @param roleId 角色ID
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
}
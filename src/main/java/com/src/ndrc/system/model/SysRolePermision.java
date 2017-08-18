/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * 描述:  SysRolePermision 实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 *
 * @author framework generator
 * @date 2016年04月14日
 */
@Table(name = "SYS_ROLE_PERMISION")
public class SysRolePermision implements Serializable {
	@Id
    @Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 角色ID
     */
    @Column(name = "RP_ROLE_ID")
    private String roleId;

    /**
     * 权限ID
     */
    @Column(name = "RP_PERMISION_ID")
    private String permisionId;


    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取角色ID
     *
     * @return RP_ROLE_ID - 角色ID
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

    /**
     * 获取权限ID
     *
     * @return RP_RESOURCE_ID - 权限ID
     */
    public String getPermisionId() {
        return permisionId;
    }

    /**
     * 设置权限ID
     *
     * @param permisionId 权限ID
     */
    public void setPermisionId(String permisionId) {
        this.permisionId = permisionId;
    }
}
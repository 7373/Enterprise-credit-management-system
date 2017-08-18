/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.model;

import com.icinfo.framework.mybatis.mapper.annotation.Before;

import javax.persistence.*;

import java.io.Serializable;

/**
 * 描述:  SysRole 实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 *
 * @author framework generator
 * @date 2016年04月05日
 */
@Table(name = "SYS_ROLE")
public class SysRole implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1228333027546694029L;
	@Id
	@Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String uid;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    private String name;

    /**
     * 角色描述
     */
    @Column(name = "ROLE_DESC")
    private String desc;

    /**
     * 角色所属类型
     */
    @Column(name = "ROLE_TYPE")
    //1-临安门户-2-临安信用
    private String roleType;



    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名称
     *
     * @param name 角色名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取角色描述
     *
     * @return ROLE_DESC - 角色描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置角色描述
     *
     * @param desc 角色描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
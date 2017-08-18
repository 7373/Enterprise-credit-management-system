/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.icinfo.framework.mybatis.mapper.annotation.Before;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;


/**
 * 描述:  SysUser 实体类.<br>
 * WARNING：不是表中字段的属性必须加@Transient注解
 *
 * @author framework generator
 * @date 2016年04月05日
 */
@Table(name = "SYS_USER")
public class SysUser implements Serializable {
	/**
   	 * 
   	 */
   	private static final long serialVersionUID = -8525821462438055711L;


   	@Id
	@Column(name = "UID")
    @Before
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select replace(uuid(), '-', '')")
    private String uid;
    
    
   	
    /**
     * 登录用户名
     */
    @Column(name = "USER_USERNAME")
    private String username;

    /**
     * 登录密码
     */
    @Column(name = "USER_PASSWORD")
    private String password;

    /**
     * 密码盐值
     */
    @Column(name = "USER_PASSWORD_SALT")
    private String passwordSalt;

    /**
     * 用户唯一编号
     */
    @Column(name = "USER_IDENTITY")
    private String identity;

    /**
     * 真实姓名
     */
    @Column(name = "USER_REAL_NAME")
    private String realName;

    /**
     * 电子邮件
     */
    @Column(name = "USER_EMAIL")
    private String email;

    /**
     * 创建时间
     */
    @Column(name = "USER_CREATE_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createTime;

    /**
     * 最后登录时间
     */
    @Column(name = "USER_LAST_LOGIN_TIME")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date lastLoginTime;

    /**
     * 用户状态
     */
    @Column(name = "USER_STATUS")
    private String status;

    /**
     * 用户描述
     */
    @Column(name = "USER_DESC")
    private String desc;
    
    /**
     * 用户部门
     */
    @Column(name = "USER_DEPT")
    private String dept;
    
    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    private String userType;


    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取登录用户名
     *
     * @return USER_USERNAME - 登录用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置登录用户名
     *
     * @param username 登录用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取登录密码
     *
     * @return USER_PASSWORD - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置登录盐值
     *
     * @param passwordSalt 登录密码
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt;
    }

    /**
     * 获取密码盐值
     *
     * @return USER_PASSWORD_SALT - 密码盐值
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 获取用户唯一编号
     *
     * @return USER_IDENTITY - 用户唯一编号
     */
    public String getIdentity() {
        return identity;
    }

    /**
     * 设置用户唯一编号
     *
     * @param identity 用户唯一编号
     */
    public void setIdentity(String identity) {
        this.identity = identity;
    }

    /**
     * 获取真实姓名
     *
     * @return USER_REAL_NAME - 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 设置真实姓名
     *
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 获取电子邮件
     *
     * @return USER_EMAIL - 电子邮件
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件
     *
     * @param email 电子邮件
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取创建时间
     *
     * @return USER_CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取最后登录时间
     *
     * @return USER_LAST_LOGIN_TIME - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取用户状态
     *
     * @return USER_STATUS - 用户状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置用户状态
     *
     * @param status 用户状态
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 获取用户描述
     *
     * @return USER_DESC - 用户描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 设置用户描述
     *
     * @param desc 用户描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
    
}
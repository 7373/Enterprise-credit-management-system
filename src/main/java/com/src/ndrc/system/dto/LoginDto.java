/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.dto;

import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 描述:  用户登录DTO对象.<br>
 *
 * @author xiajunwei
 * @date 2016年05月19日
 */
public class LoginDto implements Serializable {
    private static final long serialVersionUID = -8120224502344944929L;
    /**
     * 登录用户名
     */
    @NotBlank
    @Size(min = 5, max = 20)
    private String username;
    /**
     * 登录密码
     */
    @NotBlank
    @Size(min = 6, max = 20)
    private String password;
    /**
     * 验证码
     */
    private String checkCode;
    /**
     * 用户类型 1、门户 2、信用临安
     */
    private String userType;
    

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
    
    
    
    
}

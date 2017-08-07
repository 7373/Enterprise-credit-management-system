/*
 *  Copyright© 2003-2016 浙江汇信科技有限公司, All Rights Reserved.
 */
package com.icinfo.ndrc.system.dto;

import com.icinfo.framework.core.validator.Level;
import com.icinfo.framework.core.validator.Password;
import com.icinfo.ndrc.system.model.SysUser;
import org.hibernate.validator.constraints.Email;

/**
 * 描述:  系统用户DTO.<br>
 *
 * @author xiajunwei
 * @date 2016年04月25日
 */
public class SysUserDto extends SysUser {
   

	private String id;
	
	@Password(level = Level.WEAK)
    @Override
    public String getPassword() {
        return super.getPassword();
    }

    /**
     * 用户角色
     */
    private String[] roles;

    private String password1;

    private String deptName;

    private String logCode;

    private String logMsg;

    public String getLogCode() {
        return logCode;
    }

    public void setLogCode(String logCode) {
        this.logCode = logCode;
    }

    public String getLogMsg() {
        return logMsg;
    }

    public void setLogMsg(String logMsg) {
        this.logMsg = logMsg;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    @Email
    @Override
    public String getEmail() {
        return super.getEmail();
    }

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	

}

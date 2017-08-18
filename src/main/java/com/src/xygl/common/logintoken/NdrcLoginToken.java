package com.icinfo.ndrc.common.logintoken;

import com.icinfo.framework.security.shiro.LoginToken;

public class NdrcLoginToken extends LoginToken{
	
	private String userType;
	
	public NdrcLoginToken(String username, String password) {
		super(username, password);
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	
}

package com.icinfo.ndrc.support;

public enum SevenDoubleEnum {

	XK("xk","许可"),
	CF("cf","处罚");
	
	private String code;
	private String type;
	
	private SevenDoubleEnum(String code,String type){
		this.code = code;
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}

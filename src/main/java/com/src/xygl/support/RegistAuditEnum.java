package com.icinfo.ndrc.support;

public enum RegistAuditEnum {

	DSH("0","待审核"),
	PASS("1","通过"),
	NOPASS("2","不通过");
	
	private String code;
	private String type;
	
	private RegistAuditEnum(String code,String type){
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

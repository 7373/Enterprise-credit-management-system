package com.icinfo.ndrc.util;

import java.util.UUID;

public class UUIDUtils {

	/**
	 * 获取32位UUID
	 * 
	 * @author zhuyong
	 * @return
	 */
	public static String randomUUID(){
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
}

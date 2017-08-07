package com.icinfo.ndrc.util;
/**
 * 上传相关工具类
 * @author fanzhen
 *
 */
public class UploadUtil {

	/**
	 * 根据红黑名单第一列的值来判断是企业还是个人
	 * 长度大于等于5为企业
	 * 小于5为个人
	 * 企业则返回q,个人返回g
	 * @author fanzhen
	 * @date 20170619
	 * @param msg
	 * @return
	 */
	public static String transQyOrGr(String msg){
		if(msg.length()>=5){
			return "q";
		}
		return "g";
	}
}

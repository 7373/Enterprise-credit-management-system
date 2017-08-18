package com.icinfo.ndrc.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求处理的工具类
 * 
 * @author zhuyong
 */
public class RequestUtil {

	/**
	 * 获取http request对象
	 * 
	 * @return
	 */
	public static HttpServletRequest getRequest() {
		ServletRequestAttributes attrs = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return attrs.getRequest();
	}

	/**
	 * 获取http session对象
	 * 
	 * @return
	 */
	public static HttpSession getSession() {
		HttpSession session = null;
		try {
			return getRequest().getSession();
		} catch (Exception e) {
			return session;
		}
	}

	/**
	 * 描述: 获取 request 中所有参数
	 * @auther 胡义振
	 * @date 2014-10-14
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getAllParam(HttpServletRequest request) {
		Map<String,String> tempMap = new HashMap<String,String>();
		Enumeration enuParam = request.getParameterNames();
		while(enuParam.hasMoreElements()){
			String paramName = (String) enuParam.nextElement();
			String [] arrParamValue = request.getParameterValues(paramName);
			String paramValue = StringUtil.arrayToString(arrParamValue, ",");
			// 过滤掉空值
			if(paramValue!=null && paramValue.length()>0){
				tempMap.put(paramName, paramValue);
			}
		}
		return tempMap;
	}
}

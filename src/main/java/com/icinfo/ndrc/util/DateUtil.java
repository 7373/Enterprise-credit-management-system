package com.icinfo.ndrc.util;

import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * 时间工具类
 * @author zjj
 */
public class DateUtil {
	 
    public DateUtil() {
    	
    }
    
	/**
	 * 时间比较
	 * dateStart 时间开始
	 * dateEnd 时间结束
	 * min 相差分钟
	 * @author zjj
	 */
	public static boolean compareToDate(Date dateStart,Date dateEnd,int min) {
		int i = min*1000;
		if(dateEnd.getTime() - dateStart.getTime() > i){
			return true;
		}
		return false;
	}

	/**
	 * 描述: 以指定的格式来格式化日期
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(java.util.Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				result = "";
			}
		}
		return result;
	}
	/**
	 * 描述: 把字符转为日期
	 * @auther ZhouYan
	 * @date 2016年8月29日
	 * @param strDate
	 * @param format
	 * @return
	 */
	public static Date stringToDate(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception er) {
			return null;
		}
	}

	/**
	 * 描述: 格式化查询条件：起始日期
	 * @auther ZhouYan
	 * @date 2014年11月27日
	 * @param startTime
	 * @return
	 */
	public static Date getStartDate(String startTime) {
		if (startTime != null && startTime.length() > 0) {
			return DateUtil.stringToDate(startTime + " 00:00:00", "yyyy-MM-dd HH:mm:ss");
		}
		return null;
	}

	/**
	 * 描述: 格式化查询条件：截止日期
	 * @auther ZhouYan
	 * @date 2014年11月27日
	 * @param endTime
	 * @return
	 */
	public static Date getEndDate(String endTime) {
		if (endTime != null && endTime.length() > 0) {
			return DateUtil.stringToDate(endTime + " 23:59:59", "yyyy-MM-dd HH:mm:ss");
		}
		return null;
	}
  }
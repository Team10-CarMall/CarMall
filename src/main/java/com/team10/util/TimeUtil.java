package com.team10.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *  时间工具类
 */
public class TimeUtil {

	//获取当前的系统时间, 例如 2021-07-11 18:36:18
	public static String getSystemTime() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		String dateStr = sdf.format(date);
		return dateStr;
	}

	//获取当前的系统时间，纯数字，例如 20210711183618
	public static String getSystemTimeOnlyNumber() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		String dateStr = sdf.format(date);
		return dateStr;
	}

}

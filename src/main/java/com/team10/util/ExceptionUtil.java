package com.team10.util;

public class ExceptionUtil
{
	public static String getExceptionMsg(String userId, String msg)	{
		if(userId == null) {
			return TimeUtil.getSystemTime() + ": " + msg;
		}
		return TimeUtil.getSystemTime() + ": 用户[" + userId +"]" + msg;
	}
	public static String getExceptionMsg(String msg){
		return getExceptionMsg(null, msg);
	}
}

package com.team10.util;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:38:32
 */
public class IdUtil
{
	public static String getOrderId()
	{
		String time = TimeUtil.getSystemTimeOnlyNumber();
		return (int)(Math.random()*900)+100 + time;
	}
}

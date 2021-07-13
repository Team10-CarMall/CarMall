package com.team10.util;

/**
 * 用于生成id的工具类
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:38:32
 */
public class IdUtil {
	//生成订单编号
	public static String getOrderId() {
		String time = TimeUtil.getSystemTimeOnlyNumber();
		return (int)(Math.random()*900)+100 + time;
	}
}

package com.team10.enums;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 3:38:22
 */
public class ReturnCode {
	public static final Integer SUCCESS = 1000;            //成功操作
	public static final Integer ILLEGAL_ACCESS = 1010;     //非法访问
	public static final Integer ORDER_FAILED = 1020;       //下单失败
	public static final Integer NO_LOGIN = 888;            //用户未登录
	public static final Integer WRONG_PASS = 999;          //登录失败，账号或密码错误
	public static final Integer UNKNOWN_ERROR = 1999;      //未知错误
	public static final Integer DATA_ERROR = 1030;         //数据处理错误

	public static final Integer NO_ACCOUNT = 2999;         //第一次登录，直接注册
	public static final Integer ILLEGAL_ACCOUNT = 3999;    //异常用户
}

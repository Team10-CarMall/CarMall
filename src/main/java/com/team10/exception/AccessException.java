package com.team10.exception;

/**
 * 访问接口异常
 * 可能的原因是：
 *      1.访问了需要token验证的接口却没有在请求头中携带token
 *      2.访问的接口需要参数，但是传过来的参数是null
 *      3.
 * @Author LINZHIPIN
 * @CreateTime 2021/07/09/00009 14:34:34
 */
public class AccessException extends Exception {
	public AccessException() {
		super();
	}

	public AccessException(String message) {
		super(message);
	}
}

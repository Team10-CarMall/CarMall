package com.team10.exception;

/**
 * 登录异常
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 3:45:04
 */
public class LoginException extends Exception{
	public LoginException() {
		super();
	}

	public LoginException(String message) {
		super(message);
	}
}

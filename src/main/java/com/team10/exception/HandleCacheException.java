package com.team10.exception;

/**
 * 处理redis缓存时出现的异常
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 15:36:20
 */
public class HandleCacheException extends Exception{
	public HandleCacheException() {
		super();
	}

	public HandleCacheException(String message) {
		super(message);
	}

}

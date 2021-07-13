package com.team10.settings.service;

import com.team10.settings.model.ExceptionLog;

/**
 * 日志业务
 * @Author LINZHIPIN
 * @CreateTime 2021/07/09/00009 15:10:08
 */
public interface LogService {

	/**
	 * 用来记录系统的异常到数据库中
	 * @param exceptionLog : 异常日志对象
	 * @return flag
	 */
	boolean addExceptionLog(ExceptionLog exceptionLog);
}

package com.team10.aspect;

import com.team10.settings.model.ExceptionLog;
import com.team10.settings.service.LogService;
import com.team10.util.TimeUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/09/00009 15:13:12
 */
@Aspect
@Component
public class ExceptionHandlerAspect {
	@Autowired
	private LogService logService;

	@Before(value="execution(* com.team10.handler.GlobalExceptionHandler.*(..))")
	public void beforeExceptionHandler(JoinPoint joinPoint){
		ExceptionLog exceptionLog = new ExceptionLog();

		//获取Exception e 这个变量
		Object[] args = joinPoint.getArgs();
		for(Object o : args) {
			Exception e = (Exception) o;
			String msg = e.getMessage();
			if(msg.length() > 255) {
				msg = "未知异常";
			}
			exceptionLog.setContent(msg);
		}
		exceptionLog.setCreateTime(TimeUtil.getSystemTime());

		//boolean flag = logService.addExceptionLog(exceptionLog);
	}
}

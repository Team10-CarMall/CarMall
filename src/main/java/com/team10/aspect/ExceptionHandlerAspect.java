package com.team10.aspect;

import com.team10.settings.model.ExceptionLog;
import com.team10.settings.service.LogService;
import com.team10.util.TimeUtil;
import com.team10.util.TokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 异常处理的切面
 * @Author LINZHIPIN
 * @CreateTime 2021/07/09/00009 15:13:12
 */
@Aspect
@Component
public class ExceptionHandlerAspect {
	@Autowired
	private LogService logService;

	/**
	 * 对进入  GlobalExceptionHandler 这个全局异常处理类时进行日志记录
	 * 本来应该是通过日志框架来进行异步记录
	 * @param joinPoint 加入点，可以获取即将进入的方法的参数
	 *                  这里主要获取Exception这个对象，因为也只有这一个参数
	 */
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

		if(TokenUtils.getUserId() != null) {
			exceptionLog.setUserId(TokenUtils.getUserId());
		}
		//将异常信息记录到数据库中
		boolean flag = logService.addExceptionLog(exceptionLog);
	}
}

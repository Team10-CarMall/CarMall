package com.team10.aspect;

import com.team10.exception.AccessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 判空的切面
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 9:20:55
 */
@Aspect
@Component
public class NullCheckAspect {

	/**
	 *  定义切入点为@NullCheck注释
	 *  再通过@Before继续切入，再通过JoinPoint获取参数信息，这里是判断全部的参数
	 *  如果为空则抛出AccessException 访问异常，表示访问的方式不对，再通过全局异常处理器去处理异常
	 */
	@Pointcut(value = "@annotation(com.team10.annotation.NullCheck)")
	public void pointCut() {

	}
	@Before("pointCut()")
	public void nullCheck(JoinPoint joinPoint) throws AccessException {
		Object[] args = joinPoint.getArgs();
		for(Object o : args) {
			if(o == null) {
				throw new AccessException("传参不正确!");
			}
		}
	}
}

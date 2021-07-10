package com.team10.aspect;

import com.team10.exception.AccessException;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 9:20:55
 */
@Aspect
@Component
public class EmptyCheckAspect {

	@Pointcut(value = "@annotation(com.team10.annotation.NullCheck)")
	public void pointCut() {

	}

	@Before("pointCut()")
	public void emptyCheck(JoinPoint joinPoint) throws AccessException {
		Object[] args = joinPoint.getArgs();
		for(Object o : args) {
			if(o == null) {
				throw new AccessException("传参不正确!");
			}
		}
	}
}

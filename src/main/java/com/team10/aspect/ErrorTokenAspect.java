package com.team10.aspect;

import com.team10.exception.LoginException;
import com.team10.util.ServletUtil;
import com.team10.util.TokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ErrorTokenAspect {

    @Pointcut(value = "@annotation(com.team10.annotation.TokenCheck)")
    public void pointCut() {

    }

    @Before("pointCut()")
    public void emptyCheck(JoinPoint joinPoint) throws LoginException {
        if(!TokenUtils.checkToken()){
            throw new LoginException();
        }
    }
}
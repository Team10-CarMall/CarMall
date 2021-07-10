package com.team10.user.log;

import com.team10.user.model.ControllerLog;
import com.team10.user.service.ControllerLogService;
import com.team10.util.TimeUtil;
import com.team10.util.TokenUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

@Aspect
@Component
public class ControllerLogAspect {
    @Autowired
    private ControllerLogService controllerLogService;

    //定义切点 @Pointcut
    //在注解的位置切入代码
    @Pointcut("@annotation( com.team10.user.log.CarLog)")
    public void logPoinCut() {
    }

    //切面 配置通知
    @AfterReturning("logPoinCut()")
    public void saveSysLog(JoinPoint joinPoint) {
        System.out.println("切面==========");
        //保存日志
        ControllerLog crlLog = new ControllerLog();

        //从切面织入点处通过反射机制获取织入点处的方法
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        //获取切入点所在的方法
        Method method = signature.getMethod();

//        //获取操作
//        ControllerLog myLog = method.getAnnotation(ControllerLog.class);
//        if (myLog != null) {
//            String value = myLog.value();
//            myLog.setOperation(value);//保存获取的操作
//        }

        //获取请求的类名
        String className = joinPoint.getTarget().getClass().getName();
        //获取请求的方法名
        String methodName = method.getName();
        crlLog.setController(className + "_" + methodName);
//
//        //请求的参数
//        Object[] args = joinPoint.getArgs();
//        //将参数所在的数组转换成json
//        String params = JSON.toJSONString(args);
//        sysLog.setParams(params);

        crlLog.setCreateTime(TimeUtil.getSystemTime());
        //获取用户id
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        String token = request.getHeader("token");
        //TODO
        crlLog.setUserId(TokenUtils.getClaim(token,"id"));


        //调用service保存SysLog实体类到数据库
        controllerLogService.save(crlLog);
    }
}

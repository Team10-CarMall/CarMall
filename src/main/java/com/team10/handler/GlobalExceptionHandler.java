package com.team10.handler;

import com.team10.exception.AccessException;
import com.team10.util.ReturnDataUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AccessException.class)
	public Object doAccessException(Exception e) {
		System.out.println(e.getMessage());
		return ReturnDataUtil.getReturnMap(1010, "非法访问", null);
	}
}

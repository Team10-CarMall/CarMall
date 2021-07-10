package com.team10.handler;

import com.team10.exception.AccessException;
import com.team10.exception.HandleCacheException;
import com.team10.util.ReturnDataUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	@ExceptionHandler(value = AccessException.class)
	public Object doAccessException(Exception e) {
		return ReturnDataUtil.getReturnMap(1010, "非法访问", null);
	}



	@ExceptionHandler(value = HandleCacheException.class)
	public Object HandleCacheException(Exception e) {
		return ReturnDataUtil.getReturnMap(1020, "数据异常", null);
	}

	@ExceptionHandler(value = Exception.class)
	public Object doException(Exception e) {
		return ReturnDataUtil.getReturnMap(1999,"未知错误", null);
	}
}

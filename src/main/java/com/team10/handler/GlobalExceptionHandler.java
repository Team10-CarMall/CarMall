package com.team10.handler;

import com.team10.enums.ReturnCode;
import com.team10.exception.AccessException;
import com.team10.exception.HandleCacheException;
import com.team10.util.ReturnDataUtil;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理，用于捕获代码运行过程中出现的异常，并对异常进行处理后返回结果
 * @Author LINZHIPIN
 * @CreatTime 2021/07/08/00010 13:11:41
 *
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	//处理访问异常
	@ExceptionHandler(value = AccessException.class)
	public Object doAccessException(Exception e) {
		return ReturnDataUtil.getReturnMap(ReturnCode.ILLEGAL_ACCESS, "非法访问", null);
	}

	//处理缓存数据的异常
	@ExceptionHandler(value = HandleCacheException.class)
	public Object HandleCacheException(Exception e) {
		return ReturnDataUtil.getReturnMap(ReturnCode.DATA_ERROR, "数据异常", null);
	}

	//处理其他的异常
	@ExceptionHandler(value = Exception.class)
	public Object doException(Exception e) {
		return ReturnDataUtil.getReturnMap(ReturnCode.UNKNOWN_ERROR,"未知错误", null);
	}
}

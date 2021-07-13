package com.team10.settings.mapper;

import com.team10.settings.model.ExceptionLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * 异常日志的Mapper
 * @Author LINZHIPIN
 * @CreateTime 2021/07/13/00013 23:40:19
 */
@Mapper
public interface ExceptionLogMapper {
	int addExceptionHandlerLog(ExceptionLog exceptionLog);
}

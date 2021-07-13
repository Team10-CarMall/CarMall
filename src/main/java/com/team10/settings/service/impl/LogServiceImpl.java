package com.team10.settings.service.impl;

import com.team10.settings.mapper.ExceptionLogMapper;
import com.team10.settings.model.ExceptionLog;
import com.team10.settings.service.LogService;
import org.apache.ibatis.logging.LogException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/09/00009 15:10:23
 */
@Service
public class LogServiceImpl implements LogService {
	@Autowired
	private ExceptionLogMapper exceptionLogMapper;

	@Override
	@Transactional(
		rollbackFor = {
				RuntimeException.class,
				LogException.class
		}
	)
	public boolean addExceptionLog(ExceptionLog exceptionLog) {
		int count = exceptionLogMapper.addExceptionHandlerLog(exceptionLog);
		if(count != 1) {
			throw new LogException("添加异常日志信息失败！");
		}
		return true;
	}
}

package com.team10.user.service.impl;

import com.team10.user.mapper.ControllerLogMapper;
import com.team10.user.model.ControllerLog;
import com.team10.user.service.ControllerLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControllerLogServiceImpl implements ControllerLogService {
    @Autowired
    private ControllerLogMapper controllerLogMapper;

    @Override
    public int save(ControllerLog controllerLog) {
        return controllerLogMapper.insert(controllerLog);
    }
}

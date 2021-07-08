package com.team10.user.mapper;

import com.team10.user.model.ControllerLog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ControllerLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ControllerLog record);

    int insertSelective(ControllerLog record);

    ControllerLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ControllerLog record);

    int updateByPrimaryKey(ControllerLog record);
}
package com.team10.settings.mapper;

import com.team10.settings.model.DicType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:10:49
 */
@Mapper
public interface DicTypeMapper {
	List<DicType> getGoodsType(Boolean enable);
}

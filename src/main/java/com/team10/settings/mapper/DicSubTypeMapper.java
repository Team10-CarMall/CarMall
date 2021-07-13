package com.team10.settings.mapper;

import com.team10.settings.model.DicSubType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 关于二级分类的Mapper
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:11:36
 */
@Mapper
public interface DicSubTypeMapper {

	List<DicSubType> getGoodsSubType(DicSubType dicSubType);
}

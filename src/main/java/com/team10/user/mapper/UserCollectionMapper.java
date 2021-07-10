package com.team10.user.mapper;

import com.team10.user.model.UserCollection;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 13:38:21
 */
@Mapper
public interface UserCollectionMapper {

	//查询是否有该条记录
	UserCollection selectOne(UserCollection uc);

	//插入一条新记录
	int insertOne(UserCollection uc);

	//更新记录
	int updateOne(UserCollection uc);
}

package com.team10.user.service;

import com.team10.exception.HandleCacheException;
import com.team10.user.model.User;
import com.team10.user.model.UserCollection;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:00:23
 */
public interface UserService {

	//从Redis里面向mysql更新用户的收藏记录
	boolean updateUserCollections(UserCollection uc) throws HandleCacheException;

	boolean addUser(String username, String password);

	User getUser(String userName);

	//根据商品id和用户id来收藏商品，用户id从后端拿
	Map<String, Object> collectGoods(String goodsId) throws HandleCacheException;

	/**
	 * 返回一个boolean true表示有收藏，false表示没有收藏
	 * @param goodsId 商品的id
	 * @return flag
	 */
	Map<String, Object> isCollect(String goodsId) throws HandleCacheException;
}

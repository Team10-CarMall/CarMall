package com.team10.user.service;

import com.team10.exception.HandleCacheException;
import com.team10.user.model.User;
import com.team10.user.model.UserCollection;
import org.springframework.stereotype.Service;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:00:23
 */
public interface UserService {
	//从Redis里面更新用户的收藏记录
	boolean updateUserCollections(UserCollection uc) throws HandleCacheException;

	boolean addUser(String username, String password);

	User getUser(String userName);
}

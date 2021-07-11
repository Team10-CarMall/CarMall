package com.team10.user.service.impl;

import com.team10.exception.HandleCacheException;
import com.team10.user.mapper.UserCollectionMapper;
import com.team10.user.mapper.UserMapper;
import com.team10.user.model.User;
import com.team10.user.model.UserCollection;
import com.team10.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:00:35
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserCollectionMapper userCollectionMapper;
	@Autowired
	private UserMapper userMapper;

	//将redis中的数据持久化到MySql中
	@Override
	@Transactional(
			rollbackFor = {
					RuntimeException.class,
					HandleCacheException.class
			}
	)
	public boolean updateUserCollections(UserCollection uc) throws HandleCacheException {
		int count = 0;
		if(userCollectionMapper.selectOne(uc) == null) {
			count = userCollectionMapper.insertOne(uc);
		} else {
			count = userCollectionMapper.updateOne(uc);
		}
		if(count != 1) {
			throw new HandleCacheException("处理用户 ["+uc.getUserId()+"] 数据时异常");
		}
		return true;
	}

	@Override
	public boolean addUser(String username, String password) {
		String getId = userMapper.selectLastUserId();
		int num = Integer.parseInt(getId.substring(4)) + 1;
		String userId = "user" + num;
		return userMapper.insertSelective(new User(userId,username,password)) > 0 ? true : false;
	}

	@Override
	public User getUser(String userName) {
		return userMapper.selectByUsername(userName);
	}

}

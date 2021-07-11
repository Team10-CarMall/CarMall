package com.team10.user.service.impl;

import com.google.gson.JsonParser;
import com.team10.exception.HandleCacheException;
import com.team10.user.mapper.UserCollectionMapper;
import com.team10.user.model.UserCollection;
import com.team10.user.service.UserService;
import com.team10.util.ReturnDataUtil;
import com.team10.util.TimeUtil;
import com.team10.util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Set;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:00:35
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserCollectionMapper userCollectionMapper;
	@Resource(name="redisTemplateOfJson")
	private RedisTemplate<String, Object> redisTemplate;

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
		//先去mysql里面查，如果存在执行修改操作，否则执行插入操作
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

	//用户点击收藏商品
	@Override
	public Map<String, Object> collectGoods(String goodsId) throws HandleCacheException {
		SetOperations<String, Object> ops = redisTemplate.opsForSet();
		String redisKey = "coll_" + goodsId;

		//判断redis中是否存在该key,如果存在就从set集合中查询是否有用户的数据
		if(redisTemplate.hasKey(redisKey)) {
			Set<Object> members = ops.members(redisKey);
			for(Object o : members) {
				System.out.println(o.getClass());
				if(!(o instanceof UserCollection)){
					throw new HandleCacheException("redis中存储的数据出现异常!");
				}
				UserCollection uc = (UserCollection) o;
				if(TokenUtils.getUserId().equals(uc.getUserId())) {
					//将状态反转
					uc.setState(!uc.getState());
					uc.setEditTime(TimeUtil.getSystemTime());
					//移除以后再添加进去
					ops.remove(redisKey, o);
					ops.add(redisKey, uc);
					return ReturnDataUtil.getReturnMap(null);
				}
			}
		}
		//程序运行到这说明要么不存在key,要么存在key但是不存在value,都需要去mysql中查询
		UserCollection u1 = new UserCollection();
		u1.setGoodsId(goodsId);
		//u1.setUserId(TokenUtils.getUserId());
		u1.setUserId("user10000");
		UserCollection u2 = userCollectionMapper.selectOne(u1);
		Long count;
		//如果mysql中也没有，则应该插入新数据到redis中
		if(u2 == null) {
			u1.setState(true);
			u1.setCreateTime(TimeUtil.getSystemTime());
			u1.setVersion(1);
			count = ops.add(redisKey, u1);
		} else {
			u2.setState(!u2.getState());
			u2.setEditTime(TimeUtil.getSystemTime());
			u2.setVersion(u2.getVersion());
			count = ops.add(redisKey, u2);
		}
		if(count != 1) {
			//throw new HandleCacheException("在Redis中添加用户" + TokenUtils.getUserId() + "的收藏商品数据失败");
			throw new HandleCacheException("在Redis中添加用户" + "" + "的收藏商品数据失败");
		}
		//前端通过code来判断是否操作成功
		return ReturnDataUtil.getReturnMap(null);
	}

	//判断用户是否有收藏商品
	@Override
	public Map<String, Object> isCollect(String goodsId) throws HandleCacheException {
		SetOperations<String, Object> ops = redisTemplate.opsForSet();
		String redisKey = "coll_" + goodsId;
		//如果redis中存在key就进行查找
		if(redisTemplate.hasKey(redisKey)) {
			Set<Object> members = ops.members(redisKey);
			for(Object o : members) {
				if(!(o instanceof UserCollection)){
					throw new HandleCacheException("redis中存储的用户收藏数据出现异常!");

				}
				UserCollection uc = (UserCollection) o;
				if(TokenUtils.getUserId().equals(uc.getUserId())) {
					return ReturnDataUtil.getReturnMap(uc.getState());
				}
			}
		}
		//运行到这里说明要么redis中不存在该key,或者存在key但是不存在value，都需要去mysql中查找
		UserCollection u1 = new UserCollection();
		u1.setGoodsId(goodsId);
		//u1.setUserId(TokenUtils.getUserId())
		u1.setUserId("user10000");
		UserCollection u2 = userCollectionMapper.selectOne(u1);
		return ReturnDataUtil.getReturnMap(u2 == null ? false : u2.getState());
	}

	@Override
	public boolean addUser(String username, String password) {
		return false;
	}

	@Override
	public String getUserId(String userName) {
		return null;
	}
}

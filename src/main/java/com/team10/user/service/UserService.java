package com.team10.user.service;

import com.team10.exception.HandleCacheException;
import com.team10.user.model.User;
import com.team10.user.model.UserCollection;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 1:00:23
 */
public interface UserService {

	/**
	 * 用于处理定时任务从redis中更新用户的收藏记录到数据库中的操作
	 * @param uc 收藏记录的对象
	 * @return 由于不返回数据给前端，因此简单返回一个true或者false即可，但是在业务处理过程中
	 *         设置了抛异常的方式，因此返回值不重要
	 */
	boolean updateUserCollections(UserCollection uc) throws HandleCacheException;

	boolean addUser(String username, String password);

	User getUser(String userName);

	/**
	 * 用户点击收藏商品时的操作，如果用户已经收藏过该商品，则取消收藏，否则就收藏
	 * 先去redis中查找，没有再去数据库中查找，若两者都没有，则表示用户没有收藏过，则进行收藏操作
	 * 如果redis或者数据库中有，则根据数据的state来判断当前用户是收藏还是未收藏，取反即可
	 * 根据userId和goodsId来进行操作
	 * @param goodsId  userId从后端中后去
	 */
	Map<String, Object> collectGoods(String goodsId) throws HandleCacheException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

	/**
	 * 返回一个boolean true表示有收藏，false表示没有收藏
	 * @param goodsId 商品的id
	 * @return flag
	 */
	Map<String, Object> isCollect(String goodsId) throws HandleCacheException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;
}

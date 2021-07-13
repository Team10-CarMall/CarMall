package com.team10;

import com.team10.user.model.UserCollection;
import com.team10.util.ReflectUtil;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/11/00011 22:33:21
 */
public class DemoTest {
	public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", "12321");
		map.put("goodsId", "1232");
		Object o = ReflectUtil.setValuesFromMap(UserCollection.class, map);
		System.out.println(o);
	}
}

package com.team10.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 反射的工具类
 * @Author LINZHIPIN
 * @CreateTime 2021/07/11/00011 22:05:02
 */
public class ReflectUtil {

	/**
	 * 简答的将map中的数据映射到需要的类对象，并且返回一个该对象的实例
	 *
	 * @param clazz  某个类的Class对象
	 * @param map    需要映射的数据
	 *
	 * @return 返回需要的类对象的实例
	 */
	public static Object setValuesFromMap(Class<?> clazz, Map<String, Object> map) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		//通过构造器生成一个实例
		Object obj = clazz.getConstructor().newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(map.get(field.getName()) != null) {
				//给该实例对象进行赋值
				field.set(obj, map.get(field.getName()));
			}
		}
		return obj;
	}
}

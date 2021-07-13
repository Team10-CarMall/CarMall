package com.team10.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/11/00011 22:05:02
 */
public class ReflectUtil {
	public static Object setValuesFromMap(Class<?> clazz, Map<String, Object> map) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Object obj = clazz.getConstructor().newInstance();
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			field.setAccessible(true);
			if(map.get(field.getName()) != null) {
				field.set(obj, map.get(field.getName()));
			}
		}
		return obj;
	}
}

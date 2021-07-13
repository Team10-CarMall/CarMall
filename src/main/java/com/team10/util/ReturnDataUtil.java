package com.team10.util;

import com.team10.enums.ReturnCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于返回数据给前端时的工具类
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 3:52:51
 */
public class ReturnDataUtil {
	/**
	 * @param code : 返回的状态码
	 * @param msg : 返回的说明
	 * @param data :返回的数据
	 * */
	public static Map<String, Object> getReturnMap(Integer code, String msg, Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}

	/**
	 * 默认是操作成功，code是SUCCESS
	 * @param data :返回的数据
	 * */
	public static Map<String, Object> getReturnMap(Object data) {
		return getReturnMap(ReturnCode.SUCCESS, "操作成功", data);
	}

}

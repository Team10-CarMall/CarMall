package com.team10.util;

import com.team10.enumdemo.ReturnCode;
import org.springframework.ui.Model;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author LINZHIPIN
 * @CreateTime 2021/07/07/00007 3:52:51
 */
public class ReturnDataUtil {
	/**
	 * @param code : 返回的状态码
	 * @param msg : 返回的说明
	 * @param data :返回的数据
	 * */
	public static Map<String, Object> getReturnModel(Integer code, String msg, Object data) {
		Map<String, Object> map = new HashMap<>();
		map.put("code", code);
		map.put("msg", msg);
		map.put("data", data);
		return map;
	}

	/**
	 * 默认是操作成功，code是SUCCESS
	 * 如果返回的数据是空的话，返回的code 是SUCCESS_NONE
	 * @param msg : 返回的说明
	 * @param data :返回的数据
	 * */
	public static Map<String, Object> getReturnModel(String msg, Object data) {
		return getReturnModel(data == null ? ReturnCode.SUCCESS_NONE : ReturnCode.SUCCESS_NONE, msg, data);
	}
}

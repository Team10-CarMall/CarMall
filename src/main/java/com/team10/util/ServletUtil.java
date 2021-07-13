package com.team10.util;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Servlet工具类
 * @Author LINZHIPIN
 * @CreateTime 2021/07/10/00010 11:59:26
 */
public class ServletUtil {

	//这里只是获取request对象，使得在任何地方都可以使用request对象
	public static HttpServletRequest getRequest() {
		RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
		return request;
	}
}

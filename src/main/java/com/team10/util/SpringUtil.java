package com.team10.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;

@Component
public class SpringUtil implements ApplicationContextAware
{
	private static ApplicationContext  applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		SpringUtil.applicationContext = applicationContext;
	}

	//获取applicationContext
	public static ApplicationContext getApplicationContext()
	{
		return applicationContext;
	}

	//通过name获取bean
	public static Object getBean(String name)
	{
		return getApplicationContext().getBean(name);
	}

	//通过class获取bean
	public static <T> T getBean(Class<T> clazz)
	{
		return getApplicationContext().getBean(clazz);
	}

	//获取application
	public static ServletContext getServletContext()
	{
		return applicationContext.getBean(ServletContext.class);
	}
}
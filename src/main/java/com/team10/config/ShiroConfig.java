package com.team10.config;

import com.kotori.springboot.server.service.CustomRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public CustomRealm customRealm() {
        return new CustomRealm();
    }

    @Bean
    public DefaultWebSecurityManager securityManager() {
        DefaultWebSecurityManager securityManager =
                new DefaultWebSecurityManager();
        securityManager.setRealm(customRealm());
        securityManager.setRememberMeManager(null);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean() {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager());
        //登陆界面
        bean.setLoginUrl("/to/login");
        //未登录跳转页
        bean.setUnauthorizedUrl("/unauth");
        Map<String, String> filterChainDefinitionMap = new HashMap<>();
        //无需认证即可访问
        filterChainDefinitionMap.put("/to/login", "anon");
        filterChainDefinitionMap.put("/**", "anon");

        //对未登入用户进行拦截
        filterChainDefinitionMap.put("/kill/execute", "authc");
        filterChainDefinitionMap.put("/item/detail/*", "authc");

        bean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return bean;
    }
}

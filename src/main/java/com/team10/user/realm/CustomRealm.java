package com.team10.user.realm;

import com.team10.user.mapper.UserMapper;
import com.team10.user.model.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


public class CustomRealm extends AuthorizingRealm {
    private static final Logger log= LoggerFactory.getLogger(CustomRealm.class);




    private static final Long sessionKeyTimeOut=3600_000L;
    @Autowired
    private UserMapper userMapper;

    /**
     * 授权
     * */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 认证
    * */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        String password=String.valueOf(token.getPassword());
        log.info("当前登录的用户名={} 密码={} ",userName,password);

        User user=userMapper.selectByUsername(userName);
        if (user==null){
            throw new UnknownAccountException("用户名不存在，前往注册");
        }

        if (!user.getPassword().equals(password)){
            throw new IncorrectCredentialsException("用户名密码不匹配!");
        }
        if (user.getState().equals("0")){
            throw new DisabledAccountException("账号异常!");
        }

        SimpleAuthenticationInfo info=new SimpleAuthenticationInfo(user.getUsername(),password,getName());
        setSession("uid",user.getId());
        return info;
    }

    /**
     * 将key与对应的value塞入shiro的session中-最终交给HttpSession进行管理(如果是分布式session配置，那么就是交给redis管理)
     */
    private void setSession(String key,Object value){
        Session session= SecurityUtils.getSubject().getSession();
        if (session!=null){
            session.setAttribute(key,value);
            session.setTimeout(sessionKeyTimeOut);
        }
    }
}

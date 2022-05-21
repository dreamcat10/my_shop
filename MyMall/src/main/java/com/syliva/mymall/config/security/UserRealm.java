package com.syliva.mymall.config.security;

import com.syliva.mymall.mapper.UserMapper;
import com.syliva.mymall.pojo.User;
import com.syliva.mymall.pojo.UserToken;
import com.syliva.mymall.service.UserTokenService;
import com.syliva.mymall.service.impl.UserServiceImpl;
import com.syliva.mymall.service.impl.UserTokenServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {
    @Autowired
    UserTokenServiceImpl userTokenService;
    @Autowired
    UserServiceImpl userService;


    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof AuthToken;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        // 从 PrincipalCollection 中来获取登录用户的信息
        User user = (User) principals.getPrimaryPrincipal();
        if (user != null){
            SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
            String role = user.getRole();
            info.addRole(role);
            return info;
        }
        return null;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取到前端传来的token
        String accessToken = (String) token.getPrincipal();

        //根据accesstoken拿到用户信息
        UserToken userToken = userTokenService.findByToken(accessToken);

        //判断Usertoken是否失效
        if (userToken == null || userToken.getExpireTime().getTime() < System.currentTimeMillis()){
            //失效抛出错误
            throw new IncorrectCredentialsException("token失效, 请重新登录");
        }
        //判断Usertoken的用户信息是否与数据库中的匹配
        User user = userService.findById(userToken.getUserId());

        if (user == null){
            throw  new UnknownAccountException("用户不存在");
        }

        return new SimpleAuthenticationInfo(user, accessToken, getName());

    }


}

package com.shiro.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;

/**
 * @Author TianCheng
 * @Date 2019/8/13 14:18
 */
public class ShiroRealm extends AuthenticatingRealm {

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("doGetAuthenticationInfo : " + token);

        // 1. 把AuthenticationToken 转换为 UsernamePasswordToken
        UsernamePasswordToken upToken = (UsernamePasswordToken) token;
        // 2. 从UsernamePasswordToken中 获取 username
        String username = upToken.getUsername();
        // 3. 调用数据库的方法来从数据库中查询username对应的用户记录
        System.out.println("从数据库中获取username ：" + username + "所对应的信息");
        // 4. 若用户不存在， 则可以抛出 UnknownAccountException 异常
        if("unknown".equals(username)){
            throw new UnknownAccountException("用户不存在");
        }
        // 5. 根据用户信息的情况，决定是否需要抛出其他的 AuthenticationException 异常。
        if("monster".equals(username)){
            throw new LockedAccountException("用户被锁定");
        }
        // 6.根据用户的情况，来构建AuthenticationInfo 对象并返回.
        //假设以下信息是从数据库中获取的。
        //1. principal: 认证的实体信息，可以是username，也可以是数据表对应的用户的实体类对象。
        Object principal = username;
        //2. credentials : 密码。
        Object credentials = "123456";
        //3. realmName : 当前realm对象的name，调用父类的 getName()方法即可。
        String realmName = getName();

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal,credentials,realmName);
        return info;
    }
}

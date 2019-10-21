package com.jianping.pond.common.shiro;

import com.jianping.pond.dao.UserMapper;
import com.jianping.pond.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 自定义Realm实现身份验证，和权限认证
 */

public class MyRealm extends AuthorizingRealm {

    @Autowired
    UserMapper userMapper;
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        // 获取用户名
        String username = (String) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 给该用户设置角色，角色信息存在 t_role 表中取
//        authorizationInfo.setRoles(userService.getRoles(username));
        // 给该用户设置权限，权限信息存在 t_permission 表中取
//        authorizationInfo.setStringPermissions(userService.getPermissions(username));
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //身份验证
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        String password = String.valueOf(token.getPassword());
        // 根据用户名从数据库中查询该用户
        //User user = userService.getByUsername(username);
        User user = userMapper.getUserByUsername(username);
        if(user != null) {
            // 把当前用户存到 Session 中
            SecurityUtils.getSubject().getSession().setAttribute("user", user);
            // 传入用户名和密码进行身份认证，并返回认证信息
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword().toCharArray(), ByteSource.Util.bytes(user.getRemark()), getName());
            return authcInfo;
        } else {
            return null;
        }
    }
}

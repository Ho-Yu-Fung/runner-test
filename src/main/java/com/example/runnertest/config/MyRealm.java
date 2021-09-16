package com.example.runnertest.config;

import com.example.runnertest.entity.User;
import com.example.runnertest.service.UserService;
import io.netty.util.internal.ObjectUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;


public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;

    /**
     * 授权
     *
     * @param principalCollection 身份标识
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("================授权====================");
        //获取身份信息
        String principal = (String) principalCollection.getPrimaryPrincipal();
        System.out.println(principal);
        return null;
    }

    /**
     * 认证
     *
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("================认证====================");
        System.out.println(token.getPrincipal());
        User user = userService.findUserByName(token.getPrincipal().toString());//返回数据库对象
        System.out.println(user);
        if (!ObjectUtils.isEmpty(user)) {
            //arg1:返回数据库中正确的用户名 arg2:返回数据库中正确的密码  arg arg4:当前realm的名字 返回数据库信息与token中的数据进行比较
            SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getName(), user.getPwd(), ByteSource.Util.bytes(user.getSalt()), this.getName());
            System.out.println("===========success============");
            return authenticationInfo;
        }
        return null;
    }
}

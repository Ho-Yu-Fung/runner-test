package com.example.runnertest.config;


import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * Shiro配置类
 *
 */
@Configuration
public class ShiroConfig {
    /**
     * shirofilter负责拦截所有请求
     * @return
     */
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源
        //配置系统公共资源
        HashMap<String, String> map = new HashMap<String,String>();
        map.put("/save","anon");
        map.put("/up/*","authc");
        shiroFilterFactoryBean.setLoginUrl("/index.html");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     *
     * @return
     */
    @Bean("webSecurity")
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("shiroRealm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理器设置realm
        defaultWebSecurityManager.setRealm(realm);

        return defaultWebSecurityManager;
    }

    /**
     * 配置自定义realm
     * @return
     */
    @Bean("shiroRealm")
    public Realm realm(){
        MyRealm realm = new MyRealm();
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName("Md5");//修改默认凭证匹配器 适配Md5加密
//        credentialsMatcher.setHashIterations(1024); 设置散列次数
        realm.setCredentialsMatcher(credentialsMatcher);

        return realm;
    }
}

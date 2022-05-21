package com.syliva.mymall.config.security;



import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    //自定义的Realm
    @Bean
    public UserRealm userRealm(){
        UserRealm userRealm = new UserRealm();
        return userRealm;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(userRealm);

        return securityManager;
    }

    @Bean("shiroFilterFactoryBean")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //oauth过滤
        Map<String, Filter> filters = new HashMap<>();
        filters.put("auth", new JwtFilter());
        shiroFilterFactoryBean.setFilters(filters);

        Map<String , String > hashMap = new LinkedHashMap<>();

        hashMap.put("/user/inLogin", "anon");
        hashMap.put("/user/login", "anon");
        hashMap.put("/user/**","auth");
        hashMap.put("/cart/**","auth");
        hashMap.put("/**", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(hashMap);

        return shiroFilterFactoryBean;
    }

    @Bean("lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    // 开启注解代理
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }

}

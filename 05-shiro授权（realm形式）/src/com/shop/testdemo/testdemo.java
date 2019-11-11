package com.shop.testdemo;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

public class testdemo {

    @Test
    public void fun1(){

        IniSecurityManagerFactory securityManagerFactory = new IniSecurityManagerFactory("classpath:shiro-permissions.ini");
        SecurityManager securityManager = securityManagerFactory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();


        UsernamePasswordToken token=new UsernamePasswordToken("zhangsan","888");


        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

        boolean b = subject.isAuthenticated();
        System.out.println(b);

        boolean b1 = subject.isPermitted("user:create");
        System.out.println(b1);

        boolean b2 = subject.isPermitted("user:delete");
        System.out.println(b2);
    }
}

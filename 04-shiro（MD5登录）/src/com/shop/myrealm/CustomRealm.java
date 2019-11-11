package com.shop.myrealm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

public class CustomRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String principal = (String) authenticationToken.getPrincipal();
        //下次是要从数据库获取的，加密是注册时候存入数据库或者登录和数据库判断的时候做的。
        String pwd="955c05f38a2c9b31cd1092dcae47c31f";

        String salt="abc";
        SimpleAuthenticationInfo realm = new SimpleAuthenticationInfo(principal, pwd, ByteSource.Util.bytes(salt),"realm");


        return realm;
    }
}

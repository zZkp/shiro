package com.shop.testdemo;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.junit.Test;

public class test1 {
    @Test
    public void fun1()
    {
        Md5Hash hash=new Md5Hash("888");
        System.out.println(hash);
    }


    /**
     * 加盐
     */
    @Test
    public void fun2()
    {
        String salt="abc";
        Md5Hash hash=new Md5Hash("888",salt);
        System.out.println(hash);
    }

    /**
     * 加密2次
     */
    @Test
    public void fun3()
    {
        String salt="abc";
        Integer hashiterations=2;
        Md5Hash hash=new Md5Hash("888",salt,hashiterations);
        System.out.println(hash);
    }
}

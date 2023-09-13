package com.hang.spring.proxy.proxy_exception;

/**
 * @ClassName SubClass2
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 21:17
 * @Version 1.0
 */

public class SubClass2 implements Parent {

    @Override
    public void test() {
        System.out.println("==========SubClass2.test()");
    }
}

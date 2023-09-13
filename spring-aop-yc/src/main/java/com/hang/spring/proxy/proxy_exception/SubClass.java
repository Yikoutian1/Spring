package com.hang.spring.proxy.proxy_exception;

import org.springframework.stereotype.Service;

/**
 * @ClassName SubClass
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 21:16
 * @Version 1.0
 */
@Service
public class SubClass implements Parent {

    @Override
    public void test() {
        System.out.println("----------SubClass.test()");
    }
}

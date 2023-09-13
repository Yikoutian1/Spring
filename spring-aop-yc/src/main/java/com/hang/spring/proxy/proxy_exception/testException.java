package com.hang.spring.proxy.proxy_exception;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Controller;

/**
 * @ClassName testExpetion
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 21:18
 * @Version 1.0
 */
@Controller
public class testException {
    // 只要该类包含连接点方法,就会触发代理 => 实现接口 => JDK代理
    @Resource
    // 2. 如果是报错 得到的是一个代理类,那么则把 SubClass 改为父类
    // Java中 不能兄弟之间引用
    private SubClass subClass;
    @Resource
    private SubClass2 subClass2;

    @Test
    public void test() {
        //1. 此时这里会报错   这两个是兄弟关系
        subClass.test();
        subClass2.test();
    }

}

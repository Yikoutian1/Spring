package com.hang.spring.aop.example;

/**
 * @ClassName testDynamicProxy
 * @Description 测试类
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 19:45
 * @Version 1.0
 */

public class testDynamicProxy {
    public static void main(String[] args) {
        // 创建代理对象(动态)
        ProxyFactory factory = new ProxyFactory(new CalculatorLogImpl());
        // 得到对象
        Calculator proxy = (Calculator) factory.getProxy();
        proxy.div(1, 1);
//        proxy.div(1, 0); // 会报异常 也会输出
    }
}

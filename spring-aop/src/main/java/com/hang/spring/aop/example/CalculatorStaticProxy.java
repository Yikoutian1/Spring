package com.hang.spring.aop.example;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @ClassName CalculatorStaticProxy
 * @Description 静态代理类
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 19:20
 * @Version 1.0
 */

public class CalculatorStaticProxy implements Calculator {
    // 被代理的目标对象传递过来
    private Calculator calculator;
    public CalculatorStaticProxy(Calculator calculator) {
        this.calculator = calculator;
    }

    @Override
    public int add(int i, int j) {
        // 附加功能由代理类中的代理方法来实现
        System.out.println("[日志] add 方法开始了，参数是：" + i + "," + j);

        // 通过目标对象来实现核心业务逻辑
        int addResult = calculator.add(i, j);

        System.out.println("[日志] add 方法结束了，结果是：" + addResult);

        return addResult;
    }

    @Override
    public int sub(int i, int j) {
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        return 0;
    }

    @Override
    public int div(int i, int j) {
        return 0;
    }
}

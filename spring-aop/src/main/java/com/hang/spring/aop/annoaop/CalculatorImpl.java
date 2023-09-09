package com.hang.spring.aop.annoaop;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ClassName CalculatorImpl
 * @Description 基本实现类
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 19:05
 * @Version 1.0
 */
@Service
public class CalculatorImpl implements Calculator {

    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println("方法内部 result = " + result);
        return result;
    }

    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println("方法内部 result = " + result);
        return result;
    }
}
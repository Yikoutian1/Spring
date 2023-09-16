package com.hang.spring.function;

import org.springframework.stereotype.Service;

/**
 * @ClassName testAspect
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 19:01
 * @Version 1.0
 */
@Service
public class FunctionAspect {

    public int add(int a,int b){
        return a + b;
    }
}

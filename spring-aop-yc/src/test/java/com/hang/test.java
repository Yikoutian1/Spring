package com.hang;

import com.hang.spring.config.SpringAopConfig;
import com.hang.spring.function.FunctionAspect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName spring
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 19:06
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringAopConfig.class)
public class test {
    @Autowired
    private FunctionAspect functionAspect;
    @Test
    public void test1(){
        functionAspect.add(1,2);
    }
}

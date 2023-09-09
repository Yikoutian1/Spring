package com.hang.spring.aop.annoaop;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * @ClassName TestAop
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 21:16
 * @Version 1.0
 */

public class TestAop {
    @Test
    public void testAdd() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        Calculator bean = context.getBean(Calculator.class);
        bean.add(2, 0);
        // TODO console
        // Logger-->前置通知，方法名：add，参数：[2, 3]
        // 方法内部 result = 5
    }
}

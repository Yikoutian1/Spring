package com.hang.spring.ioc.factorybean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testUser
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 20:12
 * @Version 1.0
 */

public class testUser {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-factorybean.xml");
        Object factoryBean = context.getBean("factoryBean");
        System.out.println(factoryBean);
        /*
        DefaultListableBeanFactory - Creating shared instance of singleton bean 'factoryBean'
            得到的是一个User对象
            com.hang.spring.ioc.factorybean.User@64c63c79
         */
    }
}

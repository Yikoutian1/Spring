package com.hang.spring.ioc.scope;


import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName TestOrders
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 19:15
 * @Version 1.0
 */

public class TestOrders {
    /**
     * 单例  scope=singleton   初始化ioc容器的时候创建
     *
     * @param args
     */
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-scope.xml");
        Object orders = context.getBean("orders", Orders.class);
        /*
         * ================第四行 后面有单例显示===============
         * org.springframework.context.support.ClassPathXmlApplicationContext - Refreshing org.springframework.context.support.ClassPathXmlApplicationContext@a38c7fe
         * org.springframework.beans.factory.xml.XmlBeanDefinitionReader - Loaded 1 bean definitions from class path resource [bean-scope.xml]
         * org.springframework.beans.factory.support.DefaultListableBeanFactory - Creating shared instance of singleton bean 'orders'
         * 同一个对象
         * com.hang.spring.ioc.scope.Orders@64a40280
         * com.hang.spring.ioc.scope.Orders@64a40280
         */
        Object orders2 = context.getBean("orders", Orders.class);
        // 地址一样
        System.out.println(orders);
        System.out.println(orders2);
    }

    /**
     * prototype: 多实例   获取bean的时候创建
     */
    @Test
    public void prototype() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-scope.xml");
        Object orders = context.getBean("orders2", Orders.class);
        Object orders2 = context.getBean("orders2", Orders.class);
        System.out.println(orders);
        System.out.println(orders2);
        /*
         * 对象不同
         * com.hang.spring.ioc.scope.Orders@5316e95f
         * com.hang.spring.ioc.scope.Orders@3f053c80
         */
    }
}

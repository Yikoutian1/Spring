package com.hang.spring.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testUser
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/6 006 20:19
 * @Version 1.0
 */

public class getBeansByIdAndClass {
    /**
     * 根据id获取bean
     */
    @Test
    public void byIdGetBean() {
        // 读取bean.xml
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        // 根据id获取bean
        User bean = (User) context.getBean("user");
        System.out.println("根据id获取bean:" + bean);
    }

    /**
     * 根据类型获取bean  (感觉这种好用些)
     */
    @Test
    public void byTypeGetBean() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        User bean = context.getBean(User.class);
        System.out.println("根据类型获取bean:" + bean);
    }

    /**
     * 根据id和类型获取bean
     */
    @Test
    public void byTypeAndIdGetBean() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        User bean = context.getBean("user", User.class);
        System.out.println("根据id和类型获取bean:" + bean);
    }
}

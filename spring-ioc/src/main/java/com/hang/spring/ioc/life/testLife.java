package com.hang.spring.ioc.life;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testLife
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 19:49
 * @Version 1.0
 */

public class testLife {
    @Test
    public void test() {
        // 只有创建ClassPathXmlApplicationContext实现类才有销毁的方法
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("bean-life.xml");
        User user = context.getBean("user", User.class);
        System.out.println("6. bean对象创建完成了,可以使用了");
        System.out.println(user);
        // bean 进行销毁
        context.close();
        /*
            ==========bean的生命周期=========
            1. bean对象创建,无参数构造调用了
            2. 给bean对象设置属性值
            3. bean后置处理器,初始化之前执行
            user::com.hang.spring.ioc.life.User@f79a760
            4. bean对象初始化,会调用指定的初始化方法
            5. bean后置处理器,初始化之后执行
            user::com.hang.spring.ioc.life.User@f79a760
            6. bean对象创建完成了,可以使用了
            com.hang.spring.ioc.life.User@f79a760
            2023-09-07 20:02:00 016 [main] DEBUG org.springframework.context.support.ClassPathXmlApplicationContext - Closing org.springframework.context.support.ClassPathXmlApplicationContext@6d167f58, started on Thu Sep 07 20:01:59 SGT 2023
            7. bean对象销毁,会调用指定的销毁方法
         */

    }
}

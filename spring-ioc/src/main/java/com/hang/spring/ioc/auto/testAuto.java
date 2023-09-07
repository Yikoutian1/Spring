package com.hang.spring.ioc.auto;

import com.hang.spring.ioc.auto.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testAuto
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 20:31
 * @Version 1.0
 */

public class testAuto {
    @Test
    public void testAuto() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-auto.xml");
        UserController userController = context.getBean("userController", UserController.class);
        userController.addUser();
        // 自动注入完成
        /*
            controller方法执行了
            userService方法执行了
            userDao方法执行了
         */
    }
}

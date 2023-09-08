package com.hang.spring.autowired;

import com.hang.spring.autowired.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testUser
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:28
 * @Version 1.0
 */

public class testUser {
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        // 获取controller对象
        UserController userController = context.getBean(UserController.class);
        userController.add();
        /*
            controller执行
            service执行
            dao执行
         */
    }
}

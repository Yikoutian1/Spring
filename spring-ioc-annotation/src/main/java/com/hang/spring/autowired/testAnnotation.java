package com.hang.spring.autowired;

import com.hang.spring.autowired.controller.UserController;
import com.hang.spring.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testUser
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:28
 * @Version 1.0
 */

public class testAnnotation {
    @Test
    public void test() {
        // 加载配置类
        ApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);
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

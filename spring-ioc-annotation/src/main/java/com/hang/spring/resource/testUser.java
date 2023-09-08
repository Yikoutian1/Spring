package com.hang.spring.resource;

import com.hang.spring.resource.controller.UserController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testUser
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 10:18
 * @Version 1.0
 */

public class testUser {
    /**
     * 要想运行这个 可以通过bean.xml扫描筛选范围
     */
    @Test
    public void test() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean.xml");
        UserController bean = context.getBean(UserController.class);
        bean.add();
    }
}

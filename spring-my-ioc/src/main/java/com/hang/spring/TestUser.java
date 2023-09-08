package com.hang.spring;

import com.hang.spring.bean.AnnotationApplicationContext;
import com.hang.spring.bean.ApplicationContext;
import com.hang.spring.service.UserService;
import com.hang.spring.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;


/**
 * @ClassName TestUser
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 17:48
 * @Version 1.0
 */

public class TestUser {
    @Test
    public void test() throws Exception {
        ApplicationContext context =
                new AnnotationApplicationContext("com.hang.spring");
        UserService userService = (UserService)context.getBean(UserService.class);
        System.out.println("userService = " + userService);
        userService.add();
    }
}

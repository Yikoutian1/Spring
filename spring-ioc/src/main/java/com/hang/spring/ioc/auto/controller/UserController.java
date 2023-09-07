package com.hang.spring.ioc.auto.controller;

import com.hang.spring.ioc.auto.service.UserService;
import com.hang.spring.ioc.auto.service.impl.UserServiceImpl;

/**
 * @ClassName UserController
 * @Description 自动装配
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 20:20
 * @Version 1.0
 */

public class UserController {
    /**
     * 自动装配实现
     *  set注入
     */
    private UserService userService;

    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void addUser() {
        System.out.println("controller方法执行了");
        // 调用service方法
        userService.addUserService();

//        UserService userService = new UserServiceImpl();
//        userService.addUserService();
    }
}

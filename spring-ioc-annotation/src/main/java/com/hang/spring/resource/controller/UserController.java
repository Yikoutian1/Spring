package com.hang.spring.resource.controller;

import com.hang.spring.resource.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:04
 * @Version 1.0
 */
@Controller("myUserController")
public class UserController {
    //@Resource注解默认根据名称装配byName，未指定name时，使用属性名作为name。
    // 通过name找不到的话会自动启动通过类型byType装配
    @Resource(name = "myUserService")
    private UserService userService;

    public void add() {
        System.out.println("controller执行");
        userService.add();
    }
}

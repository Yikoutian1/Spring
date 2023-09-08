package com.hang.spring.autowired.controller;

import com.hang.spring.autowired.dao.UserDao;
import com.hang.spring.autowired.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:04
 * @Version 1.0
 */
@Controller
public class UserController {
    // 第一种方式  属性注入
//    @Autowired // 根据类型找到对应的对象,完成注入
//    private UserService userService;
    // =================== //
    // 第二种方式  set方法注入
//    private UserService userService;
//    @Autowired
//    public void setUserService(UserService userService) {
//        this.userService = userService;
//    }
    // =================== //
    // 第三种方式  构造方法注入
//    private UserService userService;
//    @Autowired
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
    // =================== //
    // 第四种方式  形参上注入
    // (如果有多个实现类,那么不能通过类型注入,则要通过名称注入)
//    private UserService userService;
//    public UserController(@Autowired UserService userService) {
//        this.userService = userService;
//    }
    // =================== //
    // 第五种方式  只有一个构造函数，注解可以省略
//    private UserService userService;
//    public UserController(UserService userService) {
//        this.userService = userService;
//    }
    // 要是有俩个构造 则不行
//    public UserController() {
//    }
    // =================== //
    // 最后一种方式  优化第四种出现的问题
    // (如果有多个实现类,那么不能通过类型注入,则要通过名称注入)
    // 使用两个注解,根据名称注入 , 详情在UserServiceImpl中
    @Autowired
    private UserService userService;

    public void add() {
        System.out.println("controller执行");
        userService.add();
    }
}

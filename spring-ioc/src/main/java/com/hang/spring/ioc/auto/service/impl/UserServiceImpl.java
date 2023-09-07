package com.hang.spring.ioc.auto.service.impl;

import com.hang.spring.ioc.auto.dao.UserDao;
import com.hang.spring.ioc.auto.dao.UserDaoImpl;
import com.hang.spring.ioc.auto.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 20:20
 * @Version 1.0
 */

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    // set注入
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUserService() {
        System.out.println("userService方法执行了");
        userDao.addUserDao();

//        UserDao userDao = new UserDaoImpl();
//        userDao.addUserDao();
    }
}

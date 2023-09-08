package com.hang.spring.service.impl;

import com.hang.spring.annotation.Bean;
import com.hang.spring.annotation.Di;
import com.hang.spring.dao.UserDao;
import com.hang.spring.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 14:30
 * @Version 1.0
 */
@Bean
public class UserServiceImpl implements UserService {
    @Di
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("==service==");
        // 调用dao的方法
        userDao.add();
    }
}

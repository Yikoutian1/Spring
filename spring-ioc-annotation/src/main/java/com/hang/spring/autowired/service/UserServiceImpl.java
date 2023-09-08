package com.hang.spring.autowired.service;

import com.hang.spring.autowired.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:04
 * @Version 1.0
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    // 类首字母改小写,指定注入的实现类
    @Qualifier(value = "userRedisDaoImpl")
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("service执行");
        userDao.add();
    }
}

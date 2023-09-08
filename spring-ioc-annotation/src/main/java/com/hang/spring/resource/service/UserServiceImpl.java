package com.hang.spring.resource.service;

import com.hang.spring.resource.dao.UserDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @ClassName UserServiceImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:04
 * @Version 1.0
 */
@Service("myUserService")
public class UserServiceImpl implements UserService {
    @Resource(name = "myUserDao")
    private UserDao userDao;
    @Override
    public void add() {
        System.out.println("service执行");
        userDao.add();
    }
}

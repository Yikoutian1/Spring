package com.hang.spring.ioc.auto.dao;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 20:21
 * @Version 1.0
 */

public class UserDaoImpl implements UserDao {
    @Override
    public void addUserDao() {
        System.out.println("userDao方法执行了");
    }
}

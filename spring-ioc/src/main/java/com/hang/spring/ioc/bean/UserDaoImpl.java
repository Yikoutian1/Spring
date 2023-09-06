package com.hang.spring.ioc.bean;

/**
 * @ClassName UserDaoImpl
 * @Description UserDao实现类
 * @Author QiuLiHang
 * @DATE 2023/9/6 006 20:37
 * @Version 1.0
 */

public class UserDaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("User Dao Impl Function!");
    }
}

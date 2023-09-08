package com.hang.spring.resource.dao;

import org.springframework.stereotype.Repository;

/**
 * @ClassName UserRedisDaoImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 9:57
 * @Version 1.0
 */
@Repository("myUserRedisDao")
public class UserRedisDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("dao redis 执行");
    }
}

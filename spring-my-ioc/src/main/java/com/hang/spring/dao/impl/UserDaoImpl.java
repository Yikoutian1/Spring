package com.hang.spring.dao.impl;

import com.hang.spring.annotation.Bean;
import com.hang.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 14:31
 * @Version 1.0
 */
@Bean
public class UserDaoImpl implements UserDao {
    @Override
    public void add() {
        System.out.println("==dao==");
    }
}

package com.hang.spring.autowired.dao;

import com.hang.spring.autowired.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:04
 * @Version 1.0
 */
@Repository
public class UserDaoImpl implements UserDao{

    @Override
    public void add() {
        System.out.println("dao执行");
    }
}

package com.hang.spring.resource.dao;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Repository;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 21:04
 * @Version 1.0
 */
@Repository("myUserDao")
public class UserDaoImpl implements UserDao {
    // 未指定name时，使用属性名作为name
    @Resource
    private UserDao userDao;

    @Override
    public void add() {
        System.out.println("dao执行");
        userDao.add();
    }
}

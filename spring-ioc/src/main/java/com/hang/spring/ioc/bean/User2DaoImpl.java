package com.hang.spring.ioc.bean;

/**
 * @ClassName User2Dao
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/6 006 20:50
 * @Version 1.0
 */

public class User2DaoImpl implements UserDao{
    @Override
    public void run() {
        System.out.println("这是第二个UserDao的实现类,测试多实现");
    }
}

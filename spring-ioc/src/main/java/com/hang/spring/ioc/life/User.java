package com.hang.spring.ioc.life;

/**
 * @ClassName User
 * @Description spring的生命周期
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 19:36
 * @Version 1.0
 */

public class User {
    private String name;

    // 无参数构造
    public User() {
        System.out.println("1. bean对象创建,无参数构造调用了");
    }

    // 初始化的方法
    public void initMethod() {
        System.out.println("4. bean对象初始化,会调用指定的初始化方法");
    }

    // 销毁的方法
    public void destroyMethod() {
        System.out.println("7. bean对象销毁,会调用指定的销毁方法");
    }


    public void setName(String name) {
        System.out.println("2. 给bean对象设置属性值");
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

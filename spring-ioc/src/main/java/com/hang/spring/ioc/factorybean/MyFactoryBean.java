package com.hang.spring.ioc.factorybean;

import org.springframework.beans.factory.FactoryBean;

/**
 * @ClassName MyFactoryBean
 * @Description 工厂对象(返回)
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 20:09
 * @Version 1.0
 */

public class MyFactoryBean implements FactoryBean<User> {
    @Override
    public User getObject() throws Exception {
        return new User();
    }

    @Override
    public Class<?> getObjectType() {
        return User.class;
    }
}

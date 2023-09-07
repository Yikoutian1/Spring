package com.hang.spring.ioc.connect;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @ClassName testConnect
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/7 007 19:01
 * @Version 1.0
 */

public class testConnect {
    @Test
    public void testConnect1() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/calyee_blog?characterEncoding=utf-8&serverTimezone=Asia/Shanghai");
        dataSource.setUsername("root");
        dataSource.setPassword("1qiulihang");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
    }

    /**
     * 引入外部文件注入
     */
    @Test
    public void testConnect2() {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("bean-jdbc.xml");
        DruidDataSource bean = context.getBean(DruidDataSource.class);
        System.out.println(bean.getUrl());
    }
}

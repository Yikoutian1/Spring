package com.hang.work.config;


import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * @ClassName JdbcConfig
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 20:11
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.hang.work")
public class JdbcConfig {
    private String user = "root";
    private String password = "1qiulihang";
    private String url = "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false";
    private String driver = "com.mysql.cj.jdbc.Driver";

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource =
                new DriverManagerDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setPassword(password);
        dataSource.setUsername(user);
        return dataSource;
    }

    // 方式一
    @Autowired
    private DataSource dataSource;

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }
// 方式二
//    @Bean
//    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
//        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
//        return jdbcTemplate;
//    }

}

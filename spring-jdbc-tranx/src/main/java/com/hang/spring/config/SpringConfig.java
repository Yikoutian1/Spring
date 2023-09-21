package com.hang.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @ClassName SpringConfig
 * @Description 基于注解的声明式事务
 * @Author QiuLiHang
 * @DATE 2023/9/20 020 18:40
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.hang.spring")
@EnableTransactionManagement // 开启事物管理
public class SpringConfig {
    // 替代数据连接池xml的配置
    @Bean
    public DataSource getDataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("1qiulihang");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false");
        return druidDataSource;
    }

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        return jdbcTemplate;
    }

    @Bean
    public DataSourceTransactionManager getDataSourceTransactionManager(DataSource dataSource) {
        DataSourceTransactionManager dataSourceTransactionManager =
                new DataSourceTransactionManager(dataSource);
        return dataSourceTransactionManager;
    }
}

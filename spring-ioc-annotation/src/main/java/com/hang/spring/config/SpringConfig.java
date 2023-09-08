package com.hang.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName SpringConfig
 * @Description 配置类
 * @Author QiuLiHang
 * @DATE 2023/9/8 008 10:37
 * @Version 1.0
 */
@Configuration
@ComponentScan("com.hang.spring.autowired") // 开启组件扫描
public class SpringConfig {

}

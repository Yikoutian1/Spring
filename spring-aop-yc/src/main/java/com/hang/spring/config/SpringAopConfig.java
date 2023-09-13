package com.hang.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @ClassName SpringConfig
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/13 013 18:55
 * @Version 1.0
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.hang.spring")
public class SpringAopConfig {

}

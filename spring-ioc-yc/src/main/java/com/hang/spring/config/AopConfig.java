package com.hang.spring.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName AopConfig
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/16 016 19:40
 * @Version 1.0
 */
@Configuration //配置类==》beans.xml
@ComponentScan("com.hang.spring.aspect")
public class AopConfig {
}

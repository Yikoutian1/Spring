package com.hang.spring.config;


import com.hang.work.bbs.bean.User;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Repository;

@Configuration //配置类==》beans.xml
@ComponentScan("com.hang.work.bbs")
public class IocConfig {
    @Primary
    @Bean
    public User user() {
        User user = new User();
        user.setUname("武松");
        return user;
    }

    @Bean("user")
    //=><bean>
    public User user1() {
        User user = new User();
        user.setUname("武松");
        return user;
    }

    @Bean("user3") //=><bean>
    @Scope("prototype")
    public User user3() {
        User user = new User();
        user.setUname("武松");
        return user;
    }

}

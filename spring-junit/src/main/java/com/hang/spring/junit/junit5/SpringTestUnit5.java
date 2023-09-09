package com.hang.spring.junit.junit5;

import org.aspectj.lang.annotation.Aspect;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ClassName SpringTestUnit5
 * @Description junit config
 * @Author QiuLiHang
 * @DATE 2023/9/9 009 16:27
 * @Version 1.0
 */
// TODO 写法一 用的不多
//@ExtendWith(SpringExtension.class)
//@ContextConfiguration("classpath:bean.xml")
// TODO 写法二
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class SpringTestUnit5 {
    // 注入
    @Autowired
    private User user;

    // 测试方法 这样就不用写ApplicationContext了,直接对象注入
    @Test
    public void testUser() {
        System.out.println(user);
        user.run();
    }
}

package com.hang.spring.junit.junit4;

import com.hang.spring.junit.junit5.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

/**
 * @ClassName SpringTestJunit4
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/9 009 16:35
 * @Version 1.0
 */
//@RunWith(SpirngJUnit4ClassRunner.class)
@ContextConfiguration("classpath:bean.xml")
public class SpringTestJunit4 {
    @Autowired
    private User user;
    @Test // org.junit.Test
    public void testJunit4(){
        user.run();
    }
}

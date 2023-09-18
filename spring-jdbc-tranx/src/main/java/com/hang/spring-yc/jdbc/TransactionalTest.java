package com.hang.spring.jdbc;

import com.hang.spring.config.JdbcConfig;
import com.hang.spring.service.BankServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName TransactionalTest
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 21:01
 * @Version 1.0
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = JdbcConfig.class)

public class TransactionalTest {
    @Resource
    private BankServiceImpl bankServiceImpl;

    public static void main(String[] args) {
        ApplicationContext context =
                new AnnotationConfigApplicationContext(JdbcConfig.class);
        BankServiceImpl bean = context.getBean(BankServiceImpl.class);
        bean.deposit(123, 500d);
    }

    @Test
    @Transactional
    public void testTransactional() {
        System.out.println(bankServiceImpl);
        bankServiceImpl.deposit(123, 5000d);
    }
}

package com.hang.spring;

import com.hang.spring.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @ClassName TestBook
 * @Description 测试类
 * @Author QiuLiHang
 * @DATE 2023/9/18 018 19:19
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class TestBook {
    @Autowired
    private BookController bookController;

    @Test
    public void testBuyBook() {
        bookController.buyBook(1, 1);
    }
}

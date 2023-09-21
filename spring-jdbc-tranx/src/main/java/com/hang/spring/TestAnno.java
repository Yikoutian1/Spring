package com.hang.spring;

import com.hang.spring.config.SpringConfig;
import com.hang.spring.controller.BookController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName TestAnno
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/20 020 18:49
 * @Version 1.0
 */

public class TestAnno {
    @Test
    public void testTxAllAnnotation() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(SpringConfig.class);
        BookController accountService =
                applicationContext.getBean("bookController", BookController.class);
        Integer[] books = {1, 2};
        accountService.buyBooks(books, 1);
    }
}

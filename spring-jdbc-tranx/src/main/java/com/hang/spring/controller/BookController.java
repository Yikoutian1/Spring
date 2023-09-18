package com.hang.spring.controller;

import com.hang.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName BookController
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/18 018 19:06
 * @Version 1.0
 */
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    // 书的id:bookId    用户id: userId
    public void buyBook(Integer bookId, Integer userId) {
        // 调用service方法进行调用
        bookService.buyBook(bookId,userId);
    }
}

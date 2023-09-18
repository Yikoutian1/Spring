package com.hang.spring.service.impl;

import com.hang.spring.service.BookService;
import com.hang.spring.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName CheckoutServiceImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/18 018 20:56
 * @Version 1.0
 */
@Service
public class CheckoutServiceImpl implements CheckoutService {
    // 注入bookService
    @Autowired
    private BookService bookService;
    // 买多本书的方法
    @Override
    @Transactional()  // 此时bookServiceImpl也有事物
    public void checkout(Integer[] bookIds, Integer userId) {

    }
}

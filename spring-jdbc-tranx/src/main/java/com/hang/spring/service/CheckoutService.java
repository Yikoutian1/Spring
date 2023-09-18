package com.hang.spring.service;

/**
 * @ClassName CheckoutService
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/18 018 20:55
 * @Version 1.0
 */

public interface CheckoutService {
    /**
     * 买多本书的方法
     */
    void checkout(Integer[] bookIds, Integer userId);
}

package com.hang.spring.service.impl;

import com.hang.spring.dao.BookDao;
import com.hang.spring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName BookServiceImpl
 * @Description 业务逻辑
 * @Author QiuLiHang
 * @DATE 2023/9/18 018 19:04
 * @Version 1.0
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;

    @Override
    /*TODO
     * @Transactional里面可以添加的属性 描述:
     * 1. 只读: 只能查询,不能增改删
     * 2. 超时: 在设置的时间内没有完成动作,抛出异常回滚
     * 3. 回滚策略: 设置哪些一次不回滚
     * 4. 隔离级别: 读问题
     * {                                     脏读 不可重复读 幻读(x代表无,*代表有)
     *  1.Isolation.DEFAULT: 数据库默认隔离级别
     *  2.Isolation.READ_UNCOMMITTED: 读未提交      ***
     *  3.Isolation.READ_COMMITTED: 读已提交        x**
     *  4.Isolation.REPEATABLE_READ: 可重复读 (默认) xx*
     *  5.Isolation.SERIALIZABLE: 序列化            xxx
     * }
     * 5. 传播行为: 事务方法之间调用,事务如何使用(共有七种)
     */
    // @Transactional(readOnly = true) // 只读
    // Connection is read-only. Queries leading to data modification are not allowed
    // @Transactional(timeout = 2)     // 超时
    // Transaction timed out: deadline was Mon Sep 18 20:28:17 SGT 2023
    // @Transactional(noRollbackFor = ArithmeticException.class)// 不回滚
    // 出现ArithmeticException异常(1/0) 不进行回滚
    // @Transactional(isolation = Isolation.DEFAULT) // 隔离级别
    @Transactional(propagation = Propagation.REQUIRED)
    public void buyBook(Integer bookId, Integer userId) {
        // 模拟超时
//        try {
//            TimeUnit.SECONDS.sleep(4);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        // 根据图书id查询图书的价格
        Integer price = bookDao.getBookPriceByBookId(bookId);
        // 更新图书表的库存量 -1
        bookDao.updateBookStock(bookId);
        // 更新用户表的余额 -图书的价格
        bookDao.updateUserBalance(userId, price);
    }
}

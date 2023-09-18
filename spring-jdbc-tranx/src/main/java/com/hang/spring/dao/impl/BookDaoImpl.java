package com.hang.spring.dao.impl;

import com.hang.spring.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @ClassName BookDaoImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/18 018 19:05
 * @Version 1.0
 */
@Service
public class BookDaoImpl implements BookDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    /**
     * 根据书id查询书的价格
     *
     * @param bookId
     * @return
     */
    @Override
    public Integer getBookPriceByBookId(Integer bookId) {
        String sql = "select price from t_book where book_id = ?";
        Integer price = jdbcTemplate.queryForObject(sql, Integer.class, bookId);
        return price;
    }

    /**
     * 更新库存
     *
     * @param bookId
     */
    @Override
    public void updateBookStock(Integer bookId) {
        String sql = "update t_book set stock = stock - 1 where book_id = ?";
        jdbcTemplate.update(sql, bookId);
    }

    /**
     * 更新用户的余额
     *
     * @param userId
     * @param price
     */
    @Override
    public void updateUserBalance(Integer userId, Integer price) {
        String sql = "update t_user set balance = balance - ? where user_id = ?";
        jdbcTemplate.update(sql, price, userId);
    }
}

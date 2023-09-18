package com.hang.spring.dao;

public interface BookDao {
    Integer getBookPriceByBookId(Integer bookId);

    void updateBookStock(Integer bookId);

    void updateUserBalance(Integer userId, Integer price);
}

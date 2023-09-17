package com.hang.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AccountDao
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 20:53
 * @Version 1.0
 */
@Repository
public class AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void addMoney(Integer id, Double money) {
        String sql = "update test.bank_account set balance = balance+ ? where id = ?";
        jdbcTemplate.update(sql, money, id);
    }
}

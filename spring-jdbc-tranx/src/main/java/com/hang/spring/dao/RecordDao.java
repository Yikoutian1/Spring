package com.hang.spring.dao;

import com.hang.spring.dto.AccountDto;
import com.hang.spring.entity.BankAccount;
import com.hang.spring.entity.BankOprecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ClassName RecordDao
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 20:20
 * @Version 1.0
 */
@Repository
public class RecordDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int insert(Integer id, Double money) {
        String sql = "insert into bank_oprecord(aid,opmoney) value (?,?)";
        return jdbcTemplate.update(sql, id, money);
    }

    public List<BankOprecord> selectById(int aid) {
        String sql = "select * from bank_oprecord where aid = ?";
        return jdbcTemplate.query(sql,
                new BeanPropertyRowMapper<>(BankOprecord.class),
                aid);
    }
}

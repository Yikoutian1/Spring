package com.hang.spring.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @ClassName JDBCTemplateTest
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/9 009 18:43
 * @Version 1.0
 */
@SpringJUnitConfig(locations = "classpath:bean.xml")
public class JDBCTemplateTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    // 添加 修改 删除
    @Test
    public void testUpdate() {
        // 1. 添加
        // 第一步 写sql
        String sql = "INSERT INTO spring VALUES(null,?,?,?)";
        // 第二步 调用jdbc方法，传入参数
//        Object[] params = {"阿哈", 18, "未知"};
//        int update = jdbcTemplate.update(sql, params);
//        if (update > 0) {
//            System.out.println("执行成功");
//        } else {
//            System.out.println("执行失败");
//        }
        // 2. 修改 删除 都一样 . . . . . .
        // 3. 查询
        // 返回单个对象写法
        String select = "select * from spring";
//        Spring springs = jdbcTemplate.queryForObject(select,
//                new BeanPropertyRowMapper<>(Spring.class),
//                1 // id
//        );
        // 返回list
        List<Spring> query = jdbcTemplate.query(select, new BeanPropertyRowMapper<>(Spring.class));
        for (Spring spring : query) {
            System.out.println("spring = " + spring);
        }
    }
}

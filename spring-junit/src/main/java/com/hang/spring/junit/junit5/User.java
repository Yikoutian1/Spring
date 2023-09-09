package com.hang.spring.junit.junit5;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @ClassName User
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/9 009 16:26
 * @Version 1.0
 */
@Component
public class User {
    public void run() {
        System.out.println("====run====");
    }
}

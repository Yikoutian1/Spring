package com.hang.spring.test;

import com.hang.spring.bean.AopApplicationContext;
import com.hang.spring.config.AopConfig;
import com.hang.spring.config.IocConfig;
import org.junit.jupiter.api.Test;

/**
 * @ClassName test
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/16 016 19:37
 * @Version 1.0
 */

public class test {
    public static void main(String[] args) throws Exception {
        AopApplicationContext context1 =
                new AopApplicationContext(AopConfig.class);
    }
}

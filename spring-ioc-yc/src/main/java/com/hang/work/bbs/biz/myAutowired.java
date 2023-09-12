package com.hang.work.bbs.biz;

import com.hang.spring.anotation.autowired;
import com.hang.spring.anotation.qualifier;
import org.springframework.stereotype.Service;

/**
 * @ClassName myAutowired
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/12 012 19:37
 * @Version 1.0
 */
@Service
public class myAutowired {
    @autowired
    private UserBiz userBiz1;

    @autowired
    @qualifier("userBiz2321321")
    private UserBiz userBiz;

}

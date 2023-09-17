package com.hang.spring.service;

import com.hang.spring.dao.AccountDao;
import com.hang.spring.dao.RecordDao;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

/**
 * @ClassName BankServiceImpl
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 21:20
 * @Version 1.0
 */

@Service
public class BankServiceImpl implements BankService {
    @Resource
    private RecordDao recordDao;
    @Resource
    private AccountDao accountDao;
    public void deposit(Integer id,Double money){
        // 存款
        accountDao.addMoney(id,money);
        // 明细
        recordDao.insert(id,money);

    }
}

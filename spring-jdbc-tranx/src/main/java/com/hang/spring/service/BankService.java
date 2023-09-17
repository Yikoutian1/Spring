package com.hang.spring.service;

import com.hang.spring.dao.AccountDao;
import com.hang.spring.dao.RecordDao;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName BankService
 * @Description TODO
 * @Author QiuLiHang
 * @DATE 2023/9/17 017 20:50
 * @Version 1.0
 */
public interface BankService {
    public void deposit(Integer id,Double money);
}

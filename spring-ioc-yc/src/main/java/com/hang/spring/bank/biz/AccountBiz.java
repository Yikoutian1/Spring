package com.hang.spring.bank.biz;

import com.hang.spring.bank.bean.Account;

public interface AccountBiz {
	
	void register(Account account);
	
	void diposit(Integer id, double money);

}

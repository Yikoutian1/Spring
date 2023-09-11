package com.hang.work.bank.biz;

import com.hang.work.bank.bean.Account;

public interface AccountBiz {
	
	void register(Account account);
	
	void diposit(Integer id, double money);

}

package com.hang.work.bank.biz.impl;

import com.hang.work.bank.bean.Account;
import com.hang.work.bank.bean.Record;
import com.hang.work.bank.biz.AccountBiz;
import com.hang.work.bank.dao.AccountDao;
import com.hang.work.bank.dao.RecordDao;
import org.springframework.stereotype.Service;

@Service
public class AccountBizImpl implements AccountBiz {
	/**
	 * 账号dao
	 */
	//@Autowired
	private AccountDao accountDao;
	
	/**
	 * 流水记录Dao
	 */
	//@Autowired 
	private RecordDao recordDao;
	
	@Override
	public void register(Account account) {
		accountDao.insert(account);
	}

	/**
	 * 存钱的业务方法，
	 */
	@Override
	public void diposit(Integer id, double money) {
		Record rec = new Record();
		rec.setAccountId(id);
		rec.setMoney(money);
		recordDao.insert(rec);
		Account acc = new Account();
		acc.setId(id);
		acc.setMoney(money);
		accountDao.update(acc);
		/**
		 * 思考:以上代码有什么问题?
		 */
	}

	public AccountDao getAccountDao() {
		return accountDao;
	}

	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public RecordDao getRecordDao() {
		return recordDao;
	}

	public void setRecordDao(RecordDao recordDao) {
		this.recordDao = recordDao;
	}
	
	public Account create() {
		return Account.getInstance();
	}

	int count;
	public Account create1() {
		return count++ < 3 ? new Account() : Account.getInstance();
	}

}

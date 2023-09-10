package com.hang.spring.bbs.biz;

import com.hang.spring.bbs.bean.User;
import com.hang.spring.bbs.dao.UserDao;

public class UserBiz {

	private UserDao uDao;

	public void create(User user) {
		uDao.insert(user);
	}

	public void modify(User user) {
		uDao.update(user);
	}

	public void remove(User user) {
		uDao.delete(user);
	}

}

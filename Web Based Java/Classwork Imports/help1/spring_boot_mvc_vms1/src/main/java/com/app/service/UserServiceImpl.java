package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service//Mandatory : to tell SC : spring bean , containing B.L methods
@Transactional//Mandatory : to tell SC --to manage the DB txs automatically , using spring supplied
//o.s.orm.hibernate5.HibernateTransactionManager
public class UserServiceImpl implements IUserService {
	//dependency : DAO layer i/f
	@Autowired
	private IUserDao userDao;

	@Override
	public User authenticateUser(String email, String pwd) {
		// TODO Auto-generated method stub
		return userDao.authenticateUser(email, pwd);
	}

}

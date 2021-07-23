package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service // to tell class holds B.L
@Transactional
public class UserServiceImpl implements IUserService {
	//dependency : Dao i/f
	@Autowired
	private IUserDao userDao;
	

	@Override
	public User validateUser(String email, String password) {
		System.out.println("in service : "+email+" "+password);
		// invoke dao's method
		return userDao.validateUser(email, password);
	}

}

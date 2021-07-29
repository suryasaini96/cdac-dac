package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	//for any user authentication (can be admin or vendor)
	User authenticateUser(String email, String pwd);
}

package com.app.dao;

import com.app.pojos.User;

public interface IUserDao {
	//add a method for user login
	User validateUser(String email,String password);

}

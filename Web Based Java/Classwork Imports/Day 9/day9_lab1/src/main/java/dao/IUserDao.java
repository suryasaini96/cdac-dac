package dao;

import pojos.User;

public interface IUserDao {
//add user details
	String addUserDetails(User user);
	//fetch user details by PK(id)
	User findByUserId(int userId);
}

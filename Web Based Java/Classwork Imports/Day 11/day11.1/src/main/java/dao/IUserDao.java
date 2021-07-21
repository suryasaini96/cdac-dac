package dao;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import pojos.Role;
import pojos.User;

public interface IUserDao {
	String saveUserDetails(User user);// user : exists ONLY in heap : TRANSIENT(not yet persistent)

	String saveUserDetailsWithCurntSession(User user);// user : exists ONLY in heap : TRANSIENT(not yet persistent)
	// get user details by PK

	User getUserDetails(int userId);

	// get all users
	List<User> getAllUsers();

	// get selected users by date n role
	List<User> getSelectedUsers(LocalDate begin, LocalDate end, Role userRole);

	// get selected users' names by date n role
	List<String> getSelectedUserNames(LocalDate begin, LocalDate end, Role userRole);

	// get selected users' details by date n role : constr expression
	List<User> getSelectedUserDetails(LocalDate begin, LocalDate end, Role userRole);
	// chage user's password
	String changePassword(int userId,String newPassword);
	//apply discount
	String applyDiscount(LocalDate date,double discountAmount);
	//delete user details
	String deleteUserDetails(int userId);
	//save image(bin contents) in to the DB
	String saveImage(String email,String filePath) ;
	//restore image from DB
	String restoreImage(int userId,String filePath) ;
}

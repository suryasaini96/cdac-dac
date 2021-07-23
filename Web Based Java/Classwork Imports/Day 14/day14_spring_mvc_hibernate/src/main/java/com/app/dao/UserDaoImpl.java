package com.app.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository // to tell SC : class contains data access logic
public class UserDaoImpl implements IUserDao {
	// Dependency : SessionFactory
	@Autowired
	private SessionFactory sf;

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email = :em and u.password=:pass";
		return sf.getCurrentSession().createQuery(jpql, User.class).setParameter("em", email)
				.setParameter("pass", password).getSingleResult();
	}

}

package com.app.dao;

import javax.persistence.EntityManager;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.User;

@Repository // Mandatory : To tell SC whatever follows is a spring bean containing Data
			// access logic
//Enable exc translation mechanism(transalation of checked sql excs ---> un chked spring data access excs)
public class UserDaoImpl implements IUserDao {
	// dependency : javax.persistence.EntityManager => super i/f of org.hibernate.Session
	@Autowired // autowire=byType
	private EntityManager mgr;

	@Override
	public User authenticateUser(String email, String pwd) {
		System.out.println("mgr "+mgr);
		String jpql = "select u from User u where u.email=:em and u.password=:pass";

		return mgr.createQuery(jpql, User.class).
				setParameter("em", email).setParameter("pass", pwd)
				.getSingleResult();
	}

}

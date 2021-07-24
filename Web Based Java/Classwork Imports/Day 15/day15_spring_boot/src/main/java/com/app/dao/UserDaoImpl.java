package com.app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.*;

import com.app.pojos.Role;
import com.app.pojos.User;

@Repository // to tell SC : class contains data access logic
public class UserDaoImpl implements IUserDao {
	// Dependency : javax.persistence.EntityManager (super i/f of
	// org.hibenrate.Session)
	@Autowired
	private EntityManager manager;

	@Override
	public User validateUser(String email, String password) {
		String jpql = "select u from User u where u.email = :em and u.password=:pass";
		return manager.createQuery(jpql, User.class).setParameter("em", email).setParameter("pass", password)
				.getSingleResult();
	}

	@Override
	public List<User> getAllVendors() {
		String jpql = "select u from User u where u.userRole=:role";
		return manager.createQuery(jpql, User.class).setParameter("role", Role.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(User vendor) {
		String mesg="Vendor details removed with VID "+vendor.getId();
		manager.remove(vendor);
		return mesg;
	}

	@Override
	public User findByUserId(int userId) {
		// TODO Auto-generated method stub
		return manager.find(User.class, userId);
	}

	@Override
	public String registerVendor(User vendor) {		
		manager.persist(vendor);
		return "Vendor registered successfully with ID ="+vendor.getId();
	}
	
	

}

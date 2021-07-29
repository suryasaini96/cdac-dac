package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Role;
import com.app.pojos.User;

@Repository
public class VendorDaoImpl implements IVendorDao {
	// dependency : JPA' s EntityManager
	@Autowired // OR
//@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<User> listVendors() {
		String jpql = "select u from User u where u.role=:rl";
		return mgr.createQuery(jpql, User.class).setParameter("rl", Role.VENDOR).getResultList();
	}

	@Override
	public String deleteVendorDetails(User user) {
		mgr.remove(user);
		return "Vendor " + user.getName() + " 's details deleted ....";
	}

	@Override
	public User getVendorDetails(int vendorId) {
		return mgr.find(User.class, vendorId);
	}

	@Override
	public String registerNewVendor(User user) {
		mgr.persist(user);
		return "Vendor reged successfully with ID " + user.getId();
	}

	@Override
	public String updateVendorDetails(User user) {
		User persistentUser = mgr.merge(user);
		return "Vendor Details updated for Vendor ID="+persistentUser.getId();
	}

}

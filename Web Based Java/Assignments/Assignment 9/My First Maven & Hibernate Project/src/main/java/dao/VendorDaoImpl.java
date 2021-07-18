package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Vendor;
import static utils.HibernateUtils.*;

public class VendorDaoImpl implements IVendorDao {
	
	@Override
	public String addVendorDetails(Vendor v) {
		String msg = "Adding vendor details failed.";
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			Serializable id = session.save(v);
			System.out.println("Adding vendor id: " + id);
			tx.commit();
			msg = "New vendor added with id: " + id;
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		} finally {
			if(session != null)
				session.close();
		}
		return msg;
	}

	@Override
	public Vendor vendorDetails(long vendorId) {
		Vendor vendor;
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();	
		try {
			vendor = session.get(Vendor.class, vendorId);
			tx.commit();
		} catch(RuntimeException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		} finally {
			if (session!=null)
				session.clear();
		}
		return vendor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vendor> allVendorDetails() {
		List<Vendor> vendorList;
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();
		try {
			vendorList = session.createQuery("from Vendor").list();
		} catch(RuntimeException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		} finally {
			if (session!=null)
				session.clear();
		}
		return vendorList;
	}

	@Override
	public void updateRegAmount(double regAmount) {

	}
}

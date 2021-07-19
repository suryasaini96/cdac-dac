package dao;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.NoResultException;

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
	public Vendor vendorDetailsByID(long vendorId) {
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
			vendorList = session.createQuery("select v from Vendor v").list();
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
	public String updateRegAmount(String email, double regAmountOffset) {
		String msg = "Updating registration amount failed.";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();	
		try {
			Vendor v = (Vendor)session.createQuery("select v from Vendor v where v.email=:email").setParameter("email", email).getSingleResult();
			if (v!=null) {
				v.setRegAmount(v.getRegAmount() + regAmountOffset);
				msg = "Registration amount successfully updated.";
			}
			tx.commit();
		} catch (NoResultException e) {
			if (tx!=null)
				tx.rollback();
		} catch(RuntimeException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}

	@Override
	public Vendor vendorLogin(String email, String password) {
		Vendor v;
		String jpql = "select v from Vendor v where v.email=:email and v.password=:password";
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();	
		try {
			v = (Vendor)session.createQuery(jpql).setParameter("email", email).setParameter("password", password).getSingleResult();
			tx.commit();
		} catch (NoResultException e) {
			if (tx!=null)
				tx.rollback();
			return null;
		} catch(RuntimeException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		} finally {
			if (session!=null)
				session.clear();
		}
		return v;
	}

	@Override
	public String deleteVendorDetails(double regAmount, LocalDate regDate) {
		String jpql = "delete from Vendor v where v.regDate > :regDate and v.regAmount < :regAmount";
		String msg = "Deletion failed.";
		Session session = getFactory().openSession();
		Transaction tx = session.beginTransaction();	
		try {
			int n = session.createQuery(jpql).setParameter("regDate", regDate).setParameter("regAmount", regAmount).executeUpdate();
			if (n>0)
				msg = n + " Vendor details deleted successfully.";
			tx.commit();
		} catch(RuntimeException e) {
			if (tx!=null)
				tx.rollback();
			throw e;
		} finally {
			if (session!=null)
				session.clear();
		}
		return msg;
	}
}

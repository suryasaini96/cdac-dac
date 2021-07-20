package dao;

import pojos.Role;
import pojos.User;

import org.apache.commons.io.FileUtils;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class UserDaoImpl implements IUserDao {

	@Override
	public String saveUserDetails(User user) {
		String mesg = "reg failed";
		// user : TRANSIENT
		// get session from SF
		Session session = getSf().openSession();
		Session session2 = getSf().openSession();
		System.out.println(session == session2);// f
		// begin tx
		Transaction tx = session.beginTransaction();
		System.out.println("session is open " + session.isOpen() + " connected " + session.isConnected());// t t
		try {
			int id = (Integer) session.save(user);// user : PERSISTENT (it IS a prt of L1 cache BUT NOT YET part of DB)
			tx.commit();// Hibernate performs "auto dirty checking" @ commit : DML insert query
			System.out.println("session is open " + session.isOpen() + " connected " + session.isConnected());// t t
			mesg = "User registered successfully with ID " + id;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		} finally {
			if (session != null)
				session.close(); // pooled out DB cn rets to the cn pool & L1 cache is destoyed
		}
		// user : DETACHED (from L1 cache)
		System.out.println("session is open " + session.isOpen() + " connected " + session.isConnected());// f f
		return mesg;
	}

	@Override
	public String saveUserDetailsWithCurntSession(User user) {
		String mesg = "reg failed";
		// user : TRANSIENT
		// get session from SF
		Session session = getSf().getCurrentSession();
		Session session2 = getSf().getCurrentSession();
		System.out.println(session == session2);// true
		// begin tx
		Transaction tx = session.beginTransaction();
		System.out.println("session is open " + session.isOpen() + " connected " + session.isConnected());// t t
		try {
			int id = (Integer) session.save(user);// user : PERSISTENT (it IS a prt of L1 cache BUT NOT YET part of DB)
			tx.commit();// Hibernate performs "auto dirty checking" @ commit : DML insert query
			System.out.println("commit : session is open " + session.isOpen() + " connected " + session.isConnected());// f
																														// f
			mesg = "User registered successfully with ID " + id;
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			System.out
					.println("rollback  : session is open " + session.isOpen() + " connected " + session.isConnected());// f
																														// f

			throw e;
		}
		// user : DETACHED (from L1 cache)
		return mesg;
	}

	@Override
	public User getUserDetails(int userId) {
		User ref = null;// ref : state NA
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// valid id
			// L1 cache : empty
			ref = session.get(User.class, userId);// int --> Integer --->Serializable : select from users_tbl where
													// user_id=?
			// ref : PERSISTENT
			ref = session.get(User.class, userId);// int --> Integer --->Serializable : no select query
			ref = session.get(User.class, userId);// int --> Integer --->Serializable : : no select query
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return ref;// ref : DETACHED
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = null;
		String jpql = "select u from User u";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).getResultList();// users : list of PERSISTENT pojos
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;// users : list of DETACHED pojos
	}

	@Override
	public List<User> getSelectedUsers(LocalDate begin, LocalDate end1, Role userRole) {
		List<User> users = null;
		// select * from users_tbl ....
		String jpql = "select u from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", begin).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();// List of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<String> getSelectedUserNames(LocalDate begin, LocalDate end1, Role userRole) {
		List<String> users = null;
		// select * from users_tbl ....
		String jpql = "select u.name from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, String.class).setParameter("start", begin).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();// List of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;
	}

	@Override
	public List<User> getSelectedUserDetails(LocalDate begin, LocalDate end1, Role userRole) {
		List<User> users = null;
		// select * from users_tbl ....
		String jpql = "select new pojos.User(userId,  email,  regAmount,  regDate) from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();// empty cache
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users = session.createQuery(jpql, User.class).setParameter("start", begin).setParameter("end", end1)
					.setParameter("rl", userRole).getResultList();// List of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;// list of detached pojos to the caller.
	}

	@Override
	public String changePassword(int userId, String newPassword) {
		User user = null;
		String mesg = "changing password failed";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// fetch user details by id
			user = session.get(User.class, userId);// de serial : select fired
			if (user != null) {
				// user : PERSISTENT (i.e part of L1 cache AND exists in DB)
				user.setPassword(newPassword);// modifying the state of PERSISTENT pojo/entity
				mesg = "user's password changed...";
			}
			tx.commit();// auto dirty checking : DML : update
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		// user : DETACHED
		user.setPassword("9999999");// changing state of the detached POJO --DOES NOT result in to any changes in
									// the DB
		return mesg;
	}

	@Override
	public String applyDiscount(LocalDate date, double discountAmount) {
		String mesg = "applying discount failed";
		// bulk updation
		String jpql = "update User u set u.regAmount=u.regAmount-:disc where u.regDate < :dt";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			int updateCount = session.createQuery(jpql).setParameter("disc", discountAmount).setParameter("dt", date)
					.executeUpdate();
			tx.commit();
			mesg = "Applied discount to " + updateCount + " users....";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return mesg;
	}

	@Override
	public String deleteUserDetails(int userId) {
		String mesg = "user details deletion failed..";
		// get session
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// session.delete(persistent pojo ref)
			// get the persistent pojo ref : get
			User user = session.get(User.class, userId);
			if (user != null) {
				// user : PERSISTENT
				session.delete(user);// user : REMOVED (i.e simply marked for removal!)
				mesg = "user details deletion succeeded..";
			}
			tx.commit();// auto dirty checking -- delete query is fired -- session is closed (=> L1
						// cache is destroyed ,pooled out db cn rets to cn pool
			// user : TRANSIENT
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback(); // L1 cache
			// is destroyed n db conn rets to the pool , closing the session
			throw e;
		}
		return mesg;
	}

	@Override
	public String saveImage(String email, String filePath) {
		String mesg = "saving image failed";
		String jpql = "select u from User u where u.email=:em";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// chk if user exists by email
			User user = session.createQuery(jpql, User.class).setParameter("em", email).getSingleResult();
			// user : persistent
			// validate file
			File file = new File(filePath);
			if (file.exists() && file.isFile() && file.canRead()) {
				// existing readable data file
				// invoke the setter : setImage
				user.setImage(FileUtils.readFileToByteArray(file));
				mesg = "saving image succeeded!";
			}
			tx.commit();// auto dirty chking ---update
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e.getMessage(), e);
		}
		return mesg;
	}

	@Override
	public String restoreImage(int userId, String filePath) {
		String mesg = "restoring image failed";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get persistent user from DB
			User user = session.get(User.class, userId);
			if (user != null) {
				// user : persistent (valid userid)
				/*
				 * public static void writeByteArrayToFile(File file, byte[] data) throws
				 * IOException Writes a byte array to a file creating the file if it does not
				 * exist.
				 */
				FileUtils.writeByteArrayToFile(new File(filePath),user.getImage());
				mesg="restoring image succeeded!";
			}
			tx.commit();
		} catch (Exception e) {
			if (tx != null)
				tx.rollback();
			throw new RuntimeException(e.getMessage(), e);
		}
		return mesg;
	}

}

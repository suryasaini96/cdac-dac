package dao;

import pojos.Role;
import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getSf;

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
		List<User> users=null;
		//select * from users_tbl ....
		String jpql="select u from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users=session.createQuery(jpql,User.class).
					setParameter("start", begin).setParameter("end", end1).
					setParameter("rl", userRole).getResultList();//List of PERSISTENT entities
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
		List<String> users=null;
		//select * from users_tbl ....
		String jpql="select u.name from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users=session.createQuery(jpql,String.class).
					setParameter("start", begin).setParameter("end", end1).
					setParameter("rl", userRole).getResultList();//List of PERSISTENT entities
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
		List<User> users=null;
		//select * from users_tbl ....
		String jpql="select new pojos.User(userId,  email,  regAmount,  regDate) from User u where u.regDate between :start and :end and u.role=:rl";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			users=session.createQuery(jpql,User.class).
					setParameter("start", begin).setParameter("end", end1).
					setParameter("rl", userRole).getResultList();//List of PERSISTENT entities
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return users;//list of detached pojos to the caller.
	}



}

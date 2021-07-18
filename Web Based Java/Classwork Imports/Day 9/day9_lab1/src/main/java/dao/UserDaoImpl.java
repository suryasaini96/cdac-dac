package dao;

import pojos.User;
import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.io.Serializable;


public class UserDaoImpl implements IUserDao {
	//NO state (instance vars)
	//no constr , no cleanup !

	@Override
	public String addUserDetails(User user) {
		String mesg="adding user details failed....";
		// get session from SF
		Session session=getFactory().openSession();//opens a NEW session(L1 cache : EMPTY)
		//begin tx
		Transaction tx=session.beginTransaction();
		try {
			//CRUD API 
			Serializable id=session.save(user);//adds the ref of the transient pojo into L1 cache; : PERSISTENT
			System.out.println("id "+id);
			tx.commit();//insertion of the rec
			mesg="new user details added with id="+id;
		}catch (RuntimeException e) {
			//failed!
			if(tx != null)
				tx.rollback();
			throw e;
		} finally {
			//close session
			if(session != null)
				session.close();//releases DB cn to the cn pool AND L1 cache is destroyed
		}
		
		return mesg;
	}

	@Override
	public User findByUserId(int userId) {
		User user=null;
		// get session from SF
		Session session=getFactory().openSession();//opens a NEW session(L1 cache : EMPTY)
		//begin tx
		Transaction tx=session.beginTransaction();
		try {
		//CRUD 
			user=session.get(User.class,userId);//int --->Integer ---> Serializable
			tx.commit();//insertion of the rec
			
		}catch (RuntimeException e) {
			//failed!
			if(tx != null)
				tx.rollback();
			throw e;
		} finally {
			//close session
			if(session != null)
				session.close();//releases DB cn to the cn pool AND L1 cache is destroyed
		}
	
		return user;
	}
	

}

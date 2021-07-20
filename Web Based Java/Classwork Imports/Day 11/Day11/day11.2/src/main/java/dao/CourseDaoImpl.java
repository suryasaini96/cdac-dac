package dao;

import static utils.HibernateUtils.getSf;
import org.hibernate.*;
import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String addNewCourse(Course course) {
		String mesg="course launching failed";
		// get session from SF
		Session session=getSf().getCurrentSession();
		//begin tx
		Transaction tx=session.beginTransaction();
		try {
			//course : transient (save/persist/saveOrUpdate/merge)
			session.persist(course);
			tx.commit();
			mesg="Course launched with ID "+course.getId();
		}catch (RuntimeException e) {
			if(tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

}

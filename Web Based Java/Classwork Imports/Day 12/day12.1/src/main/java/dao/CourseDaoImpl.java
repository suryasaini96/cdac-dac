package dao;

import static utils.HibernateUtils.getSf;
import org.hibernate.*;
import pojos.Course;

public class CourseDaoImpl implements ICourseDao {

	@Override
	public String addNewCourse(Course course) {
		String mesg = "course launching failed";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// course : transient (save/persist/saveOrUpdate/merge)
			session.persist(course);
			tx.commit();
			mesg = "Course launched with ID " + course.getId();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public String cancelCourse(int courseId) {
		String mesg = "course cancellation failed";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			// get course details from courseId
			Course course = session.get(Course.class, courseId);
			if (course != null) {
				// course : PERSISTENT
				session.delete(course);// course : REMOVED
				mesg = "course " + course.getTitle() + " cancelled!!!!";
			}
			tx.commit();// course : transient
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return mesg;
	}

	@Override
	public Course getCourseDetails(String title) {
		Course course = null;
		String jpql = "select c from Course c where c.title =:title";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			course = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();

			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return course;
	}

	@Override
	public Course getCourseStudentDetails(String title) {
		Course course = null;
		String jpql = "select c from Course c where c.title =:title";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			course = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();
			// course : persistent
			course.getStudents().size();// simply access the size of the collection in the persistent state
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return course;
	}

	@Override
	public Course getCourseStudentDetailsJoinQuery(String title) {
		Course course = null;
		String jpql = "select c from Course c left outer join fetch c.students where c.title =:title";
		// get session from SF
		Session session = getSf().getCurrentSession();
		// begin tx
		Transaction tx = session.beginTransaction();
		try {
			course = session.createQuery(jpql, Course.class).setParameter("title", title).getSingleResult();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			throw e;
		}
		return course;
	}

}

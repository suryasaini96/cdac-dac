package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import static utils.DBUtils.*;

import java.sql.SQLException;

/**
 * Application Lifecycle Listener implementation class DBConnectionMgr
 *
 */
@WebListener
public class DBConnectionMgr implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	public DBConnectionMgr() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("in ctx destroyed....");
		// close conn
		try {
			closeConnection();
		} catch (SQLException e) {
			System.out.println("err in ctx destroyed "+e);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("in ctx inited");
		// get ServletContext from event object
		ServletContext ctx = sce.getServletContext();
		try {
			// open connection
			openConnection(ctx.getInitParameter("drvr"), ctx.getInitParameter("db_url"),
					ctx.getInitParameter("user_name"), ctx.getInitParameter("pwd"));
		} catch (Exception e) {
			System.out.println("err in ctx-init " + e);
		}
	}

}

package pages;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDaoImpl;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns ="/authenticate",loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
		System.out.println("in init of "+getClass().getName());
		//instantiate dao ---getConn ---establish db conn
		customerDao=new CustomerDaoImpl();
		} catch (Exception e) {
			//re throw the exception to WC , by wrapping it in ServletException instance
			//ServletException(String mesg,Throwable cause)
			//centralized exc handling in servlets
			throw new ServletException("err in init of "+getClass().getName(),e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
		customerDao.cleanUp();
		DBUtils.closeConnection();
		} catch (Exception e) {
		//	System.out.println("err in destroy "+e);
			throw new RuntimeException("err in destory", e);//understanding purpose!!!!
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

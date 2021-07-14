package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CustomerDaoImpl;
import pojos.Customer;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerDaoImpl customerDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			System.out.println("in init of " + getClass().getName());
			// instantiate dao ---getConn ---establish db conn
			customerDao = new CustomerDaoImpl();
		} catch (Exception e) {
			// re throw the exception to WC , by wrapping it in ServletException instance
			// ServletException(String mesg,Throwable cause)
			// centralized exc handling in servlets
			throw new ServletException("err in init of " + getClass().getName(), e);

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
			// System.out.println("err in destroy "+e);
			throw new RuntimeException("err in destory", e);// understanding purpose!!!!
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in do-post of " + getClass().getName());
		// set resp cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// read request params
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// invoke dao's method for customer auth.
			Customer customer = customerDao.authenticateCustomer(email, password);
			if (customer == null) {
				pw.print("<h5>Invalid Login </h5>");
				pw.print("<h5>Please <a href='login.html'>Retry</a></h5>");
			} else {
				pw.print("customer login success : from 1st page");
				pw.flush();// committing the resp
//				//success
				// what's min scope of attributes in Server Pull : request
				// how to add aunthenticated user details in a suitable min scope ?
				// API : Method of ServletRequest : public void setAttribute(String
				// attName,Object attrValue)
				request.setAttribute("user_details", customer);
				// 1st step in Request dispatching ?
				// create RD object to wrap next resourse (servlet)
				RequestDispatcher rd = request.getRequestDispatcher("category");
				// Forward the clnt to the next page in the SAME request
				// Method of RD : public void include(ServletRequest rq,ServletResponse rs)
				// throws SE,IOExc
				rd.include(request, response);
				// WC suspends exec of curnt method ---clrs PW's buffer --invokes doPost on
				// CategoryServlet
				System.out.println("came back....");
				pw.print("contents after include.....");
			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}

}

package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Voter;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/authenticate", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private VoterDaoImpl voterDao;
	private CandidateDaoImpl candidateDao;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		try {
			System.out.println("in init of " + getClass().getName());
			// instantiate voter n candidate daos
			voterDao = new VoterDaoImpl();
			candidateDao = new CandidateDaoImpl();

		} catch (Exception e) {
			// centralized exc handling in servlets
			throw new ServletException("err in init of " + getClass().getName(), e);

		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			voterDao.cleanUp();
			candidateDao.cleanUp();
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
		// set resp cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// read request params
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// invoke dao's method for customer auth.
			Voter user = voterDao.authenticateVoter(email, password);
			if (user == null) {
				pw.print("<h5>Invalid Login </h5>");
				pw.print("<h5>Please <a href='login.html'>Retry</a></h5>");
			} else {
				// successful login
				// get HttpSession object from WC
				HttpSession session = request.getSession();
				// store validated user details(could be voter or admin : does NOT matter) under
				// session scope
				session.setAttribute("user_details", user);
				session.setAttribute("voter_dao", voterDao);
				session.setAttribute("candidate_dao", candidateDao);
				// chk the role
				if (user.getRole().equals("admin")) // admin user
					response.sendRedirect("admin_page");
				else if (user.isStatus())
					response.sendRedirect("status"); // voter user : who has already voted
				else
					response.sendRedirect("candidate_list");// voter user : who has not yet voted

			}

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}

}

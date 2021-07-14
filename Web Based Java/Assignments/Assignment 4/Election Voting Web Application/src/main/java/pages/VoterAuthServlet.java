package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.ICandidateDao;
import dao.IVoterDao;
import dao.VoterDaoImpl;
import pojos.Voter;
import utils.DBUtils;

/**
 * Servlet implementation class VoterAuthServlet
 */
@WebServlet(urlPatterns="/voter_validate",loadOnStartup=1)
public class VoterAuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVoterDao voterDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VoterAuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init() throws ServletException {
		try {
			voterDao = new VoterDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("Error in init() of " + getClass().getName());
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		try {
			voterDao.cleanUp();
			DBUtils.closeConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error in destroy() of " + getClass().getName());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			Voter voter = voterDao.authenticateVoter(email, password);
			if(voter == null) {
				pw.print("<h5>Invalid Login</h5>");
				pw.print("<h5>Please <a href='login.html'>Retry</a></h5>");
			} else {
				HttpSession session = request.getSession();
				session.setAttribute("voter_details", voter);
				if (voter.getRole().equals("voter")) {
					if (voter.getStatus() == 1)
						response.sendRedirect("status");
					else if (voter.getStatus() == 0)
						response.sendRedirect("candidateList");
				} else if (voter.getRole().equals("admin"))
					response.sendRedirect("adminStatus");
			}
		} catch(SQLException e) {
			throw new ServletException("Error in doPost() of " + getClass().getName());
		}	
	}

}

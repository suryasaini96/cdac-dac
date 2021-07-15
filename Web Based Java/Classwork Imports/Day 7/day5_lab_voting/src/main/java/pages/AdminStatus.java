package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.VoterDaoImpl;
import pojos.Candidate;
import pojos.Voter;
import utils.DBUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = "/admin_page")
public class AdminStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set resp cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// get HttpSession
			HttpSession hs = request.getSession();
			// get admin details from session scope
			Voter user = (Voter) hs.getAttribute("user_details");
			if (user != null) {
				pw.print("<h5> Welcome " + user.getName() + "</h5>");
				// get candidate dao from session scope
				CandidateDaoImpl candidateDao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
				pw.print("<h5> Top 2 Candidates </h5>");
				candidateDao.getTop2Candidates()
						.forEach(c -> pw.print("<h5>" + c.getName() + "&nbsp;&nbsp;" + c.getParty() + "</h5>"));
				pw.print("<h5> Party wise votes </h5>");
				candidateDao.getVotesAnalysis().forEach((k, v) -> pw.print("<h5>" + k + "&nbsp;&nbsp;" + v + "</h5>"));

			} else
				pw.print("<h5> No Session Tracking!!!!!!!!</h5>");
			hs.invalidate();

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}

}

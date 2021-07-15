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
@WebServlet(urlPatterns = "/candidate_list")
public class CandidateListPage extends HttpServlet {
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
			// get user details(voter)
			Voter userDetails = (Voter) hs.getAttribute("user_details");
			// get candidate dao from HttpSession
			CandidateDaoImpl candidateDao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
			// invoke dao's method for getting candidate list
			List<Candidate> list = candidateDao.getAllCandidates();
			pw.print("<h5>Hello , " + userDetails.getName() + "</h5>");
			pw.print("<h5>Candidate List</h5>");
			// dyn form generation
			pw.print("<form action='status'>");
			for (Candidate c : list)
				pw.print("<input type='radio' name='cid' value=" + c.getCandidateId() + ">" + c.getName() + " "
						+ c.getParty() + "<br/>");
			pw.print("<input type='submit' value='Cast A Vote'>");
			pw.print("</form>");

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}

}

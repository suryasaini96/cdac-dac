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
@WebServlet(urlPatterns = "/status")
public class VoterStatus extends HttpServlet {
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
			if (userDetails != null) {
				// chk if voter has alrdy voted ?
				if (userDetails.isStatus())
					pw.print("<h5>You have already Voted !!!!!!!!!!!!!!!!!</h5>");
				else {
					// get candidate dao from HttpSession
					CandidateDaoImpl candidateDao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
					// get voter dao from HS
					VoterDaoImpl voterDao = (VoterDaoImpl) hs.getAttribute("voter_dao");

					// get candidate id form req params
					int candidateId = Integer.parseInt(request.getParameter("cid"));
					// update voting status
					pw.print(
							"<h5> Voting status :  " + voterDao.updateVotingStatus(userDetails.getVoterId()) + "</h5>");
					// incr votes
					pw.print("<h5>" + candidateDao.incrementVotes(candidateId) + "</h5>");
					pw.print("<h5>Thanks for Voting!</h5>");
				}
				pw.print("<h5>You have logged out...</h5>");
				hs.invalidate();
			} else
				pw.print("No session tracking....");

		} catch (Exception e) {
			throw new ServletException("err in do-post of " + getClass().getName(), e);
		}
	}

}

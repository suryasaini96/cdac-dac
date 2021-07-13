package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
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

/**
 * Servlet implementation class statusServlet
 */
@WebServlet("/status")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IVoterDao voterDao;
	private ICandidateDao candidateDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	try {
    		voterDao = new VoterDaoImpl();
    		candidateDao = new CandidateDaoImpl();
    	} catch (SQLException e) {
    		throw new ServletException("Error in init() of StatusServlet");
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()){
			HttpSession session = request.getSession();
			Voter v = (Voter)session.getAttribute("voter_details");
			int voterId = v.getId();
			// False: already voted. True: Casting new Vote
			if (voterDao.updateStatus(voterId)) { // Checks status then updates it
				int candidateId = Integer.parseInt(request.getParameter("candidate"));
				candidateDao.updateVotes(candidateId);
				pw.print("Vote casted!");
			} else
				pw.print("You have already voted!");
			session.invalidate();
		} catch (SQLException e) {
    		throw new ServletException("Error in doGet() of StatusServlet");
    	}
	}
}

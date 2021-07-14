package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CandidateDaoImpl;
import dao.ICandidateDao;
import pojos.Candidate;
import pojos.Voter;

/**
 * Servlet implementation class AdminStatusServlet
 */
@WebServlet("/adminStatus")
public class AdminStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ICandidateDao candidateDao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init() throws ServletException {
    	try {
    		candidateDao = new CandidateDaoImpl();
		} catch (SQLException e) {
			throw new ServletException("Error in init() of " + getClass().getName());
		}	
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw = response.getWriter()) {
			HttpSession session = request.getSession();
			List<Candidate> top2Candidates = candidateDao.top2Analysis();
			LinkedHashMap<String,Integer> partywiseAnalysis = candidateDao.partywiseAnalysis();
			Voter v = (Voter)session.getAttribute("voter_details");
			if (top2Candidates !=null && partywiseAnalysis!=null) {
				pw.print("<h3> Hello, " + v.getName() + ".</h3>");
				pw.print("<h3> Vote Analysis</h3>");
				pw.print("<h4> Top 2 Candidates </h4>");
				pw.print("<table border=1>");
				pw.print("<thead>");
				pw.print("<th>ID</th>");
				pw.print("<th>Name</th>");
				pw.print("<th>Party</th>");
				pw.print("<th>Votes</th>");
				pw.print("</thead>");
				pw.print("<tbody>");
				top2Candidates.forEach(c->{
					pw.print("<tr>");
					pw.print("<td>"+c.getId()+"</td>");
					pw.print("<td>"+c.getName()+"</td>");
					pw.print("<td>"+c.getParty()+"</td>");
					pw.print("<td>"+c.getVotes()+"</td>");
					pw.print("</tr>");
				});
				pw.print("</tbody>");
				pw.print("</table>");
				pw.print("<h4> Partywise Analysis </h4>");
				pw.print("<table border=1>");
				pw.print("<thead>");
				pw.print("<th>Party</th>");
				pw.print("<th>Votes</th>");
				pw.print("</thead>");
				pw.print("<tbody>");
				for(Map.Entry<String,Integer> entry: partywiseAnalysis.entrySet()){
					pw.print("<tr>");
					pw.print("<td>"+entry.getKey()+"</td>");
					pw.print("<td>"+entry.getValue()+"</td>");
					pw.print("</tr>");
				}
				pw.print("</tbody>");
				pw.print("</table>");
			} else
				pw.print("Candidates list is empty!");
		} catch (SQLException e) {
			throw new ServletException("Error in doGet() of adminStatus");
		}
	}

}

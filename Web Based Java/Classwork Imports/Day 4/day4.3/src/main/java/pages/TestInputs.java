package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestInputs
 */
@WebServlet("/test_input")
public class TestInputs extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//set cont type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			//read req data n generate dyn resp
			pw.print("<h5>Hello , "+request.getParameter("f1")+"</h5>");
			pw.print("<h5>Fav Colors  : "+Arrays.toString(request.getParameterValues("clr"))	+"</h5>");
			pw.print("<h5>Chosen browser  : "+request.getParameter("browser")+"</h5>");
			pw.print("<h5>Selected City   : "+request.getParameter("myselect")+"</h5>");
			pw.print("<h5>Desc :  "+request.getParameter("info")+"</h5>");
		}
		
	}

}

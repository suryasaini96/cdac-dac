package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet
 */

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	public void init() throws ServletException
	{
		System.out.println("in init of "+getClass().getName()+" invoked by "+getClass().getName());
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get of "+getClass().getName());
		//set resp cont type
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("Hello from xml tags deployed servlet @ "+LocalDateTime.now());
		}
	}

}

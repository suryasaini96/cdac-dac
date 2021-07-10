package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet(urlPatterns = "/test",loadOnStartup = 1)
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init : invoked by "+Thread.currentThread());
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy : invoked by "+Thread.currentThread());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in do-get 1234 by : "+Thread.currentThread());
		//set content type of the response
		//API of HttpServletResponse : public void setContentType(String type)
		response.setContentType("text/html");
		//Attach PW : tom send the resp from server ---> clnt
		//How to get PW ? 
		//API of HttpServletResponse : public PW getWriter()
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h4> Welcome to Servlet!!!! @ "+LocalDateTime.now()+"</h4>");
		}//WC : pw.close : committing /rendering the resp
	}

}

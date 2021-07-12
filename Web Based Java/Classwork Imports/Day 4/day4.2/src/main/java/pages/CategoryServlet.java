package pages;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>Successful Login </h5>");
			// HOw to read cookies from req header :
			// API of HttpServletRequest
			// public Cookie[] getCookies()
			Cookie[] cookies = request.getCookies();

			if (cookies != null) {
				// => cookies are available
				for (Cookie c : cookies)
					if (c.getName().equals("customer_details")) {
						// Objective : send autheticated user details to clnt .
						pw.print(
								"<h5>Customer Details retrived from a Cookie  " +c.getValue() + "</h5>");
						break;
					}
			} else // => no cookies rcvd from the clnt browser
				pw.print("<h5> No Cookies : Session Tracking Failed!!!!!!!!!!!</h5>");

		}
	}

}

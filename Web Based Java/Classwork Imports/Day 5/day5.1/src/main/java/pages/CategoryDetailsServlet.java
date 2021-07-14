package pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BookDaoImpl;
import pojos.Book;
import pojos.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/category_details")
public class CategoryDetailsServlet extends HttpServlet {
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
			// get HttpSession from WC
			HttpSession hs = request.getSession();
			System.out.println("from details page HS is new " + hs.isNew());// false
			System.out.println("session id " + hs.getId());// SAME session id for the same clnt
			// how to get session data ? : book dao
			BookDaoImpl dao = (BookDaoImpl) hs.getAttribute("book_dao");
			//get chosen category from request param
			String category=request.getParameter("chosen_category");
			if (dao != null) {
			
				// get book dao instance from session
				BookDaoImpl bookDao = (BookDaoImpl) hs.getAttribute("book_dao");
				// invoke dao's method : to get books  y the chosen category
				List<Book> books=bookDao.getBooksByCategory(category);
				// dyn form generation
				pw.print("<h4>Books from Category "+category+"</h4>");
				pw.print("<h5>");
				pw.print("<form action='add_to_cart'>");
				// checkboxes
				for(Book b : books)
					pw.print("<input type='checkbox' name='bookId' value="+b.getId()+">"+b+"<br/>");
				// submit btn
				pw.print("<br><input type='submit' value='Add To Cart'>");
				pw.print("</form>");
				pw.print("</h5>");

			} else // => no cookies rcvd from the clnt browser
				pw.print("<h5> No Cookies : Session Tracking Failed!!!!!!!!!!!</h5>");

		} catch (Exception e) {
			throw new ServletException("err in do-get of " + getClass().getName(), e);
		}
	}

}

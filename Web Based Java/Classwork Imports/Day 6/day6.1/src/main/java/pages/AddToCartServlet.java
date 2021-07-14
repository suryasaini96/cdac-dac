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
import pojos.Customer;

/**
 * Servlet implementation class CategoryServlet
 */
@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
			// get HttpSession from WC
			HttpSession hs = request.getSession();
			System.out.println("from add_to_cart page HS is new " + hs.isNew());// false
			System.out.println("session id "+hs.getId());//SAME session id for the same clnt
			//get selected books ids from req params
			String[] ids=request.getParameterValues("bookId");
			//get cart from session
			List<Integer> cart=(List<Integer>)hs.getAttribute("shopping_cart");
			if(cart != null)
			{
				//populate the cart with selected n parsed book ids
				for(String id : ids)
					cart.add(Integer.parseInt(id));
				//display cart
				System.out.println("cart "+cart);
			}
			
			else // => no cookies rcvd from the clnt browser
				System.out.println("No Cookies : Session Tracking Failed!!!!!!!!!!!");
			//redirect the clnt to category page in the NEXT request
			response.sendRedirect("category");

		
}

}

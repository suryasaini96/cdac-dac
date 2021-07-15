<%@page import="pojos.User"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!//JSP declaration block : used to add private members + used to override life cycle methods(jspInit/jspDestroy)
	HashMap<String, User> users;

	//override jspInit
	public void jspInit() {
		System.out.println("in jsp init..");
		//create map n populate sample data
		users = new HashMap<>();
		users.put("Rama", new User("Rama", "1234", 24));
		users.put("Raj", new User("Raj", "12345", 25));
		users.put("Riya", new User("Riya", "12346", 26));
	}%>
<body>
	<%
	String nm = request.getParameter("name");
	String password = request.getParameter("pass");
	User user = users.get(nm);
	if (user != null) {
		//name is valid
		if (user.getPassword().equals(password)) {
			//login successful
			//store user details in session scope
			session.setAttribute("user_details", user);
			//redirect
			response.sendRedirect("details.jsp");
		} else {
	%>
	<h5>
		Invalid Password , Please <a href="login.jsp">Retry</a>
	</h5>
	<%
	}
	} else {
	%>
	<h5>
		New User , Please <a href="register.jsp">Register</a>
	</h5>
	<%
	}
	%>



</body>
<%!public void jspDestroy() {
		System.out.println("in jsp destroy..");
	}%>
</html>
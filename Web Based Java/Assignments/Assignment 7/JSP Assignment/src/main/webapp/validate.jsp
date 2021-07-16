<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.HashMap" %>
<%@ page import="pojos.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%!
	HashMap<String, User> users;
	public void jspInit(){
		System.out.println("In jspInit..");
		users = new HashMap<>();
		users.put("Babu Rao", new User("Babu Rao", "baburao", 52));
		users.put("Shyam", new User("Shyam", "shyam", 32));
		users.put("Raju", new User("Raju", "raju", 33));
	}
%>

<body>
	<%	
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		User user = users.get(name);
		if (user!=null){
			if (user.getPassword().equals(password)){
				session.setAttribute("user_details", user);
				response.sendRedirect("details.jsp");
			} else {
	%>
	<h5>Invalid details. Please try <a href="login.jsp">again</a></h5>
	<%
			} 
		} else {
	%>
	<h5>Invalid user details. Please <a href="register.jsp">register</a></h5>
	<% } %>
</body>
	<%! public void jspDestroy() {
			System.out.println("In jspDestroy..");
		}
	%>
</html>
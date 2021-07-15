<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--read req params n store them in suitable scope --%>
	<%--redirect the client to details.jsp in NEXT request --%>
	<%
	String email = request.getParameter("em");
	String pwd = request.getParameter("pass");
	//add the deatails under session scope
	session.setAttribute("user_details", email+":"+pwd);
	//redirect 
	response.sendRedirect("details.jsp");
	%>
</body>
</html>
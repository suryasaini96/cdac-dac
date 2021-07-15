<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h5>JSessionID from index page : <%= session.getId() %></h5>
	<h3>
		Welcome 2 JSP !!!!!!
		<%=LocalDateTime.now()%></h3>
	<h5>
		<a href="comments.jsp">Test Comments</a>
	</h5>
	<h5>
		<a href="login.jsp">Test Scriptlets</a>
	</h5>
	<h5>
		<a href="test1.jsp">Testing Scopes</a>
	</h5>
	
	<h5>
		<a href="login2.jsp">Test EL</a>
	</h5>
</body>
</html>
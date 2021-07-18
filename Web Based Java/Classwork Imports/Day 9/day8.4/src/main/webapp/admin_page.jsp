<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 style="text-align: center;">${sessionScope.user.message}</h5>
	<h5>
		<a href="candidate_register.jsp">Register New Candidate</a>
	</h5>
	<h5 style="text-align: center;">${sessionScope.candidate.message}</h5>
	<h5>
		<a href="logout.jsp">Log Me Out</a>
	</h5>
</body>
</html>
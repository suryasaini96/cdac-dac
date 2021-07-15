<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--to display user details : EL syntax--%>
	<h5>User Details Via EL syntax : ${sessionScope.user_details}</h5>
	<h5>
		<a href="logout2.jsp">Log Out</a>
	</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>${requestScope.message}</h5>
	<h5>Vendor Details : ${sessionScope.user_details}</h5>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Out</a>
	</h5>
</body>
</html>
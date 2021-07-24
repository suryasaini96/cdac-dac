<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>${sessionScope.message}</h5>
	<h6>${sessionScope.user_details}</h6>
	<h5>
		<a href="<spring:url value='/user/logout'/>">Log Me Out</a>
	</h5>
</body>
</html>
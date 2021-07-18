<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h4>Admin login successful...</h4>
	<h4>Hello ${sessionScope.user.validUserDetails.name}</h4>
	<a href="candidate_register.jsp">New Candidate Register</a>
	<hr>
	${sessionScope.candidate.msg}
</body>
</html>
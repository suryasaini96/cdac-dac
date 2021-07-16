<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>Admin login successful</h5>
	<h5>Hello ${sessionScope.user.voter.name}</h5>
	<a href="candidate_register.jsp">New Candidate Register</a>
	${sessionScope.candidate.message}
</body>
</html>
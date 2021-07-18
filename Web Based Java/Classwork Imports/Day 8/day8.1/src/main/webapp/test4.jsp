<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From 1st page....</h5>
	<%
	request.setAttribute("user_Details", request.getParameter("name") + ":" + request.getParameter("age"));
	%>
	<%--forward the clnt to the next page in the SAME request --%>
	<jsp:forward page="test5.jsp" />
</body>
</html>
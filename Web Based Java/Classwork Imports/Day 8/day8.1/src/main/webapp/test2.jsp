<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>From the 1st page.....</h5>
	<%--create page scoped n request scoped attributes --%>
	<%
	pageContext.setAttribute("nm1", 1234);
	request.setAttribute("nm2", 2345);
	%>
	<%-- include dir test3.jsp --%>
	<%@ include file="test3.jsp"%>
</body>
</html>
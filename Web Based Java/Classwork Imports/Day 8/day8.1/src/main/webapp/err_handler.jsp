<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--pageContext.getException().getMessage() --%>
<h5>Error Mesg : ${pageContext.exception.message}</h5>
<h5>Error Causing Page : ${pageContext.errorData.requestURI}</h5>
<h5>Error Code : ${pageContext.errorData.statusCode}</h5>
</body>
</html>
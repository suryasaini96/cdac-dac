<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- display value of page scoped n  request scoped attributes : EL   --%>
<h5> From the included page</h5>
<h5>page scoped attribute : ${nm1}</h5>
<h5>req scoped attribute : ${requestScope.nm2}</h5>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>${requestScope.message}</h4>
	
	<table style="background-color: lightgrey; margin: auto">
		<c:forEach var="dept" items="${requestScope.departments}">
			<tr>
				<td><a href="<spring:url value='/emp/hire?dept=${dept.id}'/>">${dept.name}</a></td>
				<td>${dept.location}</td>
				<td>${dept.strength}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
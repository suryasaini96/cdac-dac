<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table style="background-color: lightgrey; margin: auto">
		<caption>Courses Offered</caption>
		<tr>
			<th>Course Name</th>
			<th>Delete</th>
			<th>Admission</th>
			<th>Details</th>
		</tr>
		<c:forEach var="title" items="${applicationScope.course_management.fetchAllTitles()}" >
			<tr>
				<td>${title}</td>
				<td><a href="delete_course.jsp?courseTitle=${title}">Delete</a></td>
				<td><a href="student_admission.jsp?courseTitle=${title}">Admit Student</a></td>
				<td><a href="course_details.jsp?courseTitle=${title}">Details</a></td>
				<td></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>
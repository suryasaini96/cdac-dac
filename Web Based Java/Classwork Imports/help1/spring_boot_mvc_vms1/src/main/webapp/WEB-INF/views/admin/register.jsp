<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%--import spring supplied form tag lib to enable data binding --%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body>
<h5 align="center" style="color: red;">${requestScope.message}</h5>
	<form:form  method="post" modelAttribute="user">
		<table style="background-color: lightgrey; margin: auto;">
		<tr>
				<td>Enter User Name</td>
				<td><form:input  path="name" /></td>
			</tr>
			<tr>
				<td>Enter User Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Enter User Password</td>
				<td><form:password path="password" /></td>
			</tr>
			<tr>
				<td>Enter Reg Amount</td>
				<td><form:input type="number" path="regAmount" /></td>
			</tr>
			<tr>
				<td>Enter Reg Date</td>
				<td><form:input type="date" path="regDate" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register Vendor" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>
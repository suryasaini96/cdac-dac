<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="check_registration.jsp" method="post">
		<table style="background-color: lightgrey; margin: auto;">
			<tr>
				<td>Enter Candidate Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td>Enter Political Party</td>
				<td><input type="text" name="party" /></td>
			</tr>
			<tr>
				<td>Enter DoB</td>
				<td><input type="date" name="dob" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form>

</body>
</html>
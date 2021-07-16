<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="check_registration.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Name</td>
          <td><input type="text" name="name" autofocus></td>
        </tr>
        <tr>
          <td>Party</td>
          <td><input type="text" name="party"></td>
        </tr>
		<tr>
			<td>DOB</td>
			<td><input type="date" name="dob"></td>
		</tr>
        <tr>
        	<td></td>
          	<td><input type="submit" value="Register"></td>
        </tr>
        
      </table>
    </form>
	
</body>
</html>
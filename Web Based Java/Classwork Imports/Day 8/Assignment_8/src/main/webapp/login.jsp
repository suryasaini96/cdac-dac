<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	 <form action="validate.jsp" method="post">
      <table style="background-color: lightgrey; margin: auto">
        <tr>
          <td>Email</td>
          <td><input type="text" name="email" autofocus></td>
        </tr>
        <tr>
          <td>Password</td>
          <td><input type="password" name="password"></td>
        </tr>

        <tr>
        	<td></td>
          	<td><input type="submit" value="Login">
 		  	<input type="submit" value="Register" formaction="register.jsp"></td>
        </tr>
        
      </table>
    </form>
 
</body>
</html>
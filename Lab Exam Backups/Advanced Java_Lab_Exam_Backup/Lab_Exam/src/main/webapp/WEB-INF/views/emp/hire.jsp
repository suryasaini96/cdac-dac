<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
	 <form method="post">
      <table style="background-color: lightgrey; margin: auto">
      	<tr>
          <td>Name</td>
          <td><input type="text" name="name" autofocus></td>
        </tr>
        <tr>
          <td>Email</td>
          <td><input type="email" name="email"></td>
        </tr>
        <tr>
          <td>Salary</td>
          <td><input type="number" name="salary"></td>
        </tr>
        <tr>
          <td>DoB</td>
          <td><input type="date" name="dob"></td>
        </tr>

        <tr>
          	<td><input type="submit" value="Hire Employee"></td> 
        </tr>
        
      </table>
      <input type = "hidden" value = "${requestScope.dept_id}" name = "dept_id">
    </form>
    
    ${requestScope.message}

</body>
</html>
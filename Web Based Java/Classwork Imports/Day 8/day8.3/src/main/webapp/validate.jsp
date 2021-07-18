<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%-- session.setAttribute(user,new UserBean())--%>
<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<body>
<jsp:setProperty property="*" name="user"/>
<%-- JSP invokes JB's B.L method : EL syntax --%>
<%--session.getAttribute("user").validateUser() --%>
<c:redirect  url="${sessionScope.user.validateUser()}.jsp"/>
 
</body>
</html>
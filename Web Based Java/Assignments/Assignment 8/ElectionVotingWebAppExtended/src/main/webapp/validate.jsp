<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<%-- session.setAttribute(user,new UserBean()) --%>
	<%-- id can be anything, class-fully qualified name and scope- we can decide --%>
	<jsp:useBean id="user" class="beans.UserBean" scope="session"/>
<body>
	<%-- property=all,pass(*) name=user(same as id as in userBean) --%>
	<jsp:setProperty property="*" name="user"/>
	
	<%-- JSP invokes JavaBeans methods: using EL syntax --%>
	<%-- session.getAttribute("user").validateUser() --%>
	<c:redirect url="${sessionScope.user.validateUser()}.jsp"/>

</body>
</html>
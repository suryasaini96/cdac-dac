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
	<h5 style="text-align: center;">${sessionScope.user.validUserDetails.role} User logging
		out...</h5>
	
	${sessionScope.user.voterDao.cleanUp()}
	
	${sessionScope.candidate.candidateDao.cleanUp()}
	<%--create a page scoped attribute to store user's role --%>
	<c:set var="role" value="${sessionScope.user.validUserDetails.role}"/>
	
	${pageContext.session.invalidate()}
	<%--send the logout link iff user has logged in as admin --%>
	<c:if test="${pageScope.role eq 'admin'}">
		<h5>
			<a href="login.jsp">Visit Again</a>
		</h5>
	</c:if>

</body>
</html>
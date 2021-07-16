<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<jsp:useBean id="candidate" class="beans.CandidateBean" scope="session" />
<body>
	<jsp:setProperty property="*" name="candidate" />
	<c:redirect url="${sessionScope.candidate.validateAge()}.jsp" />
</body>
</html>
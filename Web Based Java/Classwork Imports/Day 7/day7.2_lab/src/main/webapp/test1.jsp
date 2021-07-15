<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5>from test1</h5>
	<%-- add  attributes under various scopes : page | request | session | application ? --%>
	<%
//	out.flush(); //IllegalStateExc
	pageContext.setAttribute("nm1", 1234);//page scoped attr
	request.setAttribute("nm2", 3456);//req scoped attr
	session.setAttribute("nm3", 4567);//session scoped attr
	application.setAttribute("nm4", 5678);//application scoped attr
	//server pull : forward
	/* RequestDispatcher rd = request.getRequestDispatcher("test2.jsp");
	rd.forward(request, response); */
	//clnt pull II
	response.sendRedirect("test2.jsp");
	%>
	<%-- how to get the value of page scoped attribute ? scriptlet | expr | EL --%>
	<%-- <h5>Page Scoped attribute value via EL syntax : ${pageScope.nm1}</h5> --%>
</body>
</html>
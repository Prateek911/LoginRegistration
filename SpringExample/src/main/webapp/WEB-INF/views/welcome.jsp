<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	if (session.getAttribute("userObject") == null) {
		RequestDispatcher rd = request.getRequestDispatcher("/");
		rd.forward(request, response);
	} else {
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
</head>
<body>
<p align="right"><a href="logout">Logout</a></p>
	<h1 align="center" style="color:green;">Welcome</h1>
	Welcome ${loginuser.email}
	<br><br><br>Name: ${loginuser.name}
	<br><br><br>${loginuser.password}
	<%-- <br><br><br>Name: ${loginuser} --%>
</body>
</html>
<%

	}
%>
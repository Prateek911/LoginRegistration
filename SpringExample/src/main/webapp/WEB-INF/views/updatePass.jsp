<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Update Your Password</title>
</head>
<body>
<%
System.out.println("Emailll:  "+request.getParameter("email"));
String email = request.getParameter("email");
%>
<center>
<h2>Enter your new Password!</h2>
<h4>Dont forget it this time :-)</h4>
<div>${message}</div>
<form method="post" action="finalReset">
<input type="password" name="pass">
<input type="hidden" name="email" value=<%= email %>>
<input type="Submit" value="Reset Password">
</form>
</body>
</html>
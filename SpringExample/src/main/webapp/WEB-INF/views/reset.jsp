<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Password</title>
<%
	String OTP = (String) request.getAttribute("OTP");
	String email = (String) request.getAttribute("emaill");
	System.out.println("Email12:" + email);
%>

</head>
<body>
	<form method="post" action="updatePass">
		<center>
			<h2>Check Your mail for OTP</h2>

			<div><h5 style="color:red;">${message}</h5></div>

			<input type="text" name="usrCode"> <input type="hidden"
				name="genCode" value=<%=OTP%>> <input type="hidden"
				name="email" value=<%=email%>> <input type="Submit"
				value="Enter OTP!">
	</form>
	</center>
</body>
</html>
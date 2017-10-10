<%@page import="org.apache.log4j.Logger"%>
<%@page import="com.prateek.Services.UserService"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Login Here</title>
	<script src="https://apis.google.com/js/platform.js" async defer></script>
	<meta name="google-signin-client_id"><!-- content="210547452486-1lin2i9diu2gjbtvp2vubq89042lie45.apps.googleusercontent.com" --> 
</head>
<body>

	<h1 align="center">Login Form</h1>
	<center style="color: green;">
		<b>${messages}</b>
	</center>
	<form:form commandName="loginuser" action="login" method="POST">

		<form:label path="username" />Username
		<form:input path="username" />
		<form:errors path="username" />
		<br>
		<br>
		<br>
		<form:label path="password" />Password
		<form:password path="password" name="password" />
		<form:errors path="password" />
		<br>
		<br>
		<br>
		<div style="color: red;">${message}</div>
		<br>
		<input type="submit" value="Login">&nbsp;&nbsp;&nbsp;<a
			href="forgotPass">Forgot Password</a>

	</form:form>
	<br>
	<br> New User?? Then &nbsp;&nbsp;
	<a href="Register">Signup!</a>
	<br>
	<br>
	<b>OR</b>
	<br>
	<br>

<button type="button" onClick=window.location="googleLogin">Google +
</button>

</body>
<%

%>
</html>
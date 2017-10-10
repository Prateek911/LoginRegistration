<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Here</title>
</head>
<body>
	<h1 align="center">Registration Form</h1>

	<form:form name="Register" modelAttribute="user" action="register"
		method="POST">
		<table>
			<tr>
				<td><form:label path="name" />Name</td>
				<td><form:input path="name" /> <form:errors path="name" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td><form:label path="adhaar_Id" />Adhaar ID</td>
				<td><form:input path="adhaar_Id" value=" "/> <form:errors path="adhaar_Id" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td><form:label path="age"/>Age</td>
				<td><form:input path="age" value=" "/> <form:errors path="age" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td><form:label path="email"/>Email ID</td>
				<td><form:input path="email"/> <form:errors
						path="email" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td><form:label path="username"/>Username</td>
				<td><form:input path="username"/> <form:errors
						path="username" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td><form:label path="password"/>Password</td>
				<td><form:password path="password"/> <form:errors
						path="password" /></td>
			</tr>
			<tr></tr>
			<tr>
				<td><input type="submit" value="Register"/></td>
			</tr>
			</form:form>
		</table>

		<br>
		<br>
		<a href="/MVC2">Login</a>
</body>
</html>
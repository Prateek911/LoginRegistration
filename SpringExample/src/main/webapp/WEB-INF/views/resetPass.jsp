<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Reset Your Password</title>
</head>
<body>
<b><center>Enter your Username<br><br><br></b>
<div style="color: red;">${message}</div>

<br>
<form method="post" action="reset">

<input type="text" name="uname">
<div>${message2}</div><br>
<input type="Submit" value="Generate OTP">
</form>
</center>


</body>
</html>
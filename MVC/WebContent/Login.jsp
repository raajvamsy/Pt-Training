<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

<form action="LoginController" method="post">
	<table>
		<tr>
			<td>Username</td>
			<td><input type="text" name="username" value="root"></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input type="password" name="password" value="password"></td>
		</tr>
		<tr>
			<td><input type="submit" value="Submit"></td>
		</tr>
			
	</table>
</form>
</body>
</html>
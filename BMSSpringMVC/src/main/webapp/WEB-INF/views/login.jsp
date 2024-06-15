<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Namaste!</title>
</head>
<body>
	<h1>Welcome Home</h1>
	<h3>Today is @${requestScope.stamp}</h3>
	<h4 style="color: green;">${requestScope.message}</h4>
	<form action="<spring:url value='/user/validate'/>">
		<table
			style="text-align: auto; margin: auto; background-color: grey; border: 1px solid black;">
			<tr>
				<td colspan="2" style="color: red;"><h6>${requestScope.err}</h6></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="text" name="email"
					placeholder="Enter your email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="text" name="password"
					placeholder="Enter your password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Log In"></td>
				<td><input type="button" value="Sign Up"
					onclick="window.location.href='http://localhost:8080/bms/signup'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
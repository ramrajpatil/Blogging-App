<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Become a part of our FAMILY!</title>
</head>
<body>
	<h3 style="text-align: auto;">Hello, Please register by providing
		below mentioned details!</h3>
	<br />

	<form action="<spring:url value='/user/register'/>" method="post">
		<table
			style="border: 1px solid black; text-align: auto; margin: auto;">
			<tr>
				<th>Registration Form</th>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type="email" name="email"
					placeholder="Enter your email"></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"
					placeholder="Enter your password"></td>
			</tr>
			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"
					placeholder="Enter your first name"></td>
			</tr>
			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName"
					placeholder="Enter your last name"></td>
			</tr>

			<tr>
				<td>Phone No:</td>
				<td><input type="text" name="phoneNo"
					placeholder="Enter your Phone Number"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Sign Up"></td>
			</tr>
		</table>
	</form>
</body>
</html>
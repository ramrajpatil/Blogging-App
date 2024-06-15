<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add BLog!!!</title>

</head>
<body>
	<h1>Namskar ${sessionScope.user_details.firstName}!!!!</h1>
	<table border="1" style="width: 100%;">
		<tr>
			<td colspan="2" style="text-align: center;">
				<h3>Your Blogging App</h3>
			</td>
		</tr>
		<tr>
			<td style="width: 200px; vertical-align: top;">
				<table style="height: 200px; margin-left: 10px;">
					<tr>
						<spring:url value="/blog/blogHome" var="blogss"></spring:url>
						<td><a href="${blogss}">My Blogs</a></td>
					</tr>
					<tr>
						<spring:url value="/blog/blogHome" var="blogss"></spring:url>
						<td><a href="${blogss}">All Blogs</a></td>
					</tr>
					<tr>
						<td><spring:url value="/cat/add" var="cat"></spring:url> <a
							href="${cat}">Add Category</a></td>
					</tr>
					<tr>
						<spring:url value="/cat/allCats" var="allCats"></spring:url>
						<td><a href="${allCats}">Show Categories</a></td>
					</tr>
					<tr>
						<spring:url value="/blog/add" var="addBlog"></spring:url>
						<td><a href="${addBlog}">Add Blog</a></td>
					</tr>
					<tr>
						<spring:url value="/blog/search" var="search"></spring:url>
						<td><a href="${search}">Search Blogs</a></td>
					</tr>
					<tr>
						<spring:url value="/user/logout" var="logout"></spring:url>
						<td><a href="${logout}">Logout</a></td>
					</tr>
				</table>
			</td>
			<td><spring:url value="/blog/insert" var="insertBlog"></spring:url>
				<form action="${insertBlog}">
					<table>
						<caption>Insert Blog Details Here</caption>
						<tbody>
							<tr>
								<td>
									<div style="color: green;">${requestScope.msg}</div>
								</td>
							</tr>
							<tr>
								<td>Title:</td>
								<td><input type="text" name="title"
									placeholder="Enter Title" /></td>
							</tr>
							<tr>
								<td>Contents:</td>
								<td><input type="text" name="contents"
									placeholder="Enter contents here" height="300px" width="400px" /></td>
							</tr>
							<tr>
								<td><select name="category_id">
										<c:forEach var="cat" items="${sessionScope.cats}">
											<option value="${cat.id}">${cat.title}</option>
										</c:forEach>
								</select></td>

							</tr>
							<tr>
								<td><input type="submit" value="Create"></td>
								<td><input type="hidden" name="user_id"
									value="${sessionScope.user_details.id}" /></td>
								<td><input type="button" value="Cancel"
									onclick="window.location.href='http://localhost:8080/bms/blog/add';"></td>
							</tr>
						</tbody>
					</table>
				</form></td>
		</tr>
	</table>
</body>
</html>
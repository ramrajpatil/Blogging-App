<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Categories</title>
</head>
<body>
	<h3>Namskar ${sessionScope.user_details.firstName}</h3>
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
			<td>

				<table border="1"
					style="align: auto; margin: auto; height: auto; width: 100%;">
					<caption>All Categories</caption>
					<tr>
						<!-- id | contents | created_on | title | category_id | user_id | -->
						<th>Category ID</th>
						<th>Title</th>
						<th>Description</th>
					</tr>
					<c:forEach var="cat" items="${sessionScope.cats}">
						<tr
							style="text-align: center; margin: auto; height: auto; width: 100%; border: 1px red solid;">
							<td>${cat.id}</td>
							<td>${cat.title}</td>
							<td>${cat.description}</td>
						</tr>
					</c:forEach>
				</table>
			</td>
	</table>
</body>
</html>
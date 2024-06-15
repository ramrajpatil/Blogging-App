<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome Home!!!</title>


</head>
<body>
	<div style="text-align: center; color: green; margin: auto;">${requestScope.msg}</div>
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
						<spring:url value="/cat/add" var="cat"></spring:url>
						<td><a href="${cat}">Add Category</a></td>
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
			<div style="color: geen; text-align: center;">${requestScope.deleteStatus}</div>
				<table border="1"
					style="align: auto; margin: auto; height: auto; width: 100%;">
					<caption>All Blogs</caption>
					<tr>
						<!-- id | contents | created_on | title | category_id | user_id | -->
						<th>Status</th>
						<th>Blog ID</th>
						<th>Title</th>
						<th>Contents</th>
						<th>Created On</th>
						<th>Category</th>
						<th>Owner</th>
						<th>Actions</th>
					</tr>
					<c:forEach var="blog" items="${requestScope.allBlogs}">
						<tr id="${blog.id}"
							style="text-align: center; margin: auto; height: auto; width: 100%; border: 1px red solid;">
							<td style="color: geen;"><c:if
									test="${blog.id==requestScope.blogId}">
								${requestScope.update_msg}</c:if></td>
							<td>${blog.id}</td>
							<td>${blog.title}</td>
							<td>${blog.contents}</td>
							<td>${blog.createdOn}</td>
							<td>${blog.category.title}</td>
							<td>${blog.malak.firstName}</td>
							<c:if test="${sessionScope.user_details.id==blog.malak.id}">
								<td><spring:url value="/blog/update" var="updateBlog"></spring:url>
									<form action="${updateBlog}">
										<input type="hidden" value="${blog.id}" name="blogId" /> <input
											type="submit" value="Edit" />
									</form> <spring:url value="/blog/delete" var="deleteBlog"></spring:url>
									<form action="${deleteBlog}">
										<input type="hidden" value="${blog.id}" name="blogId" /> <input
											type="submit" value="Delete">
									</form></td>
							</c:if>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
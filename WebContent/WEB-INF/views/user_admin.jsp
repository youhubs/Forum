<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Manager</title>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: seperate;
	border-spacing: 5px;
}
</style>
</head>
<body>
	<div align="center">
		<h1>User List</h1>
		<h3>
			<a href="new-user">New User</a>
		</h3>
		<table style="border-collapse: separate; border-spacing: 5px;">
			<tr>
				<th>No</th>
				<th>UserName</th>
				<th>PassWord</th>
				<th>Email</th>
				<th>MemberDate</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${users}" var="user" varStatus="status">
				<tr>
					<td>${status.index + 1}</td>
					<td>${user.username}</td>
					<td>${user.password}</td>
					<td>${user.email}</td>
					<td>${user.memberDate}</td>
					<td><a href="edit-user?id=${user.id}">Edit</a> &nbsp;&nbsp; <a
						href="delete-user?id=${user.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
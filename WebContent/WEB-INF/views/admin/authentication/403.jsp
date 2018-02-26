<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="container-fluid">
	<h1>Error 403 - Access Denied</h1>
	<h3>User: "${username }" cannot access to this page! <a href="../authentication/logout.html">logout</a></h3>
	<a href="${pageContext.request.contextPath }/home.html">Go to home page!</a>
</div>
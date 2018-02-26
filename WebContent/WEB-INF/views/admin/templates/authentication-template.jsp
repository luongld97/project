<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>${title }</title>
<link
	href="${pageContext.request.contextPath }/assets/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/assets/admin/css/styles.css"
	rel="stylesheet">
</head>
<body>
	<tiles:insertAttribute name="content" />
	<script
		src="${pageContext.request.contextPath }/assets/admin/js/jquery-1.11.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/assets/admin/js/bootstrap.min.js"></script>
</body>
</html>

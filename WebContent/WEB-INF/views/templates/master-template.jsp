<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html lang="en">
<head>

<title>${title }</title>
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/assets/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/assets/css/plyr.css" />
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/assets/css/easy-autocomplete.min.css" />
<script
	src="${pageContext.request.contextPath }/assets/js/jquery-3.2.1.min.js"
	type="text/javascript"></script>
	
</head>
<body>
	<tiles:insertAttribute name="top-first-bar" />
	<tiles:insertAttribute name="top-second-bar" />
	<tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="footer" />
</body>

<script
	src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/jquery.easy-autocomplete.min.js"
	type="text/javascript"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/autocomplete.js"
	type="text/javascript"></script>	
</html>
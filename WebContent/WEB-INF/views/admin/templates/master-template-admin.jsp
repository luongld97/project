<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Lumino - Dashboard</title>
<link
	href="${pageContext.request.contextPath }/assets/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/assets/admin/css/font-awesome.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/assets/admin/css/styles.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/assets/admin/css/chosen.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/assets/admin/css/chosen-bootstrap.css"
	rel="stylesheet">
<script
	src="${pageContext.request.contextPath }/assets/admin/js/jquery-3.2.1.min.js"></script>
</head>
<body>
	<!--  -->
	<tiles:insertAttribute name="nav-bar" />
	<!--  -->
	<tiles:insertAttribute name="side-bar" />
	<!--  -->

	<div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a
					href="${pageContext.request.contextPath}/admin/home.html"> <em
						class="fa fa-home"></em>
				</a></li>
				<li class="active">${currentTab != null ? currentTab.toUpperCase() : '' }</li>
			</ol>
		</div>
		<tiles:insertAttribute name="content" />
	</div>
</body>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/bootstrap.min.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/custom.js"></script>
</html>
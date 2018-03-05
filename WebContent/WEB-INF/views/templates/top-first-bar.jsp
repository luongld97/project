<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Start Top first Bar-->
<div class="top-first-bar">
	<div class="container">
		<div class="row">
			<div class="col-md-3 plr0">
				<div class="logo">
					<a href=""> <img
						src="${pageContext.request.contextPath }/assets/images/logo.png">
					</a>
				</div>
			</div>
			<div class="col-md-6">
				<div class="input-group search-control">
					<input type="text" class="form-control"
						placeholder="Nhập nội dung tìm kiếm" id="search-box"
						baseUrl="${pageContext.request.contextPath }"> <span
						class="input-group-btn">
						<button type="submit" class="btn btn-default">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
			</div>
			<div class="col-md-3 plr0">
				<c:if test="${sessionScope.currentAccount == null }">
					<div class="login">
						<a href="${pageContext.request.contextPath }/account/login.html">Đăng
							nhập</a>
					</div>
				</c:if>
				<c:if test="${sessionScope.currentAccount != null }">
					<div class="login">
						<div class="dropdown">
							<b>${sessionScope.currentAccount.username }</b> <a
								class="dropdown-toggle" data-toggle="dropdown"> <span
								class="caret"></span>
							</a>
							<ul class="dropdown-menu dropdown-menu-right">
								<li><a href="myplaylist.html">Music</a></li>
								<li class="divider"></li>
								<li><a href="${pageContext.request.contextPath }/account/accountinfo.html">User info</a></li>
								<li><a href="<c:url value="/account/logout.html"/>">logout</a></li>
							</ul>
						</div>
					</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
<!--End Top first Bar-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/assets/css/style.css" />
	<script
	src="${pageContext.request.contextPath }/assets/js/jquery-3.2.1.min.js"
	type="text/javascript"></script>
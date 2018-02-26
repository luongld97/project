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
						placeholder="Nhập nội dung tìm kiếm"> <span
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
						<a href="<c:url value="account/login.html"/>">Đăng nhập</a>
					</div>
				</c:if>
				<c:if test="${sessionScope.currentAccount != null }">
					<div class="login">
							<div id="dropdown-logged" class="dropdown">
								<span class="user-logged">${sessionScope.currentAccount.username }
									<span class="caret"></span>
								</span>
								<ul id="open-toggle" class="dropdown-menu dropdown-menu-right">
									<li><a href="#">Nhạc cá nhân</a></li>
									<li class="divider"></li>
									<li><a href="#">Thông tin</a></li>
									<li><a href="">Đăng xuất</a></li>
								</ul>
							</div>
						</div>
				</c:if>
			</div>
		</div>
	</div>
</div>
<!--End Top first Bar-->
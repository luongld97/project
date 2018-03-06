<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Start Top Second Bar-->
<div class="top-second-bar">
	<div class="container">
		<div class="row">
			<div class="col-md-12 plr0">
				<div class="navbar-item">
					<c:url value="/" var="home" />
					<a href="${home }"><span class="glyphicon glyphicon-home"></span></a>
				</div>
				<div class="navbar-item">
					<c:url var="userPlayList" value="/account/playlist.html">
						<c:if test="${sessionScope.currentAccount != null}">
							<c:param name="username"
								value="${sessionScope.currentAccount.username }" />
						</c:if>
					</c:url>
					<a href="${userPlayList }">Nhạc cá nhân</a>
				</div>
				<div class="navbar-item">
					<a href="">Bảng xếp hạng</a>
				</div>
				<div class="navbar-item">
					<a href="<c:url value="/"/>">Video</a>
				</div>
				<div class="navbar-item">
					<a href="">Album</a>
				</div>
				<div class="navbar-item">
					<a href="">Nghệ sĩ</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!--End Top Second Bar-->
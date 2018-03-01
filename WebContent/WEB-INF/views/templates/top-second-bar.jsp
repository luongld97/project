<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--Start Top Second Bar-->
<div class="top-second-bar">
	<div class="container">
		<div class="row">
			<div class="col-md-12 plr0">
				<div class="navbar-item">
					<a href="index.html"><span class="glyphicon glyphicon-home"></span></a>
				</div>
				<div class="navbar-item">
					<a href="${pageContext.request.contextPath }/account/playlist.html?username=${sessionScope.currentAccount.username }">Nhạc cá nhân</a>
				</div>
				<div class="navbar-item">
					<a href="">Bảng xếp hạng</a>
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
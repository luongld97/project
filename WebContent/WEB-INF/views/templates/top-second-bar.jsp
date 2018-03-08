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
					<c:url var="userPlayList" value="/account/playlist.html" />
					<a href="${userPlayList }">Personal Music</a>
				</div>
				<div class="navbar-item">
					<a href="<c:url value="/home/chart.html"/>">Charts</a>
				</div>
				<div class="navbar-item">
					<a href="<c:url value="/home/video.html"/>">Videos</a>
				</div>
				<div class="navbar-item">
					<a href="<c:url value="/album/index.html"/>">Albums</a>
				</div>
				<div class="navbar-item">
					<a href="<c:url value="/artist/singer/allsinger.html"/>">Singers</a>
				</div>
			</div>
		</div>
	</div>
</div>
<!--End Top Second Bar-->
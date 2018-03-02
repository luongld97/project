<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Start Info Background -->
<div class="main-relative">
	<img
		src="${pageContext.request.contextPath }/assets/images/background-karic.png"
		class="image-view" alt="">
	<div class="box-info-artics">
		<div class="row">
			<div class="col-xs-2 col-md-2 avatar-artics">
				<c:if test="${fn:length(fn:trim(singer.photo)) > 0 }">
					<c:set var="singerPhoto" value="${singer.photo }" />
				</c:if>
				<c:if test="${fn:length(fn:trim(singer.photo)) <= 0 }">
					<c:set var="singerPhoto"
						value="${pageContext.request.contextPath }/assets/images/default-avatar.png" />
				</c:if>
				<img src="${singerPhoto }" alt=""
					class="info-artics image-view img-thumbnail">
			</div>
			<div class="col-xs-10 col-md-10 info-summary">
				<h1>${singer.name }</h1>
				<p class="text-justify lyric-f1">
					${fn:substring(singer.description, 0, 400) } ... <a href="">Xem
						thêm</a>
				</p>
			</div>
		</div>
	</div>
</div>
<!-- End Info Background -->
<div class="row">
	<div class="col-md-12">
		<div class="navbar-item">
			<c:url var="singerInfo" value="/artist/singer/info.html">
				<c:param name="id" value="${singer.id }" />
			</c:url>
			<a href="${singerInfo }">All Info</a>
		</div>
		<div class="navbar-item">
			<c:url var="singerSong" value="/artist/singer/song.html">
				<c:param name="id" value="${singer.id }" />
			</c:url>
			<a href="${singerSong }">All Song</a>
		</div>
		<div class="navbar-item">
			<c:url var="singerAlbum" value="/artist/singer/album.html">
				<c:param name="id" value="${singer.id }" />
			</c:url>
			<a href="${singerAlbum }">Album</a>
		</div>
		<div class="navbar-item">
			<c:url var="singerVideo" value="/artist/singer/video.html">
				<c:param name="id" value="${singer.id }" />
			</c:url>
			<a href="${singerVideo }">Video</a>
		</div>
		<div class="navbar-item">
			<c:url var="singerStory" value="/artist/singer/story.html">
				<c:param name="id" value="${singer.id }" />
			</c:url>
			<a href="${singerStory }">Story</a>
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!-- Start Info Background -->
<div>
	<div class="row main-relative">
		<div class="avatar-artist">
			<div>
				<img
					src="${pageContext.request.contextPath }/assets/images/${singer.photo }"
					alt="Avatar singer" class="image-view img-thumbnail">
			</div>
		</div>
		<div class="info-summary">
			<b class="name-artist">${singer.name }</b>
			<p class="text-justify lyric-f1">
				${fn:substring(singer.description, 0, 200) } ... <a
					href="story.html?id=${singer.id }" class="text-view-more">View
					more</a>
			</p>
		</div>
	</div>
</div>
<!-- End Info Background -->
<div class="row top-second-bar">
	<div class="col-xs-12 col-md-12">
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
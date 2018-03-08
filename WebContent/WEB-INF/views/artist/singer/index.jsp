<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<!-- Body Left -->
			<div class="col-xs-9 col-md-9">
				<div class="col-xs-12 col-md-12 body-left">
					<div class="row">
						<div class="col-xs-10 col-md-10">
							<h3 class="color-purple">${singer.name.toUpperCase() }'S
								SONG</h3>
							<c:url var="playTopSongs" value="/artist/singer/play-list.html">
								<c:param name="id" value="${singer.id }" />
							</c:url>
						</div>
						<div class="col-xs-2 col-md-2">
							<div class="artist-play-all-btn text-right">
								<a href="${playTopSongs }" title="Play all"><h3>
										<span class="glyphicon glyphicon-play-circle pr-1-5" />
									</h3> </a>
							</div>
						</div>
					</div>

					<c:forEach var="song" items="${topSongs }">
						<c:url var="songLink" value="/song/play.html">
							<c:param name="id" value="${song.id }" />
						</c:url>

						<div class="artics-listsong-item artics-listsong-item-boder-top">
							<div class="row">
								<div class="col-xs-9 col-md-9">
									<a href="${songLink }" class="linksong">${song.name }</a> - <span>
										<c:forEach items="${song.songDetails }" var="songDetail"
											varStatus="i">
											<c:url var="singerLink" value="/artist/singer/info.html">
												<c:param name="id" value="${songDetail.singer.id }" />
											</c:url>
											<a class="text-view-more" href="${singerLink }">${songDetail.singer.name }</a>
											<c:if test="${i.index < song.songDetails.size() - 1 }">,&nbsp;
													</c:if>
										</c:forEach>
									</span>
								</div>
								<div class="col-xs-3 col-md-3">
									<div class="float-right">
										<a class="playlist-btn-sm" href=""
											title="Add to your playlist"><span
											class="glyphicon glyphicon-plus"></span></a>
									</div>
								</div>
							</div>
						</div>

						<hr class="hr-css">
					</c:forEach>

				</div>

				<!-- Start Video Singer -->
				<div class="col-xs-12 col-md-12 body-left">
					<h3 class="color-purple">${singer.name.toUpperCase()}'SVIDEO</h3>

					<div class="row">
						<c:forEach var="video" items="${videos }">
							<div class="col-xs-3 col-md-3">
								<c:url var="playVideo" value="/song/play.html?video">
									<c:param name="id" value="${video.id }" />
								</c:url>
								<div class="my-img-120 mb-1">
									<a href="${playVideo }"><img
										src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto}"
										class="img-thumbnail image-view" /></a>
								</div>
								<a class="song-name" href="${playVideo }">${video.name }</a>
								<div>
									<i> <c:forEach items="${song.songDetails }"
											var="songDetail" varStatus="k">
											<c:url var="singerLink" value="/artist/singer/info.html">
												<c:param name="id" value="${songDetail.singer.id }" />
											</c:url>
											<a href="${singerLink }">${songDetail.singer.name }</a>
											<c:if test="${k.index < song.songDetails.size() - 1 }">
																,&nbsp;
															</c:if>
										</c:forEach>
									</i>
								</div>
							</div>
						</c:forEach>
					</div>



				</div>
				<!-- End Video Singer -->

				<!-- Start Album Singer -->
				<div class="col-xs-12 col-md-12 body-left">
					<h3 class="color-purple mb-2">${singer.name.toUpperCase()}'S
						ALBUM</h3>
					<div class="row">
						<c:forEach var="album" items="${albums }">
							<div class="col-xs-3 col-md-3">
								<c:url var="playAlbum" value="/album/play.html">
									<c:param name="id" value="${album.id }" />
								</c:url>
								<div class="my-img-120 mb-1">
									<a href="${playAlbum }"> <img
										src="${pageContext.request.contextPath }/assets/images/${album.photo}"
										class="img-thumbnail image-view" /></a>
								</div>
								<a class="song-name" href="${playAlbum }">${album.name }</a>
							</div>
						</c:forEach>
					</div>

				</div>
				<!-- End Album Singer -->
			</div>
			<!-- End Body Left -->
			<!-- Body Right -->
			<div class="col-xs-3 col-md-3"></div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<!-- Body Left -->
			<div class="col-xs-9 col-md-9">
				<div class="col-xs-12 col-md-12 body-left">
				<div class="row">
					<a href="">
						<h3 class="color-purple">${singer.name.toUpperCase() }' S SONG</h3>
					</a>
					&nbsp;
					<c:url var="playTopSongs" value="/artist/singer/play-list.html">
						<c:param name="id" value="${singer.id }"/>
					</c:url>
					<a class="artic-play-all-btn" href="${playTopSongs }" title="Play all">
						<span	class="glyphicon glyphicon-play-circle" />
					</a>
					</div>
					<ul class="list-item">
						<c:forEach var="song" items="${topSongs }">
							<c:url var="songLink" value="/song/play.html" >
								<c:param name="id" value="${song.id }"/>
							</c:url>
							<li>
								<div class="artics-listsong-item artics-listsong-item-boder-top">
									<div class="row">
										<div class="col-md-9">
											<a href="${songLink }" class="linksong">${song.name }</a> - 
											<span>
												<c:forEach items="${song.songDetails }" var="songDetail"
													varStatus="i">
													<c:url var="singerLink" value="/artist/singer/info.html">
														<c:param name="id" value="${songDetail.singer.id }" />
													</c:url>
													<a href="${singerLink }">${songDetail.singer.name }</a>
													<c:if test="${i.index < song.songDetails.size() - 1 }">
														,&nbsp;
													</c:if>
												</c:forEach>
											</span>
										</div>
										<div class="col-md-3">
											<div class="float-right">
												<a class="playlist-btn-sm" href="" title="Tải về"><span
													class="glyphicon glyphicon-download-alt"></span></a> <a
													class="playlist-btn-sm" href="" title="Thêm vào"><span
													class="glyphicon glyphicon-plus"></span></a> <a
													class="playlist-btn-sm" href="" title="Chia sẻ"><span
													class="glyphicon glyphicon-share"></span></a>
											</div>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css">
						</c:forEach>
					</ul>
				</div>
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">VIDEO
							${singer.name }</h3></a>
					<div class="row mb-2">
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
					</div>
				</div>
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">ALBUM
							${singer.name }</h3></a>
					<div class="row mb-2">
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
					</div>
					<div class="row">
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">${singer.name }</a>, <a
								class="singer-name" href="">Orange</a>, <a class="singer-name"
								href="">Superbrothers</a>
							</i>
						</div>
					</div>
				</div>
			</div>
			<!-- End Body Left -->
			<!-- Body Right -->
			<div class="col-xs-3 col-md-3"></div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
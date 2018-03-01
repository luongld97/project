<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="body-web">
	<div class="container bg-web">
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
					<a href="">Tất cả</a>
				</div>
				<div class="navbar-item">
					<a href="">Bài hát</a>
				</div>
				<div class="navbar-item">
					<a href="">Album</a>
				</div>
				<div class="navbar-item">
					<a href="">Video</a>
				</div>
				<div class="navbar-item">
					<a href="">Tiểu sử</a>
				</div>
			</div>
		</div>
		<div class="row">
			<!-- Body Left -->
			<div class="col-md-9">
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">${singer.name.toUpperCase() }'
							S SONG</h3></a> <a class="artic-play-all-btn" href="" title="Phát tất cả"><span
						class="glyphicon glyphicon-play-circle"></span></a>
					<ul class="list-item">
						<c:forEach var="song" items="${topSongs }">
							<c:url var="linkSong" value="/song/play.html" >
								<c:param name="id" value="${song.id }"/>
							</c:url>
							<li>
								<div class="artics-listsong-item artics-listsong-item-boder-top">
									<div class="row">
										<div class="col-md-9">
											<a href="${linkSong }" class="linksong">${song.name } - 
												<span>
													<c:forEach items="${song.songDetails }" var="songDetail"
														varStatus="i">
														${songDetail.singer.name }
														<c:if test="${i.index < song.songDetails.size() - 1 }">
															,&nbsp;
														</c:if>
													</c:forEach>
												</span>
											</a>
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
			<div class="col-md-4"></div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left -->
			<div class="col-xs-8 col-md-8">
				<!-- Start Live Show -->
				<div class="col-xs-12 col-md-12 body-left">
					<img
						src="${pageContext.request.contextPath }/assets/images/liveshow.png"
						class="image-view" alt="">
				</div>
				<!-- End Live Show -->
				<!-- List TOP 5 -->
				<div class="col-xs-12 col-md-12 body-left">
					<ul class="list-item">
						<c:forEach items="${charts }" var="chart" varStatus="i">
							<c:set var="song" value="${chart.song }" />
							<c:url var="listenLink" value="/song/play.html">
								<c:param name="id" value="${song.id }" />
							</c:url>
							<li class="item">
								<div class="label-rank-top">${i.index + 1 }</div>
								<div class="label-status">-</div>
								<div class="info-song">
									<a href="${listenLink }"><b class="song-name">${song.name }</b></a><br>
									<i> <c:forEach items="${song.songDetails }"
											var="songDetail" varStatus="i">
											<c:url var="singerLink" value="/artist/singer/info.html">
												<c:param name="id" value="${songDetail.singer.id }" />
											</c:url>
											<a class="singer-name" href="${singerLink }">${songDetail.singer.name }</a>
											<c:if test="${i.index < song.songDetails.size() - 1 }">			
												,&nbsp;
											</c:if>
										</c:forEach>
									</i> <br>
									<p class="time-top"></p>
								</div>
								<div class="tool-song">
									<a class="playlist-btn" href="${listenLink }" title="Nghe"><span
										class="glyphicon glyphicon-play"></span></a> <a
										class="playlist-btn" onclick="addToClick('${song.id}');"
										href="#modal-add-play-list" title="Add to..."
										data-toggle="modal"><span class="glyphicon glyphicon-plus"></span></a>
								</div>
								<div class="number-listen">${chart.listen }</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- End List TOP 5 -->
				<!-- Video HOT -->
				<div class="col-xs-12 col-md-12 body-left">
					<a href="<c:url value="home/video.html"/>"><h3
							class="color-purple">VIDEO HOT</h3></a>
					<div class="row mb-2">
						<div class="col-xs-3 col-md-3">
							<div class="img-thumbnail my-img-120">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
									class="image-view" />
							</div>
							<a class="song-name" href="">Người lạ ơi</a>
							<div>
								<i> <a class="singer-name" href="">Karik</a>, <a
									class="singer-name" href="">Orange</a>, <a class="singer-name"
									href="">Superbrothers</a>
								</i>
							</div>
						</div>
						<div class="col-xs-3 col-md-3">
							<div class="img-thumbnail my-img-120">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
									class="image-view" />
							</div>
							<a class="song-name" href="">Người lạ ơi</a>
							<div>
								<i> <a class="singer-name" href="">Karik</a>, <a
									class="singer-name" href="">Orange</a>, <a class="singer-name"
									href="">Superbrothers</a>
								</i>
							</div>
						</div>
						<div class="col-xs-3 col-md-3">
							<div class="img-thumbnail my-img-120">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
									class="image-view" />
							</div>
							<a class="song-name" href="">Người lạ ơi</a>
							<div>
								<i> <a class="singer-name" href="">Karik</a>, <a
									class="singer-name" href="">Orange</a>, <a class="singer-name"
									href="">Superbrothers</a>
								</i>
							</div>
						</div>
						<div class="col-xs-3 col-md-3">
							<div class="img-thumbnail my-img-120">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
									class="image-view" />
							</div>
							<a class="song-name" href="">Người lạ ơi</a>
							<div>
								<i> <a class="singer-name" href="">Karik</a>, <a
									class="singer-name" href="">Orange</a>, <a class="singer-name"
									href="">Superbrothers</a>
								</i>
							</div>
						</div>
					</div>
				</div>
				<!-- End Video Hot -->
			</div>
			<!-- End Body Left -->
			<!-- Body Right -->
			<div class="col-xs-4 col-md-4">
				<!-- BXH bai hat tuan-->
				<div class="col-xs-12 col-md-12 body-right">
					<div class="item-right title-chart">
						<div class="row">
							<div class="col-xs-5">
								<h4 class="color-purple">#TOP SONG</h4>
							</div>
							<div class="col-xs-2">
								<c:url var="playListLink" value="/song/playlist.html" />
								<a class="play-all-btn" href="${playListLink }"
									title="Phát tất cả"> <span
									class="glyphicon glyphicon-play-circle"></span>
								</a>
							</div>
							<div class="col-xs-5 text-right">

								<a class="text-view-more"
									href="<c:url value="/home/chart.html"/>">View more</a>
							</div>
						</div>
					</div>

					<ul class="list-item">
						<c:forEach items="${charts }" var="chart" varStatus="i">
							<c:set var="song" value="${chart.song }" />
							<c:url var="listenLink" value="/song/play.html">
								<c:param name="id" value="${song.id }" />
							</c:url>
							<li class="item-chart">
								<div class="label-rank-chart">${i.index + 1 }</div>
								<div class="info-chart">
									<a href="${listenLink }"><b class="song-name-chart">${song.name }</b></a><br>
									<i> <c:forEach items="${song.songDetails }"
											var="songDetail" varStatus="i">
											<a class="singer-name-chart" href="">${songDetail.singer.name }</a>
											<c:if test="${i.index < song.songDetails.size() - 1 }">			
												,&nbsp;
											</c:if>
										</c:forEach>
									</i>
								</div>
								<div class="tool-chart">
									<a class="playlist-btn-sm" href="${listenLink }" title="Play"><span
										class="glyphicon glyphicon-play"></span></a> <a
										class="playlist-btn-sm" onclick="addToClick('${song.id}');"
										href="#modal-add-play-list" title="Add to..."
										data-toggle="modal"><span class="glyphicon glyphicon-plus"></span></a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- End BXH bai hat tuan -->
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<!--End Body Web-->
<!-- Form Add To Playlist -->
<div class="modal fade" id="modal-add-play-list" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
<!-- End Form -->
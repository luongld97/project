<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left -->
			<div class="col-md-8">
				<!-- Start Live Show -->
				<div class="col-md-12 body-left">
					<img
						src="${pageContext.request.contextPath }/assets/images/liveshow.png"
						class="image-view" alt="">
				</div>
				<!-- End Live Show -->
				<!-- List TOP 5 -->
				<div class="col-md-12 body-left">
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
										class="playlist-btn" href="" title="Tải về"><span
										class="glyphicon glyphicon-download-alt"></span></a> <a
										class="playlist-btn" href="" title="Thêm vào"><span
										class="glyphicon glyphicon-plus"></span></a> <a
										class="playlist-btn" href="" title="Chia sẻ"><span
										class="glyphicon glyphicon-share"></span></a>
								</div>
								<div class="number-listen">${chart.listen }</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- End List TOP 5 -->
				<!-- Video HOT -->
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">VIDEO HOT</h3></a>
					<div class="row mb-2">
						<div class="col-md-3">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgvideo.png"
								alt="" class="image-view img-thumbnail mb-1"> <br> <a
								href=""><b class="song-name">Người lạ ơi</b></a> <br> <i>
								<a class="singer-name" href="">Karik</a>, <a class="singer-name"
								href="">Orange</a>, <a class="singer-name" href="">Superbrothers</a>
							</i>
						</div>

					</div>

				</div>
				<!-- End Video Hot -->
				<!-- Album Hot -->
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">ALBUM HOT</h3></a>
					<div class="row mb-2">
						<div class="col-md-3">
							<a href=""><img
								src="${pageContext.request.contextPath }/assets/images/imgalbum.png"
								alt="" class="image-view img-thumbnail mb-1"></a> <br> <a
								href=""><b class="song-name">Buồn Của Anh</b></a> <br> <i>
								<a class="singer-name" href="">Masew</a>, <a class="singer-name"
								href="">Đạt G</a>, <a class="singer-name" href="">K-ICM</a>
							</i>
						</div>
					</div>
				</div>
				<!-- End Album Hot -->
			</div>
			<!-- End Body Left -->
			<!-- Body Right -->
			<div class="col-md-4">
				<!-- Theme Hot -->
				<div class="col-md-12 body-right">
					<div class="item-right title-list-index">
						<h4>CHỦ ĐỀ HOT</h4>
					</div>
					<div class="item-right">
						<img
							src="${pageContext.request.contextPath }/assets/images/chude4.png"
							class="image-view" alt="">
					</div>
					<div class="item-right">
						<img
							src="${pageContext.request.contextPath }/assets/images/chude2.png"
							class="image-view" alt="">
					</div>
					<div class="item-right">
						<img
							src="${pageContext.request.contextPath }/assets/images/chude3.png"
							class="image-view" alt="">
					</div>
				</div>
				<!-- End Theme Hot -->
				<!-- BXH bai hat tuan-->
				<div class="col-md-12 body-right">
					<div class="item-right title-chart">
						<h4 class="title-list-index">BXH THÁNG BÀI HÁT</h4>
						<c:url var="playListLink" value="/song/playlist.html">
							<c:param name="id" value="-1" />
						</c:url>
						<a class="play-all-btn" href="${playListLink }" title="Phát tất cả"><span
							class="glyphicon glyphicon-play-circle"></span></a> <a
							class="text-view-more" href="#">Xem thêm</a>
					</div>

					<ul class="list-item">
						<c:forEach items="${charts }" var="chart" varStatus="i">
							<c:set var="song" value="${chart.song }" />
							<c:url var="listenLink" value="/song/play.html">
								<c:param name="id" value="${song.id }"/>
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
									<a class="playlist-btn-sm" href="" title="Tải về"><span
										class="glyphicon glyphicon-download-alt"></span></a> <a
										class="playlist-btn-sm" href="" title="Thêm vào"><span
										class="glyphicon glyphicon-plus"></span></a> <a
										class="playlist-btn-sm" href="" title="Chia sẻ"><span
										class="glyphicon glyphicon-share"></span></a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- End BXH bai hat tuan -->
				<!-- BXH Album tuan -->
				<div class="col-md-12 body-right">
					<div class="item-right title-chart">
						<h4 class="title-list-index">BXH THÁNG ALBUM</h4>
						<a class="play-all-btn" href="" title="Phát tất cả"><span
							class="glyphicon glyphicon-play-circle"></span></a> <a
							class="text-view-more" href="#">Xem thêm</a>
					</div>
					<ul class="list-item">
						<li class="item-chart">
							<div class="label-rank-chart">1</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Perfect Duet</b></a><br>
								<i><a class="singer-name-chart" href="">Ed Sheeran</a>, <a
									class="singer-name-chart" href="">Beyoncé</a></i>
							</div>
							<div class="tool-chart">
								<a class="playlist-btn-sm" href="" title="Tải về"><span
									class="glyphicon glyphicon-download-alt"></span></a> <a
									class="playlist-btn-sm" href="" title="Thêm vào"><span
									class="glyphicon glyphicon-plus"></span></a> <a
									class="playlist-btn-sm" href="" title="Chia sẻ"><span
									class="glyphicon glyphicon-share"></span></a>
							</div>
						</li>
						<li class="item-chart">
							<div class="label-rank-chart">2</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Perfect Duet</b></a><br>
								<i><a class="singer-name-chart" href="">Ed Sheeran</a>, <a
									class="singer-name-chart" href="">Beyoncé</a></i>
							</div>
							<div class="tool-chart">
								<a class="playlist-btn-sm" href="" title="Tải về"><span
									class="glyphicon glyphicon-download-alt"></span></a> <a
									class="playlist-btn-sm" href="" title="Thêm vào"><span
									class="glyphicon glyphicon-plus"></span></a> <a
									class="playlist-btn-sm" href="" title="Chia sẻ"><span
									class="glyphicon glyphicon-share"></span></a>
							</div>
						</li>
						<li class="item-chart">
							<div class="label-rank-chart">3</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Perfect Duet</b></a><br>
								<i><a class="singer-name-chart" href="">Ed Sheeran</a>, <a
									class="singer-name-chart" href="">Beyoncé</a></i>
							</div>
							<div class="tool-chart">
								<a class="playlist-btn-sm" href="" title="Tải về"><span
									class="glyphicon glyphicon-download-alt"></span></a> <a
									class="playlist-btn-sm" href="" title="Thêm vào"><span
									class="glyphicon glyphicon-plus"></span></a> <a
									class="playlist-btn-sm" href="" title="Chia sẻ"><span
									class="glyphicon glyphicon-share"></span></a>
							</div>
						</li>
						<li class="item-chart">
							<div class="label-rank-chart">4</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Perfect Duet</b></a><br>
								<i><a class="singer-name-chart" href="">Ed Sheeran</a>, <a
									class="singer-name-chart" href="">Beyoncé</a></i>
							</div>
							<div class="tool-chart">
								<a class="playlist-btn-sm" href="" title="Tải về"><span
									class="glyphicon glyphicon-download-alt"></span></a> <a
									class="playlist-btn-sm" href="" title="Thêm vào"><span
									class="glyphicon glyphicon-plus"></span></a> <a
									class="playlist-btn-sm" href="" title="Chia sẻ"><span
									class="glyphicon glyphicon-share"></span></a>
							</div>
						</li>
						<li class="item-chart">
							<div class="label-rank-chart">5</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Perfect Duet</b></a><br>
								<i><a class="singer-name-chart" href="">Ed Sheeran</a>, <a
									class="singer-name-chart" href="">Beyoncé</a></i>
							</div>
							<div class="tool-chart">
								<a class="playlist-btn-sm" href="" title="Tải về"><span
									class="glyphicon glyphicon-download-alt"></span></a> <a
									class="playlist-btn-sm" href="" title="Thêm vào"><span
									class="glyphicon glyphicon-plus"></span></a> <a
									class="playlist-btn-sm" href="" title="Chia sẻ"><span
									class="glyphicon glyphicon-share"></span></a>
							</div>
						</li>
					</ul>
				</div>
				<!-- End BXH Album tuan -->
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<!--End Body Web-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left  -->
			<div class="col-md-8">
				<!-- Play Song -->
				<div class="col-md-12 body-left">
					<input type="hidden" id="page-info"
						base-url="${pageContext.request.contextPath }"
						song-id="${song.id }" />
					<div class="play-song mb-3">
						<img
							src="${pageContext.request.contextPath }/assets/images/chude.png"
							alt="" class="image-view">
						<audio id="media-player">
						</audio>
						<ul id="list-song" class="list-item">
							<c:forEach var="song" items="${songs }" varStatus="i">
								<li>
									<div class="pl-playlist-item">
										<div class="col-md-8 play-this-song">
											<input type="hidden" value="${song.id }" name="id" /> <input
												type="hidden" value="${song.link }" name="link" /> <span
												class="playing-song-text-color">${i.index + 1}</span> <span
												class="ml-4 playing-song-text-color">${song.name }</span>
										</div>
										<div class="float-right col-md-4">
											<c:if test="${song.video }">
												<c:url var="videoLink" value="/song/play.html?video">
													<c:param name="id" value="${song.id }" />
												</c:url>
												<a class="playlist-btn-sm" href="${videoLink }"
													title="Xem MV"> <span class="glyphicon glyphicon-film" />
												</a>
											</c:if>
											<!-- <a class="playlist-btn-sm" href="" title="Tải về"> <span
												class="glyphicon glyphicon-download-alt" />
											</a> -->
											<a class="playlist-btn-sm" href="#modalAddPlaylist"
												title="Add to..." data-toggle="modal"
												onclick="addToClick('${song.id}');"> <span
												class="glyphicon glyphicon-plus" />
											</a>
											<c:url var="songLink" value="/song/play.html">
												<c:param name="id" value="${song.id }" />
											</c:url>
											<a class="playlist-btn-sm" href="${songLink }"
												target="_blank" title="Nghe riêng"> <span
												class="glyphicon glyphicon-arrow-right" />
											</a>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="btn-tool">
						<div class="listen-time float-right">
							<span> <span class="glyphicon glyphicon-headphones" /> <b
								id="listen"></b>
							</span>
						</div>
					</div>
				</div>
				<!-- End Play Song -->
				<!-- Loi Bai Hat -->
				<div class="col-md-12 body-left">
					<h3 class="title-list-index">Lyric</h3>
					<p id="lyric" class="text-justify lyric-f2"></p>
				</div>
				<!-- End Loi Bai Hat -->

				<c:if test="${sessionScope.currentAccount != null }">
					<!-- Album cá nhân -->
					<div class="col-md-12 body-left">
						<a href=""><h3 class="title-list-index">MY PLAY LIST</h3></a>
						<div class="row mb-2">
							<c:forEach var="playList" items="${recommendPlayLists }">
								<div class="col-md-3">
									<c:url var="playListLink" value="/song/playlist.html">
										<c:param name="id" value="${playList.id }" />
									</c:url>
									<a href="${playListLink }"><img
										src="${pageContext.request.contextPath }/assets/images/${playList.photo }"
										class="image-view img-thumbnail mb-1"></a> <br> <a
										href=""><b class="song-name">${playList.name }</b></a> <br>
									<i> </i>
								</div>
							</c:forEach>
						</div>
					</div>
					<!-- End Album -->
				</c:if>
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">RECOMMEND ALBUM</h3></a>
					<div class="row mb-2">
						<div class="col-md-3">
							<a href=""><img src="images/imgalbum.png" alt=""
								class="image-view img-thumbnail mb-1"></a> <br> <a
								href=""><b class="song-name">Play List 1</b></a> <br> <i>
								<a class="singer-name" href="">Masew</a>, <a class="singer-name"
								href="">Đạt G</a>, <a class="singer-name" href="">K-ICM</a>
							</i>
						</div>
					</div>
				</div>
				<!-- Binh luan -->
				<div class="col-md-12 body-left">
					<h3>COMMENTS</h3>
					<!-- Nhap binh luan -->
					<div class="margin-top-20">
						<div class="row">
							<div class="col-md-2">
								<img class="avatar"
									src="${pageContext.request.contextPath }/assets/images/imgcasi.png" />
							</div>
							<div class="col-md-10">
								<textarea id="comment-box"
									username="${sessionScope.currentAccount.username }"
									class="text-command" placeholder=" Nhập bình luận ở đây"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<c:if test="${sessionScope.currentAccount != null }">
									<button class="btn btn-primary float-right" id="post-button">POST</button>
								</c:if>
								<c:if test="${sessionScope.currentAccount == null }">
									<button class="btn btn-primary float-right">You should
										login first!</button>
								</c:if>
							</div>
						</div>
					</div>
					<!-- End Nhap binh luan -->
					<!-- Xem binh luan -->
					<div class="margin-top-20">
						<ul id="comment-area" class="list-item">
							<!-- comments will load here -->
						</ul>
					</div>
					<!-- End Xem binh luan -->
					<div class="">
						<button id="show-more-button" class="btn btn-primary full-width">SHOW
							MORE</button>
					</div>
				</div>
				<!-- End Binh luan -->
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-md-4">
				<div class="col-md-12 body-right">
					<div class="item-right">
						<h4 class="title-list-index">MV RECOMMEND</h4>
					</div>
					<ul class="list-item">
						<c:forEach items="${suggestedVideos }" var="video">
							<li class="item-chart">
								<div class="label-img">
									<img
										src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto }"
										class="image-view thumbnail">
								</div>
								<div class="info-chart">
									<c:url var="videoLink" value="/song/play.html?video">
										<c:param name="id" value="${video.id }" />
									</c:url>
									<a href="${videoLink }"><b class="song-name-chart">${video.name }</b></a><br>
									<i class="singer-name-chart"> <c:forEach
											items="${suggestedSong.songDetails }" var="songDetail"
											varStatus="i">
																${songDetail.singer.name }
																<c:if
												test="${i.index < suggestedSong.songDetails.size() - 1 }">
																	,&nbsp;
																</c:if>
										</c:forEach>
									</i>
								</div>
								<div class="tool-chart">
									<a class="playlist-btn-sm" href="" title="Nghe"><span
										class="glyphicon glyphicon-play"></span></a> <a
										class="playlist-btn-sm" href="" title="Thêm vào"><span
										class="glyphicon glyphicon-plus"></span></a> <a
										class="playlist-btn-sm" href="" title="Chia sẻ"><span
										class="glyphicon glyphicon-share"></span></a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
				<!-- Recommend Song -->
				<tiles:insertDefinition name="song.recommend" />
			</div>
		</div>
		<!-- End Body Right -->
	</div>
</div>
<!--End Body Web-->
<!-- Form Add To Playlist -->
<div class="modal fade" id="modal-add-play-list" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"></div>
<!-- End Form -->
<script src="${pageContext.request.contextPath }/assets/js/plyr.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/comment.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/counter.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/pages/play-list-song.js"></script>
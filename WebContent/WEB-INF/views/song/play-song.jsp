<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<div class="col-md-8">
				<div class="col-md-12 body-left">
					<h4>
						<strong>${song.name }</strong> &nbsp;-&nbsp;
						<c:forEach items="${song.songDetails }" var="songDetail"
							varStatus="i">
							<c:url var="singerLink" value="../artist/singer/info.html">
								<c:param name="id" value="${songDetail.singer.id }" />
							</c:url>
							<a href="${singerLink }">${songDetail.singer.name }</a>
							<c:if test="${i.index < song.songDetails.size() - 1 }">
								,&nbsp;
							</c:if>
						</c:forEach>
					</h4>
					<div class="play-song">
						<input type="hidden" id="page-info"
							value="${song.video ? 'video' : 'audio' }"
							base-url="${pageContext.request.contextPath }"
							song-id="${song.id }" />
						<c:if test="${!isVideo }">
							<img
								src="${pageContext.request.contextPath }/assets/images/chude.png"
								alt="" class="image-view">
							<audio>
								<source src="${song.link }" />
							</audio>
						</c:if>
						<c:if test="${isVideo }">
							<video class="play-video"
								poster="${pageContext.request.contextPath }/assets/images/${song.videoPhoto }">
								<source src="${song.videoLink }" type="video/mp4" />
							</video>
						</c:if>
					</div>
					<div class="info-play-song">
						<p>
							Authors:
							<c:forEach items="${song.authorDetails }" var="authorDetail"
								varStatus="i">
							${authorDetail.author.name }
							<c:if test="${i.index < song.authorDetails.size() - 1 }">
								,&nbsp;
							</c:if>
							</c:forEach>
							&nbsp;-&nbsp; Album: ${song.albumSongs.size() > 0 ? '' : 'Không có album.' }
						</p>
						<p>
							Categories:
							<c:forEach items="${song.categoryDetails }" var="categoryDetail"
								varStatus="i">
							${categoryDetail.category.name }
							<c:if test="${i.index < song.categoryDetails.size() - 1 }">
								,&nbsp;
							</c:if>
							</c:forEach>
						</p>
					</div>
					<div class="btn-tool">
						<a id="btn-add-to" class="btn btn-primary"
							href="#modal-add-play-list" title="Add to..." data-toggle="modal"
							onclick="addToClick('${song.id}');"> <span
							class="glyphicon glyphicon-plus"></span> Add to...
						</a>
						<c:if test="${song.video && !isVideo}">
							<c:url var="mvLink" value="/song/play.html?video">
								<c:param name="id" value="${song.id }" />
							</c:url>
							<a class="btn btn-primary" title="View MV" href="${mvLink }">
								<span class="glyphicon glyphicon glyphicon-film"></span> MV
							</a>
						</c:if>

						<c:if test="${isVideo}">
							<c:url var="songLink" value="/song/play.html">
								<c:param name="id" value="${song.id }" />
							</c:url>
							<a class="btn btn-primary" title="Listen" href="${songLink }">
								<span class="glyphicon glyphicon glyphicon-film"></span> MP3
							</a>
						</c:if>

						<div class="listen-time float-right">
							<span class="glyphicon glyphicon-headphones"></span> <span
								id="listen">${isVideo ? song.view : song.listen }</span>
						</div>
					</div>
				</div>
				<!-- End Play Song -->
				<!-- Loi Bai Hat -->
				<div class="col-md-12 body-left">
					<h3 class="title-list-index">LYRIC</h3>
					<p class="text-justify">${song.lyric.length() > 0 ? song.lyric : 'Hiện chưa có lời bài hát!' }</p>
				</div>
				<!-- End Loi Bai Hat -->
				<!-- Video cua ca si bai hat nay -->
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">RECOMMEND MV</h3></a>
					<div class="row">
						<c:forEach var="video" items="${suggestedVideos }">
							<div class="col-md-3">
								<img
									src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto }"
									class="image-view img-thumbnail mb-1"> <br> <a
									href=""><b class="song-name">${video.name }</b></a> <br> <i>
									<c:forEach items="${video.songDetails }" var="songDetail"
										varStatus="i">
										<c:url var="singerLink" value="/artist/singer/info.html">
											<c:param name="id" value="${songDetail.singer.id }" />
										</c:url>
										<a href="${singerLink }">${songDetail.singer.name }</a>
										<c:if test="${i.index < song.songDetails.size() - 1 }">
												,&nbsp;
											</c:if>
									</c:forEach>
								</i>
							</div>
						</c:forEach>
					</div>
				</div>
				<!-- End Video cua ca si bai hat nay -->
				<!-- Album cua ca si bai hat nay -->
				<!-- <div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">ALBUM TUẤN HƯNG</h3></a>
					<div class="row">
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
				</div> -->
				<!-- End Album -->
				<!-- Binh luan -->
				<div class="col-md-12 body-left">
					<h3>COMMENTS</h3>
					<!-- Nhap binh luan -->
					<div class="margin-top-20">
						<c:if test="${sessionScope.currentAccount == null }">
							<div class="row">
								<div class="col-md-3 float-right">
									<a class="btn btn-primary pull-right"
										href="<c:url value="/account/login.html"/>">Login to
										comment!</a>
								</div>
							</div>
						</c:if>
						<c:if test="${sessionScope.currentAccount != null }">
							<div class="row">
								<div class="col-md-2">
									<img id="user-avatar" class="avatar"
										src="${pageContext.request.contextPath }/assets/images/${currentAccount.photo }"
										alt="">
								</div>
								<div class="col-md-10">
									<textarea id="comment-box"
										username="${sessionScope.currentAccount.username }"
										class="text-command" placeholder="Say something...!"></textarea>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<button class="btn btn-primary float-right" id="post-button">POST</button>
								</div>
							</div>
						</c:if>
					</div>
					<!-- End Nhap binh luan -->
					<!-- Xem binh luan -->
					<div class="margin-top-20">
						<ul class="list-item" id="comment-area">
							<!-- comment will append here -->
						</ul>
					</div>
					<!-- End Xem binh luan -->
					<div>
						<button class="btn btn-primary full-width" id="show-more-button">Show
							more</button>
					</div>
				</div>
				<!-- End Binh luan -->
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-md-4">
				<div class="col-md-12 body-right">
					<tiles:insertDefinition name="song.recommend" />
				</div>
			</div>
		</div>
		<!-- End Body Right -->
	</div>
</div>
<!-- Form Add To Playlist -->
<div class="modal fade" id="modal-add-play-list" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"
	base-url="${pageContext.request.contextPath }"></div>
<!-- End Form -->
<!--End Body Web-->

<script src="${pageContext.request.contextPath }/assets/js/plyr.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/comment.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/counter.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/pages/play-song.js"></script>
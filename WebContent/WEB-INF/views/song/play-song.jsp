<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left  -->
			<div class="col-md-8">
				<!-- Play Song -->
				<div class="col-md-12 body-left">
					<h4>
						<strong>${song.name }</strong> &nbsp;-&nbsp;
						<c:forEach items="${song.songDetails }" var="songDetail"
							varStatus="i">
							${songDetail.singer.name }
							<c:if test="${i.index < song.songDetails.size() - 1 }">
								,&nbsp;
							</c:if>
						</c:forEach>
					</h4>
					<div class="play-song">
						<img
							src="${pageContext.request.contextPath }/assets/images/chude.png"
							alt="" class="image-view">
						<audio baseUrl="${pageContext.request.contextPath }"
							songId="${song.id }">
							<source src="${song.link }" />
						</audio>
					</div>
					<div class="info-play-song">
						<p>
							Sáng tác:
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
							Thể loại:
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
						<button class="btn btn-primary" title="Thêm vào">
							<span class="glyphicon glyphicon-plus"></span> Thêm vào
						</button>
						<button class="btn btn-primary" title="Tải về">
							<span class="glyphicon glyphicon-download-alt"></span> Tải về
						</button>
						<button class="btn btn-primary" title="Phản hồi">
							<span class="glyphicon glyphicon-comment"></span> Phản hồi
						</button>
						<button class="btn btn-primary" title="Chia sẻ">
							<span class="glyphicon glyphicon-share"></span> Chia sẻ
						</button>
						<div class="listen-time float-right">
							<span> <span class="glyphicon glyphicon-headphones" />
								${song.listen }
							</span>
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
					<a href=""><h3 class="title-list-index">VIDEO TUẤN HƯNG</h3></a>
					<div class="row">
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
						<div class="row">
							<div class="col-md-2">
								<img class="avatar"
									src="${pageContext.request.contextPath }/assets/images/${currentAccount.photo }"
									alt="">
							</div>
							<div class="col-md-10">
								<textarea id="comment-box" username="${sessionScope.currentAccount.username }" class="text-command" placeholder="Say something...!"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-primary float-right" id="post-button">POST</button>
							</div>
						</div>
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
						<button class="btn btn-primary full-width" id="show-more-button">Show more</button>
					</div>
				</div>
				<!-- End Binh luan -->
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-md-4">
				<div class="col-md-12 body-right">
					<div class="item-right">
						<h4 class="title-list-index">GỢI Ý BÀI HÁT</h4>
					</div>
					<ul class="list-item">
						<c:forEach items="${suggestedSongs }" var="suggestedSong">
							<li class="item-chart">
								<div class="label-img">
									<img
										src="${pageContext.request.contextPath }/assets/images/imgsong.png"
										class="image-view thumbnail">
								</div>
								<div class="info-chart">
									<c:url var="suggestedSongLink" value="play.html">
										<c:param name="id" value="${suggestedSong.id }" />
									</c:url>
									<a href="${suggestedSongLink }"><b class="song-name-chart">${suggestedSong.name }</b></a><br>
									<a href="${suggestedSongLink }"> <i
										class="singer-name-chart"> <c:forEach
												items="${suggestedSong.songDetails }" var="songDetail"
												varStatus="i">
												${songDetail.singer.name }
												<c:if
													test="${i.index < suggestedSong.songDetails.size() - 1 }">
													,&nbsp;
												</c:if>
											</c:forEach>
									</i>
									</a>
								</div>
								<div class="tool-chart">
									<a class="playlist-btn-sm" href="${suggestedSongLink }"
										title="Nghe"><span class="glyphicon glyphicon-play"></span></a>
									<a class="playlist-btn-sm" href="" title="Thêm vào"><span
										class="glyphicon glyphicon-plus"></span></a> <a
										class="playlist-btn-sm" href="" title="Chia sẻ"><span
										class="glyphicon glyphicon-share"></span></a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</div>
		</div>
		<!-- End Body Right -->
	</div>
</div>
<!--End Body Web-->

<script src="${pageContext.request.contextPath }/assets/js/plyr.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/comment.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/counter.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/pages/play-song.js"></script>
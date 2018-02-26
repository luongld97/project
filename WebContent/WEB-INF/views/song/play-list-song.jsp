<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left  -->
			<div class="col-md-8">
				<!-- Play Song -->
				<div class="col-md-12 body-left">
					<div class="play-song mb-3">
						<img
							src="${pageContext.request.contextPath }/assets/images/chude.png"
							alt="" class="image-view">
						<audio id="audio-player"
							baseUrl="${pageContext.request.contextPath }">
						</audio>
						<ul id="list-song" class="list-item">
							<c:forEach var="song" items="${songs }" varStatus="i">
								<li>
									<div class="pl-playlist-item">
										<div class="col-md-5 play-this-song">
											<input type="hidden" value="${song.id }" name="id" /> <input
												type="hidden" value="${song.link }" name="link" /> <span
												class="playing-song-text-color">${i.index + 1}</span> <span
												class="ml-4 playing-song-text-color">${song.name }</span>
										</div>
										<div class="float-right">
											<a class="playlist-btn-sm" href="" title="Xem MV"><span
												class="glyphicon glyphicon-film"></span></a> <a
												class="playlist-btn-sm" href="" title="Tải về"><span
												class="glyphicon glyphicon-download-alt"></span></a> <a
												class="playlist-btn-sm" href="" title="Thêm vào"><span
												class="glyphicon glyphicon-plus"></span></a> <a
												class="playlist-btn-sm" href="" title="Chia sẻ"><span
												class="glyphicon glyphicon-share"></span></a> <a
												class="playlist-btn-sm" href="" title="Nghe riêng"><span
												class="glyphicon glyphicon-arrow-right"></span></a>
										</div>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
					<div class="btn-tool">
						<button class="btn btn-primary" title="Phản hồi">
							<span class="glyphicon glyphicon-comment"></span> Phản hồi
						</button>
						<button class="btn btn-primary" title="Chia sẻ">
							<span class="glyphicon glyphicon-share"></span> Chia sẻ
						</button>
						<div class="listen-time float-right">
							<span>
								<span class="glyphicon glyphicon-headphones" />
								<b id="listen"></b>
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

				<!-- Album cá nhân -->
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">ALBUM CỦA CÁ NHÂN</h3></a>
					<div class="row mb-2">
						<div class="col-md-3">
							<a href=""><img
								src="${pageContext.request.contextPath }/assets/images/imgalbum.png"
								alt="" class="image-view img-thumbnail mb-1"></a> <br> <a
								href=""><b class="song-name">Play List 1</b></a> <br> <i>
								<a class="singer-name" href="">Masew</a>, <a class="singer-name"
								href="">Đạt G</a>, <a class="singer-name" href="">K-ICM</a>
							</i>
						</div>
						<div class="col-md-3">
							<a href=""><img
								src="${pageContext.request.contextPath }/assets/images/imgalbum2.png"
								alt="" class="image-view img-thumbnail mb-1"></a> <br> <a
								href=""><b class="song-name">Play List 2</b></a> <br> <i>
								<a class="singer-name" href="">Masew</a>, <a class="singer-name"
								href="">Đạt G</a>, <a class="singer-name" href="">K-ICM</a>
							</i>
						</div>
						<div class="col-md-3">
							<a href=""><img
								src="${pageContext.request.contextPath }/assets/images/imgalbum.png"
								alt="" class="image-view img-thumbnail mb-1"></a> <br> <a
								href=""><b class="song-name">Play List 3</b></a> <br> <i>
								<a class="singer-name" href="">Masew</a>, <a class="singer-name"
								href="">Đạt G</a>, <a class="singer-name" href="">K-ICM</a>
							</i>
						</div>
						<div class="col-md-3">
							<a href=""><img
								src="${pageContext.request.contextPath }/assets/images/imgalbum2.png"
								alt="" class="image-view img-thumbnail mb-1"></a> <br> <a
								href=""><b class="song-name">Play List 4</b></a> <br> <i>
								<a class="singer-name" href="">Masew</a>, <a class="singer-name"
								href="">Đạt G</a>, <a class="singer-name" href="">K-ICM</a>
							</i>
						</div>
					</div>
				</div>
				<!-- End Album -->
				<!-- Binh luan -->
				<div class="col-md-12 body-left">
					<h3>BÌNH LUẬN</h3>
					<!-- Nhap binh luan -->
					<div class="margin-top-20">
						<div class="row">
							<div class="col-md-2">
								<img class="avatar"
									src="${pageContext.request.contextPath }/assets/images/imgcasi.png"
									alt="">
							</div>
							<div class="col-md-10">
								<textarea class="text-command"
									placeholder=" Nhập bình luận ở đây"></textarea>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<button class="btn btn-primary float-right">Bình luận</button>
							</div>
						</div>
					</div>
					<!-- End Nhap binh luan -->
					<!-- Xem binh luan -->
					<div class="margin-top-20">
						<ul class="list-item">
							<li class="mb-3">
								<div class="row">
									<div class="col-md-2">
										<img
											src="${pageContext.request.contextPath }/assets/images/imgcasi.png"
											alt="" class="avatar">
									</div>
									<div class="col-md-10">
										<div class="top-read">
											<b>Tân Óc Chó</b> <i class="float-right">00:00:00
												01/01/2018</i>
										</div>
										<div class="text-justify">Đây là bình luận của tôi, đây
											là bình luận của tôi, đây là bình luận của tôi, đây là bình
											luận của tôi, đây là bình luận của tôi, đây là bình luận của
											tôi, đây là bình luận của tôi, đây là bình luận của tôi, đây
											là bình luận của tôi, đây là bình luận của tôi, đây là bình
											luận của tôi.</div>
									</div>
								</div>
							</li>
							<li class="mb-3">
								<div class="row">
									<div class="col-md-2">
										<img
											src="${pageContext.request.contextPath }/assets/images/imgcasi.png"
											alt="" class="avatar">
									</div>
									<div class="col-md-10">
										<div class="top-read">
											<b>Giàu Ngu Người</b> <i class="float-right">00:00:00
												01/01/2018</i>
										</div>
										<div class="text-justify">Đây là bình luận của tôi, đây
											là bình luận của tôi, đây là bình luận của tôi, đây là bình
											luận của tôi, đây là bình luận của tôi, đây là bình luận của
											tôi, đây là bình luận của tôi, đây là bình luận của tôi, đây
											là bình luận của tôi, đây là bình luận của tôi, đây là bình
											luận của tôi.</div>
									</div>
								</div>
							</li>
							<li class="mb-3">
								<div class="row">
									<div class="col-md-2">
										<img
											src="${pageContext.request.contextPath }/assets/images/imgcasi.png"
											alt="" class="avatar">
									</div>
									<div class="col-md-10">
										<div class="top-read">
											<b>Lương Ngáo Đá</b> <i class="float-right">00:00:00
												01/01/2018</i>
										</div>
										<div class="text-justify">Đây là bình luận của tôi, đây
											là bình luận của tôi, đây là bình luận của tôi, đây là bình
											luận của tôi, đây là bình luận của tôi, đây là bình luận của
											tôi, đây là bình luận của tôi, đây là bình luận của tôi, đây
											là bình luận của tôi, đây là bình luận của tôi, đây là bình
											luận của tôi.</div>
									</div>
								</div>
							</li>
						</ul>
					</div>
					<!-- End Xem binh luan -->
					<div class="">
						<button class="btn btn-primary full-width">Xem thêm</button>
					</div>
				</div>
				<!-- End Binh luan -->
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-md-4">
				<div class="col-md-12 body-right">
					<div class="item-right">
						<h4 class="title-list-index">MV TUẤN HƯNG</h4>
					</div>
					<ul class="list-item">
						<li class="item-chart">
							<div class="label-img">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgsong.png"
									class="image-view thumbnail">
							</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Biết Tìm Ai</b></a><br>
								<a href=""><i class="singer-name-chart">Ngá Đáo</i></a>
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
						<li class="item-chart">
							<div class="label-img">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgsong2.png"
									class="image-view thumbnail">
							</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Độc Thoại</b></a><br>
								<a href=""><i class="singer-name-chart">Chiến Đo</i></a>
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
						<li class="item-chart">
							<div class="label-img">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgsong.png"
									class="image-view thumbnail">
							</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Biết Tìm Ai</b></a><br>
								<a href=""><i class="singer-name-chart">Ngá Đáo</i></a>
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
						<li class="item-chart">
							<div class="label-img">
								<img
									src="${pageContext.request.contextPath }/assets/images/imgsong2.png"
									class="image-view thumbnail">
							</div>
							<div class="info-chart">
								<a href=""><b class="song-name-chart">Độc Thoại</b></a><br>
								<a href=""><i class="singer-name-chart">Chiến Đo</i></a>
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
					</ul>
				</div>
				<div class="item-right">
					<h4 class="title-list-index">GỢI Ý BÀI HÁT</h4>
				</div>
				<ul class="list-item">
					<li class="item-chart">
						<div class="label-img">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgsong.png"
								class="image-view thumbnail">
						</div>
						<div class="info-chart">
							<a href=""><b class="song-name-chart">Biết Tìm Ai</b></a><br>
							<a href=""><i class="singer-name-chart">Ngá Đáo</i></a>
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
					<li class="item-chart">
						<div class="label-img">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgsong2.png"
								class="image-view thumbnail">
						</div>
						<div class="info-chart">
							<a href=""><b class="song-name-chart">Độc Thoại</b></a><br>
							<a href=""><i class="singer-name-chart">Chiến Đo</i></a>
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
					<li class="item-chart">
						<div class="label-img">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgsong.png"
								class="image-view thumbnail">
						</div>
						<div class="info-chart">
							<a href=""><b class="song-name-chart">Biết Tìm Ai</b></a><br>
							<a href=""><i class="singer-name-chart">Ngá Đáo</i></a>
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
					<li class="item-chart">
						<div class="label-img">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgsong2.png"
								class="image-view thumbnail">
						</div>
						<div class="info-chart">
							<a href=""><b class="song-name-chart">Độc Thoại</b></a><br>
							<a href=""><i class="singer-name-chart">Chiến Đo</i></a>
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
					<li class="item-chart">
						<div class="label-img">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgsong.png"
								class="image-view thumbnail">
						</div>
						<div class="info-chart">
							<a href=""><b class="song-name-chart">Biết Tìm Ai</b></a><br>
							<a href=""><i class="singer-name-chart">Ngá Đáo</i></a>
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
					<li class="item-chart">
						<div class="label-img">
							<img
								src="${pageContext.request.contextPath }/assets/images/imgsong2.png"
								class="image-view thumbnail">
						</div>
						<div class="info-chart">
							<a href=""><b class="song-name-chart">Độc Thoại</b></a><br>
							<a href=""><i class="singer-name-chart">Chiến Đo</i></a>
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
				</ul>

			</div>
		</div>
		<!-- End Body Right -->
	</div>
</div>
<!--End Body Web-->
<script src="${pageContext.request.contextPath }/assets/js/plyr.js"></script>
<script src="${pageContext.request.contextPath }/assets/js/counter.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/js/pages/play-list-song.js"></script>
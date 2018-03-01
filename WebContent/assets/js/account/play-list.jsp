<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left  -->
			<div class="col-md-3 mb-10">
				<div class="row mt-2">
					<div class="col-md-3 pr-0">
						<img src="${pageContext.request.contextPath }/assets/images/imgcasi.png" class="img-circle image-view" alt="">
					</div>
					<div class="col-md-9">
						<div class="mt-1">
							<strong>Username</strong>
						</div>
					</div>
				</div>
				<hr>
				<ul class="list-item ul-playlist">
					<b>YÊU THÍCH</b>
					<li><a href="">Playlist<span class="float-right">(0)</span></a></li>
					<li><a href="">Bài hát<span class="float-right">(0)</span></a></li>
					<li><a href="">Video<span class="float-right">(0)</span></a></li>
				</ul>
				<hr>
				<a href="" class="a-playlist"><b class="pl-selected">PLAYLIST
						CÁ NHÂN</b></a>
				<hr>
				<ul class="list-item ul-playlist">
					<b>NGHE GẦN ĐÂY</b>
					<li><a href="">Playlist<span class="float-right">(0)</span></a></li>
					<li><a href="">Bài hát<span class="float-right">(0)</span></a></li>
					<li><a href="">Video<span class="float-right">(0)</span></a></li>
				</ul>
				<hr>
				<ul class="list-item ul-playlist">
					<b>QUAN TÂM</b>
					<li><a href="">Nghệ sĩ<span class="float-right">(0)</span></a></li>
				</ul>
				<hr>
				<a href="" class="a-playlist"><b>NHẠC UPLOAD</b></a>
				<hr>
				<a href="" class="a-playlist"><b>KÊNH CỦA TÔI</b></a>
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-md-9">
				<h2 class="pl-title-top">${sessionScope.currentAccount.username.toUpperCase() }' S PLAY LIST</h2>
				<hr>
				<div class="mb-2">
					<a href="" class="pl-new-playlist"><span
						class="glyphicon glyphicon-film"></span>Create new play list</a>
				</div>
				<jsp:useBean id="playLists" scope="request" type="org.springframework.beans.support.PagedListHolder" />
				<c:url value="account/playlist.html" var="pagedLink">
					<c:param name="page" value="~" />
				</c:url>
				<ul class="list-item">
				<c:forEach var="playList" items="${playLists.pageList }">
					<li class="pl-my-playlist">
						<c:url var="playListLink" value="../song/playlist.html">
							<c:param name="id" value="${playList.id }" />
						</c:url>
						<div class="pl-avatar-img float-left">
							<a href="${playListLink }"><img src="${pageContext.request.contextPath }/assets/images/${playList.photo }" alt="Avatar"
								class="image-view img-thumbnail"></a>
						</div>
						<div class="pl-info float-left">
							<span class="playlist-name">
								<a href="${playListLink }">
									${playList.name.toUpperCase() }	
								</a>
							</span>
							<br>
							<span class="playlist-create-time">
								Created: ${playList.createdTime }
							</span>
						</div>
						<div class="pl-number-song">
							<span class="number-song">Songs: ${playList.playListDetails.size() }</span>
						</div>
						<div class="pl-tool">
							<a class="playlist-btn" href="" title="Sửa playlist"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
								class="playlist-btn" href="" title="Xóa playlist"><span
								class="glyphicon glyphicon-remove"></span></a>
						</div>
					</li>
				</c:forEach>
					<%-- <li class="pl-my-playlist">
						<div class="pl-avatar-img float-left">
							<a href=""><img src="${pageContext.request.contextPath }/assets/images/imgcasi.png" alt="Avatar"
								class="image-view img-thumbnail"></a>
						</div>
						<div class="pl-info float-left">
							<span class="playlist-name">
								<a href="playlist.html">
									Playlist	1
								</a>
							</span>
							<br>
							<span class="playlist-create-time">
								Ngày tạo: 8:02 sáng hôm qua
							</span>
							<br>
							<span class="playlist-listen-time">
								Lượt nghe: 0
							</span>
						</div>
						<div class="pl-number-song">
							<span class="number-song">Số bài hát: 1</span>
						</div>
						<div class="pl-tool">
							<a class="playlist-btn" href="" title="Sửa playlist"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
								class="playlist-btn" href="" title="Xóa playlist"><span
								class="glyphicon glyphicon-remove"></span></a>
						</div>
					</li> --%>
				</ul>
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<!--End Body Web-->
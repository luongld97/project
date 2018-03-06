<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<a href="${suggestedSongLink }"> <i class="singer-name-chart">
						<c:forEach items="${suggestedSong.songDetails }" var="songDetail"
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
				<a class="playlist-btn-sm" href="${suggestedSongLink }" title="Nghe"><span
					class="glyphicon glyphicon-play"></span></a> <a class="playlist-btn-sm"
					onclick="addToClick('${suggestedSong.id}');"
					href="#modalAddPlaylist" title="Add to..." data-toggle="modal"><span
					class="glyphicon glyphicon-plus"></span></a>
			</div>
		</li>
	</c:forEach>
</ul>

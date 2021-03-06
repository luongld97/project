<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="item-right">
	<h4 class="color-purple">SONG RECOMMENDS</h4>
</div>
<ul class="list-item">
	<c:forEach items="${suggestedSongs }" varStatus="i" var="suggestedSong">
		<li class="item-chart">
			<div class="label-img text-right">
				${i.index +1 }
			</div>
			<div class="info-chart">
				<c:url var="suggestedSongLink" value="/song/play.html">
					<c:param name="id" value="${suggestedSong.id }" />
				</c:url>
				<a href="${suggestedSongLink }"><b class="song-name-chart">${suggestedSong.name }</b></a><br>
				<i class="singer-name-chart">
						<c:forEach items="${suggestedSong.songDetails }" var="songDetail"
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
				<a class="playlist-btn-sm" href="${suggestedSongLink }" title="Nghe"><span
					class="glyphicon glyphicon-play"></span></a> <a class="playlist-btn-sm"
					onclick="addToClick('${suggestedSong.id}');"
					href="#modal-add-play-list" title="Add to..." data-toggle="modal"><span
					class="glyphicon glyphicon-plus"></span></a>
			</div>
		</li>
	</c:forEach>
</ul>

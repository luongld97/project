<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<!-- Body Left -->
			<div class="col-md-9">
				<div class="col-md-12 body-left">
				
					<div class="row">
						<div class="col-xs-10 col-md-10">
							<h3 class="color-purple">${singer.name.toUpperCase() }'S
								SONG</h3>
							<c:url var="playTopSongs" value="/artist/singer/play-list.html">
								<c:param name="id" value="${singer.id }" />
							</c:url>
						</div>
						<div class="col-xs-2 col-md-2">
							<div class="artist-play-all-btn text-right">
								<a href="${playTopSongs }" title="Play all"><h3>
										<span class="glyphicon glyphicon-play-circle pr-1-5" />
									</h3> </a>
							</div>
						</div>
					</div>
					
					<ul class="list-item">
						<jsp:useBean id="songs" scope="request"
							type="org.springframework.beans.support.PagedListHolder" />
						<c:url value="/artist/singer/song.html" var="pagedLink">
							<c:param name="page" value="~" />
							<c:param name="id" value="1" />
						</c:url>
						<c:forEach var="song" items="${songs.pageList }">
							<li>
								<div class="artics-listsong-item artics-listsong-item-boder-top">
									<div class="row">
										<div class="col-md-9">
											<c:url var="songLink" value="/song/play.html">
												<c:param name="id" value="${song.id }" />
											</c:url>
											<a href="${songLink }" class="linksong">${song.name }</a> - 
											<span>
												<c:forEach items="${song.songDetails }" var="songDetail"
													varStatus="i">
													<c:url var="singerLink" value="/artist/singer/info.html">
														<c:param name="id" value="${songDetail.singer.id }" />
													</c:url>
													<a class="text-view-more" href="${singerLink }">${songDetail.singer.name }</a>
													<c:if test="${i.index < song.songDetails.size() - 1 }">
														,&nbsp;
													</c:if>
												</c:forEach>
											</span>
										</div>
										<div class="col-md-3">
											<div class="float-right">
												<a
													class="playlist-btn-sm" href="" title="Add to your playlist"><span
													class="glyphicon glyphicon-plus"></span></a>
											</div>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css">
						</c:forEach>
					</ul>
					<!-- Moi trang 12 bai hat duoc khong?  -->
					<!-- Khu vuc phan trang, tao ko biet lam, may tu lam di :) -->
					<div class="text-center">
						<tg:paging pagedListHolder="${songs}" pagedLink="${pagedLink}" />
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
<!--End Body Web-->
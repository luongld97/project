<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<!-- Body Left -->
			<div class="col-md-9">
				<div class="col-md-12 body-left">
					<h3 class="color-purple">${singer.name.toUpperCase()}'SALBUM</h3>

					<jsp:useBean id="albums" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<c:url value="/artist/singer/album.html" var="pagedLink">
						<c:param name="page" value="~" />
						<c:param name="id" value="1" />
					</c:url>

					<c:if test="${albums.pageList.size() / 4 - 1 >= 0 }">
						<c:forEach begin="0" end="${albums.pageList.size() / 4 - 1 }"
							var="i">
							<div class="row">
								<c:forEach begin="${temp }" end="${temp + 3 }" var="j">
									<c:set var="album" value="${albums.pageList[j] }" />
									<div class="col-xs-3 col-md-3">
										<div class="my-img-150">
											<a href=""><img
												src="${pageContext.request.contextPath }/assets/images/${album.photo }"
												alt="Album background" class="image-view img-thumbnail mb-1" /></a>
										</div>
										<br>
										<c:url var="playAlbum" value="/album/play.html">
											<c:param name="id" value="${album.id }" />
										</c:url>
										<a href="${playAlbum }"> <b class="song-name">${album.name }</b>
										</a> <br> <i> <span> <c:forEach
													items="${album.albumSingers }" var="albumSinger"
													varStatus="k">
													<c:url var="singerLink" value="/artist/singer/info.html">
														<c:param name="id" value="${albumSinger.singer.id }" />
													</c:url>
													<a href="${singerLink }">${songDetail.singer.name }</a>
													<c:if test="${k.index < song.songDetails.size() - 1 }">
																,&nbsp;
															</c:if>
												</c:forEach>
										</span>
										</i>
									</div>
								</c:forEach>

							</div>
							<c:set var="temp" value="${(i + 1) * 4 }" />
						</c:forEach>
					</c:if>
					<div class="row">
						<c:forEach begin="${temp }" end="${temp + 3 }" var="j">
							<c:set var="album" value="${albums.pageList[j] }" />
							<div class="col-xs-3 col-md-3">
								<div class="my-img-150">
									<a href=""><img
										src="${pageContext.request.contextPath }/assets/images/${album.photo }"
										alt="Album background" class="image-view img-thumbnail mb-1" /></a>
								</div>
								<br>
								<c:url var="playAlbum" value="/album/play.html">
									<c:param name="id" value="${album.id }" />
								</c:url>
								<a href="${playAlbum }"> <b class="song-name">${album.name }</b>
								</a> <br> <i> <span> <c:forEach
											items="${album.albumSingers }" var="albumSinger"
											varStatus="k">
											<c:url var="singerLink" value="/artist/singer/info.html">
												<c:param name="id" value="${albumSinger.singer.id }" />
											</c:url>
											<a href="${singerLink }">${songDetail.singer.name }</a>
											<c:if test="${k.index < song.songDetails.size() - 1 }">
																,&nbsp;
															</c:if>
										</c:forEach>
								</span>
								</i>
							</div>
						</c:forEach>

					</div>

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
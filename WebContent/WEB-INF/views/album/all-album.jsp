<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<jsp:useBean id="albums" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/album/index.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<h1 class="color-purple">ALL ALBUMS</h1>
		<c:set var="temp" value="0" />
		<c:if test="${albums.pageList.size() / 4 - 1 >= 0 }">
			<c:forEach begin="0" end="${albums.pageList.size() / 4 - 1 }" var="i">
				<div class="row">
					<c:forEach begin="${temp }" end="${temp + 3 }" var="j">
						<c:set var="album" value="${albums.pageList[j] }" />
						<div class="col-xs-3 col-md-3">
							<c:url var="playAlbum" value="/album/play.html">
								<c:param name="id" value="${album.id }" />
							</c:url>
							<div class="my-img-180 mt-2">
								<a href="${playAlbum }"> <img
									src="${pageContext.request.contextPath }/assets/images/${album.photo }"
									alt="Album background" class="img-thumbnail image-view">
								</a>
							</div>
							<br> <a href="${playAlbum }"> <b>${album.name }</b>
							</a> <br> <i> <c:forEach items="${album.albumSingers }"
									var="albumSinger" varStatus="j">
									<c:url var="singerLink" value="/artist/singer/info.html">
										<c:param name="id" value="${albumSinger.singer.id }" />
									</c:url>
									<a href="${singerLink }">${albumSinger.singer.name }</a>
									<c:if test="${j.index < album.albumSingers.size() - 1 }">
													,&nbsp;
												</c:if>
								</c:forEach>
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
					<c:url var="playAlbum" value="/album/play.html">
						<c:param name="id" value="${album.id }" />
					</c:url>
					<div class="my-img-180 mt-2">
						<a href="${playAlbum }"> <img
							src="${pageContext.request.contextPath }/assets/images/${album.photo }"
							alt="Album background" class="img-thumbnail image-view">
						</a>
					</div>
					<br> <a href="${playAlbum }"> <b>${album.name }</b>
					</a> <br> <i> <c:forEach items="${album.albumSingers }"
							var="albumSinger" varStatus="j">
							<c:url var="singerLink" value="/artist/singer/info.html">
								<c:param name="id" value="${albumSinger.singer.id }" />
							</c:url>
							<a href="${singerLink }">${albumSinger.singer.name }</a>
							<c:if test="${j.index < album.albumSingers.size() - 1 }">
													,&nbsp;
												</c:if>
						</c:forEach>
					</i>

				</div>
			</c:forEach>

		</div>
		<div class="text-center">
			<tg:paging pagedListHolder="${albums}" pagedLink="${pagedLink}" />
		</div>
	</div>
</div>
<!--End Body Web-->
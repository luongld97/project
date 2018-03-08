<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<jsp:useBean id="videos" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/home/video.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<h1 class="color-purple">ALL VIDEOS</h1>
		<c:set var="temp" value="0" />
		<c:if test="${videos.pageList.size() / 4 - 1 >= 0 }">
			<c:forEach begin="0" end="${videos.pageList.size() / 4 - 1 }" var="i">
				<div class="row">
					<c:forEach begin="${temp }" end="${temp + 3 }" var="j">
						<c:set var="video" value="${videos.pageList[j] }" />
						<div class="col-xs-3 col-md-3">
							<c:url var="playVideo" value="/song/play.html?video">
								<c:param name="id" value="${video.id }" />
							</c:url>
							<div class="my-img-180 mt-2">
								<a href="${playVideo }"> <img
									src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto }"
									alt="Video background" class="image-view img-thumbnail">
								</a>
							</div>
							<br> <a href="${playVideo }"> <b>${video.name }</b>
							</a> <br> <i> <c:forEach items="${video.songDetails }"
									var="songDetail" varStatus="j">
									<c:url var="singerLink" value="/artist/singer/info.html">
										<c:param name="id" value="${songDetail.singer.id }" />
									</c:url>
									<a href="${singerLink }">${songDetail.singer.name }</a>
									<c:if test="${j.index < video.songDetails.size() - 1 }">
													,&nbsp;
												</c:if>
								</c:forEach>
							</i> <br>
						</div>
					</c:forEach>
				</div>
				<c:set var="temp" value="${(i + 1) * 4 }" />

			</c:forEach>
		</c:if>
		<div class="row">
			<c:forEach begin="${temp }" end="${ videos.pageList.size() - 1}"
				var="j">
				<c:set var="video" value="${videos.pageList[j] }" />
				<div class="col-xs-3 col-md-3">

					<c:url var="playVideo" value="/song/play.html?video">
						<c:param name="id" value="${video.id }" />
					</c:url>
					<div class="my-img-180 mt-2">
						<a href="${playVideo }"> <img
							src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto }"
							alt="Video background" class="image-view img-thumbnail">
						</a>
					</div>
					<br> <a href="${playVideo }"> <b>${video.name }</b>
					</a> <br> <i> <c:forEach items="${video.songDetails }"
							var="songDetail" varStatus="j">
							<c:url var="singerLink" value="/artist/singer/info.html">
								<c:param name="id" value="${songDetail.singer.id }" />
							</c:url>
							<a href="${singerLink }">${songDetail.singer.name }</a>
							<c:if test="${j.index < video.songDetails.size() - 1 }">
													,&nbsp;
												</c:if>
						</c:forEach>
					</i> <br>

				</div>
			</c:forEach>
		</div>
		<div class="text-center">
			<tg:paging pagedListHolder="${videos}" pagedLink="${pagedLink}" />
		</div>
	</div>
</div>
<!--End Body Web-->
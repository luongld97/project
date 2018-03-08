<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<jsp:useBean id="result" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/home/search.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<c:set var="songs" value="<%=new ArrayList<>()%>" />
<c:set var="videos" value="<%=new ArrayList<>()%>" />
<c:set var="singers" value="<%=new ArrayList<>()%>" />
<c:forEach var="obj" items="${result.pageList }">
	<c:if test="${obj.getClass().simpleName == 'Singer' }">
		<c:set var="temp" value="${singers.add(obj) }" />
	</c:if>
	<c:if test="${obj.getClass().simpleName == 'Song' && !obj.video}">
		<c:set var="temp" value="${songs.add(obj) }" />
	</c:if>
	<c:if test="${obj.getClass().simpleName == 'Song' && obj.video }">
		<c:set var="temp" value="${videos.add(obj) }" />
	</c:if>
</c:forEach>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left -->
			<div class="col-xs-9 col-md-9">
				<c:if test="${songs.size() > 0 }">
					<!-- Search Song Result -->
					<h3 class="color-purple mb-2">SONG</h3>
					<c:forEach var="song" items="${songs }">
						<c:url var="playSong" value="/song/play.html">
							<c:param name="id" value="${song.id }" />
						</c:url>
						<div class="row">
							<div class="col-xs-9 col-md-9">
								<a href="${playSong }" class="linksong"> ${song.name } </a> -
								<c:forEach items="${song.songDetails }" var="songDetail"
									varStatus="i">
									<c:url var="singerLink" value="/artist/singer/info.html">
										<c:param name="id" value="${songDetail.singer.id }" />
									</c:url>
									<a href="${singerLink }"> ${songDetail.singer.name } </a>
									<c:if test="${i.index < song.songDetails.size() - 1 }">
											,&nbsp;
										</c:if>
								</c:forEach>
							</div>
						</div>
						<hr class="hr-css1">
					</c:forEach>
					<!-- End Search Song -->
				</c:if>
				<c:if test="${videos.size() > 0 }">
					<!-- Search Video Result -->
					<h3 class="color-purple mt-3 mb-2">VIDEO</h3>
					<c:forEach begin="0" end="1" var="i">
						<c:set var="temp" value="${i % 2 }" />
						<c:if test="${temp == 1 }">
							<div class="row mb-3">
								<c:forEach items="${videos }" var="video">
									<c:if test="${temp == 1 }">
										<div class="col-xs-6 col-md-6">
											<div class="row">
												<div class="col-xs-4 col-md-4">
													<div class="my-img-120">
														<c:url var="playVideo" value="/song/play.html?video">
															<c:param name="id" value="${video.id }" />
														</c:url>
														<a href="${playVideo }"> <img
															src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto }"
															class="img-thumbnail image-view" alt="Video background">
														</a>
													</div>
												</div>
												<div class="col-xs-8 col-md-8">
													<a href="${playVideo }" class="song-name2"> <b>${video.name }</b>
													</a> <br> <span> <c:forEach
															items="${video.songDetails }" var="songDetail"
															varStatus="i">
															<c:url var="singerLink" value="/artist/singer/info.html">
																<c:param name="id" value="${songDetail.singer.id }" />
															</c:url>
															<span> <a href="${singerLink }">
																	${songDetail.singer.name } </a> <c:if
																	test="${i.index < video.songDetails.size() - 1 }">
																		,&nbsp;
																	</c:if>
															</span>
														</c:forEach>
													</span> <br>
												</div>
											</div>
										</div>
									</c:if>
								</c:forEach>
							</div>
						</c:if>
					</c:forEach>
					<!-- End Video -->
					<hr class="hr-css">
				</c:if>
				<c:if test="${singers.size() > 0 }">
					<!-- Search Singer Result -->
					<h3 class="color-purple mt-3 mb-2">SINGER</h3>
					<c:forEach begin="0" end="1" var="i">
						<c:set var="temp" value="${i % 2 }" />
						<c:if test="${temp == 1 }">
							<div class="row mb-3">
								<c:forEach items="${singers }" var="singer">
									<div class="col-xs-6 col-md-6">
										<div class="row">
											<c:url var="singerLink" value="/artist/singer/info.html">
												<c:param name="id" value="${singer.id }" />
											</c:url>
											<div class="col-xs-4 col-md-4">
												<div class="my-img-120">
													<a href="${singerLink }"> <img
														src="${pageContext.request.contextPath }/assets/images/${singer.photo }"
														class="img-thumbnail image-view" alt="Avatar">
													</a>
												</div>
											</div>
											<div class="col-xs-8 col-md-8">
												<a href="${singerLink }" class="song-name2"> <b>${singer.name }</b>
												</a>
												<p>${fn:substring(singer.description, 0, 135) }...</p>
											</div>
										</div>
									</div>
								</c:forEach>
							</div>
						</c:if>
					</c:forEach>

					<!-- End Singer -->
				</c:if>
				<div class="text-center mb-3 mt-3">
					<tg:paging pagedListHolder="${result}" pagedLink="${pagedLink}" />
				</div>
			</div>
			<!-- End Body Left -->
			<!-- Body Right -->
			<div class="col-xs-3 col-md-3"></div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<!--End Body Web-->


<!--End Body Web-->

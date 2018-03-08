<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<div class="col-md-9">
				<div class="col-md-12 body-left">

					<h3 class="color-purple">${singer.name.toUpperCase()}'SVIDEO</h3>

					<jsp:useBean id="songs" scope="request"
						type="org.springframework.beans.support.PagedListHolder" />
					<c:url value="/artist/singer/video.html" var="pagedLink">
						<c:param name="page" value="~" />
						<c:param name="id" value="1" />
					</c:url>

					<c:set var="temp" value="0" />
					<c:if test="${songs.pageList.size() / 4 - 1 >= 0 }">
						<c:forEach begin="0" end="${songs.pageList.size() / 4 - 1 }"
							var="i">
							<div class="row">
								<c:forEach begin="${temp }" end="${temp + 3 }" var="j">
									<c:set var="song" value="${songs.pageList[j] }" />
									<div class="col-xs-3 col-md-3">
										<div class="my-img-180">
											<a href=""><img
												src="${pageContext.request.contextPath }/assets/images/${song.videoPhoto}"
												alt="Video background" class="image-view img-thumbnail" /></a>
										</div>
										<br> <a class="song-name" href="">${song.name }</a> <br>
										<i> <span> <c:forEach items="${song.songDetails }"
													var="songDetail" varStatus="k">
													<c:url var="singerLink" value="/artist/singer/info.html">
														<c:param name="id" value="${songDetail.singer.id }" />
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
						<c:forEach begin="${temp }" end="${ songs.pageList.size() - 1}"
							var="j">
							<c:set var="song" value="${songs.pageList[j] }" />
							<div class="col-xs-3 col-md-3">
								<div class="my-img-150">
									<img
										src="${pageContext.request.contextPath }/assets/images/${song.videoPhoto}"
										alt="Video background" class="image-view img-thumbnail">
								</div>
								<br> <a class="song-name" href="">${song.name }</a> <br>
								<i> <span> <c:forEach items="${song.songDetails }"
											var="songDetail" varStatus="k">
											<c:url var="singerLink" value="/artist/singer/info.html">
												<c:param name="id" value="${songDetail.singer.id }" />
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
			<div class="col-md-4"></div>
		</div>
	</div>
</div>
<!--End Body Web-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>

<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<div class="col-md-9">
				<div class="col-md-12 body-left">
					<a href=""><h3 class="title-list-index">${singer.name.toUpperCase() }' S VIDEO</h3></a> <a
						class="artic-play-all-btn" href="" title="Phát tất cả"><span
						class="glyphicon glyphicon-play-circle"></span></a>
		<!-- 			<div class="sort-song">
						<span>Sắp xếp theo: </span> <a href=""><span>Mới nhất</span></a> |
						<a href=""><span>Lượt nghe</span></a>
					</div> -->
						<jsp:useBean id="songs" scope="request"
							type="org.springframework.beans.support.PagedListHolder" />
						<c:url value="/artist/singer/video.html" var="pagedLink">
							<c:param name="page" value="~" />
							<c:param name="id" value="1" />
						</c:url>
						<c:forEach begin="0" end="3" var="i">
							<c:set var="temp" value="${i % 4 }" />
							<c:if test="${temp == 3 }">
								<div class="row mb-2">
									<c:forEach items="${songs.pageList }" var="song" varStatus="j">
										<c:if test="${temp == 3 }">
											<div class="col-xs-3 col-md-3">
												<img src="${pageContext.request.contextPath }/assets/images/imgvideo.png" alt=""
													class="image-view img-thumbnail mb-1"> <br> <a
													href=""><b class="song-name">${song.name }</b></a> <br> <i>
													<span>
														<c:forEach items="${song.songDetails }" var="songDetail"
															varStatus="i">
															<c:url var="singerLink" value="/artist/singer/info.html">
																<c:param name="id" value="${songDetail.singer.id }" />
															</c:url>
															<a href="${singerLink }">${songDetail.singer.name }</a>
															<c:if test="${i.index < song.songDetails.size() - 1 }">
																,&nbsp;
															</c:if>
														</c:forEach>
													</span>
												</i>
											</div>
										</c:if>
									</c:forEach>	
								</div>
							</c:if>
						</c:forEach>
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
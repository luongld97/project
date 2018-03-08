<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<jsp:useBean id="playLists" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/account/playlist.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<tiles:insertDefinition name="play.list.body.left" />
			<!-- Body Right -->
			<div class="col-xs-9 col-md-9">
				<h2 class="pl-title-top">PERSONAL PLAY LIST</h2>
				<hr>
				<div class="mb-2">
					<a href="newplaylist.html" class="pl-new-playlist"><span
						class="glyphicon glyphicon-film"></span>New play list</a>
				</div>
				<c:forEach var="playList" items="${playLists.pageList }">
					<div class="row">
						<div class="col-xs-3 col-md-3">
							<a href=""><img
								src="${pageContext.request.contextPath }/assets/images/${playList.photo }"
								class="image-view img-thumbnail"></a>
						</div>
						<div class="col-xs-6 col-md-6 playlist-content-info mt-1">
							<p>
								<c:url var="playListDetailLink"
									value="/account/playlist/detail.html">
									<c:param name="id" value="${playList.id }" />
								</c:url>
								<a href="${playListDetailLink }">${playList.name }</a>
							</p>
							<span> Created: <fmt:formatDate
									value="${playList.createdTime }" pattern="yyyy-MM-dd HH:mm:ss" />
							</span> <br> <span>Song: ${playList.playListDetails.size() }</span>
						</div>
						<div class="col-xs-3 col-md-3 mt-4">
							<a class="playlist-btn" href="" title="update"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
								class="playlist-btn" href="" title="delete"><span
								class="glyphicon glyphicon-remove"></span></a>
						</div>
					</div>
					<hr class="hr-css1">
				</c:forEach>
				<div class="text-center mb-3 mt-3">
					<tg:paging pagedListHolder="${playLists}" pagedLink="${pagedLink}" />
				</div>
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<!--End Body Web-->
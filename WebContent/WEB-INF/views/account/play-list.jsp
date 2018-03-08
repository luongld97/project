<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
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
				<h2 class="color-purple">PERSONAL PLAY LIST</h2>
				<hr>
				<div class="mb-2">
					<a href="#create-play-list-modal" data-toggle="modal"
						class="pl-new-playlist"><span class="glyphicon glyphicon-film"></span>New
						play list</a>
				</div>
				<c:forEach var="playList" items="${playLists.pageList }">
					<div class="row">
						<div class="col-xs-4 col-md-4">
							<div class="my-img-120">
								<a href=""><img
									src="${pageContext.request.contextPath }/assets/images/${playList.photo }"
									class="image-view img-thumbnail" alt="Playlist background"></a>
							</div>
						</div>
						<div class="col-xs-5 col-md-5 playlist-content-info mt-1">
							<p>
								<c:url var="playThisList" value="/song/playlist.html">
									<c:param name="id" value="${playList.id }" />
								</c:url>
								<a href="${playThisList }">${playList.name }</a>
							</p>
							<span> Created: <fmt:formatDate
									value="${playList.createdTime }" pattern="yyyy-MM-dd" />
							</span> <br> <span>Song: ${playList.playListDetails.size() }</span>
						</div>
						<div class="col-xs-3 col-md-3 mt-4">
							<c:url var="updatePlayList" value="/account/playlist/update.html">
								<c:param name="id" value="${playList.id }" />
							</c:url>
							<c:url var="deletePlayList" value="/account/playlist/delete.html">
								<c:param name="id" value="${playList.id }" />
							</c:url>
							<a class="playlist-btn" href="${updatePlayList }" title="update"><span
								class="glyphicon glyphicon-pencil"></span></a> <a
								class="playlist-btn" href="${deletePlayList }"
								onclick="return confirm('Are you sure?');" title="delete"><span
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
<!-- Form Add To Playlist -->
<div class="modal fade" id="create-play-list-modal" tabindex="-1"
	role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
				<h4 class="modal-title" id="myModalLabel">Create Playlist</h4>
			</div>
			<div class="modal-body">
				<span id="name-box-error" style="display: block;"
					class="alert alert-danger hidden"></span>
				<div id="add-form">
					<div class="form-group">
						<label>PlayList Name: </label> <input id="play-list-name"
							class="form-control" type="text" />
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button class="btn btn-default" data-dismiss="modal">Close</button>
				<button onclick="quickAdd();" class="btn btn-primary">Add</button>
			</div>
		</div>
	</div>
</div>
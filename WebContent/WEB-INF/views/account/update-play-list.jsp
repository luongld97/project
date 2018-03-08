<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%><%@ taglib
	prefix="tg" tagdir="/WEB-INF/tags"%>
<jsp:useBean id="songs" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/account/playlist/update.html" var="pagedLink">
	<c:param name="id" value="${playList.id }" />
	<c:param name="page" value="~" />
</c:url>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<tiles:insertDefinition name="play.list.body.left" />
			<!-- Body Right -->
			<div class="col-md-9">
				<div class="row mt-4">
					<div class="col-xs-4 col-md-4">
						<div class="my-img-120">
							<img
								src="${pageContext.request.contextPath }/assets/images/${playList.photo }"
								class="img-thumbnail image-view" alt="Playlist background">
						</div>
					</div>
					<div class="col-xs-8 col-md-8">
						<c:url var="postLink" value="/account/playlist/update.html" />
						<s:form cssClass="form-horizontal" commandName="playList"
							action="${postLink }" method="post" enctype="multipart/form-data">
							<s:hidden path="id" />
							<div class="form-group">
								<label class="col-sm-4 control-label">Name:</label>
								<div class="col-sm-8">
									<s:input path="name" cssClass="form-control" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4"></label>
								<div class="col-sm-8 checkbox">
									<label> <input type="checkbox"
										${fileTypeError != null ? 'checked' : '' } /> Change
										background ?
									</label>
								</div>
							</div>
							<div class="form-group" id="image-form"
								style="display: ${fileTypeError != null ? 'block': 'none'};">
								<label class="col-sm-4"></label>
								<div class="col-sm-8">
									<span
										class="sm-alert alert-danger ${fileTypeError != null ? '' : 'hidden' }"
										style="display: block;">${fileTypeError
										}</span> <input
										type="file" name="albumPhoto" accept="image/*" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4"></label>
								<div class="col-sm-8 text-right">
									<button type="submit" class="btn btn-success">&nbsp;Save&nbsp;</button>
								</div>
							</div>
						</s:form>
					</div>
				</div>
				<c:if test="${songs.pageList.size() > 0 }">
					<h2 class="title-list-index mt-3">List song</h2>
					<div class="row mt-2">
						<div class="col-xs-12 col-md-12">
							<c:forEach items="${songs.pageList }" var="song" varStatus="i">
								<div class="row">
									<div class="col-xs-9 col-md-9 edit-playlist-song-name">
										<span><c:if test="${i.index < 9}">0${i.index + 1 }</c:if>
											<c:if test="${i.index >= 9}">${i.index + 1 }</c:if>. <c:url
												var="songLink" value="/song/play.html">
												<c:param name="id" value="${song.id }" />
											</c:url> <a href="${songLink }">${song.name }</a></span>
									</div>
									<div class="col-xs-3 col-md-3">
										<div class="text-right">
											<a class="playlist-btn-nm"
												onclick="deleteSongInPlayList('${pageContext.request.contextPath}', '${playList.id }', '${song.id }')"
												title="Delete song"><span
												class="glyphicon glyphicon-remove"></span></a>
										</div>
									</div>
								</div>
								<hr class="hr-css1">
							</c:forEach>
						</div>
						<div class="col-xs-12 col-md-12">
							<tg:paging pagedListHolder="${songs}" pagedLink="${pagedLink}" />
						</div>
					</div>
				</c:if>
				<c:if test="${songs.pageList.size() <= 0}">
					<div class="row mt-2 text-center">
						<h3>No have song in this play list!</h3>
					</div>
				</c:if>
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/pages/update-play-list.js">
	
</script>
<!--End Body Web-->
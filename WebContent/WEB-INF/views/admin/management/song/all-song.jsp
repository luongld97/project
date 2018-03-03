<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-song" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath }/admin/song/addsong.html"
				class="btn btn-primary" style="height: 46px; line-height: 32px;">
				NEW SONG </a>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<div class="input-group">
					<input class="form-control" placeholder="Enter song name!"
						id="search-box" baseUrl="${pageContext.request.contextPath }"
						requestUrl="/api/song/search"
						targetUrl="/admin/song/updatesong.html" />
					<div class="input-group-addon">
						<span class="input-group-text"><span
							class="glyphicon glyphicon-search"></span></span>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-3"></div>
	</div>
	<div class="panel-body">
		<jsp:useBean id="songs" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/song/allsong.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered text-center">
			<thead class="text-center">
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center"><b>Name</b></th>
					<th class="text-center"><b>Link</b></th>
					<th class="text-center"><b>Lyric</b></th>
					<th class="text-center"><b>Listen</b></th>
					<th class="text-center"><b>Show</b></th>
					<th class="text-center"><b>Video</b></th>
					<th class="text-center"><b>Uploaded</b></th>
					<th class="text-center"><b>Uploaded by</b></th>
					<th class="text-center" width="8%"><b>Options</b></th>
				</tr>
			</thead>
			<c:if test="${songs.pageList.size() > 0 }">
				<tbody>
					<c:forEach var="song" items="${songs.pageList }">
						<tr>
							<td>${song.id }</td>
							<td>${song.name }</td>
							<td>${song.link }</td>
							<td><div style="max-height: 100px; overflow: auto;">${song.lyric }</div></td>
							<td>${song.listen }</td>
							<td>${song.show }</td>
							<td>${song.video }</td>
							<td>${song.uploadedTime }</td>
							<td>${song.uploadedBy }</td>
							<c:url var="updateLink" value="/admin/song/updatesong.html">
								<c:param name="id" value="${song.id }" />
							</c:url>
							<c:url var="statusLink" value="/admin/song/changestatus.html">
								<c:param name="id" value="${song.id }" />
							</c:url>
							<td><a href="${updateLink }">Edit</a> &nbsp; <a
								href="${statusLink }"> <c:if test="${song.status }">
											Hide
										</c:if> <c:if test="${!song.status }">
											Show
										</c:if>
							</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${songs.pageList.size() == 0 }">
				<tr>
					<td class="text-center" colspan="7"><b>No song in your
							system!</b></td>
				</tr>
			</c:if>
		</table>
		<tg:paging pagedListHolder="${songs}" pagedLink="${pagedLink}" />
	</div>
</div>

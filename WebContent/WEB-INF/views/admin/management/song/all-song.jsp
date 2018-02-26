<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-song" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<a href="${pageContext.request.contextPath }/admin/song/addsong.html" class="btn btn-primary">
			NEW SONG
		</a>
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
					<th><b>Options</b></th>
				</tr>
			</thead>
			<c:if test="${songs.pageList.size() > 0 }">
				<tbody>
					<c:forEach var="song" items="${songs.pageList }">
						<tr>
							<td>${song.id }</td>
							<td>${song.name }</td>
							<td>${song.link }</td>
							<td>${song.lyric }</td>
							<td>${song.listen }</td>
							<td>${song.show }</td>
							<td>${song.video }</td>
							<td>${song.uploadedTime }</td>
							<td>${song.uploadedBy }</td>
							<c:url var="updateLink" value="song/updatesong.html">
								<c:param name="id" value="${song.id }"/>
							</c:url>
							<td><a href="${updateLink }" >Update</a> | <a href="" >Hide</a></td>
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
<script
	src="${pageContext.request.contextPath }/assets/admin/js/pages/song-management.js"></script>

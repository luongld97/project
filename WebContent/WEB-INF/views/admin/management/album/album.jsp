<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<jsp:useBean id="songs" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/admin/management/song.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<div class="panel panel-default">
	<div class="panel-heading">
		<a href="<c:url value="/admin/management/song/add.html"/>" class="btn btn-primary pull-right">
			<span class="glyphicon glyphicon-plus"></span>
		</a>
	</div>
	<div class="panel-body">
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
							<td>${song.isShow }</td>
							<td>${song.isVideo }</td>
							<td>${song.uploadedTime }</td>
							<td>${song.uploadedBy }</td>
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
	</div>
</div>
<tg:paging pagedListHolder="${songs}" pagedLink="${pagedLink}" />
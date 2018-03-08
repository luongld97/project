<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-album" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<div class="row">
			<div class="col-md-3">
				<a
					href="${pageContext.request.contextPath }/admin/album/addalbum.html"
					class="btn btn-primary" style="height: 46px; line-height: 32px;">
					NEW ALBUM </a>
			</div>
			<div class="col-md-6">
				
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<div class="panel-body">
		<jsp:useBean id="albums" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/album/allalbum.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered text-center">
			<thead class="text-center">
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center"><b>Name</b></th>
					<th class="text-center"><b>Photo</b></th>
					<th class="text-center"><b>Options</b></th>
				</tr>
			</thead>
			<c:if test="${albums.pageList.size() > 0 }">
				<tbody>
					<c:forEach var="album" items="${albums.pageList }">
						<tr>
							<c:url value="/admin/album/updatealbum.html" var="updateLink">
								<c:param name="id" value="${album.id }" />
							</c:url>
							<td>${album.id }</td>
							<td>${album.name }</td>
							<td><img alt="Images Album"
								src="${pageContext.request.contextPath }/assets/images/${album.photo }"></td>
							<td><a href="${updateLink }">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${albums.pageList.size() == 0 }">
				<tr>
					<td class="text-center" colspan="7"><b>No album in your
							system!</b></td>
				</tr>
			</c:if>
		</table>
		<tg:paging pagedListHolder="${albums}" pagedLink="${pagedLink}" />
	</div>
</div>

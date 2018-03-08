<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-author" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<div class="row">
			<div class="col-md-3">
				<a
					href="${pageContext.request.contextPath }/admin/author/addauthor.html"
					class="btn btn-primary"  style="height: 46px; line-height: 32px;"> NEW AUTHOR </a>
			</div>
			<div class="col-md-6">
				
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<div class="panel-body">
		<jsp:useBean id="authors" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/author/allauthor.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered text-center">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center" width="15%">Name</th>
					<th class="text-center" width="10%">Date Of Birth</th>
					<th class="text-center" width="10%">Gender</th>
					<th class="text-center" width="auto">Description</th>
					<th class="text-center" width="15%">Photo</th>
					<th class="text-center" width="10%">Option</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${authors.pageList.size() > 0 }">
					<c:forEach var="author" items="${authors.pageList }">
						<tr>
							<c:url value="/admin/author/updateauthor.html" var="updateLink">
								<c:param name="id" value="${author.id }" />
							</c:url>
							<td>${author.id }</td>
							<td>${author.name }</td>
							<td>${author.dateOfBirth }</td>
							<td>${author.gender }</td>
							<td><div style="max-height: 100px; overflow: auto;">${author.description }</div></td>
							<td>${author.photo }</td>
							<td><a href="${updateLink }">Edit</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${categories.pageList.size() == 0 }">
					<tr>
						<td class="text-center" colspan="2"><b>No author in your
								system!</b></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<tg:paging pagedListHolder="${authors}" pagedLink="${pagedLink}" />
	</div>
</div>
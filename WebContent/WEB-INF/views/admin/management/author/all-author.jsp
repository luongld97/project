<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<div class="panel panel-default">
	<div class="panel-heading">
		<a href="${pageContext.request.contextPath }/admin/author/addauthor.html"
			class="btn btn-primary pull-right"> NEW AUTHOR </a>
	</div>

	<div class="panel-body col-md-6 ">
		<jsp:useBean id="authors" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/author/allauthor.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center" width="10%">Name</th>
					<th class="text-center" width="10%">Date Of Birth</th>
					<th class="text-center" width="5%">Gender</th>
					<th class="text-center" width="10%"><i>Description</i></th>
					<th class="text-center" width="15%">Photo</th>
					<th class="text-center" width="10%">Option</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${authors.pageList.size() > 0 }">
					<c:forEach var="author" items="${authors.pageList }">
						<tr>
							<c:url value="/admin/author/updateauthor.html" var="updateLink">
								<c:param name="id" value="${author.id }"/>
							</c:url>
							<td>${author.id }</td>
							<td>${author.name }</td>
							<td>${author.dateOfBirth }</td>
							<td>${author.gender }</td>
							<td style="max-height: 100px; overflow: auto;" >${author.description }</td>
							<td>${author.photo }</td>
							<td><a href="${updateLink }">Edit</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${categories.pageList.size() == 0 }">
					<tr>
						<td class="text-center" colspan="2"><b>No author in
								your system!</b></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<tg:paging pagedListHolder="${authors}" pagedLink="${pagedLink}" />
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-category" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<div class="row">
			<div class="col-md-3">
				<a
					href="${pageContext.request.contextPath }/admin/category/addcategory.html"
					class="btn btn-primary" style="height: 46px; line-height: 32px;">
					NEW CATEGORY </a>
			</div>
			<div class="col-md-6">
				
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>

	<div class="panel-body">
		<jsp:useBean id="categories" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/category/allcategory.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered text-center">
			<thead>
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center">Content</th>
					<th class="text-center">Option</th>
				</tr>
			</thead>

			<tbody>
				<c:if test="${categories.pageList.size() > 0 }">
					<c:forEach var="category" items="${categories.pageList }">
						<tr>
							<c:url value="/admin/category/updatecategory.html"
								var="updateLink">
								<c:param name="id" value="${category.id }" />
							</c:url>
							<td>${category.id }</td>
							<td>${category.name }</td>
							<td><a href="${updateLink }">Edit</a></td>
						</tr>
					</c:forEach>
				</c:if>
				<c:if test="${categories.pageList.size() == 0 }">
					<tr>
						<td class="text-center" colspan="2"><b>No category in
								your system!</b></td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<tg:paging pagedListHolder="${categories}" pagedLink="${pagedLink}" />
	</div>
</div>
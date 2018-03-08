<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-account" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<div class="row">
			<div class="col-md-3">
				<a
					href="${pageContext.request.contextPath }/admin/account/addaccount.html"
					class="btn btn-primary" style="height: 46px; line-height: 32px;">
					NEW ACCOUNT </a>
			</div>
			<div class="col-md-6">
				<div class="form-group">
					<div class="input-group">
						<input class="form-control" placeholder="Enter username!"
							id="search-box" baseUrl="${pageContext.request.contextPath }"
							requestUrl="/api/account/search"
							targetUrl="/admin/account/updateaccount.html" />
						<div class="input-group-addon">
							<span class="input-group-text"><span
								class="glyphicon glyphicon-search"></span></span>
						</div>
					</div>
				</div>
			</div>
			<div class="col-md-3"></div>
		</div>
	</div>
	<div class="panel-body">
		<jsp:useBean id="accounts" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/account/allaccount.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered text-center">
			<thead class="text-center">
				<tr>
					<th class="text-center">Role ID</th>
					<th class="text-center">Username</th>
					<th class="text-center">Date of birth</th>
					<th class="text-center">Created time</th>
					<th class="text-center">Gender</th>
					<th class="text-center">Phone number</th>
					<th class="text-center">Status</th>
					<th class="text-center">Avatar</th>
					<th class="text-center">Options</th>
				</tr>
			</thead>
			<c:if test="${accounts.pageList.size() > 0 }">
				<tbody>
					<c:forEach var="account" items="${accounts.pageList }">
						<tr>
							<c:url value="/admin/account/updateaccount.html" var="updateLink">
								<c:param name="username" value="${account.username }" />
							</c:url>
							<td>${account.role.id }</td>
							<td>${account.username }</td>
							<td>${account.dateOfBirth }</td>
							<td>${account.createdTime }</td>
							<td>${account.gender }</td>
							<td>${account.phone }</td>
							<td>${account.status }</td>
							<td><img alt="Avatar"
								src="${pageContext.request.contextPath }/assets/images/${account.photo }"></td>
							<td><a href="${updateLink }">Edit</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${accounts.pageList.size() == 0 }">
				<tr>
					<td class="text-center" colspan="7"><b>No account in your
							system!</b></td>
				</tr>
			</c:if>
		</table>
		<tg:paging pagedListHolder="${accounts}" pagedLink="${pagedLink}" />
	</div>
</div>

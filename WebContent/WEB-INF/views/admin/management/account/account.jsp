<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<jsp:useBean id="accounts" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/admin/management/account.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<table class="table table-bordered text-center">
	<thead class="text-center">
		<tr>
			<th class="text-center" width="5%"></th>
			<th class="text-center" width="20%"><b>Username</b></th>
			<th class="text-center" width="10%"><b>DoB</b></th>
			<th class="text-center" width="5%"><b>Gender</b></th>
			<th class="text-center" width="10%"><b>Phone</b></th>
			<th class="text-center" width="15%"><b>Created</b></th>
			<th class="text-center"><b>Options</b></th>
		</tr>
	</thead>
	<c:if test="${accounts.pageList.size() > 0 }">
		<tbody>
			<c:forEach var="account" items="${accounts.pageList }">
				<tr>
					<td class="text-center">
						<c:if test="${account.status }">
							<span style="color: green;" class="glyphicon glyphicon-ok"></span>
						</c:if>
						<c:if test="${!account.status }">
							<span style="color: red;" class="glyphicon glyphicon-remove"></span>
						</c:if> 
						| 
						<c:if test="${account.status }">
							<c:url value="/admin/management/account/block.html"
								var="blockLink">
								<c:param name="id" value="${account.username }" />
								<c:param name="status" value="false" />
								<c:param name="page" value="${currentPage }" />
							</c:url>
							<a href="${blockLink }"><span style="color: red;"
								class="glyphicon glyphicon-ban-circle"></span></a>
						</c:if>
						<c:if test="${!account.status }">
							<c:url value="/admin/management/account/block.html"
								var="activeLink">
								<c:param name="id" value="${account.username }" />
								<c:param name="status" value="true" />
								<c:param name="page" value="${currentPage }" />
							</c:url>
							<a href="${activeLink }"><span  style="color: blue;"
								class="glyphicon glyphicon-refresh"></span></a>
						</c:if>
					</td>
					<td>${account.username }</td>
					<td>${account.dateOfBirth }</td>
					<td class="text-center">${account.gender }</td>
					<td>${account.phone }</td>
					<td>${account.createdTime }</td>
					<td class="text-center"></td>
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
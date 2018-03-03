<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<div id="form-add-song" class="col-md-8"></div>
<div class="panel">
	<div class="panel-heading">
		<div class="col-md-3">
			<a href="${pageContext.request.contextPath }/admin/singer/addsinger.html"
				class="btn btn-primary" style="height: 46px; line-height: 32px;"> NEW SINGER </a>
		</div>
		<div class="col-md-6">
			<div class="form-group">
				<div class="input-group">
					<input class="form-control" placeholder="Enter singer name!"
						id="search-box" baseUrl="${pageContext.request.contextPath }"
						requestUrl="/api/singer/search"
						targetUrl="/admin/singer/updatesinger.html" />
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
		<jsp:useBean id="singers" scope="request"
			type="org.springframework.beans.support.PagedListHolder" />
		<c:url value="/admin/singer/allsinger.html" var="pagedLink">
			<c:param name="page" value="~" />
		</c:url>
		<table class="table table-bordered text-center">
			<thead class="text-center">
				<tr>
					<th class="text-center">ID</th>
					<th class="text-center" width="10%" ><b>Name</b></th>
					<th class="text-center" width="10%" ><b>Nickname</b></th>
					<th class="text-center" width="10%" ><b>Date of birth</b></th>
					<th class="text-center" width="5%" ><b>Gender</b></th>
					<th class="text-center" width="35%" ><b>Description</b></th>
					<th class="text-center" width="15%" ><b>Photo</b></th>
					<th class="text-center" width="10%" ><b>Options</b></th>
				</tr>
			</thead>
			<c:if test="${singers.pageList.size() > 0 }">
				<tbody>
					<c:forEach var="singer" items="${singers.pageList }">
						<tr>
							<td>${singer.id }</td>
							<td>${singer.name }</td>
							<td>${singer.nickName }</td>
							<td>${singer.dateOfBirth }</td>
							<td>${singer.gender }</td>
							<td><div style="max-height: 100px; overflow: auto;">${singer.description }</div></td>
							<td><img src="${pageContext.request.contextPath }/assets/images/${singer.photo }"  height="100px" /></td>
							<c:url var="updateLink" value="/admin/singer/updatesinger.html">
								<c:param name="id" value="${singer.id }"/>
							</c:url>
							<td><a href="${updateLink }" >Edit</a> &nbsp; <a href="" >Hide</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</c:if>
			<c:if test="${singers.pageList.size() == 0 }">
				<tr>
					<td class="text-center" colspan="7"><b>No singer in your
							system!</b></td>
				</tr>
			</c:if>
		</table>
		<tg:paging pagedListHolder="${singers}" pagedLink="${pagedLink}" />
	</div>
</div>
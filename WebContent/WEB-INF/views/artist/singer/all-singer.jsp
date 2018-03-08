<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tg" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<jsp:useBean id="singers" scope="request"
	type="org.springframework.beans.support.PagedListHolder" />
<c:url value="/artist/singer/allsinger.html" var="pagedLink">
	<c:param name="page" value="~" />
</c:url>
<div class="body-web">
	<div class="container bg-web">
		<h1 class="color-purple">ALL SINGERS</h1>
		<c:set var="temp" value="0" />
		<c:if test="${singers.pageList.size() / 5 - 1 >= 0 }">
			<c:forEach begin="0" end="${singers.pageList.size() / 5 - 1 }" var="i">
				<div class="row">
					<c:forEach begin="${temp }" end="${temp + 4 }" var="j">
						<c:set var="singer" value="${singers.pageList[j] }" />
						<div class="col-oxs-2 col-omd-2">
							<c:url var="singerLink" value="/artist/singer/info.html">
								<c:param name="id" value="${singer.id }" />
							</c:url>
							<div class="my-img-200 mb-1 mt-1">
								<a href="${singerLink }"><img
									src="${pageContext.request.contextPath }/assets/images/${singer.photo }"
									alt="Avatar singer" class="img-thumbnail image-view"></a>
							</div>
							<div>
								<a class="singer-name2" href="${singerLink }">${singer.name }</a>
							</div>
							<div>
								<i><fmt:formatDate value="${singer.dateOfBirth }"
										pattern="yyyy-MM-dd" /></i>
							</div>
						</div>
					</c:forEach>
				</div>
				<c:set var="temp" value="${(i + 1) * 5 }" />
			</c:forEach>
		</c:if>
		<div class="row">
			<c:forEach begin="${temp }" end="${ singers.pageList.size() - 1}"
				var="j">
				<c:set var="singer" value="${singers.pageList[j] }" />
				<div class="col-oxs-2 col-omd-2">
					<c:url var="singerLink" value="/artist/singer/info.html">
						<c:param name="id" value="${singer.id }" />
					</c:url>
					<div class="my-img-200 mb-1 mt-1">
						<a href="${singerLink }"><img
							src="${pageContext.request.contextPath }/assets/images/${singer.photo }"
							alt="Avatar singer" class="img-thumbnail image-view"></a>
					</div>
					<div>
						<a class="singer-name2" href="${singerLink }">${singer.name }</a>
					</div>
					<div>
						<i><fmt:formatDate value="${singer.dateOfBirth }"
								pattern="yyyy-MM-dd" /></i>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="text-center">
			<tg:paging pagedListHolder="${singers}" pagedLink="${pagedLink}" />
		</div>
	</div>
</div>
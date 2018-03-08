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
		<h1 class="title-list-index mb-2">ALL SINGERS</h1>
		<c:forEach begin="0" end="5" var="i">
			<c:set var="temp" value="${i % 6 }" />
			<c:if test="${temp == 5 }">
				<div class="row mb-3">
					<c:forEach items="${singers.pageList }" var="singer">
						<c:if test="${temp == 5 }">
							<div class="col-xs-2 col-md-2">
								<div class="">
									<c:url var="singerLink" value="/artist/singer/info.html">
										<c:param name="id" value="${singer.id }" />
									</c:url>
									<a href="${singerLink }"><img
										src="${pageContext.request.contextPath }/assets/images/${singer.photo }"
										alt="" class="img-thumbnail mb-1"></a><br>
									<div class="text-center">
										<a class="singer-name2" href="${singerLink }"><b>
												${singer.name } </b> </a><br> <i><fmt:formatDate
												value="${singer.dateOfBirth }" pattern="yyyy-MM-dd" /></i>
									</div>
								</div>
							</div>
						</c:if>
					</c:forEach>
				</div>
			</c:if>
		</c:forEach>
		<div class="text-center mb-3">
			<tg:paging pagedListHolder="${singers}" pagedLink="${pagedLink}" />
		</div>
	</div>
</div>
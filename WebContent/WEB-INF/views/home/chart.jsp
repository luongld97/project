<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row mb-3">
			<div class="col-xs-7 col-md-7">
				<h3 class="title-list-index mb-2">CHART SONG</h3>
				<c:forEach items="${songs }" var="song" varStatus="i">
					<c:url var="songLink" value="/song/play.html">
						<c:param name="id" value="${song.id }" />
					</c:url>
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<span class="top-20-chart-song"> <c:if
									test="${i.index + 1 < 10 }">0${i.index + 1}</c:if> <c:if
									test="${i.index + 1 >= 10 }">${i.index + 1}</c:if>. <a
								href="${songLink }">${song.name }</a></span>
						</div>
						<div class="col-xs-6 col-md-6 text-right mt-1">
							<span>Listen: ${song.listen }</span>
						</div>
					</div>
					<hr class="hr-css2">
				</c:forEach>
			</div>
			<div class="col-xs-5 col-md-5 border-chart">
				<h3 class="title-list-index">CHART VIDEO</h3>
				<c:forEach var="video" items="${videos }" varStatus="i">
					<c:url var="videoLink" value="/song/play.html?video">
						<c:param name="id" value="${video.id }" />
					</c:url>
					<div class="row">
						<div class="col-xs-6 col-md-6">
							<div class="my-img-120 text-center ">
								<img
									src="${pageContext.request.contextPath }/assets/images/${video.videoPhoto }"
									class="image-view" alt="">
							</div>
							<c:if test="${i.index + 1 < 10 }">
								<b class="rank-chart-video">0${i.index + 1 }</b>
							</c:if>
							<c:if test="${i.index + 1 >= 10 }">
								<b class="rank-chart-video">${i.index + 1 }</b>
							</c:if>
						</div>
						<div class="col-xs-6 col-md-6">
							<p class="text-justify top-10-chart-video">
								<a href="${videoLink }">${video.name }</a>
							</p>
							<br>
							<p>Listen: ${video.listen }</p>
						</div>
					</div>
					<hr class="hr-css1">
				</c:forEach>

			</div>
		</div>
	</div>
</div>
<!--End Body Web-->
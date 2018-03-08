<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<tiles:insertDefinition name="play.list.body.left" />
			<!-- Body Right -->
			<div class="col-md-9">
				<h2 class="pl-title-top">UPDATE PLAYLIST</h2>
				<hr>
				<div class="row">
					<div class="col-md-4">
						<img
							src="${pageContext.request.contextPath }/assets/images/${playList.photo }"
							class="img-thumbnail" alt=""> <br> <br> <label>Change
							background?</label> <input type="file">
					</div>
					<div class="col-md-8">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-4 control-label">Name:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
						</form>
					</div>
				</div>
				<h3 class="title-list-index mt-3">List song</h3>
				<div class="row mt-2">
					<div class="col-md-12">
						<ul class="list-item">
							<c:forEach var="song" items="">
								<li class="edit-playlist-item-song">
									<div class="row">
										<div class="col-md-9">
											05. <a href="">Người Lạ ơi</a>
										</div>
										<div class="col-md-3">
											<div class="float-right">
												<a class="playlist-btn-nm" href="" title="Delete song"><span
													class="glyphicon glyphicon-remove"></span></a>
											</div>
										</div>
									</div>
								</li>
								<hr class="hr-css1" />
							</c:forEach>
						</ul>
						<div class="text-right mt-3 mb-3">
							<a href=""><button class="btn btn-success">Update</button></a> <a
								href=""><button class="btn btn-success">Cancel</button></a>
						</div>
					</div>
				</div>
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/pages/update-play-list.js">
	
</script>
<!--End Body Web-->
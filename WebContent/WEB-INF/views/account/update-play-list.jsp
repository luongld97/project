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
				<div class="row">
					<div class="col-xs-4 col-md-4">
						<div class="img-thumbnail my-img-120">
							<img src="${pageContext.request.contextPath }/images/default_playlist.png" class="image-view" alt="">
						</div>
					</div>
					<div class="col-xs-8 col-md-8">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-4 control-label">Playlist name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Change background?</label>
								<div class="col-sm-8">
									<input type="file">
								</div>
							</div>
						</form>
					</div>
				</div>
				<h2 class="title-list-index mt-3">List song</h2>
				<div class="row mt-2">
					<div class="col-xs-12 col-md-12">
						<div class="row">
							<div class="col-xs-9 col-md-9 edit-playlist-song-name">
								<span>01. <a href="">Người Lạ ơi</a></span>
							</div>
							<div class="col-xs-3 col-md-3">
								<div class="text-right">
									<a class="playlist-btn-nm" href="" title="Delete song"><span
										class="glyphicon glyphicon-remove"></span></a>
								</div>
							</div>
						</div>
						<hr class="hr-css1">
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
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
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
						<img src="images/default_playlist.png" class="img-thumbnail"
							alt=""> <br> <br> <label>Change
							background?</label> <input type="file">
					</div>
					<div class="col-md-8">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-4 control-label">Playlist name</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Description</label>
								<div class="col-sm-8">
									<textarea rows="5" class="form-control"></textarea>
								</div>
							</div>
						</form>
					</div>
				</div>
				<h3 class="title-list-index mt-3">List song</h3>
				<div class="row mt-2">
					<div class="col-md-12">
						<ul class="list-item">
							<li class="edit-playlist-item-song">
								<div class="row">
									<div class="col-md-9">
										01. <a href="">Người Lạ ơi</a>
									</div>
									<div class="col-md-3">
										<div class="float-right">
											<a class="playlist-btn-nm" href="" title="Delete song"><span
												class="glyphicon glyphicon-remove"></span></a> <a
												class="playlist-btn-nm" href="" title="Drag song"><span
												class="glyphicon glyphicon-move"></span></a>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css1">
							<li class="edit-playlist-item-song">
								<div class="row">
									<div class="col-md-9">
										02. <a href="">Người Lạ ơi</a>
									</div>
									<div class="col-md-3">
										<div class="float-right">
											<a class="playlist-btn-nm" href="" title="Delete song"><span
												class="glyphicon glyphicon-remove"></span></a> <a
												class="playlist-btn-nm" href="" title="Drag song"><span
												class="glyphicon glyphicon-move"></span></a>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css1">
							<li class="edit-playlist-item-song">
								<div class="row">
									<div class="col-md-9">
										03. <a href="">Người Lạ ơi</a>
									</div>
									<div class="col-md-3">
										<div class="float-right">
											<a class="playlist-btn-nm" href="" title="Delete song"><span
												class="glyphicon glyphicon-remove"></span></a> <a
												class="playlist-btn-nm" href="" title="Drag song"><span
												class="glyphicon glyphicon-move"></span></a>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css1">
							<li class="edit-playlist-item-song">
								<div class="row">
									<div class="col-md-9">
										04. <a href="">Người Lạ ơi</a>
									</div>
									<div class="col-md-3">
										<div class="float-right">
											<a class="playlist-btn-nm" href="" title="Delete song"><span
												class="glyphicon glyphicon-remove"></span></a> <a
												class="playlist-btn-nm" href="" title="Drag song"><span
												class="glyphicon glyphicon-move"></span></a>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css1">
							<li class="edit-playlist-item-song">
								<div class="row">
									<div class="col-md-9">
										05. <a href="">Người Lạ ơi</a>
									</div>
									<div class="col-md-3">
										<div class="float-right">
											<a class="playlist-btn-nm" href="" title="Delete song"><span
												class="glyphicon glyphicon-remove"></span></a> <a
												class="playlist-btn-nm" href="" title="Drag song"><span
												class="glyphicon glyphicon-move"></span></a>
										</div>
									</div>
								</div>
							</li>
							<hr class="hr-css1">

						</ul>
						<div class="text-right mt-3">
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
</div>
<!--End Body Web-->
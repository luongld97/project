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
				<div class="row mt-4">
					<div class="col-xs-10 col-md-10">
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-4 control-label">Name:</label>
								<div class="col-sm-8">
									<input type="text" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Choose photo</label>
								<div class="col-sm-8">
									<input type="file" class="file-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label"></label>
								<div class="col-sm-8">
									<a href=""><button class="btn btn-success">Create</button></a>
									<a href=""><button class="btn btn-danger">Cancel</button></a>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="postLink" value="/admin/album/addalbum.html" />
<s:form action="${postLink }" method="post" commandName="album"
	enctype="multipart/form-data">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row">
				<div class="col-md-7">
					<div class="form-group">
						<s:errors path="name" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-music" aria-hidden="true"></span></span>
							</div>
							<s:input cssClass="form-control" placeholder="Enter album name!"
								path="name" />
						</div>
					</div>
					<div class="form-group">
						<c:if test="${fileTypeError != null }">
							<span class="alert alert-danger" style="display: block;">
								${fileTypeError } </span>
						</c:if>
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-picture"></span></span>
							<div class="custom-file">
								<input name="album-photo" type="file" accept="image/*"
									class="custom-file-input form-control" /> <span
									class="custom-file-label" style="height: 46px">Choose
									photo</span>
							</div>
						</div>
					</div>
				</div>
				<div class="col-md-5">
					<s:errors path="singers" cssClass="alert alert-danger"
						cssStyle="display:block;" />
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-btn">
								<button type="submit" name="addsinger" class="btn btn-primary"
									style="height: 41px;">
									<span class="glyphicon glyphicon-plus" />
								</button>
							</div>
							<s:select path="singers" multiple="true" id="singer-detail"
								cssClass="form-control">
								<s:options items="${singers }" itemLabel="name" itemValue="id" />
							</s:select>
						</div>
					</div>
					
					<s:errors path="songs" cssClass="alert alert-danger"
						cssStyle="display:block;" />
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-btn">
								<button type="submit" name="addsong" class="btn btn-primary"
									style="height: 41px;">
									<span class="glyphicon glyphicon-plus" />
								</button>
							</div>
							<s:select path="songs" multiple="true" id="song-detail"
								cssClass="form-control">
								<s:options items="${songs }" itemLabel="name" itemValue="id" />
							</s:select>
						</div>
					</div>
					
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="text-right">
				<input type="submit" name="addalbum" class="btn btn-primary"
					name="save" value="&nbsp;ADD ALBUM&nbsp;">
			</div>
		</div>
	</div>
</s:form>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/chosen.jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/pages/add-album.js"></script>

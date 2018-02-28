<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="postLink" value="/admin/song/addsong.html" />
<s:form action="${postLink }" method="post" commandName="song"
	enctype="multipart/form-data">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row">
				<div class="col-md-7">
					<div class="form-group">
						<s:hidden path="id"/>
						<s:errors path="name" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-music" aria-hidden="true"></span></span>
							</div>
							<s:input cssClass="form-control" placeholder="Enter song name!"
								path="name" />
						</div>
					</div>
					<div class="form-group">
						<s:errors path="link" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-link" aria-hidden="true"></span></span>
							</div>
							<s:input cssClass="form-control" placeholder="Enter song link"
								path="link" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-pencil" aria-hidden="true"></span></span>
							</div>
							<s:textarea rows="10" cssClass="form-control"
								placeholder="Enter song lyric" path="lyric" />
						</div>
					</div>
				</div>
				<div class="col-md-5">
					<s:errors path="singers" cssClass="alert alert-danger"
						cssStyle="display:block;" />
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-btn">
								<button type="submit" name="addsinger" class="btn btn-primary" style="height: 41px;">
									<span class="glyphicon glyphicon-plus" />
								</button>
							</div>
							<s:select path="singers" multiple="true" id="singer-detail"
								cssClass="form-control">
								<s:options items="${singers }" itemLabel="name" itemValue="id" />
							</s:select>
						</div>
					</div>
					<div class="form-group">
						<s:errors path="authors" cssClass="alert alert-danger"
							cssStyle="display:block;" />
						<div class="input-group">
							<div class="input-group-btn">
								<button type="submit" name="addauthor" class="btn btn-primary" style="height: 41px;">
									<span class="glyphicon glyphicon-plus" />
								</button>
							</div>
							<s:select path="authors" multiple="true" id="author-detail"
								cssClass="form-control">
								<s:options items="${authors }" itemLabel="name" itemValue="id" />
							</s:select>
						</div>
					</div>
					<div class="form-group">
						<s:errors path="categories" cssClass="alert alert-danger"
							cssStyle="display:block;" />
						<div class="input-group">
							<div class="input-group-btn">
								<button type="submit" name="addcategory" class="btn btn-primary" style="height: 41px;">
									<span class="glyphicon glyphicon-plus" />
								</button>
							</div>
							<s:select path="categories" multiple="true" id="category-detail"
								cssClass="form-control">
								<s:options items="${categories }" itemLabel="name"
									itemValue="id" />
							</s:select>
						</div>
					</div>
					<div class="checkbox">
						<label> <s:checkbox path="show" /> <span>show in
								home page?</span>
						</label>
					</div>
					<div class="checkbox">
						<label> <s:checkbox path="video" id="is-video" /> <span
							id="is-video-content">${song.video ? 'this is a video.' : 'this is not a video.' }</span>
						</label>
					</div>
					<div id="video-photo"
						class="form-group ${(fileTypeError != null || song.video) ? '' : 'hidden' }">
						<div
							class="alert alert-danger ${fileTypeError != null ? '' : 'hidden' }"
							style="display: block;">${fileTypeError }</div>
						<label>Select photo for this video.</label> <input type="file"
							name="photo" accept="image/*" />
					</div>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="text-right">
				<input type="submit" name="addsong" class="btn btn-primary" name="save"
					value="&nbsp;UPDATE SONG&nbsp;">
			</div>
		</div>
	</div>
</s:form>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/chosen.jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/admin/js/pages/add-song.js"></script>
    
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="postLink" value="/admin/singer/updatesinger.html" />
<s:form action="${postLink }" method="post" commandName="singer"
	enctype="multipart/form-data">
	<div class="panel panel-default">
		<div class="panel-body">
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<s:hidden path="id" />
						<s:errors path="name" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-music" aria-hidden="true"></span></span>
							</div>
							<s:input cssClass="form-control" placeholder="Enter singer name!"
								path="name" />
						</div>
					</div>
					<div class="form-group">
						<s:errors path="nickName" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-link" aria-hidden="true"></span></span>
							</div>
							<s:input cssClass="form-control" placeholder="Enter nick name"
								path="nickName" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-pencil" aria-hidden="true"></span></span>
							</div>
							<s:textarea rows="10" cssClass="form-control"
								placeholder="Enter description" path="description" />
						</div>
					</div>
				</div>

				<div class="col-md-6">
					<div class="form-group">
						<s:errors path="dateOfBirth" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="form-group">
							<div class="input-group date" id="singer-dob">
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-calendar"></span></span>
								<%
										java.util.Date currentDate = new java.util.Date();
										String dateString = new java.text.SimpleDateFormat("yyyy-MM-dd").format(currentDate);
								%>
								<s:input type="date" cssClass="form-control" path="dateOfBirth"
									min="1900-01-01" max="<%=dateString%>" />
								<span class="input-group-addon">DOB</span>
							</div>
						</div>
					</div>
					<div class="form-group">
						<s:errors path="gender" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<div class="input-group-addon">
								<span class="input-group-text"><span
									class="glyphicon glyphicon-heart" aria-hidden="true"></span></span>
							</div>
							<s:select cssClass="form-control" path="gender"
								cssStyle="height:46px">
								<s:option value="male">Male</s:option>
								<s:option value="female">Female</s:option>
								<s:option value="other">Other</s:option>
							</s:select>
						</div>
					</div>
					<div class="form-group">
						<s:errors path="photo" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="input-group">
							<span class="input-group-addon"><span
								class="glyphicon glyphicon-picture"></span></span>
							<div class="custom-file">
								<input accept="image/*" type="file" name="avatar"
									class="custom-file-input form-control" /> <span
									class="custom-file-label" style="height: 46px">Choose
									avatar</span>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="panel-footer">
			<div class="text-right">
				<input type="submit" name="addsong" class="btn btn-primary"
					name="save" value="&nbsp;UPDATE SINGER&nbsp;">
			</div>
		</div>
	</div>
</s:form>

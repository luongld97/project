<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="postLink" value="/admin/song/addsong.html" />
<s:form action="${postLink }" method="post" commandName="author"
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
							<s:input cssClass="form-control" placeholder="Enter author name!"
								path="name" />
						</div>
					</div>
					<div class="form-group">
						<s:errors path="dateOfBirth" cssClass="alert alert-danger"
							cssStyle="display: block;" />
						<div class="form-group">
							<div class='input-group-date' id='datetimepicker1'>
								<span class="input-group-addon"><span
									class="glyphicon glyphicon-calendar"></span></span> <input type="date"
									class="form-control" path="dateOfBirth"/>
								<span class="input-group-addon">Choose date of birth</span>
							</div>
						</div>
					</div>
					
				</div>
				
			</div>
		</div>
		<div class="panel-footer">
			<div class="text-right">
				<input type="submit" name="addauthor" class="btn btn-primary" name="save"
					value="&nbsp;ADD AUTHOR&nbsp;">
			</div>
		</div>
	</div>
</s:form>
<script
	src="${pageContext.request.contextPath }/assets/admin/js/chosen.jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/assets/admin/js/pages/add-song.js"></script>

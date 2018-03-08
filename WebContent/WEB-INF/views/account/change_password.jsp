<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<!-- Body Left  -->
			<div
				class="col-md-offset-1 col-xs-5 col-md-5 info-account-border-left">
				<img src="images/proinf3.png" class="image-view" alt="">
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-xs-5 col-md-5 info-account-border-right">
				<form id="frm" class="form-horizontal" name="updatepassword"
					action="${pageContext.request.contextPath }/account/updatepassword.html"
					method="POST">
					<div class="form-group">
						<label class="col-sm-4 control-label">Old Password</label>
						<div class="col-sm-8">
							<span
								class="sm-alert alert-danger ${error != null ? '' : 'hidden' }"
								style="display: block;">${error }</span> <input type="password"
								class="form-control" name="oldpassword"> <input hidden
								name="username" value="${account.username }" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Password</label>
						<div class="col-sm-8">
							<input type="password" id="newpassword" class="form-control"
								name="newpassword">
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Re-Password</label>
						<div class="col-sm-8">
							<input type="password" class="form-control"
								name="confirmpassword" id="confirmpassword">
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<button type="submit" class="btn btn-success">Change</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<!-- End Body Right -->
	</div>
</div>
<!--End Body Web-->
<script>
	$(document).ready(function() {
		$("#frm").validate({
			rules : {
				oldpassword : {
					required : true,
				},
				newpassword : {
					required : true,
					minlength : 8,
					maxlength : 16
				},
				confirmpassword : {
					required : true,
					minlength : 8,
					maxlength : 16,
					equalTo : '#newpassword'
				}
			}
		});

		if ($("#frm").valid()) {
			$(this).submit();
		}
	});
</script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/jquery.validate.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.17.0/additional-methods.min.js"></script>
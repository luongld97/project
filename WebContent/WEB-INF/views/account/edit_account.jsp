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
					<div class="col-md-offset-1 col-xs-5 col-md-5 info-account-border-left">
						<img src="images/proinf3.png" class="image-view" alt="">
					</div>
					<!-- End body Left -->
					<!-- Body Right -->
					<div class="col-xs-5 col-md-5 info-account-border-right">
						${message}
						<form method="post" class="form-horizontal" enctype="multipart/form-data" name="account" action="${pageContext.request.contextPath }/account/doUpdateAccount.html">
							<div class="form-group">
								<label class="col-sm-4 control-label">Username</label>
								<div class="col-sm-5">
									<p class="form-control-static">${account.username }</p>
								</div>
								<div class="col-sm-3">
									<div class="text-right">
										<button type="submit" class="btn btn-success">Update</button>
									</div>
								</div>
							</div>
							<input hidden name="username" value="${account.username }">
							<div class="form-group">
								<label class="col-sm-4 control-label">Birthday</label>
								<div class="col-sm-8">
									<input pattern="yyyy-MM-dd" type="date" class="form-control" value="${account.dateOfBirth }" name="dateOfBirth">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Gender</label>
								<div class="col-sm-8">
									<select class="form-control" itemValue="${account.gender }" name="gender" >
										<option value="Male">Male</option>
										<option value="Female">Female</option>
										<option value="other">other</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Phone number</label>
								<div class="col-sm-8">
									<input type="text" name="phone" class="form-control" value="${account.phone }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Avatar</label>
								<div class="col-sm-8">
									<input type="file" class="file-control" name="file" value="${account.photo }"></input>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- End Body Right -->
			</div>
		</div>
	</div>
	<!--End Body Web-->
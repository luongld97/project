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
			<div class="col-xs-1 col-md-1">
			</div>
			<div
				class="col-xs-5 col-md-5 info-account-border-left">
				<img src="${pageContext.request.contextPath }/assets/images/proinf3.png" class="image-view" alt="">
			</div>
			<!-- End body Left -->
			<!-- Body Right -->
			<div class="col-xs-5 col-md-5 info-account-border-right">
				<form class="form-horizontal" >
					<div class="form-group">
						<label class="col-sm-4 control-label">Username</label>
						<div class="col-sm-5">
							<p class="form-control-static">${sessionScope.currentAccount.username }</p>
						</div>
						<div class="col-sm-3">
							<div class="text-right">
								<a href="${pageContext.request.contextPath }/account/updateAccount.html?acc=${sessionScope.currentAccount.username }"><input type="button"
									class="btn btn-success" value="Edit info"></a>
							</div>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Birthday</label>
						<div class="col-sm-8">
							<p class="form-control-static">${sessionScope.currentAccount.dateOfBirth }</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Gender</label>
						<div class="col-sm-8">
							<p class="form-control-static">${sessionScope.currentAccount.gender }</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Phone number</label>
						<div class="col-sm-8">
							<p class="form-control-static">${sessionScope.currentAccount.phone }</p>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-4 control-label">Avatar</label>
						<div class="col-sm-8">
							<img
								src="${pageContext.request.contextPath }/assets/images/${sessionScope.currentAccount.photo}"
								class="form-control-static img-rounded" width="100px" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<a
								href="${pageContext.request.contextPath }/account/changepassword.html?username=${sessionScope.currentAccount.username}"><button
									type="button" class="btn btn-success">Change password</button></a>
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

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
						<s:form class="form-horizontal" commandName="account" action="${pageContext.request.contextPath }/account/accountinfo.html">
							<div class="form-group">
								<label class="col-sm-4 control-label">Tài khoản</label>
								<div class="col-sm-5">
									<p class="form-control-static">${account.username}</p>
								</div>
								<div class="col-sm-3">
									<div class="text-right"><a href="info_account_edit.html"><input type="button" class="btn btn-success" value="Chỉnh sửa"></a></div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Ngày sinh</label>
								<div class="col-sm-8">
									<p class="form-control-static">${account.dateOfBirth }</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Giới tính</label>
								<div class="col-sm-8">
									<p class="form-control-static">${account.gender }</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Số điện thoại</label>
								<div class="col-sm-8">
									<p class="form-control-static">${account.phone }</p>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Ảnh đại diện</label>
								<div class="col-sm-8">
									<img src="images/default-avatar.png" class="form-control-static img-rounded" width="100px" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-4"></div>
								<div class="col-sm-8">
									<a href="${pageContext.request.contextPath }/account/changepassword.html"><button type="button" class="btn btn-success">Đổi mật khẩu</button></a>
								</div>
							</div>
						</s:form>
					</div>
				</div>
				<!-- End Body Right -->
			</div>
		</div>
	</div>
	<!--End Body Web-->
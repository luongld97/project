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
						<form class="form-horizontal">
							<div class="form-group">
								<label class="col-sm-4 control-label">Mật khẩu cũ</label>
								<div class="col-sm-8">
									<input type="password" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Mật khẩu mới</label>
								<div class="col-sm-8">
									<input type="password" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Xác nhận lại</label>
								<div class="col-sm-8">
									<input type="password" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<div class="col-sm-4"></div>
								<div class="col-sm-8">
									<a href="info_account.html"><button type="button" class="btn btn-success">Đổi mật khẩu</button></a>
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
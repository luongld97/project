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
								<label class="col-sm-4 control-label">Tài khoản</label>
								<div class="col-sm-5">
									<p class="form-control-static">SarahRuby</p>
								</div>
								<div class="col-sm-3">
									<div class="text-right">
										<a href="info_account.html"><button type="button" class="btn btn-success">Cập nhật</button></a>
									</div>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Ngày sinh</label>
								<div class="col-sm-8">
									<input type="date" class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Giới tính</label>
								<div class="col-sm-8">
									<select class="form-control">
										<option value="malle">Nam</option>
										<option value="female">Nữ</option>
										<option value="other">Khác</option>
									</select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Số điện thoại</label>
								<div class="col-sm-8">
									<input type="text" class="form-control" placeholder="Nhập số điện thoại">
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-4 control-label">Ảnh đại diện</label>
								<div class="col-sm-8">
									<input type="file" class="file-control">
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
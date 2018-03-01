<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<title>Login - Register</title>
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/assets/css/style.css">
		<link rel="stylesheet" type="text/css"
			href="${pageContext.request.contextPath }/assets/css/bootstrap.min.css">
	</head>
	<body class="background-login-page">
		<div class="image-view-login">
			<a href="${pageContext.request.contextPath }/assets/index.html"><img src="${pageContext.request.contextPath }/assets/images/logo_login_page.png"></a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-4"></div>
				<div class="col-md-4 bg-form">
					<div class="row mb-3">
						<div class="pd-login col-md-6">
							<div class="text-center bg-login bg-is-selected">Đăng nhập</div>
						</div>
						<div class="pd-register col-md-6">
							<div class="text-center bg-register">Đăng ký</div>
						</div>
					</div>
					<div id="login-tab">
						<s:form commandName="account"
						action="${pageContext.request.contextPath }/account/login.html"
						method="post">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
									<s:input type="text" class="form-control" placeholder="Tài khoản" path="username"></s:input>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
									<s:input type="password" class="form-control" placeholder="Mật khẩu" path="password"></s:input>
								</div>
							</div>
							<div class="checkbox">
								<label>
									<input type="checkbox"> Lưu mật khẩu
								</label>
							</div>
							<div class="sm-alert alert-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								Account invalid
							</div>
							${error }
							<div class="form-group">
								<button type="submit" class="btn btn-success form-control">Đăng nhập</button>
							</div>
							<div class="text-center">
								<a href="${pageContext.request.contextPath }/home.html">Trở về trang chủ</a>
							</div>
						</s:form>
					</div>
					<div id="register-tab" >
						<s:form commandName="account"
							action="${pageContext.request.contextPath }/account/register.html" method="post">
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
									<s:input type="text" class="form-control" placeholder="Tài khoản" path="username"></s:input>
								</div>
							</div>
							<div class="sm-alert alert-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								<!-- Account invalid -->
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
									<s:input type="password" class="form-control" placeholder="Mật khẩu" path="password"></s:input>
								</div>
							</div>
							<div class="sm-alert alert-success">
								<span class="glyphicon glyphicon-ok" aria-hidden="true"></span>
								<!-- Enter a valid email address -->
							</div>
							<%-- <div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-cog"></span></span>
									<input type="password" class="form-control" placeholder="Xác nhận mật khẩu">
								</div>
							</div> --%>
							<div class="sm-alert alert-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								<!-- Account invalid -->
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									<s:input type="date" class="form-control" path="dateOfBirth"></s:input>
									<span class="input-group-addon">Ngày sinh</span>
								</div>
							</div>
							<div class="sm-alert alert-warning">
								<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
								<!-- Enter a valid email address -->
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
									<div class="custom-file">
										<s:input type="file" class="custom-file-input form-control" path=""></s:input>
										<span class="custom-file-label">Chọn ảnh đại diện</span>
									</div>
								</div>
							</div>
							<div class="sm-alert alert-warning">
								<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
								<!-- Enter a valid email address -->
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span></span>
									<s:input type="text" class="form-control" placeholder="Số điện thoại" path="phone"></s:input>
								</div>
							</div>
							<div class="sm-alert alert-warning">
								<span class="glyphicon glyphicon-warning-sign" aria-hidden="true"></span>
								<!-- Enter a valid email address -->
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-heart"></span></span>
									<s:select class="form-control" path="gender">
										<option selected>Chọn giới tính...</option>
										<option value="male">Nam</option>
										<option value="female">Nữ</option>
										<option value="other">Khác</option>
									</s:select>
								</div>
							</div>
							<div class="sm-alert alert-danger">
								<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
								<!-- Account invalid -->
							</div>
							${errors }
							<div class="form-group">
								<button type="submit" class="btn btn-success form-control">Đăng ký</button>
							</div>
							<div class="text-center">
								<a href="${pageContext.request.contextPath }/assets/home.html">Trở về trang chủ</a>
							</div>
						</s:form>
					</div>
				</div>
				<div class="col-md-4"></div>
			</div>
		</div>
	</body>
	
	<script src="${pageContext.request.contextPath }/assets/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/pages/login-register.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js" type="text/javascript"></script>
</html>
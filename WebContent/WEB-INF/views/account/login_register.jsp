<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<a href="${pageContext.request.contextPath }/home.html"><img src="${pageContext.request.contextPath }/assets/images/logo_login_page.png"></a>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-md-4 col-xs-2"></div>
				<div class="col-md-4 col-xs-8 bg-form">
					<div class="row mb-3">
						<div class="pd-login col-xs-6 col-md-6">
							<div class="text-center bg-login bg-is-selected">Sign In</div>
						</div>
						<div class="pd-register col-xs-6 col-md-6">
							<div class="text-center bg-register">Sign Up</div>
						</div>
					</div>
					<div id="login-tab">
						<s:form commandName="account"
						action="${pageContext.request.contextPath }/account/login.html"
						method="post">
							<div class="form-group">
							
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
									<s:input type="text" class="form-control" placeholder="Username" path="username"></s:input>
								</div>
							</div>
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
									<s:input type="password" class="form-control" placeholder="Password" path="password"></s:input>
								</div>
							</div>
							
							<c:if test="${error != null }"> 
								<div class="sm-alert alert-danger">
									<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
									${error }
								</div>
							</c:if>
							
							<div class="form-group">
								<button type="submit" class="btn btn-success form-control">Sign In</button>
							</div>
							<div class="text-center">
								<a href="${pageContext.request.contextPath }/home.html">Return home</a>
							</div>
						</s:form>
					</div>
					<div id="register-tab" >
						<s:form commandName="account" enctype="multipart/form-data"
							action="${pageContext.request.contextPath }/account/register.html" method="post">
							<s:errors path="username" cssClass="alert alert-danger"
							cssStyle="display: block;" />
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
									<s:input type="text" class="form-control" placeholder="Username" path="username"></s:input>
								</div>
							</div>
							
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
									<s:input type="password" class="form-control" placeholder="Password" path="password"></s:input>
								</div>
							</div>
							
							<%-- <div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-cog"></span></span>
									<input type="password" class="form-control" placeholder="Xác nhận mật khẩu">
								</div>
							</div> --%>
							
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span></span>
									<input type="date" class="form-control" name="dateOfBirth"></input>
									<span class="input-group-addon">Birthday</span>
								</div>
							</div>
							
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-picture"></span></span>
									<div class="custom-file">
										<input name="file" type="file" class="custom-file-input form-control"></input>
										<span class="custom-file-label">Choose avatar</span>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-phone-alt"></span></span>
									<s:input type="text" class="form-control" placeholder="Phone number" path="phone"></s:input>
								</div>
							</div>
							
							<div class="form-group">
								<div class="input-group">
									<span class="input-group-addon"><span class="glyphicon glyphicon-heart"></span></span>
									<s:select class="form-control" path="gender">
										<option selected>Choose gender...</option>
										<option value="male">Male</option>
										<option value="female">Female</option>
										<option value="other">Other</option>
									</s:select>
								</div>
							</div>
							
							${errors }
							<div class="form-group">
								<button type="submit" class="btn btn-success form-control">Sign Up</button>
							</div>
							<div class="text-center">
								<a href="${pageContext.request.contextPath }/home.html">Return home</a>
							</div>
						</s:form>
					</div>
				</div>
				<div class="col-md-4 col-xs-2"></div>
			</div>
		</div>
	</body>
	
	<script src="${pageContext.request.contextPath }/assets/js/jquery-3.2.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/assets/js/pages/login-register.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath }/assets/js/bootstrap.min.js" type="text/javascript"></script>
</html>
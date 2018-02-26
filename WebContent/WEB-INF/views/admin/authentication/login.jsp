<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="row">
	<div
		class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
		<div class="login-panel panel panel-default">
			<div class="panel-heading">Log in</div>
			<div class="panel-body">
				<form role="form" method="post"
					action="${pageContext.request.contextPath }/authentication/logging.html">
					<c:if test="${error != null }">
						<div class="alert bg-danger" role="alert">${error }</div>
					</c:if>
					<c:if test="${logout != null }">
						<div class="alert bg-success" role="alert">${logout }</div>
					</c:if>
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Enter your username!"
								name="username" autofocus />
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Enter your password!"
								name="password" type="password" />
						</div>
						<div class="form-group">
							<input class="form-control btn btn-primary" type="submit"
								value="Enter" />
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
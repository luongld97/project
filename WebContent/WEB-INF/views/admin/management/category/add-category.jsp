<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>


<div class="col-md-6">
	<s:form commandName="category" action="${pageContext.request.contextPath }/admin/category/addcategory.html" method="POST">

		<div class="panel panel-default">
			<div class="panel-body">

				<div class="form-group">
					<label>Category name:</label>
					<s:errors cssClass="alert alert-danger" cssStyle="display: block;" path="name"/>
					<s:input cssClass="form-control" path="name"
						placeholder="Enter category name!" />
				</div>
			</div>
			<div class="panel-footer">
				<div class="text-right">
					<button class="btn btn-primary">SAVE</button>
				</div>
			</div>
		</div>
	</s:form>
</div>
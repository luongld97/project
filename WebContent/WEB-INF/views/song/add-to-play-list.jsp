<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="modal-dialog">
	<div class="modal-content">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">
				<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">Add To Playlist</h4>
		</div>
		<div class="modal-body">
			<div id="add-form"
				style="display: none; border: 0.5px solid yellow; padding: 12px; margin-bottom: 15px; border-radius: 6px;">
				<div class="form-group">
					<span id="name-box-error" style="display: block;"
						class="alert alert-danger hidden"></span> <label>PlayList
						Name: </label> <input baseUrl="${pageContext.request.contextPath }"
						id="play-list-name" class="form-control" type="text" />
				</div>
				<div class="form-group">
					<div class="text-right">
						<button id="btn-add" class="btn btn-primary">ADD PLAY
							LIST</button>
					</div>
				</div>
			</div>
			<div class="form-group">
				<div class="input-group">
					<div class="input-group-btn">
						<button style="height: 42px;" id="btn-toggle" class="btn btn-primary">
							<span class="glyphicon glyphicon-plus" />
						</button>
					</div>
					<select multiple id="play-list-dropbox" class="form-control">
						<c:forEach items="${playLists }" var="playList">
							<option value="${playList.id }">${playList.name }</option>
						</c:forEach>
					</select>
				</div>
			</div>

		</div>
		<div class="modal-footer">
			<button class="btn btn-default" data-dismiss="modal">Close</button>
			<button id="btn-save" class="btn btn-primary">Save</button>
		</div>
	</div>
</div>
<script
	src="${pageContext.request.contextPath }/assets/js/chosen.jquery.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/pages/add-to-play-list.js">
	
</script>
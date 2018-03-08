<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Body Left  -->
<div class="col-xs-3 col-md-3 mb-10">
	<div class="row mt-2">
		<div class="col-xs-3 col-md-3 pr-0">
			<div class="image-avatar img-thumbnail">
				<img
					src="${pageContext.request.contextPath }/assets/images/${sessionScope.currentAccount.photo }"
					class="image-view" alt="Avatar"/>
			</div>
		</div>
		<div class="col-xs-9 col-md-9">
			<div class="pt-2">
				<strong>${sessionScope.currentAccount.username }</strong>
			</div>
		</div>
	</div>
	<hr>
	<ul class="list-item ul-playlist">
		<li><a href="">Playlist<span class="float-right">(${sessionScope.currentAccount.playLists.size() })</span></a></li>
		<li><a href="">Bài hát<span class="float-right">(0)</span></a></li>
		<li><a href="">Video<span class="float-right">(0)</span></a></li>
	</ul>
</div>
<!-- End body Left -->
</html>
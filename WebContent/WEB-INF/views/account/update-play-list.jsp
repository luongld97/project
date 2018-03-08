<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!--Start Body Web-->
<div class="body-web">
	<div class="container bg-web">
		<div class="row">
			<tiles:insertDefinition name="play.list.body.left" />
			<!-- Body Right -->
			<div class="col-md-9">
				
			</div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/assets/js/pages/update-play-list.js">
	
</script>
<!--End Body Web-->
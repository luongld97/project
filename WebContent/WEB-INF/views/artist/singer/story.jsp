<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<div class="body-web">
	<div class="container bg-web">
		<tiles:insertDefinition name="artist.singer.header" />
		<div class="row">
			<!-- Body Left -->
			<div class="col-md-9">
				<div class="col-md-12 body-left">
					<h3 class="color-purple">${singer.name.toUpperCase() }'S STORY</h3>
					<div class="text-justify lyric-f2">
						<p>${singer.description }</p>
					</div>
				</div>
			</div>
			<!-- End Body Left -->
			<!-- Body Right -->
			<div class="col-md-4"></div>
			<!-- End Body Right -->
		</div>
	</div>
</div>
<!--End Body Web-->
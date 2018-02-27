<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
	<div class="profile-sidebar">
		<div class="profile-userpic">
			<img src="http://placehold.it/50/30a5ff/fff" class="img-responsive"
				alt="">
		</div>
		<div class="profile-usertitle">
			<div class="profile-usertitle-name">${account.username }</div>
			<div class="profile-usertitle-status">
				<span class="indicator label-success"></span>Online
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="divider"></div>
	<ul class="nav menu">
			<li><a href="<c:url value = "/admin/home.html"/>"><em class="fa fa-dashboard">&nbsp;</em> Dashboard</a></li>
			<li class="parent"><a data-toggle="collapse" href="#sub-item-entity">
				<em class="fa fa-navicon">&nbsp;</em> Management <span data-toggle="collapse" href="#sub-item-entity" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse ${(currentTab == 'account' || currentTab == 'author'|| currentTab == 'singer'|| currentTab == 'song'|| currentTab == 'album'|| currentTab == 'category') ? 'in' : '' }" id="sub-item-entity">
					
					<li>
						<a ${currentTab == 'account' ? 'class="active"' : '' } href="<c:url value = "/admin/management/account.html"/>">
							<span class="glyphicon glyphicon-user"></span>&nbsp;
							Account
						</a>
					</li>
					<li>
						<a ${currentTab == 'album' ? 'class="active"' : '' }  href="#">
							<span class="glyphicon glyphicon-list-alt"></span>&nbsp;
							Album
						</a>
					</li>
					<li class="parent">
						<a data-toggle="collapse" href="#sub-item-1">
							<span class="glyphicon glyphicon-pencil"></span>&nbsp;
							Artist
							<span data-toggle="collapse" href="#sub-item-1" class="icon pull-right" style="padding-right:20%"><em class="fa fa-plus"></em></span>
						</a>
						<ul class="children collapse ${(currentTab == 'author'|| currentTab == 'singer') ? 'in' : '' }" id="sub-item-1">
<<<<<<< HEAD
								<li><a ${currentTab == 'singer' ? 'class="active"' : '' }  href="<c:url value="/admin/singer.html" />"><span>&nbsp;&nbsp;&nbsp;</span>Singer</a></li>
								<li><a ${currentTab == 'author' ? 'class="active"' : '' } href="#"><span>&nbsp;&nbsp;&nbsp;</span>Author</a></li>
=======
								<li><a ${currentTab == 'singer' ? 'class="active"' : '' }  href="#"><span>&nbsp;&nbsp;&nbsp;</span>Singer</a></li>
								<li><a ${currentTab == 'author' ? 'class="active"' : '' } href="<c:url value="/admin/author.html"/>"><span>&nbsp;&nbsp;&nbsp;</span>Author</a></li>
>>>>>>> aebcd427f9e838debe908e60e97077a2e0239455
						</ul>
					</li>
					<li>
						<a ${currentTab == 'category' ? 'class="active"' : '' } href="#">
							<span class="glyphicon glyphicon-list"></span>&nbsp;
							Category
						</a>
					</li>
					<li>
						<a ${currentTab == 'song' ? 'class="active"' : '' } href="<c:url value="/admin/song.html"/>">
							<span class="glyphicon glyphicon-music"></span>&nbsp;
							Song
						</a>
					</li>
				</ul>
			</li>
			<li><a href="../authentication/logout.html"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
</div>
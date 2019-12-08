<%-- 
    Document   : topBar
    Created on : Dec 3, 2019, 11:00:10 AM
    Author     : QuaMin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="nav-bar fix-position nav-bar-custom d-flex flex-row">
		<div class="container-fluid">
			<a href="" class="navbar-brand logo">
				<span class="logo-text">
					<img src="/template/images/LogoVM.png" alt="logo">
					<span class="text ml-1">VietMart</span>
				</span>
			</a>
			<a href=""  class="bar-menu" id="bar-menu-out"><i class="fas fa-bars"></i></a>

			<div class="app-search">
				<form action="">
					<div class="input-group">
						<input type="text" name="search" class="form-text" placeholder="Search...">
						<button type="submit" class="form-control" ><i class="fas fa-search" id="icon"></i>
						</button>
					</div>
				</form>
			</div>
		</div>
	</div>

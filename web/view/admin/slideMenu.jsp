<%-- 
    Document   : slideMenu
    Created on : Dec 3, 2019, 11:01:30 AM
    Author     : QuaMin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="left-slide-menu" id="bar-menu-out-result">
		<div class='close'>
			<a href="" id="close"><i class="fas fa-window-close"></i></a>
		</div>
		<div class="user-profile mt-2 mb-2">
			<div class="user-profile-body">
				<h6 class="pro-user-name">Tran Quang Minh</h6>
				<span class="role-user">Administrator</span>

			</div>
			<div class="dropdown-menu profile-dropdownmenu">

				<button value="dropdown-admin-user" class="dropdown-btn">
					<i class="fas fa-caret-down"></i>
				</button>
				<div id="dropdown-admin-user" class="dropdown-content">
					<a href="#"><i class="far fa-user"></i> My Account</a>
					<a href="#"><i class="fas fa-cog"></i> Setting</a>
					<a href="#"><i class="fas fa-sign-out-alt"></i> Logout</a>
				</div>

				
			</div>
		</div>
		<!-- end-user-profile -->
		<div class="slide-bar-content">
			<nav class="main-nav">
				<ul>
					<li>
						<h6 class="title-li"><a href="">Dashboard</a></h6>
					</li>
					<li>
						<h6 class="title-li"><i class="fas fa-users"></i> Person</h6>
						<ul>
							<li><a href="/admin/addPerson">Add Person</a></li>
							<!--<li><a href="/admin/editPerson">Edit Person</a></li>-->
							<li><a href="/admin/listPerson">List Person</a></li>
						</ul>
					</li>
					<li>
						<h6 class="title-li"><i class="fab fa-product-hunt"></i> Product</h6>
						<ul>
							<li><a href="/admin/addProduct">Add Product</a></li>
							<!--<li><a href="/admin/editProduct">Edit Product</a></li>-->
							<li><a href="/admin/listProduct">List Product</a></li>
						</ul>
					</li>
<!--					<li>
						<h6 class="title-li"><i class="fas fa-notes-medical"></i> Category</h6>
						<ul>
							<li><a href="">Add Category</a></li>
							<li><a href="">Edit Category</a></li>
							<li><a href="/admin/listCategory">List Category</a></li>
						</ul>
					</li>-->
					<li>
						<h6 class="title-li"><i class="fas fa-cart-plus"></i> Cart</h6>
						<ul>
							<li><a href="/admin/listCart">List Cart</a></li>
						</ul>
					</li>
					
				</ul>
			</nav>
		</div>
	</div>
	<!-- end-slide-menu -->
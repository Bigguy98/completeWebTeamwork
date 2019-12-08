<%-- 
    Document   : header
    Created on : Oct 28, 2019, 10:16:09 AM
    Author     : hoaiphat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="nen">
<div class="topHeader wrap">
	<div class="topHeader-left">
		<ul>
			<li class=>
				<a href=""><i class="far fa-envelope"></i>support@vn.com</a>
			</li>
			<li>
				<i class="fas fa-phone-alt"></i>123456789
			</li>
		</ul>
	</div>
	<div class="topHeader-right">
		<div class="inner">
			<ul>
				<li><a href="">Check out</a></li>
				<li><a href="">Login</a></li>

			</ul>
		</div>
	</div>
</div>
<div class="header wrap">
	<div class="logo">
		<a href=""><img src="/template/images/LogoVM.png" alt=""></a>
	</div>
	<div class="header-right">
		<div class="header-right-inner">
			<ul class="icon">
				<li><a href=""><i class="fab fa-facebook-f"></i></a></li>
				<li><a href=""><i class="fab fa-twitter"></i></a></li>
				<li><a href=""><i class="fab fa-youtube"></i></a></li>
				<li><a href=""><i class="fab fa-google-plus-g"></i></a></li>
			</ul>
			<form action="" class="search">
				<input type="text" name="search" id="search">
                                <button type="button" onclick="btnSearch()"><i class="fas fa-search"></i></button>
			</form>
		</div>

	</div>
</div>
<div class="menu wrap">

	<div class="container">
		
			<div class="menu-left">
				
					<ul class="mainnav">
						<li class="custom-item">
							<a href="/home" class="title">
								<span>Home</span>
							</a>
							
						</li>
						<li class="custom-item">
							<a href="" class="title">
								<span>Category</span>
							</a>
							<div class="dropdown">
								<ul>
									<li class="level1">
										<a href="" class="title-category">Smartphone</a>
										<div class="subdropdown">
											<ul>
												<li><a href=""><i class="fas fa-chevron-right"></i>SamSung</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Iphone</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Sony</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Semi</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Heawei</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Vsmart</a></li>
											</ul>
										</div>
									</li>
									<li class="level1">
										<a href="#" class="title-category" >Tablet</a>
										<div class="subdropdown">
											<ul>
												<li><a href=""><i class="fas fa-chevron-right"></i>SamSung</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Iphone</a></li>
												<li><a href=""><i class="fas fa-chevron-right"></i>Sony</a></li>
											</ul>
										</div>
									</li>
								</ul>
							</div>
						</li>
			
						<li class="custom-item">
							<a href="/cartDetail" class="title">
								<span>Cart</span>
							</a>
						</li>

					</ul>
				</div><!-- end-menu-left -->
				<div class="menu-canvans">
					<a href="">
						<i class="fas fa-bars"></i>
					</a>
				</div>
				<div class="content-menu-canvans">
					<p><i class="fas fa-window-close"></i></p>
					<ul class="title">
						<li>
							<span class="level-1">Home</span>
							<hr class="ngang">
						</li>
						<li>
							<div class="icon-show-category">
								<i class="fas fa-plus"></i>
								<i class="fas fa-minus"></i>
							</div>
							<span class="level-1">Category</span>
							<hr class="ngang">
							<ul class="content-level-1">
								<li>
									<div class="icon-show-category">
										<i class="fas fa-plus"></i>
										<i class="fas fa-minus"></i>
									</div>
									<span class="level-2">SmartPhone</span>
									<hr class="ngang">
									<ul class="content-level-2">
										<li>
											<a href=""><i class="fas fa-chevron-right"></i>SamSung</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Iphone</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Sony</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Semi</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Heawei</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Vsmart</a></li>
									</ul>
								</li>
								<li>
									<div class="icon-show-category">
										<i class="fas fa-plus"></i>
										<i class="fas fa-minus"></i>
									</div>
									<span class="level-2">Tablet</span>
									<hr class="ngang">
									<ul class="content-level-2">
									
										<li><a href=""><i class="fas fa-chevron-right"></i>SamSung</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Iphone</a></li>
										<li><a href=""><i class="fas fa-chevron-right"></i>Sony</a></li>
											
									</ul>
								</li>
							</ul>
						</li>
						<li>
							<span class="level-1">Contact</span>
							<hr class="ngang">
						</li>
					</ul>
				</div>
				<div class="menu-right">
					<div class="menu-right-inner">
						<div class="icon">
							<a href=""><i class="fas fa-cart-plus"></i></a>
						</div>
					</div>
				</div><!-- end-menu-right -->
			
		
	</div>
	
</div>
	<div class="slide">
		<div class="container-slide">
			<div class="slide-left">
				<h1>Khuyến mãi ngập tràn mua hàng VN</h1>
				<p><i class="fas fa-check"></i>Hàng chính hãng 100%</p>
				<p><i class="fas fa-check"></i>Bảo hành 2 năm</p>
				<p><i class="fas fa-check"></i>Tặng các phụ kiện </p>
				<p><i class="fas fa-check"></i>Tặng ngay một phiếu mua hàng trị giá 1.000.000đ cho tất cả các khách hàng</p>

			</div>
			<div class="slide-right">
				<div class="slide1">
					<img src="/template/images/slide1.png" alt="" class="img-1">
				</div>
				<div class="slide2">
					<img src="/template/images/slide2.jpg" alt="" class="img-2">
				</div>
			</div>
		</div>
	</div>
</div>
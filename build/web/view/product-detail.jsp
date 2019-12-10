<%-- 
    Document   : product-detail
    Created on : Oct 28, 2019, 9:01:27 AM
    Author     : hoaiphat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">

	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	
        <link rel="stylesheet" href="/template/css/index.css">
	<link rel="stylesheet" href="/template/css/product-detail.css">

	<link rel="stylesheet" href="/template/fontawesome/css/all.css">
	<link rel="stylesheet" href="/template/fontawesome/css/fontawesome.min.css">

	<title>Product-detail</title>
</head>
<body>
	<jsp:include page="/view/header.jsp"></jsp:include>
	<ol class="breadcrumb">
		<li>
			<a href="">Home</a>
		</li>
		<li>
			<a href="">Category</a>
		</li>
		<li class="active"> iphone11-pro
		</li>
	</ol>
        <% int itemId = Integer.valueOf(request.getParameter("item_id")) ; %>
        <script>var itemId =<%= itemId%>;
            console.log("item id: " + itemId);
        </script>
        
	<div class="a-product-detail">
		<div class="a-product-detail-inner">
			<div class="col-6 col-12 img-product">
				<div class="img-show">
					<img  alt="" id="product-image">
				</div>
			</div>
			<div class="col-6 col-12 info-product">
				<div class="info-product_inner">
					<h4 class="name-product" id="product-name"></h4>
					<h4 class="price-product" id="product-price"></h4>
					<div class="marketing-product">
						<ul class="detail" id="product-info">
                                                    <li id="screen"></li>
                                                    <li id="selfieCamera"></li>
                                                    <li id="mainCamera"></li>
                                                    <li id="ram"></li>
                                                    <li id="rom"></li>
                                                    <li id="gpu"></li>
                                                    <li id="cpu"></li>
                                                    <li id="os"></li>
						</ul>
					</div>

<!--					<div class="choose-color">
						<div class="label">Màu</div>
						<div class="select-a-color">
							<select name="" id="">
								<option>Chọn màu</option>
								<option>Xám</option>
								<option>Đen</option>
								<option>Đỏ</option>
							</select>
						</div>
					</div>-->

					<div class="quantity-product">
						<div class="label">Số lượng</div>
						<div class="quantity-product-inner">
							<div class="quantity">
								<input type="number" id="item-number" min="1">
							</div>
						</div>
					</div>
					<div class="add-product">
						<button type="submit" onclick="addItemToCart()"> Thêm</button>
					</div>
				</div>
			</div>

		</div>
	</div>
	<jsp:include page="/view/footer.jsp" ></jsp:include>

        <script src="/template\js\jquery.min.js"></script>

	<script src="/template/js/product-detail.js" type="text/javascript"></script>

</body>
</html>

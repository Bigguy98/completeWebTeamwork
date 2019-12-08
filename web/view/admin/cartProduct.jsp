<%-- 
    Document   : welcomAdmin
    Created on : Dec 3, 2019, 10:59:20 AM
    Author     : QuaMin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="/template/fontawesome/css/all.css">
        
	<link rel="stylesheet" href="/template/css/admin.css">
        <title>Cart Product</title>
    </head>
    <body>
        <jsp:include page="/view/admin/topBar.jsp"></jsp:include>
        
        <jsp:include page="/view/admin/slideMenu.jsp"></jsp:include>

        <div class="content-page">
		<div class="content">
			<div class="container-fluid-content">
				<div class="row page-title">
					<div class="col-6 col-4">
						<h4>Cart Product</h4>
					</div>
					<div class="col-6 col-8">
						<form action="" class="search-control" method="post">
							<div class="search-text">
								<input type="text" placeholder="Search..." name="name-search">
							</div>
							<button type="submit"><i class="fas fa-search"></i></button>
						</form>
					</div>
				</div>
				<!-- end-title -->
				<div class="row">
					<div class="table-content cart-product">
						<table class="table">
							
								<tr class="table-header">
									<th class="column-1">id</th>
									<th class="column-2">name-product</th>
									<th class="column-3">quantity</th>
									<th class="column-4">by-price</th>
									<th class="column-5">total</th>
								</tr>
							<tbody class="table-tbody" id="table-tbody">
								<tr class="table-content">
									<td class="column-1">1</td>
									<td class="column-2">Samsung Galaxy A50 (No.00543138)</td>
									<td class="column-3">3</td>
									<td class="column-4">6990000</td>
									<td class="column-5">
										
									</td>
								</tr>
							</tbody>
						</table>
					</div>
					
				</div>
					
				
			</div>
		</div>
	</div>
        <input type="hidden" id="hidden_id" value="${idCart}">


        <script type="text/javascript" src="/template/js/admin.js"></script>
        <script type="text/javascript" src="/template/js/jquery.min.js"></script>
        <script type="text/javascript" src="/template/js/admin/cartProduct.js"></script>
        
    </body>
</html>

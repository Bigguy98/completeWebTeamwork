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
        <title>Cart Client</title>
    </head>
    <body>
        <jsp:include page="/view/admin/topBar.jsp"></jsp:include>
        
        <jsp:include page="/view/admin/slideMenu.jsp"></jsp:include>

        <div class="content-page">
		<div class="content">
			<div class="container-fluid-content">
				<div class="row page-title">
					<div class="col-6 col-4">
						<h4>Cart Client</h4>
					</div>
					<div class="col-6 col-8">
						<form action="" class="search-control" method="get">
							<div class="search-text">
								<input type="text" placeholder="Search..." name="name-search">
							</div>
							<button type="submit"><i class="fas fa-search"></i></button>
						</form>
					</div>
				</div>
				<!-- end-title -->
				<div class="row">
					<div class="table-content list-cart">
						<table class="table">
							
								<tr class="table-header">
									<th class="column-1">id</th>
									<th class="column-2">name-client</th>
									<th class="column-3">name-product</th>
									<th class="column-4">by-date</th>
									<th class="column-5"></th>
								</tr>
							<tbody class="table-tbody" id="my-cart-table">
								<tr class="table-content">
									<td class="column-1">1</td>
									<td class="column-2">Tran Quang Minh</td>
									<td class="column-3">
										<a href="?id=">Detail</a>	
									</td>
									<td class="column-4">2-12-2019</td>
									<td class="column-5">
										<a href="">Delete</a> |
										<a href="">Edit</a>
									</td>
								</tr>
							</tbody>
                                                        
						</table>
                                            <div class="center-flex">
                                                            <button id="first" type="submit" onclick="first()">First</button>
                                                            <button id="previous" type="submit" onclick="previous()">Previous</button>
                                                            <button id="next" type="submit" onclick="next()">Next</button>
                                                            <button id="last" type="submit" onclick="last()">Last</button>
                                                        </div>
					</div>
					
				</div>
			</div>
		</div>
	</div>



        <script type="text/javascript" src="/template/js/admin.js"></script>
        <script type="text/javascript" src="/template/js/jquery.min.js"></script>
         <script type="text/javascript" src="/template/js/admin/cartClient.js"></script>
    </body>
</html>

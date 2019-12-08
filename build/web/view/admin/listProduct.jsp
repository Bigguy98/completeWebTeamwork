<%-- 
    Document   : welcomAdmin
    Created on : Dec 3, 2019, 10:59:20 AM
    Author     : QuaMin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="/template/fontawesome/css/all.css">
        
	<link rel="stylesheet" href="/template/css/admin.css">
        <title>List Person</title>
    </head>
    <body>
        <jsp:include page="/view/admin/topBar.jsp"></jsp:include>
        
        <jsp:include page="/view/admin/slideMenu.jsp"></jsp:include>

        <div class="content-page">
		<div class="content">
			<div class="container-fluid-content">
				<div class="row page-title">
					<div class="col-6 col-4">
						<h4>List Product</h4>
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
					<div class="table-content list-product">
						<table class="table">
							
								<tr class="table-header">
									<th class="column-1">id</th>
									<th class="column-2">image</th>
									<th class="column-3">name</th>
									<th class="column-4">price</th>
									<th class="column-5">descript</th>
									<th class="column-6"></th>
								</tr>
							<tbody class="table-tbody" id="table-tbody">	
								<tr class="table-content">
									<td class="column-1">1</td>
									<td class="column-2"><img src="https://cdn.fptshop.com.vn/Uploads/Originals/2019/3/13/636880892473841431_ss-galaxy-a50-den-1.png" alt="image+product"></td>
									<td class="column-3">Samsung Galaxy A50 (No.00543138)</td>
									<td class="column-4">6990000</td>
									<td class="column-5">
										<span class="descript-product">
											Screen: 6.4 inches, 1080 x 2340 Pixels
										</span>
										<span class="descript-product">
											Selfiecamera: 25 MP
										</span>
										<span class="descript-product">
											Maincamera: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Ram: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Rom: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Cpu: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Gpu: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Battery: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Os: 25 MP, 8 MP and 5 MP
										</span>
										<span class="descript-product">
											Sim: 25 MP, 8 MP and 5 MP
										</span>
									</td>
									<td class="column-6">
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

        <script type="text/javascript" src="/template/js/jquery.min.js"></script>                                                               
        <script type="text/javascript" src="/template/js/admin.js"></script>
        <script type="text/javascript" src="/template/js/admin/listProduct.js"></script>
    </body>
</html>

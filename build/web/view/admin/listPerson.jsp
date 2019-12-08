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
						<h4>List Person</h4>
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
					<div class="table-content">
						<table class="table">
							
								<tr class="table-header">
									<th class="column-1">id</th>
									<th class="column-2">name</th>
									<th class="column-3">age</th>
									<th class="column-4">address</th>
									<th class="column-5">role</th>
									<th class="column-6"></th>
								</tr>
                                                        <tbody class="table-tbody" id="table-tbody">
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
        <script type="text/javascript" src="/template/js/admin/listPerson.js"></script>
    </body>
</html>

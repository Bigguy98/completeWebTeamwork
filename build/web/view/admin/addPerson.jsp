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
        <title>Add Person</title>
    </head>
    <body>
        <jsp:include page="/view/admin/topBar.jsp"></jsp:include>
        
        <jsp:include page="/view/admin/slideMenu.jsp"></jsp:include>

      <div class="content-page">
		<div class="content">
			<div class="container-fluid-content">
				<div class="row page-title">
					<div class="col-6 col-4">
						<h4>Add Person</h4>
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
					<div class="add">
                                            <form >
							<div class="text-box" >
								<label for="name">Name: </label>
								<input type="text" name="name" id="name" placeholder="Name...">
							</div>
							<div class="text-box" >
								<label for="age">Age: </label>
								<input type="number" name="age" id="age" placeholder="Age...">
							</div>
							<div class="text-box" >
								<label for="address">Address: </label>
								<input type="text" name="address" id="address" placeholder="Address...">
							</div>
							<div class="text-box" >
								<label for="username">Username: </label>
								<input type="text" name="username" id="username" placeholder="Username...">
							</div>
							<div class="text-box" for="password">
								<label for="password">Password: </label>
								<input type="password" name="password" id="password" placeholder="Password...">
							</div>
                                                        <input type="hidden" name="role" id="role" value="ADMIN">
                                                        <button type="button" onclick="add_person()">Add Person</button>
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>


        <script type="text/javascript" src="/template/js/admin.js"></script>
        <script type="text/javascript" src="/template/js/jquery.min.js"></script>
        <script type="text/javascript" src="/template/js/admin/addPerson.js"></script>
    </body>
</html>

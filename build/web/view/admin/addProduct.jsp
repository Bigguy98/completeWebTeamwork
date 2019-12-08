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
        
        <title>Add Product</title>
    </head>
    <body>
        <jsp:include page="/view/admin/topBar.jsp"></jsp:include>
        
        <jsp:include page="/view/admin/slideMenu.jsp"></jsp:include>

        <div class="content-page">
		<div class="content">
			<div class="container-fluid-content">
				<div class="row page-title">
					<div class="col-6 col-4">
						<h4>Add Product</h4>
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
					<div class="add-product">
                                            <form action="" class="form-add-product" id="fileUploadForm" enctype="multipart/form-data">
							<div class="box-form">
								<div class="form-left">
									<div class="text-box" >
										<label for="name">Name: </label>
										<input type="text" name="name" id="name" placeholder="Name...">
									</div>
									<div class="text-box" >
										<label for="price">Price: </label>
										<input type="number" name="price" id="price" placeholder="Price...">
									</div>
									<div class="text-box" >
										<label for="screen">Screen: </label>
										<input type="text" name="screen" id="screen" placeholder="Screen...">
									</div>
									<div class="text-box" >
										<label for="selfiecamera">SelfieCamera: </label>
										<input type="text" name="selfiecamera" id="selfiecamera" placeholder="SelfieCamera...">
									</div>
									<div class="text-box">
										<label for="maincamera">MainCamera: </label>
										<input type="text" name="maincamera" id="maincamera" placeholder="MainCamera...">
									</div>
									<div class="text-box">
										<label for="ram">Ram: </label>
										<input type="text" name="ram" id="ram" placeholder="Ram...">
									</div>
									<div class="text-box">
										<label for="rom">Rom: </label>
										<input type="text" name="rom" id="rom" placeholder="MainCamera...">
									</div>
								</div>
							</div>
							<div class="box-form">
								<div class="form-right">
									<div class="text-box">
										<label for="cpu">Cpu: </label>
										<input type="text" name="cpu" id="cpu" placeholder="Cpu...">
									</div>
									<div class="text-box">
										<label for="gpu">Gpu: </label>
										<input type="text" name="gpu" id="rom" placeholder="Gpu...">
									</div>
									<div class="text-box">
										<label for="battery">Battery: </label>
										<input type="text" name="battery" id="battery" placeholder="Battery...">
									</div>
									<div class="text-box">
										<label for="os">Os: </label>
										<input type="text" name="os" id="os" placeholder="Os...">
									</div>
									<div class="text-box">
										<label for="sim">Sim: </label>
										<input type="text" name="sim" id="sim" placeholder="Sim...">
									</div>
									<div class="text-box">
										<label for="image">Image: </label>
										<input type="file" name="file" id="file" placeholder="Image...">
									</div>

                                                                    <button type="button" onclick="addPerson()">Add Product</button>
								</div>
							</div>
						</form>
					</div>
					
				</div>
			</div>
		</div>
	</div>


        <script type="text/javascript" src="/template/js/jquery.min.js"></script>
        <script type="text/javascript" src="/template/js/admin.js"></script>
        <script type="text/javascript" src="/template/js/admin/addProduct.js"></script>
    </body>
</html>

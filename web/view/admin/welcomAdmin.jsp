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
        <title>Welcome</title>
    </head>
    <body>
        <jsp:include page="/view/admin/topBar.jsp"></jsp:include>
        
        <jsp:include page="/view/admin/slideMenu.jsp"></jsp:include>

        <div class="content-page">
		<div class="content">
			<div class="container-fluid-content">
				<div class="row page-title">
					<div class="col-6 col-4">
						<h4>Dashboard</h4>
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
					<div class="welcome-page">
						<h3><i class="fas fa-hand-peace"></i>Welcome!</h3>
						<p>This is an admin site that sells phones online</p>
				
					</div>
				</div>
				<div class="footer">Design by team <a href="">LapTrinhWeb</a></div>
			</div>
		</div>
	</div>

        <script type="text/javascript" src="/template/js/admin.js"></script>
    </body>
</html>

<%-- 
    Document   : login
    Created on : Oct 28, 2019, 9:01:02 AM
    Author     : hoaiphat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8"> 
	
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" href="/template/fontawesome/css/all.css">
	<link rel="stylesheet" href="/template/css/login.css">
	<title>Login</title>
</head>
<body>
	<div class="background">
		<div class="login">
                    <form action="/loginAdmin" method="post">
				<span class="logo top"><img src="template/images/LogoVM.png" alt=""></span>
				<span class="title top">Login</span>
				<div class="text-box">
					<i class="fas fa-user"></i>
					<input type="text" id="login-username" name="username" placeholder="Username">
					<span id="erroruser"></span>
				</div>
				<div class="text-box">
					<i class="fas fa-lock"></i>
					<input type="password" id="login-password"  name="password" placeholder="Password">
					<span id="errorpass"></span>
				</div>
				<div class="forget">
					<a href="">Forgot password?</a>
				</div>
				<div class="remember">
					<input type="checkbox" id="check">
					<label for="check">Remember</label>

				</div>
				<div class="btn">
                                    <input type="submit" value="Log in"  style="margin-right: 20px">
                                                                                                                                             
				</div>
			</form>
		</div>
	</div>
        <script src="/template/js/jquery.min.js"></script>
<!--	<script type="text/javascript" src="template/js/login.js"></script> onclick="login()"-->
        
</body>
</html>

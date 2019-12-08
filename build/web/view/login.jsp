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
                        <form>
				<span class="logo top"><img src="template/images/LogoVM.png" alt=""></span>
				<span class="title top">Login</span>
				<div class="text-box">
					<i class="fas fa-user"></i>
					<input type="text" id="login-username" placeholder="Username">
					<span id="erroruser"></span>
				</div>
				<div class="text-box">
					<i class="fas fa-lock"></i>
					<input type="password" id="login-password" placeholder="Password">
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
                                    <input type="button" value="Log in" onclick="login()" style="margin-right: 20px">
                                    <input type="button" onclick="showSigninPage()"  value="Sign in">                                                                                                           
				</div>
			</form>
			
			<div class="register">
				<form>
					<span class="logo top"><img src="template/images/LogoVM.png" alt=""></span>
					<span class="title top">Register</span>
					<div class="text-box">
						<input type="text" id="signin-name" placeholder="Name">
					</div>
					
					<div class="text-box">
						<input type="text" id="signin-address" placeholder="Address">
					</div>		
					<div class="text-box">
						<input type="text" id="signin-username" placeholder="Username">
					</div>
					<div class="text-box">
						<input type="password" id="signin-password" placeholder="Password">
					</div>
                                        <div class="text-box">
						<input type="text" id="signin-age" placeholder="Age">
					</div>
                                        <div class="btn" >
                                            <input type="button" value="Back  " onclick="hideSigninPage()" style="margin-right: 20px">
                                            <input type="button" value="Submit" onclick="signin()">
					</div>
				</form>
			</div>

		</div>
	</div>
        <script src="/template/js/jquery.min.js"></script>
	<script type="text/javascript" src="/template/js/login.js"></script>
        
</body>
</html>

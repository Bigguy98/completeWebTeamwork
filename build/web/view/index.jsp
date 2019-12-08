<%-- 
    Document   : index
    Created on : Oct 28, 2019, 9:00:50 AM
    Author     : hoaiphat
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="/template/css/index.css">
    <link rel="stylesheet" href="/template/fontawesome/css/all.css">

    <title>Index</title>
</head>
<body>
    <jsp:include page="/view/header.jsp"></jsp:include>

    <jsp:include page="/view/banner.jsp"></jsp:include>

	<div class="product">
		<div class="product-inner">
			<div class="title-product">
				<h1>Sản phẩm</h1>
				<hr class=line>
			</div>
			<div class="intro-product">
				<p>"Càng mua Càng rẻ" Chúng tôi không cố gắng để thuyết phục người dùng về điều chỉnh suy nghĩ của mình, mà đơn giản, đó chỉ là tìm cách tốt nhất để tiết kiệm tài chính phục vụ cho lợi ích của chính mình. Đó cũng chính là những gì chúng tôi cố gắng để đem đến cho người dùng một lời giới thiệu ý nghĩa nhất.</p>
			</div>
			<div class="list-product" id="list-items">			
				
			</div>

		</div>
	</div>
    <div class="center-flex">
        <button id="first" type="submit" onclick="first()">First</button>
        <button id="previous" type="submit" onclick="previous()">Previous</button>
        <button id="next" type="submit" onclick="next()">Next</button>
        <button id="last" type="submit" onclick="last()">Last</button>
    </div>
    <jsp:include page="/view/footer.jsp" ></jsp:include>
    <script src="/template\js\jquery.min.js" type="text/javascript"></script>
    <script src="/template\js\index.js" type="text/javascript"></script>
</body>
</html>


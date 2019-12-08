
var pageSize = 10;
var currentPage = 1;
var totalPage;
$(document).ready(function () {
    if(sessionStorage.getItem("userId")  === null) location.pathname = "/login";
    
    getTotalPage();
    getItem();
    
});
function getTotalPage() {
    
    $.ajax({
        url: "/item/count",
        type: "get",
        success: function (number) {
            totalPage = Math.ceil(number/pageSize);
            console.log("total items: " + number);
        }
        
    });
}
function getItem() {
    $('#list-items').empty();
    $.ajax({
        url: "/item/getAll",
        type: "get",
        data: {
            "pageSize": pageSize,
            "currentPage": currentPage
        },
        success: function (data) {
            generateView(JSON.parse(data));
        }
        
    });
}
function generateView(data) {
    data.forEach(function(item){
        console.log(item.name + " " + item.price);
        
        var item_product = document.createElement("div");
        item_product.setAttribute("class", "item-product col-4 col-12 col-6");
        
        var item_inner = document.createElement("div");
        item_inner.setAttribute("class", "item-inner");
        
        var item_img_cart = document.createElement("div");
        item_img_cart.setAttribute("class","item-img-cart");
        
        var item_cart_info = document.createElement("div");
        item_cart_info.setAttribute("class","item-cart-info");
        
        var a = document.createElement("a");
        a.setAttribute("href","/detail?item_id=" + item.id);
        
        var i = document.createElement("i");
        i.setAttribute("class","fas fa-cart-plus");
        
        a.appendChild(i);
        item_cart_info.appendChild(a);
        
        var item_img_info = document.createElement("div");
        item_img_info.setAttribute("class","item-img-info");
        
        var img = document.createElement("img");
        img.setAttribute("src", "/image?image=" + item.image);
        
        item_img_info.appendChild(img);
        
        item_img_cart.appendChild(item_cart_info);
        item_img_cart.appendChild(item_img_info);
        
        var item_info = document.createElement("div");
        item_info.setAttribute("class", "item-info");
        
        var price = document.createElement("h2");
        price.setAttribute("class","price-product");
        price.innerHTML = item.price;
        
        var name = document.createElement("h2");
        name.setAttribute("class","name-product");
        name.innerHTML = item.name;
        
        item_info.appendChild(name);
        item_info.appendChild(price);
        
        item_inner.appendChild(item_img_cart);
        item_inner.appendChild(item_info);
        
        item_product.appendChild(item_inner);
        
        $('#list-items').append(item_product);
    });
    
    check();
}

$(function () {

	$('.content-level-1 i.fas.fa-plus:first()').click(function(event) {
		$('.menu .content-level-1 ul.content-level-2:first()').addClass('show');
		$('.menu .content-menu-canvans .content-level-1 .icon-show-category i.fas.fa-minus:first()').addClass('show');
		$('.menu .content-menu-canvans .content-level-1 .icon-show-category i.fas.fa-plus:first()').addClass('hidden');
		/* Act on the event */
	});

	$('.content-level-1 i.fas.fa-plus:last()').click(function(event) {
		$('.menu .content-level-1 ul.content-level-2:last()').addClass('show');
		$('.menu .content-menu-canvans .content-level-1 .icon-show-category i.fas.fa-minus:last()').addClass('show');
		$('.menu .content-menu-canvans .content-level-1 .icon-show-category i.fas.fa-plus:last()').addClass('hidden');
		/* Act on the event */
	});

	$('.title i.fas.fa-plus:first()').click(function(event) {
		$('.menu .content-menu-canvans ul.content-level-1:first()').addClass('show');
		$('.menu .content-menu-canvans .icon-show-category i.fas.fa-minus:first()').addClass('show');
		$('.menu .content-menu-canvans .icon-show-category i.fas.fa-plus:first()').addClass('hidden');
		/* Act on the event */
	});

	$('.menu-canvans i.fas.fa-bars').click(function(event) {
		$('.menu .content-menu-canvans').addClass('menu-show');
		return false;
		/* Act on the event */
	});

	$('.menu .content-menu-canvans i.fas.fa-window-close').click(function(event) {
		$('.menu .content-menu-canvans').removeClass('menu-show');
		return false;
		/* Act on the event */
	});
	// body...
});

function first() {
    currentPage = 1;
    getItem();
}
function previous() {
    currentPage -= 1;
    getItem();
}

function next() {
    currentPage += 1;
    getItem();
}
function last() {
    currentPage = totalPage;
    getItem();
}
function check() {
    console.log(currentPage + " " + totalPage);
    document.getElementById("first").disabled = currentPage === 1 ? true: false;
    document.getElementById("previous").disabled = (currentPage === 1) ? true: false;
    document.getElementById("next").disabled = (currentPage === totalPage) ? true: false;
    document.getElementById("last").disabled = (currentPage === totalPage) ? true: false;
}

//function getTotalPageSearch(){
//
//    $.ajax({
//        url: "/customer/countItemSearch",
//        type: 'GET',
//        data: {
//            "name" : name
//        },
//        success: function (data, textStatus, jqXHR) {
//            console.log(data);
//            totalPage = Math.ceil(data/pageSize);
//        },error: function (jqXHR, textStatus, errorThrown) {
//            alert("GetCountItemSearch fail");
//        }
//    });
//}
function btnSearch(){
//    getTotalPageSearch();
    $('#list-items').empty();
    var name = document.getElementById("search").value;
    $.ajax({
        url: "/customer/searchItem",
        type: "get",
        data: {
            "name" : name
        },
        success: function (data) {
            console.log(data);
            showItemSearch(JSON.parse(data));
            disableButtons();
        }
        
    });
}
function showItemSearch(data){
    data.forEach(function(item){
        console.log(item.name + " " + item.price);
        
        var item_product = document.createElement("div");
        item_product.setAttribute("class", "item-product col-4 col-12 col-6");
        
        var item_inner = document.createElement("div");
        item_inner.setAttribute("class", "item-inner");
        
        var item_img_cart = document.createElement("div");
        item_img_cart.setAttribute("class","item-img-cart");
        
        var item_cart_info = document.createElement("div");
        item_cart_info.setAttribute("class","item-cart-info");
        
        var a = document.createElement("a");
        a.setAttribute("href","/detail?item_id=" + item.id);
        
        var i = document.createElement("i");
        i.setAttribute("class","fas fa-cart-plus");
        
        a.appendChild(i);
        item_cart_info.appendChild(a);
        
        var item_img_info = document.createElement("div");
        item_img_info.setAttribute("class","item-img-info");
        
        var img = document.createElement("img");
        img.setAttribute("src", "/image?image=" + item.image);
        
        item_img_info.appendChild(img);
        
        item_img_cart.appendChild(item_cart_info);
        item_img_cart.appendChild(item_img_info);
        
        var item_info = document.createElement("div");
        item_info.setAttribute("class", "item-info");
        
        var price = document.createElement("h2");
        price.setAttribute("class","price-product");
        price.innerHTML = item.price;
        
        var name = document.createElement("h2");
        name.setAttribute("class","name-product");
        name.innerHTML = item.name;
        
        item_info.appendChild(name);
        item_info.appendChild(price);
        
        item_inner.appendChild(item_img_cart);
        item_inner.appendChild(item_info);
        
        item_product.appendChild(item_inner);
        
        $('#list-items').append(item_product);
    });
    
    check();
}
function disableButtons(){
    document.getElementById("first").disabled = true;
    document.getElementById("previous").disabled = true;
    document.getElementById("next").disabled = true;
    document.getElementById("last").disabled = true;
}
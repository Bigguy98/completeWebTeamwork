/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var pageSize = 10;
var currentPage = 1;
var totalPage ;

$(document).ready(function (){
    getTotalPage();
    getCart();
});

function getTotalPage(){
    $.ajax({
        url : "/admin/getCountCart",
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            totalPage= Math.ceil(data/pageSize);
            console.log(data);
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("getTotalPage error");
        }
    });
}


function getCart(){
    $('#my-cart-table').empty();
    $.ajax({
        url : "/admin/getCartPage",
        type: 'get',
        data: {
            "pageSize" : pageSize,
            "currentPage" : currentPage
        },success: function (data, textStatus, jqXHR) {
            console.log(data);
            showCart(JSON.parse(data));
        }
        
    });
}
function showCart(data){
    data.forEach(function (cart){
        console.log(cart.id);
        var cover =document.createElement("tr");
        cover.setAttribute("class","table-content");
        
        var column_1 = document.createElement("td");
        column_1.setAttribute("class","column-1");
        column_1.innerHTML = cart.id;
        
        var column_2 = document.createElement("td");
        column_2.setAttribute("class","column-2");
        column_2.innerHTML = cart.owner.name;
        
        var column_3 = document.createElement("td");
        column_3.setAttribute("class","column-3");
        var a_detail=document.createElement("a");
        a_detail.setAttribute("href","/admin/cartItem?idCart="+cart.id);
        a_detail.innerHTML="Detail";
        
        column_3.appendChild(a_detail);
        
        var column_4 = document.createElement("td");
        column_4.setAttribute("class","column-4");
        column_4.innerHTML=cart.creationTime;
        
        var column_5 = document.createElement("td");
        column_5.setAttribute("class","column-5");
        
        
//        var a_delete = document.createElement("a");
//        a_delete.setAttribute("href","#");
//        a_delete.onclick = function (){
//            deleteCart(cart.id);
//        };
//        a_delete.innerHTML = "Delete";
               
//        column_5.appendChild(a_delete);
      
        
        cover.appendChild(column_1);
        cover.appendChild(column_2);
        cover.appendChild(column_3);
        cover.appendChild(column_4);
        cover.appendChild(column_5);
        $('#my-cart-table').append(cover);
    });
    check();
}
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
    document.getElementById("first").disabled = currentPage === 1 ? true: false;
    document.getElementById("previous").disabled = (currentPage === 1) ? true: false;
    document.getElementById("next").disabled = (currentPage === totalPage) ? true: false;
    document.getElementById("last").disabled = (currentPage === totalPage) ? true: false;
}




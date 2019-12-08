
var pageSize = 10;
var currentPage = 1;
var totalPage;
$(document).ready(function () {
    getTotalPage();
    getItem();
    
});
function getTotalPage() {
    
    $.ajax({
        url: "/admin/countProduct",
        type: "get",
        success: function (number) {
            totalPage = Math.ceil(number/pageSize);
            console.log("total items: " + number);
        }
        
    });
}
function getItem() {
    $('#table-tbody').empty();
    $.ajax({
        url: "/admin/getProductPage",
        type: "get",
        data: {
            "pageSize": pageSize,
            "currentPage": currentPage
        },
        success: function (data) {
            showProduct(JSON.parse(data));
        }
        
    });
}
function showProduct(data) {
    data.forEach(function(item){
        console.log(item.name + " " + item.price);
//        /image?image=" + item.image
         var cover =document.createElement("tr");
        cover.setAttribute("class","table-content");
        
        var column_1 = document.createElement("td");
        column_1.setAttribute("class","column-1");
        column_1.innerHTML = item.id;
        
        var column_2 = document.createElement("td");
        column_2.setAttribute("class","column-2");
        var img = document.createElement("img");
     //   img.setAttribute("src","/image?image=" + item.image);
        
        var column_3 = document.createElement("td");
        column_3.setAttribute("class","column-3");
        column_3.innerHTML = item.name;
        
        var column_4 = document.createElement("td");
        column_4.setAttribute("class","column-4");
        column_4.innerHTML = item.price;
        
        var column_5 = document.createElement("td");
        column_5.setAttribute("class","column-5");
        var span1 =document.createElement("span");
        span1.setAttribute("class","descript-product");
        span1.innerHTML="Screen: "+item.screen;
        var span2 =document.createElement("span");
        span2.setAttribute("class","descript-product");
        span2.innerHTML="selfiecamera: "+item.selfieCamera;
        var span3 =document.createElement("span");
        span3.setAttribute("class","descript-product");
        span3.innerHTML="maicamera: "+item.mainCamera;
        var span4 =document.createElement("span");
        span4.setAttribute("class","descript-product");
        span4.innerHTML="Ram: "+item.ram;
        
        var span5 =document.createElement("span");
        span5.setAttribute("class","descript-product");
        span5.innerHTML="Rom: "+item.rom;
        var span6 =document.createElement("span");
        span6.setAttribute("class","descript-product");
        span6.innerHTML="Cpu: "+item.cpu;
        var span7 =document.createElement("span");
        span7.setAttribute("class","descript-product");
        span7.innerHTML="Gpu: "+item.gpu;
        var span8 =document.createElement("span");
        span8.setAttribute("class","descript-product");
        span8.innerHTML="Battery: "+item.battery;
        var span9 =document.createElement("span");
        span9.setAttribute("class","descript-product");
        span9.innerHTML="Os: "+item.os;
        var span10 =document.createElement("span");
        span10.setAttribute("class","descript-product");
        span10.innerHTML="Sim: "+item.sim;
        
        column_5.appendChild(span1);
        column_5.appendChild(span2);
        column_5.appendChild(span3);
        column_5.appendChild(span4);
        column_5.appendChild(span5);
        column_5.appendChild(span6);
        column_5.appendChild(span7);
        column_5.appendChild(span8);
        column_5.appendChild(span9);
        column_5.appendChild(span10);
        
        
        var column_6 = document.createElement("td");
        column_6.setAttribute("class","column-6");
        
//        var a_delete = document.createElement("a");
//        a_delete.setAttribute("href","#");
//        a_delete.onclick = deletePerson(customer.id);
//        a_delete.innerHTML = "Delete";
        
        var a_edit = document.createElement("a");
        a_edit.setAttribute("href","/admin/editProduct?idProduct="+item.id);
        a_edit.innerHTML="Edit";
        
//        column_6.appendChild(a_delete);
      
        column_6.appendChild(a_edit);
        
        cover.appendChild(column_1);
        cover.appendChild(column_2);
        cover.appendChild(column_3);
        cover.appendChild(column_4);
        cover.appendChild(column_5);
        cover.appendChild(column_6);
        $('#table-tbody').append(cover);
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
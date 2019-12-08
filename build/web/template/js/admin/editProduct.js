$(document).ready(function (){
    getProduct();
});

var idProduct = $('#idProduct').val();
function getProduct(){
    $.ajax({
        
        url:"/item/getById?itemId="+idProduct,
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            showItem(JSON.parse(data));
        }
    });
}
function showItem(data){
    
    document.getElementById("name").value=data.name;
    document.getElementById("price").value=data.price;
    document.getElementById("screen").value=data.screen;
    document.getElementById("selfiecamera").value=data.selfieCamera;
    document.getElementById("maincamera").value=data.mainCamera;
    document.getElementById("ram").value=data.ram;
    document.getElementById("rom").value=data.rom;
    document.getElementById("cpu").value=data.cpu;
    document.getElementById("gpu").value=data.gpu;
    document.getElementById("battery").value=data.battery;
    document.getElementById("os").value=data.os;
    document.getElementById("sim").value=data.sim;
                
}
function btnEdit(){
    var form = $('#fileUploadForm')[0];
    var data = new FormData(form);
    data.append("id", idProduct);
    $.ajax({
            type: "POST",
            enctype: 'multipart/form-data',
            url: "/admin/editProduct",
            data: data,
            processData: false,
            contentType: false,
            cache: false,
            timeout: 600000,
            success: function (data) {
                console.log(data);
                alert("edit Product success");
                location.pathname = "admin/listProduct";
            },
            error: function (e) {

                alert("edit Product fail");
            }
        });
}

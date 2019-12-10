$(document).ready(function () {
    
    $.ajax({
        url: "/item/getById?itemId=" + itemId,
        type: "get",
        success: function(item) {
            console.log(item);
            fillData(JSON.parse(item));
        }
    });
    
});
function fillData(item) {
    document.getElementById("product-image").src = "/image?image=" + item.image;
    document.getElementById("product-name").innerHTML = item.name;
    document.getElementById("product-price").innerHTML = item.price.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    
    document.getElementById("screen").innerHTML = "Màn hình: " + item.screen;
    document.getElementById("selfieCamera").innerHTML = "Camera trước: " + item.selfieCamera;
    document.getElementById("mainCamera").innerHTML = "Camera sau: " + item.mainCamera;
    document.getElementById("cpu").innerHTML = "CPU: " + item.cpu;
    document.getElementById("gpu").innerHTML = "GPU: " + item.gpu;
    document.getElementById("ram").innerHTML = "Ram: " + item.ram;
    document.getElementById("rom").innerHTML = "Rom: " + item.rom;
    document.getElementById("os").innerHTML = "Hệ điều hành: " + item.os;
}
function addItemToCart() {
    var number = $('#item-number').val();
//    if(number < 0) {
//        alert("So luong phai lon hon 0");
//        return;
//    }
    $.ajax({
        url: "/cart/addItem",
        type: "post",
        data: {
            "itemId": itemId,
            "number": number,
            "cartId": sessionStorage.getItem("cartId")
        },
        success: function () {
            alert("Them thanh cong");
            location.href = "/home";
        }
    });
    
}
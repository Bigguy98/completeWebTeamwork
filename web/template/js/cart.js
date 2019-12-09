var items;
var cartId;
var payment = 0;
var showStatus;
$(document).ready(function() {
    cartId = sessionStorage.getItem("cartId");
    if(cartId !== null) {
        loadData();
    }
    
});
function loadData() {
    console.log("Loading data");
    $.ajax({
        url: "/cart/getById",
        type: "post",
        data: {
            "cartId": cartId
        },
        success: function (response) {
            var data  = JSON.parse(response);
            items = data.items;
            showStatus = Array(items.length).fill(1);
            handlerData(items);
        }
        
    }); 
    
}
function handlerData(items) {
    $('#my-table').empty();
    console.log(items);
    items.forEach(function (value, index){
        if(showStatus[index] === 1){
            buildRow(value);        
            payment += value.number*value.item.price;
        }
    });
    $('#payment').html(payment.toLocaleString('it-IT', {style : 'currency', currency : 'VND'}));//xem ham nay
}
function buildRow(data) {
    
    var table_row = document.createElement("tr");
    table_row.setAttribute("class","table-row");
    
    var column_1 = document.createElement("td");
    column_1.setAttribute("class","column-1");
    
    var image_product = document.createElement("div");
    image_product.setAttribute("class","img-product");
    
    var image = document.createElement("img");
    image.setAttribute("src", "/image?image=" + data.item.image);
    
    image_product.appendChild(image);
    column_1.appendChild(image_product);
    
    var column_2 = document.createElement("td");
    column_2.setAttribute("class","column-2");
    column_2.innerHTML = data.item.name;
    
    var column_3 = document.createElement("td");
    column_3.setAttribute("class","column-3");
    column_3.setAttribute("id","price" + data.item.id);
    column_3.innerHTML = data.item.price.toLocaleString('it-IT', {style : 'currency', currency : 'VND'});
    
    var column_4 = document.createElement("td");
    
    var quantity = document.createElement("div");
    quantity.setAttribute("class","quantity-product");
    
    var inputnumber = document.createElement("input");
    inputnumber.setAttribute("type","number");
    inputnumber.setAttribute("min",0);
    inputnumber.setAttribute("id", data.item.id);
    inputnumber.setAttribute("class","item-number");
    inputnumber.value = data.number;
    
    quantity.appendChild(inputnumber);
    column_4.appendChild(quantity);
                
    
    var column_5 = document.createElement("td");
    column_5.setAttribute("id","total" + data.item.id);
    column_5.innerHTML = (data.item.price*data.number).toLocaleString('it-IT', {style : 'currency', currency : 'VND'}); 
    
    table_row.appendChild(column_1);
    table_row.appendChild(column_2);
    table_row.appendChild(column_3);
    table_row.appendChild(column_4);
    table_row.appendChild(column_5);
    
    document.getElementById("my-table").appendChild(table_row);
}
function update() {
    var inputs = $('.item-number');    
    
 
    for(var i =0; i < inputs.length; i++ ){
        var num = inputs[i];
        items.forEach(function(value){
            
            if(value.item.id == num.id) {
                console.log(value.item.id);
                value.number = num.value; 
            }
        });
//        console.log(num.id + " " + num.value);
        updateItemNumber(num.id, num.value);  
        if(num.value === "0") showStatus[i] = 0;
    }
//    console.log(showStatus);
    
    handlerData(items);
    
//    update thì có cần phải ghi lại html không
    payment = 0;
    items.forEach(function (value){
        var id = value.item.id;
        var price = value.item.price;
        var number = value.number;
        var total = price*number;
//        console.log(price + " " + number);
//        console.log(total);
        payment += total;
//        $('#total'+id).html(total.toLocaleString('it-IT', {style : 'currency', currency : 'VND'}));
    });
    $('#payment').html(payment.toLocaleString('it-IT', {style : 'currency', currency : 'VND'}));
    
    alert("Cap nhat thanh cong");
    
}
function updateItemNumber(itemId, itemNumber) {
    $.ajax({
        url: "/cart/update",
        type: "post",
        data: {
            "itemId": itemId,
            "number": itemNumber,
            "cartId": cartId
        },
        success: function() {
        }       
    });
}
function createBill() {
    var city    = $('#city').val();
    var street  = $('#street').val();
    var no      = $('#no').val();
    alert("Xac nhan don hang. Hang hoa se duoc van chuyen den: số nhà " + no + " đường " + street + " thành phố " + city );
    
    $.ajax({
        url: "/bill/create",
        type: "post",
        data: {
            "payment": payment,
            "cartId": cartId
        },
        success: function() {
            console.log("Tao hoa don thanh cong!");
            getCart();
        }
    });
}
function getCart() {
    var userId = sessionStorage.getItem("userId");
    $.ajax({
        url: "/cart/getByCustomerId",
        type: "post",
        data: {
            "customerId": userId
        },
        success: function (response) {
            console.log("cart id: " + response);
            sessionStorage.setItem("cartId", response);
        }
        
    });
    
}
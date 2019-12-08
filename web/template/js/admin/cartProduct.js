var idCart = $('#hidden_id').val();
$(document).ready(function (){
    console.log(idCart);
    getProduct();
});
function getProduct(){
    $('#table-tbody').empty()
    $.ajax({
        url: "/admin/getItemByCart?idCart="+idCart,
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            showProduct(JSON.parse(data));
            console.log(data)
        }
    })
}
function showProduct(data){
    data.forEach(function (cartItem){
        console.log(cartItem.item.id);
        var cover =document.createElement("tr");
        cover.setAttribute("class","table-content");
        
        var column_1 = document.createElement("td");
        column_1.setAttribute("class","column-1");
        column_1.innerHTML = cartItem.item.id;
        
        var column_2 = document.createElement("td");
        column_2.setAttribute("class","column-2");
        column_2.innerHTML = cartItem.item.name;
        
        var column_3 = document.createElement("td");
        column_3.setAttribute("class","column-3");
        column_3.innerHTML= cartItem.number;
      
        
        var column_4 = document.createElement("td");
        column_4.setAttribute("class","column-4");
        column_4.innerHTML=cartItem.item.price;
        
        var column_5 = document.createElement("td");
        column_5.setAttribute("class","column-5");
        column_5.innerHTML=cartItem.number*cartItem.item.price;
        
        cover.appendChild(column_1);
        cover.appendChild(column_2);
        cover.appendChild(column_3);
        cover.appendChild(column_4);
        cover.appendChild(column_5);
        $('#table-tbody').append(cover);
    })
}
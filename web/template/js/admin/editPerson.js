var idPerson =document.getElementById("id").value;
console.log("person id: " + idPerson);
$(document).ready(function (){
    
    getCustomer();
});

function getCustomer(){
     $.ajax({
        url : "/admin/getPersonById?idPerson="+idPerson,
        type: 'GET',
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            showCustomer(JSON.parse(data));                   
        }
    });
}
function showCustomer(data){
    document.getElementById("name").value= data.name;
    document.getElementById("age").value = data.age;
    document.getElementById("address").value = data.address;
    document.getElementById("username").value = data.username;
    document.getElementById("password").value = data.password;
}

function btnEdit(){
    var name = $('#name').val();
    var age =$('#age').val();
    var address = $('#address').val();
    var username = $('#username').val();
    var password = $('#password').val();
    console.log(name);
    console.log(idPerson);
    
    $.ajax({
        url : "/admin/editPerson",
        type: "POST",
        data:{
            "id"  : idPerson,
            "name" : name,
            "age" : age,
            "address" : address,
            "username" : username,
            "password" : password
        },
        success: function (data, textStatus, jqXHR) {
            console.log(data);
            alert("edit person success");
            location.href="/admin/listPerson";
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("edit person fail!");
            location.href = "/admin/editPerson?idPerson="+idPerson;
        }
    });
};
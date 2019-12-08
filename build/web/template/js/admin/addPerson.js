/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function (){
    
    
});

function add_person() {
    var name = $('#name').val();
    var age = $('#age').val();
    var address =$('#address').val();
    var username = $('#username').val();
    var password = $('#password').val();
    var role = $('#role').val();
        $.ajax({
            url: "/admin/addPerson",
            type: "POST",
            data:{
               "name" : name,
               "age" : age,
               "address" : address,
               "username" : username,
               "password" : password,
               "role" : role
            },
            success: function (data, textStatus, jqXHR) {
                alert('add Person success!');
                console.log(data);
                location.pathname = "/admin/listPerson";
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert(' add Person fail!!!') ;
                console.log(textStatus);
            }
        });
}


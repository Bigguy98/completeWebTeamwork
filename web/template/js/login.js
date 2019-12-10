var reg = /\W/;
$(document).ready(function(){
    
    
});
function showSigninPage() {
    $('.register').addClass('ra');    
}
function hideSigninPage() {
    $('.register').removeClass('ra');    
}
function login() {
    var username = $('#login-username').val();
    var password = $('#login-password').val();
    
    if(reg.test(username)) {
        alert("Ten dang nhap ko dc chua ki tu dac biet");
        return;
    }
    $.ajax({
        url: "/handlerLogin",
        type: "POST",
        data: {
            "username": username,
            "password": password       
        },
        success: function (response) {        
            alert("Login success");
            getCart(response);
            sessionStorage.setItem("userId", response);  
            location.pathname = "/home";
                     
        },
        error: function(reponse) {
            alert(reponse.responseText);
        }
        
    });
}
function signin() {
    var name = $('#signin-name').val();
    var username = $('#signin-username').val();
    var password = $('#signin-password').val();
    var address = $('#signin-address').val();
    var age = $('#signin-age').val();
    
    if(name == "" || username == "" || password == "" || address == "" || age == "" ) {
        alert("Infomation can not be empty!");
        return;
    };
    
    if(isNaN(age) || age < 0) {
        alert("Tuoi phai la mot so nguyen duong");
        return;
    }
    
    $.ajax({
        url: "/handlerSignin",
        type: "POST",
        data: {
            "name": name,
            "username": username,
            "password": password,
            "address": address,
            "age": age          
        },
        success: function(response) {
            alert("Signin success");
            getCart(response);
            sessionStorage.setItem("userId", response);
            location.pathname = "/home";
            
            
        },
        error: function(reponse) {           
            console.log(reponse.responseText);
            alert("Thong tin dang ky khong hop le");
        }
    });
};

function getCart(userId) {
    
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



